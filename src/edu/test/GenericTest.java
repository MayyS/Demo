package edu.test;

import edu.entity.Movie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    @Test
    public void Test1(){
        List<String> StringList=new ArrayList<String>();
        List<Integer>StringInteger=new ArrayList<Integer>();
        Movie movie=new Movie();
        System.out.println(StringInteger.getClass()+"   "+StringList.getClass()+"   " +
                movie.getClass());
    }
}
