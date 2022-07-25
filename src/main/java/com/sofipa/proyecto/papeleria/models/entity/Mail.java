package com.sofipa.proyecto.papeleria.models.entity;

/*La clase mail es usada para tener un formato al momento de enviar un correo electrónico 
 * y no es una entidad para usarse como modelo en la base de datos, en otras palabras, no es una tabla.*/
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
