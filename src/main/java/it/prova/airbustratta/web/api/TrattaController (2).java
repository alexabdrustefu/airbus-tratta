package it.prova.airbustratta.web.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.airbustratta.dto.TrattaDTO;
import it.prova.airbustratta.model.Tratta;
import it.prova.airbustratta.service.TrattaService;
import it.prova.airbustratta.web.api.exception.AirbusNotFoundException;
import it.prova.airbustratta.web.api.exception.IdNotNullForInsertException;
import it.prova.airbustratta.web.api.exception.TrattaNotFoundException;


@RestController
@RequestMapping("api/tratta")
public class TrattaController {
	@Autowired
	private TrattaService trattaService;
	@GetMapping
	public List<TrattaDTO> getAll() {
		return TrattaDTO.createTrattaDTOListFromModelList(trattaService.listAllElements(true), true);
	}

	// gli errori di validazione vengono mostrati con 400 Bad Request ma
	// elencandoli grazie al ControllerAdvice
	@PostMapping
	public TrattaDTO createNew(@Valid @RequestBody TrattaDTO trattoInput) {
		// se mi viene inviato un id jpa lo interpreta come update ed a me (producer)
		// non sta bene
		if (trattoInput.getId() != null)
			throw new IdNotNullForInsertException("Non è ammesso fornire un id per la creazione");

		Tratta trattaInserito = trattaService.inserisciNuovo(trattoInput.buildTrattaModel());
		return TrattaDTO.buildTrattaDTOFromModel(trattaInserito, true);
	}

	@GetMapping("/{id}")
	public TrattaDTO findById(@PathVariable(value = "id", required = true) long id) {
		Tratta tratta = trattaService.caricaSingoloElementoEager(id);

		if (tratta == null)
			throw new TrattaNotFoundException("Tratta not found con id: " + id);

		return TrattaDTO.buildTrattaDTOFromModel(tratta, true);
	}
	
	//update
	@PutMapping("/{id}")
	public TrattaDTO update(@Valid @RequestBody TrattaDTO  trattaInput, @PathVariable(required = true) Long id) {
		Tratta tratte= trattaService.caricaSingoloElemento(id);

		if (tratte == null)
			throw new AirbusNotFoundException("Airbus not found con id: " + id);

		trattaInput.setId(id);
		Tratta trattaAggioranto= trattaService.aggiorna(trattaInput.buildTrattaModel());
		return TrattaDTO.buildTrattaDTOFromModel(trattaAggioranto, false);
	}
	//delete
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(required = true) Long id) {
		trattaService.rimuovi(id);
	}
	
	@PostMapping("/search")
	public List<TrattaDTO> search(@RequestBody TrattaDTO example) {
		return TrattaDTO.createTrattaDTOListFromModelList(trattaService.findByExample(example.buildTrattaModel()),
				false);
	}
	
	@GetMapping("/concludiTratte")
	public List<TrattaDTO> concludiTratte(){
		return TrattaDTO.createTrattaDTOListFromModelList(trattaService.concludiTratte(), true) ;
	}

}