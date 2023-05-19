package it.prova.airbustratta.repository.Airbus;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.airbustratta.model.Airbus;


public interface AirbusRepository extends CrudRepository<Airbus, Long>, CustomAribusRepository{
	Airbus findByCodiceAndDescrizione(String codice, String descrizione);
	List<Airbus> findByCodiceIgnoreCaseContainingOrDescrizioneIgnoreCaseContainingOrderByCodiceAsc(String codice,
			String descrizione);
	
	@Query("select distinct a from Airbus a left join fetch a.tratte")
	List<Airbus> findAllEager();
	
	@Query("from Airbus a left join fetch a.tratte where a.id=?1")
	Airbus findByIdEager(Long idAirbus);
}
