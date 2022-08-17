package br.com.pasquali.casapopular.csr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pasquali.casapopular.csr.service.FamiliaService;
import br.com.pasquali.casapopular.util.dto.ClassificacaoDTO;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("resultadoclassificacao")
public class ResultadoClassificacaoController {

	/** A service */
    @Autowired
    private FamiliaService familiaService;
    
    @GetMapping
	@ApiOperation(value = "Consulta o resultado do programa habitacional de maneira ordenada")
	public ResponseEntity<List<ClassificacaoDTO>> consultarClassificacaoOrgenada() {
		return new ResponseEntity<>(familiaService.consultarClassificacaoOrdenada(), HttpStatus.OK);
	}
	
}
