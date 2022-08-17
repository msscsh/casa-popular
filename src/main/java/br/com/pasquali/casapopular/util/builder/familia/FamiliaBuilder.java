package br.com.pasquali.casapopular.util.builder.familia;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import br.com.pasquali.casapopular.util.po.FamiliaPO;
import br.com.pasquali.casapopular.util.po.MembroFamiliarPO;

public class FamiliaBuilder {

	public Long id;
	public Integer pontuacao;
	public Double rendaFamiliarAtualizada;
	public List<MembroFamiliarPO> membrosFamiliarPO = new ArrayList<>();
	
	public FamiliaBuilder with(Consumer<FamiliaBuilder> builderConsumer) {
		builderConsumer.accept(this);
		return this;
	}
	
	public FamiliaPO createFamiliaPO() {
		return new FamiliaPO(this.id, this.pontuacao, this.rendaFamiliarAtualizada, this.membrosFamiliarPO);
	}
	
}
