package br.com.pasquali.casapopular.util.builder.classificacao;

import java.util.function.Consumer;

import br.com.pasquali.casapopular.util.dto.ClassificacaoDTO;

/**
 * 
 * Builder para apresentacao do resultado final
 * 
 * @author bruno.pinheiro
 *
 */
public class ClassificacaoBuilder {

	public Integer pontuacao;
	public Double rendaFamiliarAtualizada;
	public Long idPretendente;
	
	public ClassificacaoBuilder with(Consumer<ClassificacaoBuilder> builderConsumer) {
		builderConsumer.accept(this);
		return this;
	}
	
	public ClassificacaoDTO createClassificacaoDTO() {
		return new ClassificacaoDTO(this.pontuacao, this.rendaFamiliarAtualizada, this.idPretendente);
	}

}
