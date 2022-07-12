package com.dome.oggetti;

public class CalciatoreDto {

	private int idgiornata;
	private String nome;
	private String ruolo;
	private double voto;
	private double fantaVoto;
	private String titolare;

	public int getIdGiornata() {
		return idgiornata;
	}

	public void setIdGiornata(int idgiornata) {
		this.idgiornata = idgiornata;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public double getVoto() {
		return voto;
	}

	public void setVoto(double voto) {
		this.voto = voto;
	}

	public double getFantaVoto() {
		return fantaVoto;
	}

	public void setFantaVoto(double fantaVoto) {
		this.fantaVoto = fantaVoto;
	}

	public String getTitolare() {
		return titolare;
	}

	public void setTitolare(String titolare) {
		this.titolare = titolare;
	}

	public String toString() {
		return String.format("%n nome:%s, rulo:%s, voto:%.1f, fantavoto:%.1f , titolare:%s , Giornata:%d", getNome(),
				getRuolo(), getVoto(), getFantaVoto(), getTitolare(), getIdGiornata());
	}

}
