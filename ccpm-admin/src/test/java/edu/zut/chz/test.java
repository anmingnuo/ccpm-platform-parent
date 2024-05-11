package edu.zut.chz;

import edu.zut.chz.system.domain.Course;
import edu.zut.chz.system.domain.Direction;
import edu.zut.chz.system.mapper.DirectionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class test {
    @Autowired
    private DirectionMapper directionMapper;
    @Test
    public void testDirection(){
        List<Direction> directions = directionMapper.selectDirectionList(new Direction());
        System.out.println(directions);
    }

    @Test
    public void testListToString(){
        List<String> list=new ArrayList<>();
        list.add("I");
        list.add("love");
        list.add("you");
        System.out.println(list);
    }
}
