package it.prova.airbustratta.service;

import java.util.List;

import it.prova.airbustratta.model.Airbus;


public interface AirbusService {

	List<Airbus> listAllElements();
	
	List<Airbus> listAllElementsEager();

	Airbus caricaSingoloElemento(Long id);
	
	Airbus caricaSingoloElementoConFilms(Long id);

	Airbus aggiorna(Airbus airbusInstance);

	Airbus inserisciNuovo(Airbus airbusInstance);

	void rimuovi(Long idToRemove);
	
	List<Airbus> findByExample(Airbus example);
	
	Airbus findByCodiceAndDescrizione(String Codice, String descrizione);


}
