package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.util.Properties;

@Configuration
@EnableRedisHttpSession
public class Config {

    @Bean
    public LettuceConnectionFactory connectionFactory() {
        LettuceConnectionFactory lettuceConnectionFactory =  new LettuceConnectionFactory();
        lettuceConnectionFactory.setHostName(System.getenv("spring_redis_host"));
        lettuceConnectionFactory.setPassword(System.getenv("spring_redis_password"));
        lettuceConnectionFactory.setPort(6380);
        lettuceConnectionFactory.setUseSsl(true);

        return lettuceConnectionFactory;
    }

    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }
}

