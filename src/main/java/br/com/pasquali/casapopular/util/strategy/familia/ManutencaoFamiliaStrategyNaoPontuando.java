package br.com.pasquali.casapopular.util.strategy.familia;

import br.com.pasquali.casapopular.util.builder.familia.FamiliaBuilder;
import br.com.pasquali.casapopular.util.builder.familia.MembroFamiliarBuilder;
import br.com.pasquali.casapopular.util.dto.FamiliaDTO;
import br.com.pasquali.casapopular.util.exception.PasqualiException;
import br.com.pasquali.casapopular.util.po.FamiliaPO;

/**
 * 
 * Esta estrategia visa armazenar as informacoes das familias sem realizar a classificacao.
 * Utiliza um metodo default da interface para validacao generica
 * 
 * @author bruno.pinheiro
 *
 */
public class ManutencaoFamiliaStrategyNaoPontuando implements ManutencaoFamiliaStrategy, ManutencaoFamiliarValidacao {

	@Override
	public FamiliaPO executar(FamiliaDTO familiaDTO) throws PasqualiException {
		validar(familiaDTO);
		return criarFamiliaPO(familiaDTO);
	}

	private FamiliaPO criarFamiliaPO(FamiliaDTO familiaDTO) {
		
		FamiliaPO familiaPO = new FamiliaBuilder()
		        .with(familia -> {
		            familia.id = familiaDTO.getId();
		            familia.pontuacao = familiaDTO.getPontuacao();
		            familia.rendaFamiliarAtualizada = familiaDTO.getRendaFamiliarAtualizada();
		        })
		        .with(familia -> { familiaDTO.getFamiliares()
	        						.forEach( membroFamiliarDTO -> {
	        								familia.membrosFamiliarPO.add(
        										new MembroFamiliarBuilder()
						            				.with( membroFamiliar -> {
								            			membroFamiliar.id = membroFamiliarDTO.getId();
								            			membroFamiliar.idade = membroFamiliarDTO.getIdade();
								            			membroFamiliar.renda = membroFamiliarDTO.getRenda();
								            			membroFamiliar.isDependente = membroFamiliarDTO.isDependente();
								            			membroFamiliar.isPretendente = membroFamiliarDTO.isPretendente();
								            			membroFamiliar.isConjuge = membroFamiliarDTO.isConjuge();
							            			})
							            		.createMembroFamiliarPO()
							            	);
			        				});
    			})
		        .createFamiliaPO();

		return familiaPO;
		
	}
	
}
