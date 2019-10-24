package top.guitoubing.taobao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaobaoApplicationTests {

	private static Logger logger = LogManager.getLogger(TaobaoApplicationTests.class);

	@Test
	void contextLoads() {
		logger.info("test starts");
	}

}
