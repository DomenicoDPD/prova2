package com.dome.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dome.oggetti.CalciatoreDto;
import com.dome.oggetti.FormazioniDto;

@Service
public class FormazioniService {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<CalciatoreDto> salvaFormazioneCampionato(List<CalciatoreDto> campionato) {
		for (CalciatoreDto calciatore : campionato) {
			String query = "INSERT INTO formazioni_fanta.campionato (nome,ruolo,titolare) values ('"
					+ calciatore.getNome() + "','" + calciatore.getRuolo() + "','" + calciatore.getTitolare() + "' )";
			jdbcTemplate.update(query);

		}

		return campionato;

	}

	public List<CalciatoreDto> salvaFormazioneCoppa(List<CalciatoreDto> coppa) {
		for (CalciatoreDto calciatore : coppa) {
			String query = "INSERT INTO formazioni_fanta.coppa (nome,ruolo,titolare) values ('" + calciatore.getNome()
					+ "','" + calciatore.getRuolo() + "','" + calciatore.getTitolare() + "' )";
			jdbcTemplate.update(query);

		}

		return coppa;

	}

	public List<CalciatoreDto> prendiRosa(List<CalciatoreDto> calciatori) {
		String query = "SELECT nome,ruolo FROM formazioni_fanta.rosa";
		calciatori = jdbcTemplate.query(query, new BeanPropertyRowMapper<CalciatoreDto>(CalciatoreDto.class));

		return calciatori;
	}

	public List<CalciatoreDto> caricaVoti(List<CalciatoreDto> voti) {
		for (CalciatoreDto calciatore : voti) {
			String query = "UPDATE formazioni_fanta.campionato SET campionato.voto = ?, campionato.fantavoto = ? WHERE nome = ?";
			jdbcTemplate.update(query, calciatore.getVoto(), calciatore.getFantaVoto(), calciatore.getNome());

		}

		for (CalciatoreDto calciatore : voti) {
			String query = "UPDATE formazioni_fanta.coppa SET coppa.voto = ?, coppa.fantavoto = ?  where nome = ? ";
			jdbcTemplate.update(query, calciatore.getVoto(), calciatore.getFantaVoto(), calciatore.getNome());

		}

		return voti;
	}

	public FormazioniDto prendiFormazioni(FormazioniDto formazioni) {

		String queryCamp = "SELECT nome,ruolo,voto,fantavoto,titolare FROM formazioni_fanta.campionato WHERE titolare = 't'";
		String queryCop = "SELECT nome,ruolo,voto,fantavoto,titolare FROM formazioni_fanta.coppa WHERE titolare = 't'";

		formazioni.setCampionato(
				jdbcTemplate.query(queryCamp, new BeanPropertyRowMapper<CalciatoreDto>(CalciatoreDto.class)));
		formazioni
				.setCoppa(jdbcTemplate.query(queryCop, new BeanPropertyRowMapper<CalciatoreDto>(CalciatoreDto.class)));

		return formazioni;
	}

}