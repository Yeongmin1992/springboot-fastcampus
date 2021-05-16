package fastcampus.spring.batch.part3;

import org.springframework.batch.item.ItemProcessor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class DuplicateValidationProcessor<T> implements ItemProcessor<T, T> {

    private final Map<String, Object> keyPool = new ConcurrentHashMap<>();   // 중복체크를 위한 맵
    private final Function<T, String> keyExtractor;
    private final boolean allowDuplicate;   // 필터링 여부를 설정하는 값

    public DuplicateValidationProcessor(Function<T, String> keyExtractor,
                                        boolean allowDuplicate) {
        this.keyExtractor = keyExtractor;
        this.allowDuplicate = allowDuplicate;
    }

    @Override
    public T process(T item) throws Exception {
        // allowDuplicate이 트루이면 필터링을 하지 않는다는 의미이므로 item을 그대로 리턴
        if (allowDuplicate) {
            return item;
        }

        String key = keyExtractor.apply(item);   // 해당 아이템으로 키를 추출

        // 키가 키풀에 존재하는지(중복되는지) 체크
        if(keyPool.containsKey(key)) {
            return null;
        }

        // 중복이 아닐 경우 키 풀에 키를 저장하고 아이템을 리턴
        keyPool.put(key, key);
        return item;
    }
}
