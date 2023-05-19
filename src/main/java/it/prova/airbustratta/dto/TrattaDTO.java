package it.prova.airbustratta.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import it.prova.airbustratta.model.Stato;
import it.prova.airbustratta.model.Tratta;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class TrattaDTO {
	private Long id;
	@NotBlank(message="{codiceTratta.notblank}")
	private String codiceTratta;
	@NotBlank(message="{descrizione.notblank}")
	private String descrizione;
	@NotNull(message="{data.notnull}")
	private LocalDate data;
	@NotNull(message="{oraDecollo.notnull}")
	private LocalTime oraDecollo;
	@NotNull(message="{oraAtterraggio.notnull}")
	private LocalTime oraAtterraggio;
	@NotNull(message="{stato.notnull}")
	private Stato stato;
	@JsonIgnoreProperties(value = { "films" })
	@NotNull(message = "{airbus.notnull}")
	private AirbusDTO airbus;
	//costruttore
	public TrattaDTO() {
	}
	public TrattaDTO(@NotBlank(message = "{codiceTratta.notblank}") @NotBlank(message = "{codice.notblank}") String codiceTratta,
			@NotBlank(message = "{descrizione.notblank}") @NotBlank(message = "{descrizione.notblank}") String descrizione,
			@NotNull(message = "{data.notnull}") LocalDate data,
			@NotNull(message = "{oraDecollo.notnull}") LocalTime oraDecollo,
			@NotNull(message = "{oraAtterraggio.notnull}") LocalTime oraAtterraggio,
			@NotNull(message = "{stato.notnull}") Stato stato) {
		super();
		this.codiceTratta = codiceTratta;
		this.descrizione = descrizione;
		this.data = data;
		this.oraDecollo = oraDecollo;
		this.oraAtterraggio = oraAtterraggio;
		this.stato = stato;
	}
	public TrattaDTO(Long id,
			@NotBlank(message = "{codiceTratta.notblank}") @NotBlank(message = "{codiceTratta.notblank}") String codiceTratta,
			@NotBlank(message = "{descrizione.notblank}") @NotBlank(message = "{descrizione.notblank}") String descrizione,
			@NotNull(message = "{data.notnull}") LocalDate data,
			@NotNull(message = "{oraDecollo.notnull}") LocalTime oraDecollo,
			@NotNull(message = "{oraAtterraggio.notnull}") LocalTime oraAtterraggio,
			@NotNull(message = "{stato.notnull}") Stato stato) {
		super();
		this.id = id;
		this.codiceTratta = codiceTratta;
		this.descrizione = descrizione;
		this.data = data;
		this.oraDecollo = oraDecollo;
		this.oraAtterraggio = oraAtterraggio;
		this.stato = stato;
	}
	public TrattaDTO(Long id, String codiceTratta, LocalDate data, LocalTime oraDecollo, LocalTime oraAtterraggio,
			Stato stato) {
		super();
		this.id = id;
		this.codiceTratta = codiceTratta;
		this.data = data;
		this.oraDecollo = oraDecollo;
		this.oraAtterraggio = oraAtterraggio;
		this.stato = stato;	}
	public TrattaDTO(Long id, String codiceTratta, String descrizione, LocalDate data, LocalTime oraDecollo,
			LocalTime oraAtterraggio) {
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
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodiceTratta() {
		return codiceTratta;
	}
	public void setCodiceTratta(String codiceTratta) {
		this.codiceTratta = codiceTratta;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
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
	
	public Stato getStato() {
		return stato;
	}
	public void setStato(Stato stato) {
		this.stato = stato;
	}
	public LocalTime getOraAtterraggio() {
		return oraAtterraggio;
	}
	public void setOraAtterraggio(LocalTime oraAtterraggio) {
		this.oraAtterraggio = oraAtterraggio;
	}
	public AirbusDTO getAirbus() {
		return airbus;
	}
	public void setAirbus(AirbusDTO airbus) {
		this.airbus = airbus;
	}
	
	
	public Tratta buildTrattaModel() {
		Tratta result = new Tratta(this.id, this.codiceTratta, this.descrizione, this.data, this.oraDecollo,this.oraAtterraggio,this.stato);
		if (this.airbus != null)
			result.setAirbus(this.airbus.buildAirbusModel());

		return result;
	}
	
	
	public static TrattaDTO buildTrattaDTOFromModel(Tratta trattaModel, boolean includeAirbus) {
		TrattaDTO result = new TrattaDTO(trattaModel.getId(), trattaModel.getCodiceTratta(), trattaModel.getDescrizione(),
				trattaModel.getData(), trattaModel.getOraDecollo(),trattaModel.getOraAtterraggio());

		if (includeAirbus)
			result.setAirbus(AirbusDTO.buildAirbusDTOFromModel(trattaModel.getAirbus(), false));

		return result;
	}
	
	
	public static List<TrattaDTO> createTrattaDTOListFromModelList(List<Tratta> modelListInput, boolean includeAirbus){
		return modelListInput.stream().map(trattaEntity -> {
			return TrattaDTO.buildTrattaDTOFromModel(trattaEntity , includeAirbus);
		}).collect(Collectors.toList());
	}
	
	
	public static Set<TrattaDTO> createTrattaDTOSetFromModelSet(Set<Tratta> modelListInput, boolean includeAirbus){
		return modelListInput.stream().map(trattaEntity-> {
			return TrattaDTO.buildTrattaDTOFromModel(trattaEntity, includeAirbus);
		}).collect(Collectors.toSet());
	}
	
	
	
}
