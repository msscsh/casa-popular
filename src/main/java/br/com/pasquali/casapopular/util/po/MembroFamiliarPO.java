package br.com.pasquali.casapopular.util.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "TbMembroFamiliar", schema = "casapopular")
public class MembroFamiliarPO extends SerializadoPOJO {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private FamiliaPO familiaPO;
	
	@Column( name = "idade")
	private Integer idade;

	@Column( name = "renda")
	private Double renda;

	@Column( name = "isDependente")
	private boolean isDependente;

	@Column( name = "isPretendente")
	private boolean isPretendente;

	@Column( name = "isConjuge")
	private boolean isConjuge;
	
}
