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

@CrossOrigin(origins= {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MailController {
	@Autowired
	JavaMailSender mailSenderObj; 
	
	
	/*
	 * Método para enviar un correo electronico
	 * */
	@PostMapping("/correo")
	public Mail enviarCorreo(@RequestBody Mail correo) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			//Se asigna al correo a aenviar los datos correspondientes
			message.setTo(correo.getPara());
			message.setSubject(correo.getAsunto());
			message.setText(correo.getMensaje());
			//Se envía el correo electrónico
			mailSenderObj.send(message);
		}catch(Exception e) {
			System.out.println("error:"+ e);
		}
		return correo;
	}
}
