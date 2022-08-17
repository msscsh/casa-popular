package br.com.pasquali.casapopular.util.strategy.familia;

import java.util.List;
import java.util.Optional;

import br.com.pasquali.casapopular.util.dto.FamiliaDTO;
import br.com.pasquali.casapopular.util.dto.MembroFamiliarDTO;
import br.com.pasquali.casapopular.util.exception.DadosInvalidosException;

public interface ManutencaoFamiliarValidacao {

	default void validar(FamiliaDTO familiaDTO) {
		Optional<List<MembroFamiliarDTO>> nullable = Optional.ofNullable(familiaDTO.getFamiliares());
		nullable.orElseThrow(() -> new DadosInvalidosException("Nenhum membro da família foi informado"));
		nullable.get().stream().findFirst().orElseThrow(() -> new DadosInvalidosException("Nenhum membro da família foi informado"));
	}
	
}
