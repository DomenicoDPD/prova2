package com.dome.beans;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.dome.oggetti.CalciatoreDto;
import com.dome.oggetti.FormazioniDto;
import com.dome.oggetti.VotiDto;
import com.dome.oggetti.VotiSquadraDto;

@Component

public class GetFormazione {
	Logger logger = Logger.getLogger(GetFormazione.class.getName());

	public VotiSquadraDto calcoloFormazioni(FormazioniDto formazioni) throws IOException {
		/*
		 * 1: recupero formazioni da db 1.5 calcolaTitolari 2: calcolo di eventuali
		 * malus 3: calcolo voto di giornata 4: risposta con oggetto con voto + nome
		 * squadra + altro
		 * 
		 */

		return calcoloVotiGiornata(formazioni);

	}

	private VotiSquadraDto calcoloVotiGiornata(FormazioniDto formazione) {
		VotiSquadraDto squadra = new VotiSquadraDto();
		VotiDto voti = new VotiDto();
		squadra.setRealVaggina(voti);
		squadra.getRealVaggina().setMalus(-7);

		for (CalciatoreDto calciatore : formazione.getCampionato()) {
			for (CalciatoreDto calciatore1 : formazione.getCoppa()) {
				if (calciatore.getNome().equalsIgnoreCase(calciatore1.getNome())) {
					squadra.getRealVaggina().setMalus(squadra.getRealVaggina().getMalus() + 1);
					;
				}
			}
		}

		if (squadra.getRealVaggina().getMalus() < 1) {
			squadra.getRealVaggina().setMalus(0);
		}

		for (CalciatoreDto calciatore : formazione.getCampionato()) {
			squadra.getRealVaggina()
					.setTotaleCampionato(squadra.getRealVaggina().getTotaleCampionato() + calciatore.getVoto());
		}

		for (CalciatoreDto calciatore : formazione.getCampionato()) {
			squadra.getRealVaggina().setTotaleCampionatoFanta(
					squadra.getRealVaggina().getTotaleCampionatoFanta() + calciatore.getFantaVoto());
		}

		for (CalciatoreDto calciatore : formazione.getCoppa()) {
			squadra.getRealVaggina().setTotaleCoppa(squadra.getRealVaggina().getTotaleCoppa() + calciatore.getVoto());
		}

		for (CalciatoreDto calciatore : formazione.getCoppa()) {
			squadra.getRealVaggina()
					.setTotaleCoppaFanta(squadra.getRealVaggina().getTotaleCoppaFanta() + calciatore.getFantaVoto());
		}
		squadra.getRealVaggina().setCampionatoMalus(
				squadra.getRealVaggina().getTotaleCampionatoFanta() - squadra.getRealVaggina().getMalus());

		return squadra;

	}

}
