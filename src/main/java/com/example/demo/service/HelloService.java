package com.example.demo.service;

import com.example.demo.TrackTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:my.properties")
public class HelloService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    Environment env;

    @Value("#{ systemProperties['os.name'] }")
    private String defaultLocale;


    @Value("${my.message: unknown}")
    private String text;

  @Value("${your.message: unknown}")
  private String text2;

    @TrackTime
    public String toUpperCase(String name)  {
//        logger.info("in to upper");
//        logger.debug("debug in to upper");

        logger.info(defaultLocale);
       logger.info(text);

      logger.info(env.getProperty("your.message"));
      logger.info(text2);

        return name.toUpperCase();
    }

}
