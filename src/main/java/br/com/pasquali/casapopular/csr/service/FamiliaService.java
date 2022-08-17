package br.com.pasquali.casapopular.csr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pasquali.casapopular.csr.repository.FamiliaRepository;
import br.com.pasquali.casapopular.util.builder.classificacao.ClassificacaoBuilder;
import br.com.pasquali.casapopular.util.dto.ClassificacaoDTO;
import br.com.pasquali.casapopular.util.dto.FamiliaDTO;
import br.com.pasquali.casapopular.util.exception.PretendenteNotFoundException;
import br.com.pasquali.casapopular.util.po.FamiliaPO;
import br.com.pasquali.casapopular.util.po.MembroFamiliarPO;
import br.com.pasquali.casapopular.util.strategy.familia.ManutencaoFamiliaStrategy;
import br.com.pasquali.casapopular.util.strategy.familia.ManutencaoFamiliaStrategyEnum;

/**
 * 
 * Service para manutencao de aspectos negociais da Familia
 * 
 * @author bruno.pinheiro
 *
 */
@Service
public class FamiliaService {

	/** O Repository */
	@Autowired
	private FamiliaRepository familiaRepository;
	private ManutencaoFamiliaStrategy manutencaoFamiliaStrategy = ManutencaoFamiliaStrategyEnum.CRIACAO_OBJETO_PO_REALIZANDO_CLASSIFICACAO.getStrategy();
	
	public void cadastrarFamilia(FamiliaDTO familiaDTO) {

		FamiliaPO familiaPO = manutencaoFamiliaStrategy.executar(familiaDTO);

		familiaPO.getMembrosFamiliarPO().forEach( membro -> membro.setFamiliaPO(familiaPO));
		
		familiaRepository.save(familiaPO);		
	}

	public List<ClassificacaoDTO> consultarClassificacaoOrdenada() {
		return criarClassificacaoDTO(familiaRepository.findAll());
	}
	
	/**
	 * 
	 * Prepara o objeto para o retorno da view
	 * 
	 * @param familiasPO
	 * @return
	 */
	private List<ClassificacaoDTO> criarClassificacaoDTO(List<FamiliaPO> familiasPO) {
		
		List<ClassificacaoDTO> listaClassificacaoDTO = new ArrayList<>();
		
		familiasPO.stream().forEach(
				
				familia ->  {
					
					List<MembroFamiliarPO> membrosTidoComoChefeDaFamilia = familia.getMembrosFamiliarPO().stream().filter( membro -> !membro.isPretendente()).collect(Collectors.toList());	
					Optional<List<MembroFamiliarPO>> optionalMembrosPretentendes = Optional.ofNullable(membrosTidoComoChefeDaFamilia);
					optionalMembrosPretentendes.orElseThrow(() -> new PretendenteNotFoundException("Nenhum pretendente foi encontrado para esta familia " + familia.getId()));
					MembroFamiliarPO chefeDeFamilia = optionalMembrosPretentendes.get().stream().findFirst().orElseThrow(() -> new PretendenteNotFoundException("Nenhum membro da família foi informado"));
					
					ClassificacaoDTO classificadoDTO = new ClassificacaoBuilder().with(
							classificado -> {
								classificado.pontuacao = familia.getPontuacao();
								classificado.rendaFamiliarAtualizada = familia.getRendaFamiliarAtualizada();
								classificado.idPretendente = chefeDeFamilia.getId();
							})
						.createClassificacaoDTO();
					
					listaClassificacaoDTO.add(classificadoDTO);
					
				});
		
		return listaClassificacaoDTO;
		
	}
	
}

