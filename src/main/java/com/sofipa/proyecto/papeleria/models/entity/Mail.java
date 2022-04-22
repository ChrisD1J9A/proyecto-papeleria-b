package com.sofipa.proyecto.papeleria.models.entity;

public class Mail {
	private String para;
	private String mensaje;
	private String asunto;
	
	public String getPara() {
		return para;
	}
	
	public void setPara(String para) {
		this.para = para;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getAsunto() {
		return asunto;
	}
	
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

}
