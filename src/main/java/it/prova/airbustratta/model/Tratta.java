package it.prova.airbustratta.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tratta")
public class Tratta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name="codiceTratta")
	private String codiceTratta;
	@Column(name="data")
	private LocalDate data;
	@Column(name="oraDecollo")
	private LocalTime oraDecollo;
	@Column(name="oraAtterraggio")
	private LocalTime oraAtterraggio;
	@Column(name="statp")
	@Enumerated(EnumType.STRING)
	private Stato stato;
	//costruttore
	public Tratta() {
	}
	public Tratta(String codiceTratta, LocalDate data, LocalTime oraDecollo, LocalTime oraAtterraggio, Stato stato) {
		super();
		this.codiceTratta = codiceTratta;
		this.data = data;
		this.oraDecollo = oraDecollo;
		this.oraAtterraggio = oraAtterraggio;
		this.stato = stato;
	}
	public Tratta(Long id, String codiceTratta, LocalDate data, LocalTime oraDecollo, LocalTime oraAtterraggio,
			Stato stato) {
		super();
		this.id = id;
		this.codiceTratta = codiceTratta;
		this.data = data;
		this.oraDecollo = oraDecollo;
		this.oraAtterraggio = oraAtterraggio;
		this.stato = stato;
	}
	//get e set
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodiceTratta() {
		return codiceTratta;
	}
	public void setCodiceTratta(String codiceTratta) {
		this.codiceTratta = codiceTratta;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalTime getOraDecollo() {
		return oraDecollo;
	}
	public void setOraDecollo(LocalTime oraDecollo) {
		this.oraDecollo = oraDecollo;
	}
	public LocalTime getOraAtterraggio() {
		return oraAtterraggio;
	}
	public void setOraAtterraggio(LocalTime oraAtterraggio) {
		this.oraAtterraggio = oraAtterraggio;
	}
	public Stato getStato() {
		return stato;
	}
	public void setStato(Stato stato) {
		this.stato = stato;
	}
	
	
}
