package br.com.pasquali.casapopular.util.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClassificacaoDTO {

	private Integer pontuacao;
	private Double rendaFamiliarAtualizada;
	private Long idPretendente;
	
}
