package com.ryz.sh;

import com.ryz.sh.kafka.KafkaSender;
import com.ryz.sh.service.AsyncServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan(basePackages="com.ryz.sh")
@EntityScan(basePackages="com.ryz.sh.pojo")
@EnableJpaRepositories(basePackages="com.ryz.sh.repository")
@EnableAsync
@SpringBootApplication
public class ShApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ShApplication.class, args);
		KafkaSender sender = context.getBean(KafkaSender.class);
		for (int i = 0; i < 3; i++) {
			//调用消息发送类中的消息发送方法
			sender.send();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		AsyncServer asyncServer = (AsyncServer) context.getBean("asyncServer");
		System.out.println("开始在线程"+Thread.currentThread().getName()+"中调用异步方法");
		asyncServer.doAsync("任彦章");
		System.out.println("异步方法调用完成");
	}
}
