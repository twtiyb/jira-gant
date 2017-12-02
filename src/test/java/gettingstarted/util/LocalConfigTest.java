package gettingstarted.util;

import com.example.java.gettingstarted.util.LocalConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by chunchun.xu on 2017/12/2.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableConfigurationProperties(LocalConfig.class)
public class LocalConfigTest {
	@Resource
	LocalConfig config;

	@Test
	public void testConfig() throws Exception {
		System.out.println(config.toString());
	}
}