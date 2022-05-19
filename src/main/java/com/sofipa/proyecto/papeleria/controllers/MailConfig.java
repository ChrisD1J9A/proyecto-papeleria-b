package com.sofipa.proyecto.papeleria.controllers;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender; 
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	/*
	 *  CONFIGURACION DE CORREO ELECTRONICO
	 * */

	@Value("smtp.gmail.com")
	private String host;

	@Value("587")
	private Integer port;

	@Bean
	public JavaMailSender javaMailService() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setPort(587);
		//Se establece la dirección de correo electrónico que estará emitiendo los correos 
		javaMailSender.setUsername("control.papeleria2022@gmail.com");
		//Se define la contraseña obtenida para aplicaciones
		javaMailSender.setPassword("xeiinzolwgujpful");
		javaMailSender.setJavaMailProperties(getMailProperties());

		return javaMailSender;
	}
	
	private Properties getMailProperties() {
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.debug", "true");
		return properties;
	}
}
