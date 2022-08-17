package br.com.pasquali.casapopular.util.dto;

import java.util.List;

import br.com.pasquali.casapopular.util.SerializadoPOJO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class FamiliaDTO extends SerializadoPOJO {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer pontuacao;
	private Double rendaFamiliarAtualizada;
	private List<MembroFamiliarDTO> familiares;
	
}
