package com.codestationdev.cursomc.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fildName;
	private String messsage;

	public FieldMessage() {

	}

	public FieldMessage(String fildName, String messsage) {
		super();
		this.fildName = fildName;
		this.messsage = messsage;
	}

	public String getFildName() {
		return fildName;
	}

	public void setFildName(String fildName) {
		this.fildName = fildName;
	}

	public String getMesssage() {
		return messsage;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

}
