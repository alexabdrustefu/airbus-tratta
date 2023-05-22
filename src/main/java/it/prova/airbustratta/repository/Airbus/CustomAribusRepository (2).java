package it.prova.airbustratta.repository.Airbus;

import java.util.List;

import it.prova.airbustratta.model.Airbus;

public interface CustomAribusRepository {
	List<Airbus> findByExample(Airbus example);
}
