package fastcampus.spring.batch.part3;

import fastcampus.spring.batch.TestConfiguration;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

// @JobScope를 테스트하기 위함
@SpringBatchTest
// 스프링 테스트가 가능하도록
@RunWith(SpringRunner.class)
// 테스트 대상
@ContextConfiguration(classes = {SavePersonConfiguration.class, TestConfiguration.class})
public class SavePersonConfigurationTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private PersonRepository personRepository;

    // 한번 테스트 후 DB의 데이터를 지워주고, 이후의 테스트를 할 수 있도록
    @After
    public void tearDown() throws Exception {
        personRepository.deleteAll();
    }

    @Test
    public void test_step() {
        JobExecution jobExecution = jobLauncherTestUtils.launchStep("savePersonStep"); // 파라미터도 넘겨주기 가능

        Assertions.assertThat(jobExecution.getStepExecutions().stream()
                .mapToInt(StepExecution::getWriteCount)
                .sum())
                .isEqualTo(personRepository.count())  //DB에 몇개의 데이터가 저장됐는지 확인
                .isEqualTo(3);
    }

    @Test
    public void test_allow_duplicate() throws Exception {
        //given
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("allow_duplicate", "false")
                .toJobParameters();

        // when -> SaverPersonConfiguration에서 실행된 job이 launchJob 매서드에 의해 실행되고, 실행된 job의 결과를 jobExecution으로 받음
        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

        // then -> 중복제거로 인해 총 3건이 write 되었는지 검증
        Assertions.assertThat(jobExecution.getStepExecutions().stream()
                .mapToInt(StepExecution::getWriteCount)
                .sum())
                .isEqualTo(personRepository.count())  //DB에 몇개의 데이터가 저장됐는지 확인
                .isEqualTo(3);
    }

    // 중복제가 안했을 때(allow_dupicate 'true') 테스트
    @Test
    public void test_not_allow_duplicate() throws Exception {
        //given
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("allow_duplicate", "true")
                .toJobParameters();

        // when -> SaverPersonConfiguration에서 실행된 job이 launchJob 매서드에 의해 실행되고, 실행된 job의 결과를 jobExecution으로 받음
        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

        // then -> 중복제거로 인해 총 3건이 write 되었는지 검증
        Assertions.assertThat(jobExecution.getStepExecutions().stream()
                .mapToInt(StepExecution::getWriteCount)
                .sum())
                .isEqualTo(personRepository.count())  //DB에 몇개의 데이터가 저장됐는지 확인
                .isEqualTo(100);
    }
}
