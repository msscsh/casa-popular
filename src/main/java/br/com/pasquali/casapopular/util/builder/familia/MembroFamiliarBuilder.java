package br.com.pasquali.casapopular.util.builder.familia;

import java.util.function.Consumer;

import br.com.pasquali.casapopular.util.po.MembroFamiliarPO;

public class MembroFamiliarBuilder {

	public Long id;
	public Integer idade;
	public Double renda;
	public boolean isDependente;
	public boolean isPretendente;
	public boolean isConjuge;
	
	public MembroFamiliarBuilder with(Consumer<MembroFamiliarBuilder> builderConsumer) {
		builderConsumer.accept(this);
		return this;
	}
	
	public MembroFamiliarPO createMembroFamiliarPO() {
		return new MembroFamiliarPO(this.id, null, this.idade, this.renda, this.isDependente, this.isPretendente, this.isConjuge);
	}
	
}
