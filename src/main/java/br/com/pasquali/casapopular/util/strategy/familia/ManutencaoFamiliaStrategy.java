package br.com.pasquali.casapopular.util.strategy.familia;

import br.com.pasquali.casapopular.util.dto.FamiliaDTO;
import br.com.pasquali.casapopular.util.exception.PasqualiException;
import br.com.pasquali.casapopular.util.po.FamiliaPO;

/**
 * 
 * Defini as assinaturas a serem concretizadas conforme n cenarios possiveis
 * 
 * @author bruno.pinheiro
 *
 */
public interface ManutencaoFamiliaStrategy {
	
	FamiliaPO executar(FamiliaDTO familiaDTO) throws PasqualiException;

}
