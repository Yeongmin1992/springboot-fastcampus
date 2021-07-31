import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) throws JsonProcessingException {
        System.out.println("main");
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        Car car1 = new Car();
        car1.setName("K5");
        car1.setCarNumber("11가 1111");
        car1.setType("sedan");

        Car car2 = new Car();
        car2.setName("Q5");
        car2.setCarNumber("22가 2222");
        car2.setType("SUV");

        List<Car> carList = Arrays.asList(car1, car2);
        user.setCars(carList);

        /*
         1. 윈도우는 기본 설정이 UTF-8이 아니어서 그냥 출력하면 에러남. File > Setting > Global Encoding, Project Encoding, properties files
         모두 UTF-8로 바꿔줘라~!
         2. Help > Find Action > 'edit custom vm option' 검색 제일 밑에 -Dfile.encoding=UTF-8 입력
         */
        System.out.println(user);

        /*
        json validator 검색 > json 형식 입력한 후 process > 올바른 json 형식인지 아닌지 판별해줌
         */
        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);


        // 하나씩 파싱하기기
       JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();
        System.out.println("name : " + _name);
        System.out.println("age " + _age);

        /* 이렇게 String으로 불러오면 리스트 형식의 json node를 가져올 수 없다
        String _list = jsonNode.get("cars").asText();
        System.out.println(_list);

         */

        JsonNode cars = jsonNode.get("cars");
        ArrayNode arrayNode = (ArrayNode)cars;

        /* convertValue를 사용하여 여러 객체를 가지고 json이 아닌 우리가 원하는 클래스로 맵핑을 시킬 수 있답니다. > arrayNode 객체를 받아서
         우리가 원하는 List<Car> 형태로 변환해준다.

         */
        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>(){});
        System.out.println(_cars);

        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "steve");
        objectNode.put("age", 20);

        System.out.println(objectNode.toPrettyString());

    }
}
