package it.prova.airbustratta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.airbustratta.model.Airbus;
import it.prova.airbustratta.repository.Airbus.AirbusRepository;
import it.prova.airbustratta.web.api.exception.AirbusNotFoundException;

@Service
@Transactional(readOnly = true)
public class AirbusServiceImpl implements AirbusService {
	@Autowired
	private AirbusRepository repository;

	@Override
	@Transactional
	public List<Airbus> listAllElements() {
		return (List<Airbus>) repository.findAll();

	}
	@Override
	@Transactional
	public Airbus caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Airbus caricaSingoloElementoConFilms(Long id) {
		return repository.findByIdEager(id);
	}

	@Override
	@Transactional
	public Airbus aggiorna(Airbus airbusInstance) {
		return repository.save(airbusInstance);
	}

	@Override
	@Transactional
	public Airbus inserisciNuovo(Airbus airbusInstance) {
		return repository.save(airbusInstance);
	}

	@Override
	@Transactional
	public void rimuovi(Long idToRemove) {
		repository.findById(idToRemove)
				.orElseThrow(() -> new AirbusNotFoundException("Airbus not found con id: " + idToRemove));
		repository.deleteById(idToRemove);

	}

	@Override
	@Transactional
	public List<Airbus> findByExample(Airbus example) {
		return repository.findByExample(example);
	}

	@Override
	@Transactional
	public Airbus findByCodiceAndDescrizione(String Codice, String descrizione) {
		return repository.findByCodiceAndDescrizione(Codice, descrizione);
	}
	@Override
	@Transactional
	public List<Airbus> listAllElementsEager() {
		return (List<Airbus>) repository.findAllEager();
	}

}
