package com.dome.primoSpring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dome.beans.GetFormazione;
import com.dome.oggetti.CalciatoreDto;
import com.dome.oggetti.FormazioniDto;
import com.dome.oggetti.VotiSquadraDto;
import com.dome.services.FormazioniService;

@RestController
public class HelloController {
	@Autowired
	BeanFactory beanFactory;

	@RequestMapping(value = "/inviaFormazioneCampionato", method = RequestMethod.POST)
	List<CalciatoreDto> formazioneCampionato(@RequestBody List<CalciatoreDto> formazione) throws IOException {

		FormazioniService forma = beanFactory.getBean(FormazioniService.class);
		forma.salvaFormazioneCampionato(formazione);

		return formazione;

	}

	@RequestMapping(value = "/inviaFormazioneCoppa", method = RequestMethod.POST)
	List<CalciatoreDto> formazioneCoppa(@RequestBody List<CalciatoreDto> formazione) throws IOException {

		FormazioniService forma = beanFactory.getBean(FormazioniService.class);
		forma.salvaFormazioneCoppa(formazione);

		return formazione;

	}

	@RequestMapping(value = "/prendiRosa", method = RequestMethod.GET)
	public List<CalciatoreDto> prendiRosa() {
		List<CalciatoreDto> rosa = new ArrayList<CalciatoreDto>();
		FormazioniService prendiRosa = beanFactory.getBean(FormazioniService.class);
		rosa = prendiRosa.prendiRosa(rosa);

		return rosa;

	}

	@RequestMapping(value = "/caricaVoti", method = RequestMethod.POST)
	public List<CalciatoreDto> caricaVoti(@RequestBody List<CalciatoreDto> voti) {

		FormazioniService forma = beanFactory.getBean(FormazioniService.class);
		forma.caricaVoti(voti);

		return voti;

	}

	@RequestMapping(value = "/prendiFormazioni", method = RequestMethod.GET)
	public FormazioniDto prendiFormazioneCamp() {
		FormazioniService forma = beanFactory.getBean(FormazioniService.class);
		FormazioniDto formazioni = beanFactory.getBean(FormazioniDto.class);
		forma.prendiFormazioni(formazioni);

		return formazioni;

	}

	@RequestMapping(value = "/calcoloVoti", method = RequestMethod.GET)
	public VotiSquadraDto calcoloVoti() throws IOException {
		GetFormazione calcolo = beanFactory.getBean(GetFormazione.class);
		FormazioniService forma = beanFactory.getBean(FormazioniService.class);
		FormazioniDto formazioni = beanFactory.getBean(FormazioniDto.class);
		forma.prendiFormazioni(formazioni);

		return calcolo.calcoloFormazioni(formazioni);

	}

}
