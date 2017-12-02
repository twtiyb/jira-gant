package com.example.java.gettingstarted.util;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by chunchun.xu on 2017/12/2.
 */

@Data
@ToString
@ConfigurationProperties(prefix = "LocalConfig")
public class LocalConfig {
	Boolean live;
}
