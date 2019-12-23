import com.kermi.market.userservice.untils.UUIDUtils;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;

import java.util.Random;

/**
 * @Author : Kermi
 * @Date : 2019/12/10 15:03
 * @Version : 1.0
 */
public class UUIDTest {
    @Test
    public void getUUID(){
        Thread thread01 = new Thread() {
            @Override
            public void run() {
                System.out.println(UUIDUtils.getUUID());
            }
        };
        Thread thread02 = new Thread(){
            @Override
            public void run (){
                System.out.println(UUIDUtils.getUUID());
            };
        };
        thread01.run();
        thread02.run();

    }

    @Test
    public void go(){
        System.out.println(Math.random());
    }
}
