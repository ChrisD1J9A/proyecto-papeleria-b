package com.sofipa.proyecto.papeleria.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sofipa.proyecto.papeleria.models.entity.Mail;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class MailController {
	@Autowired
	JavaMailSender mailSenderObj; 
	
	
	/*
	 * envia correo electronico
	 * */
	@PostMapping("/correo")
	public Mail enviarCorreo(@RequestBody Mail correo) {
		System.out.println(correo);
		System.out.println("------------");
		System.out.println("Correo enviado con exito...");
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(correo.getPara());
			message.setSubject(correo.getAsunto());
			message.setText(correo.getMensaje());
			mailSenderObj.send(message);
			System.out.println("Correo enviado con exito...");
		}catch(Exception e) {
			System.out.println("error:"+ e);
		}
		return correo;
	}
}
