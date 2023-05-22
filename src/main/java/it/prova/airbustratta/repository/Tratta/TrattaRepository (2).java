package it.prova.airbustratta.repository.Tratta;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.airbustratta.model.Tratta;


public interface TrattaRepository extends CrudRepository<Tratta, Long>  {
	@Query("SELECT t FROM Tratta t JOIN FETCH t.airbus WHERE t.id=?1")
	Tratta findSingleTrattaEager(Long id);
	@Query("select t from Tratta t join fetch t.airbus")
	List<Tratta> findAllTrattaEager();
	List<Tratta> findBycodiceTrattaAndDescrizione(String codice, String descrizione);
	@Query("select t from Tratta t where t.stato = 0")
	List<Tratta> findAllTratteAttive();
}