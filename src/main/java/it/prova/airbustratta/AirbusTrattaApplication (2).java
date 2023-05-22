package it.prova.airbustratta;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.airbustratta.model.Airbus;
import it.prova.airbustratta.model.Stato;
import it.prova.airbustratta.model.Tratta;
import it.prova.airbustratta.service.AirbusService;
import it.prova.airbustratta.service.TrattaService;

@SpringBootApplication
public class AirbusTrattaApplication implements CommandLineRunner {

	@Autowired
	private AirbusService airbusService;
	@Autowired
	private TrattaService trattaService;

	public static void main(String[] args) {
		SpringApplication.run(AirbusTrattaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String codiceAirbus1 = "001";
		String descrizioneAirbus1 = "AirItaly";
		Airbus airbus1 = airbusService.findByCodiceAndDescrizione(codiceAirbus1, descrizioneAirbus1);
		if (airbus1 == null) {
			airbus1 = new Airbus(codiceAirbus1, LocalDate.now().minusDays(1), descrizioneAirbus1,45 );
			airbusService.inserisciNuovo(airbus1);
		}
		Tratta RomaNY = new Tratta("RMNY001", "Roma - New York", LocalDate.now(), LocalTime.of(10, 0),
				LocalTime.of(10, 30), Stato.ATTIVA, airbus1);
		if (trattaService.findByCodiceAndDescrizione(RomaNY.getCodiceTratta(), RomaNY.getDescrizione()).isEmpty()) {
			trattaService.inserisciNuovo(RomaNY);
		}
		String codiceAirbus2 = "002";
		String descrizioneAirbus2 = "Emirates";
		Airbus airbus2 = airbusService.findByCodiceAndDescrizione(codiceAirbus2, descrizioneAirbus2);
		if (airbus2 == null) {
			airbus2 = new Airbus(codiceAirbus2, LocalDate.of(2020, 05, 19),descrizioneAirbus2, 105);
			airbusService.inserisciNuovo(airbus2);
		}
		Tratta MilanoParigi1 = new Tratta("MLPR", "Milano - Parigi", LocalDate.of(2022, 12, 1), LocalTime.of(10, 0),
				LocalTime.of(18, 30), Stato.ATTIVA, airbus2);
		if (trattaService.findByCodiceAndDescrizione(MilanoParigi1.getCodiceTratta(), MilanoParigi1.getDescrizione())
				.isEmpty()) {
			trattaService.inserisciNuovo(MilanoParigi1);
		}

	}
}
