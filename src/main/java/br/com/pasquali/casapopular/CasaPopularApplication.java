package br.com.pasquali.casapopular;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CasaPopularApplication {

	/** A interface **/
	@Value("${server.timezone}")
	private String timezone;
	
	public static void main(String[] args) {
		SpringApplication.run(CasaPopularApplication.class, args);
	}

	/**
	 * 
	 * Apos a inicializacao da aplicacao atraves da mains, aplica a time zone
	 * 
	 */
    @PostConstruct
    public void init() {
      TimeZone.setDefault(TimeZone.getTimeZone(timezone));
    }
    
}
