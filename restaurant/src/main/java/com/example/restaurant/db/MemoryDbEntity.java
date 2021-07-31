package com.example.restaurant.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemoryDbEntity {
    // int형은 default가 0으로 db에 자동으로 0이 들어갈 수 있기때문에 Integer 사용
    protected Integer index;
}
