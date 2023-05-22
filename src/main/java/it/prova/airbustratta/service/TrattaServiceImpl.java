package it.prova.airbustratta.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.airbustratta.model.Stato;
import it.prova.airbustratta.model.Tratta;
import it.prova.airbustratta.repository.Tratta.TrattaRepository;
import it.prova.airbustratta.web.api.exception.TrattaNotFoundException;

@Service
@Transactional(readOnly = true)
public class TrattaServiceImpl implements TrattaService {
	@Autowired
	private TrattaRepository repository;

	@Override
	@Transactional
	public List<Tratta> listAllElements(boolean eager) {
		if (eager)
			return (List<Tratta>) repository.findAllTrattaEager();
		return (List<Tratta>) repository.findAll();
	}

	@Override
	@Transactional
	public Tratta caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Tratta caricaSingoloElementoEager(Long id) {
		return repository.findSingleTrattaEager(id);
	}

	@Override
	@Transactional
	public Tratta aggiorna(Tratta trattaInstance) {
		return repository.save(trattaInstance);
	}

	@Override
	@Transactional
	public Tratta inserisciNuovo(Tratta trattaInstance) {
		return repository.save(trattaInstance);
	}

	@Override
	@Transactional
	public void rimuovi(Long idToRemove) {
		repository.findById(idToRemove)
				.orElseThrow(() -> new TrattaNotFoundException("Tratta not found con id: " + idToRemove));
		repository.deleteById(idToRemove);

	}

	@Override
	@Transactional
	public List<Tratta> findByExample(Tratta example) {
		return null;
	}

	@Override
	@Transactional
	public List<Tratta> findByCodiceAndDescrizione(String codice, String descrizione) {
		return repository.findBycodiceTrattaAndDescrizione(codice,descrizione);
	}

	@Override
	public List<Tratta> concludiTratte() {
		List<Tratta> tratteAttive = repository.findAllTratteAttive();
		for (Tratta trattaItem : tratteAttive) {
			LocalDateTime dateTimeAtterraggio = LocalDateTime.of(trattaItem.getData(), trattaItem.getOraAtterraggio());
			if (dateTimeAtterraggio.isBefore(LocalDateTime.now())) {
				trattaItem.setStato(Stato.CONCLUSA);
			}
		}
		repository.saveAll(tratteAttive);
		return tratteAttive;
	
	
	}

}