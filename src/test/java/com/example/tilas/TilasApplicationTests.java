package com.example.tilas;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Slf4j
@SpringBootTest
class TilasApplicationTests {

    @Test
    public void myTest(){
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7,8,9,10);
        log.info("--------------"+ Arrays.toString(list.toArray()));
        log.info(list.toString());
    }


}
