package br.com.pasquali.casapopular.util.strategy.familia;

import java.util.List;
import java.util.stream.Collectors;

import br.com.pasquali.casapopular.util.po.FamiliaPO;
import br.com.pasquali.casapopular.util.po.MembroFamiliarPO;

/**
 * 
 * Inteface para facil manutencao de criterios juntamente as classes que a implementarem
 * 
 * @author bruno.pinheiro
 *
 */
public interface ManutencaoFamiliarCriterios {

	default FamiliaPO aplicarTodosCriterios(FamiliaPO familiaPO) {

		Integer pontuacao = pontuarCriterioRenda(familiaPO);
		pontuacao = pontuacao + pontuarCriterioDependentes(familiaPO);
		familiaPO.setPontuacao(familiaPO.getPontuacao() + pontuacao);
		return familiaPO;
		
	}

	default Integer pontuarCriterioRenda(FamiliaPO familiaPO) {
		familiaPO.setRendaFamiliarAtualizada(0D);
		familiaPO.getMembrosFamiliarPO().forEach( membro -> {
			double rendaFamiliarAtualizada = familiaPO.getRendaFamiliarAtualizada() + membro.getRenda();
			familiaPO.setRendaFamiliarAtualizada(rendaFamiliarAtualizada);
		});
		return Double.compare(familiaPO.getRendaFamiliarAtualizada(), 900) < 1 ? 5 : 3;
	}

	default Integer pontuarCriterioDependentes(FamiliaPO familiaPO) {
		
		List<MembroFamiliarPO> dependentesMenoresIgualA18 = familiaPO.getMembrosFamiliarPO()
			.stream()
			.filter(membro -> (membro.getIdade() < 18 && membro.isDependente()) ) //uma pequena redundancia
			.collect(Collectors.toList());

		int pontuacao = dependentesMenoresIgualA18.size() >= 3 ? 3 : 0;
		pontuacao =  dependentesMenoresIgualA18.size() >= 1 && dependentesMenoresIgualA18.size() <= 2 ? 2 : pontuacao;
		
		return pontuacao;
		
	}
	
}
