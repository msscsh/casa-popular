package br.com.pasquali.casapopular.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;  

/**
 * 
 * Classe responsavel por interceptar as chamadas de metodos das camadas 'CSR' fazendo a trilha de execucao
 * 
 * @author bruno.pinheiro
 *
 */
@Slf4j
@Aspect  
@Component  
public class LoggerAspectJ {  

	@Before(value = "execution(* br.com.pasquali.casapopular.csr..*(..))")  
	public void logarAntes(JoinPoint joinPoint) {  
		log.info("Entrada na classe: " + joinPoint.getSignature());  
	}  

	@After(value = "execution(* br.com.pasquali.casapopular.csr..*(..))")  
	public void logarApos(JoinPoint joinPoint) {  
		log.info("Saída da classe: " + joinPoint.getSignature());  
	}  
	
}  