package br.com.pasquali.casapopular.util.po;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.pasquali.casapopular.util.SerializadoPOJO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name = "TbFamilia", schema = "casapopular")
public class FamiliaPO extends SerializadoPOJO {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id", columnDefinition = "")
	private Long id;

	@Column( name = "pontuacao")
	private Integer pontuacao;

	@Column( name = "rendaFamiliarAtualizada")
	private Double rendaFamiliarAtualizada;
	
	//Uma listagem simples dos integrantes da familia, por isso EAGER. E' preciso mudar caso o sistema apresente robustez, e realizar join fetch
	@OneToMany(mappedBy = "familiaPO", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<MembroFamiliarPO> membrosFamiliarPO;
	
}
