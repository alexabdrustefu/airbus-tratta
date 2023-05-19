package it.prova.airbustratta.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.prova.airbustratta.model.Airbus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AirbusDTO {
	private Long id;
	@NotBlank(message= "{codice.notblank}")
	private String codice;
	@NotBlank(message= "{descrizione.notblank}")
	private String descrizione;
	@NotNull(message="{dataInizioServizio.notnull}")
	private LocalDate dataInizioServizio;
	@NotNull(message="{numeroPassegeri.notnull}")
	private Integer numeroPassegeri;
	@NotNull(message="{tratte.notnull}")
	private Set<TrattaDTO> tratte= new HashSet<TrattaDTO>();
	//costruttore
	public AirbusDTO() {
	}
	public AirbusDTO(Long id, @NotBlank(message = "{codice.notblank}") String codice,
			@NotBlank(message = "{descrizione.notblank}") String descrizione,
			@NotBlank(message = "{dataInizioServizio.notnull}") LocalDate dataInizioServizio,
			@NotBlank(message = "{numeroPassegeri.notnull}") Integer numeroPassegeri,
			@NotBlank(message = "{tratte.notnull}") Set<TrattaDTO> tratte) {
		super();
		this.id = id;
		this.codice = codice;
		this.descrizione = descrizione;
		this.dataInizioServizio = dataInizioServizio;
		this.numeroPassegeri = numeroPassegeri;
		this.tratte = tratte;
	}
	public AirbusDTO(@NotBlank(message = "{codice.notblank}") String codice,
			@NotBlank(message = "{descrizione.notblank}") String descrizione,
			@NotBlank(message = "{dataInizioServizio.notnull}") LocalDate dataInizioServizio,
			@NotBlank(message = "{numeroPassegeri.notnull}") Integer numeroPassegeri,
			@NotBlank(message = "{tratte.notnull}") Set<TrattaDTO> tratte) {
		super();
		this.codice = codice;
		this.descrizione = descrizione;
		this.dataInizioServizio = dataInizioServizio;
		this.numeroPassegeri = numeroPassegeri;
		this.tratte = tratte;
	}
	public AirbusDTO(Long id, String codice, String descrizione, LocalDate dataInizioServizio,
			Integer numeroPassegeri) {
		this.id=id;
		this.codice = codice;
		this.descrizione = descrizione;
		this.dataInizioServizio = dataInizioServizio;
		this.numeroPassegeri = numeroPassegeri;
		}
	//get e set
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
	public Set<TrattaDTO> getTratte() {
		return tratte;
	}
	public void setTratte(Set<TrattaDTO> tratte) {
		this.tratte = tratte;
	}
	
	public Airbus buildAirbusModel() {
		return new Airbus(this.id,this.codice,this.descrizione,this.dataInizioServizio,this.numeroPassegeri);
	} 
	
	
	public static AirbusDTO buildAirbusDTOFromModel(Airbus airbusModel,boolean includeTratte) {
		AirbusDTO result = new AirbusDTO(airbusModel.getId(), airbusModel.getCodice(), airbusModel.getDescrizione(),
				airbusModel.getDataInizioServizio(), airbusModel.getNumeroPassegeri());
		if (includeTratte)
			result.setTratte(TrattaDTO.createTrattaDTOSetFromModelSet(airbusModel.getTratte(), false));
		return result;
	}
	
	public static List<AirbusDTO> createAirbusDTOListFromModelList(List<Airbus> modelListInput,
			boolean includeTratte) {
		return modelListInput.stream().map(airbusEntity -> {
			AirbusDTO result = AirbusDTO.buildAirbusDTOFromModel(airbusEntity, includeTratte);
			if (includeTratte)
				result.setTratte(TrattaDTO.createTrattaDTOSetFromModelSet(airbusEntity.getTratte(), false));
			return result;
		}).collect(Collectors.toList());
	}
	

}
