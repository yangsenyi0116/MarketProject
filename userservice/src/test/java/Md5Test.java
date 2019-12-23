import com.kermi.market.userservice.untils.Md5Utils;
import org.junit.Test;

/**
 * @Author : Kermi
 * @Date : 2019/12/10 21:21
 * @Version : 1.0
 */
public class Md5Test {
    @Test
    public void getMd5(){
        System.out.println(Md5Utils.getMd5("123456"));
    }
}
