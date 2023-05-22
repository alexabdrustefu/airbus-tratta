package it.prova.airbustratta.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="airbus")
public class Airbus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "codice")
	private String codice;
	@Column(name="descrizione")
	private String descrizione;
	@Column(name="dataInizioServizio")
	private LocalDate dataInizioServizio;
	@Column(name="numeroPassegeri")
	private Integer numeroPassegeri;
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "airbus")
	private Set<Tratta> tratte= new HashSet<Tratta>(0);
	
	//costruttori
	public Airbus() {
	}
	
	public Airbus(Long id, String codice, String descrizione, LocalDate dataInizioServizio, Integer numeroPassegeri,
			Set<Tratta> tratte) {
		super();
		this.id = id;
		this.codice = codice;
		this.descrizione = descrizione;
		this.dataInizioServizio = dataInizioServizio;
		this.numeroPassegeri = numeroPassegeri;
		this.tratte = tratte;
	}

	public Airbus(String codice, String descrizione, LocalDate dataInizioServizio, Integer numeroPassegeri,
			Set<Tratta> tratte) {
		super();
		this.codice = codice;
		this.descrizione = descrizione;
		this.dataInizioServizio = dataInizioServizio;
		this.numeroPassegeri = numeroPassegeri;
		this.tratte = tratte;
	}
	//metodi get e set

	public Airbus(Long id, @NotBlank(message = "{codice.notblank}") String codice,
			@NotBlank(message = "{descrizione.notblank}") String descrizione,
			@NotBlank(message = "{dataInizioServizio.notnull}") LocalDate dataInizioServizio,
			@NotBlank(message = "{numeroPassegeri.notnull}") Integer numeroPassegeri) {
		this.id=id;
		this.codice=codice;
		this.descrizione=descrizione;
		this.dataInizioServizio=dataInizioServizio;
		this.numeroPassegeri=numeroPassegeri;
	}

	public Airbus(String codice, LocalDate dataInizioServizio, String descrizione, int numeroPassegeri) {
		this.codice=codice;
		this.descrizione=descrizione;
		this.dataInizioServizio=dataInizioServizio;
		this.numeroPassegeri=numeroPassegeri;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDate getDataInizioServizio() {
		return dataInizioServizio;
	}

	public void setDataInizioServizio(LocalDate dataInizioServizio) {
		this.dataInizioServizio = dataInizioServizio;
	}

	public Integer getNumeroPassegeri() {
		return numeroPassegeri;
	}

	public void setNumeroPassegeri(Integer numeroPassegeri) {
		this.numeroPassegeri = numeroPassegeri;
	}

	public Set<Tratta> getTratte() {
		return tratte;
	}

	public void setTratte(Set<Tratta> tratte) {
		this.tratte = tratte;
	}
	
	
	
}
