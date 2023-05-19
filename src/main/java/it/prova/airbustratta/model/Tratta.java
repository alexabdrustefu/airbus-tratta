package it.prova.airbustratta.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tratta")
public class Tratta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name="codiceTratta")
	private String codiceTratta;
	@Column(name="descrizione")
	private String descrizione;
	@Column(name="data")
	private LocalDate data;
	@Column(name="oraDecollo")
	private LocalTime oraDecollo;
	@Column(name="oraAtterraggio")
	private LocalTime oraAtterraggio;
	@Column(name="stato")
	@Enumerated(EnumType.STRING)
	private Stato stato;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "airbus_id", nullable = false)
	private Airbus airbus;
	
	//costruttore
	public Tratta() {
	}
	public Tratta(String codiceTratta, LocalDate data, LocalTime oraDecollo, LocalTime oraAtterraggio, Stato stato,Airbus airbus) {
		super();
		this.codiceTratta = codiceTratta;
		this.data = data;
		this.oraDecollo = oraDecollo;
		this.oraAtterraggio = oraAtterraggio;
		this.stato = stato;
		this.airbus=airbus;
	}
	public Tratta(Long id, String codiceTratta, LocalDate data, LocalTime oraDecollo, LocalTime oraAtterraggio,
			Stato stato,Airbus airbus) {
		super();
		this.id = id;
		this.codiceTratta = codiceTratta;
		this.data = data;
		this.oraDecollo = oraDecollo;
		this.oraAtterraggio = oraAtterraggio;
		this.stato = stato;
		this.airbus=airbus;
	}
	
	
	
	public Tratta(Long id, String codiceTratta, String descrizione, LocalDate data, LocalTime oraDecollo,
			LocalTime oraAtterraggio, Stato stato, Airbus airbus) {
		super();
		this.id = id;
		this.codiceTratta = codiceTratta;
		this.descrizione = descrizione;
		this.data = data;
		this.oraDecollo = oraDecollo;
		this.oraAtterraggio = oraAtterraggio;
		this.stato = stato;
		this.airbus = airbus;
	}
	public Tratta(Long id, @NotBlank(message = "{codiceTratta.notblank}") String codiceTratta,
			@NotNull(message = "{data.notnull}") LocalDate data,
			@NotNull(message = "{oraDecollo.notnull}") LocalTime oraDecollo,
			@NotNull(message = "{oraAtterraggio.notnull}") LocalTime oraAtterraggio) {
		this.id = id;
		this.codiceTratta = codiceTratta;
		this.data = data;
		this.oraDecollo = oraDecollo;
		this.oraAtterraggio = oraAtterraggio;	}
	public Tratta(Long id, @NotBlank(message = "{codiceTratta.notblank}") String codiceTratta,
			@NotBlank(message = "{descrizione.notblank}") String descrizione,
			@NotNull(message = "{data.notnull}") LocalDate data,
			@NotNull(message = "{oraDecollo.notnull}") LocalTime oraDecollo,
			@NotNull(message = "{oraAtterraggio.notnull}") LocalTime oraAtterraggio,
			@NotNull(message = "{stato.notnull}") Stato stato) {
		this.id = id;
		this.codiceTratta = codiceTratta;
		this.data = data;
		this.oraDecollo = oraDecollo;
		this.oraAtterraggio = oraAtterraggio;
	}
	//get e set
	public Long getId() {
		return id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
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
	public Airbus getAirbus() {
		return airbus;
	}
	public void setAirbus(Airbus airbus) {
		this.airbus = airbus;
	}
	
	
	
}
