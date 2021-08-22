package log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// MypLogger 클래스도 싱글톤 패턴이어서 생성자를 private으로 생성
public class MyLogger {

    // singleton 패턴으로 "mylogger" 식별자가 갖고 있는 데이터들(배열 등)으로 늘 동일하게 인스턴스를 생성 -> Singleton이라서 new를 안쓴다!?
    Logger logger = Logger.getLogger("mylogger");
    private static MyLogger instance = new MyLogger();

    public static final String errorLog = "log.txt";
    public static final String warningLog = "warning.txt";
    public static final String fineLog = "fine.txt";

    private FileHandler logFile = null;
    private FileHandler warningFile = null;
    private FileHandler fineFile = null;

    private MyLogger(){

        try {
            logFile = new FileHandler(errorLog, true);
            warningFile = new FileHandler(warningLog, true);
            fineFile = new FileHandler(fineLog, true);

        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        logFile.setFormatter(new SimpleFormatter());
        warningFile.setFormatter(new SimpleFormatter());
        fineFile.setFormatter(new SimpleFormatter());

        // 모든 단계의 오류를 다 찍겠다. -> 어느 단계의 오류 로그 부터 남길지 조정 가능
        logger.setLevel(Level.ALL);
        fineFile.setLevel(Level.FINE);
        warningFile.setLevel(Level.WARNING);

        logger.addHandler(logFile);
        logger.addHandler(warningFile);
        logger.addHandler(fineFile);
    }


    public static MyLogger getLogger(){
        return instance;
    }


    public void log(String msg){

        logger.finest(msg);
        logger.finer(msg);
        logger.fine(msg);
        logger.config(msg);
        logger.info(msg);
        logger.warning(msg);
        logger.severe(msg);

    }

    public void fine(String msg){
        logger.fine(msg);
    }

    public void warning(String msg){
        logger.warning(msg);
    }
}

/*
아래의 콘솔은 jre의 plugin에 있는 logging.properties 파일 설정이 info로 되어있기 때문에 info
단계부터 log가 찍힌다.
 */
