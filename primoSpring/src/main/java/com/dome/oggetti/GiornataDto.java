package com.dome.oggetti;

import org.springframework.stereotype.Component;

@Component
public class GiornataDto {
	private int giornata;
	private FormazioniDto formazioni;

	public int getGiornata() {
		return giornata;
	}

	public void setGiornata(int giornata) {
		this.giornata = giornata;
	}

	public FormazioniDto getFormazioniDto() {
		return formazioni;

	}

	public void setFormazioniDto(FormazioniDto formazioni) {
		this.formazioni = formazioni;
	}

	public String toString() {
		return String.format("\n giornata:%d,%n formazioni:%s", giornata, formazioni);
	}

}
