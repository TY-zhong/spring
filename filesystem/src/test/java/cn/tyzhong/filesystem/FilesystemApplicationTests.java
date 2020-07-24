package cn.tyzhong.filesystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class FilesystemApplicationTests {

	@Test
	void contextLoads() {
		Date now = new Date();
		Integer i = (Long.valueOf((now.getTime() - now.getTime()) / 1000)).intValue();
		System.out.println(i);
	}

}
