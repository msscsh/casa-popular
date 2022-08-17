package br.com.pasquali.casapopular.csr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pasquali.casapopular.csr.service.FamiliaService;
import br.com.pasquali.casapopular.util.dto.FamiliaDTO;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("familia")
public class FamiliaController {

	/** A service */
    @Autowired
    private FamiliaService familiaService;
    
    @PostMapping
	@ApiOperation(value = "Cria a familia com seus membros")
	public ResponseEntity<String> detalhar(@RequestBody FamiliaDTO familia) {
		familiaService.cadastrarFamilia(familia);
		return new ResponseEntity<>("Família inclusa no programa", HttpStatus.OK);
	}
	
}
