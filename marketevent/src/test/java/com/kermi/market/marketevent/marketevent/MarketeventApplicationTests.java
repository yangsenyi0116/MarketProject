package com.kermi.market.marketevent.marketevent;

import com.kermi.market.marketevent.MarketeventApplication;
import com.kermi.market.marketevent.pojo.CustomerLogin;
import com.kermi.market.marketevent.service.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MarketeventApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MarketeventApplicationTests {

//	@Autowired
//	private RegistryService registryService;

	@Autowired
	private LoginService loginService;

	@Test
	void contextLoads() {
//		CustomerLogin customerLogin=new CustomerLogin();
//		customerLogin.setLoginName("AmazeBlank");
//		customerLogin.setPassword(Md5Util.md5("123456"));
//		Date date =new Date();
//		ParsePosition pos = new ParsePosition(8);
//		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		customerLogin.setModifiedTime(format.parse(format.format(date),pos));
//		registryService.RegistryNewCustomer(customerLogin);
		CustomerLogin customerLogin=loginService.test("abcd");

		System.out.println(customerLogin.getLoginName());

	}

}
