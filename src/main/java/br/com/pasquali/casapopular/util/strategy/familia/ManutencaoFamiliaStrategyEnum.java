package br.com.pasquali.casapopular.util.strategy.familia;

import lombok.Getter;

/**
 * 
 * Este enum armazena as mais variadas formas de se manter os dados da familia
 * 
 * @author bruno.pinheiro
 *
 */
@Getter
public enum ManutencaoFamiliaStrategyEnum {
	
	CRIACAO_OBJETO_PO_NAO_PONTUANDO(new ManutencaoFamiliaStrategyNaoPontuando()),
	CRIACAO_OBJETO_PO_REALIZANDO_CLASSIFICACAO(new ManutencaoFamiliaStrategyAplicandoPontuacao());
	
	private ManutencaoFamiliaStrategy strategy;
	
	ManutencaoFamiliaStrategyEnum(ManutencaoFamiliaStrategy strategy) {
		this.strategy = strategy;
	}
	
}
