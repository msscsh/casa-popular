package br.com.pasquali.casapopular.csr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pasquali.casapopular.util.po.FamiliaPO;

/**
 * 
 * Camada responsavel pelas operacoes JPA
 * 
 * @author bruno.pinheiro
 *
 */
@Repository
public interface FamiliaRepository extends JpaRepository<FamiliaPO, Long> {

}
