package service;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : Kermi
 * @Date : 2019/12/13 10:34
 * @Version : 1.0
 */
public class UserInfServiceTest {

    @Test
    public void test1() {
        String str = "431225200001162411";
        System.out.println(str.substring(6, 14));

    }

    @Test
    public void test2() {
        String str=null;
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = format.parse("20000116");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
    }

    @Test
    public void test3(){
        String str="";
        if (str == "") {
            str = null;
        }
        System.out.println(str==null);
    }
}
