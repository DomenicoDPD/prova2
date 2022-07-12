package com.dome.oggetti;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FormazioniDto {
	private List<CalciatoreDto> campionato;
	private List<CalciatoreDto> coppa;

	public List<CalciatoreDto> getCampionato() {
		return campionato;

	}

	public void setCampionato(List<CalciatoreDto> campionato) {
		this.campionato = campionato;
	}

	public List<CalciatoreDto> getCoppa() {
		return coppa;
	}

	public void setCoppa(List<CalciatoreDto> coppa) {
		this.coppa = coppa;
	}

	public String toString() {
		return String.format("\n campionato:%s,%n coppa:%s", campionato, coppa);
	}

}
