package br.com.pasquali.casapopular.util.dto;

import br.com.pasquali.casapopular.util.SerializadoPOJO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class MembroFamiliarDTO extends SerializadoPOJO {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer idFamilia;
	private Integer idade;
	private Double renda;
	private boolean isDependente;
	private boolean isPretendente;
	private boolean isConjuge;
	
}
