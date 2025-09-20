package com.xpinc.assessor.dto;

import com.xpinc.assessor.domain.Alocacao;
import com.xpinc.assessor.domain.ClasseAtivo;

public class AlocacaoDTO {
	private ClasseAtivo classe;
	private double percentual;

	public AlocacaoDTO() {
	}

	public AlocacaoDTO(ClasseAtivo classe, double percentual) {
		this.classe = classe;
		this.percentual = percentual;
	}

	public static AlocacaoDTO of(Alocacao a) {
		return new AlocacaoDTO(a.getClasse(), a.getPercentual());
	}

	public ClasseAtivo getClasse() {
		return classe;
	}

	public void setClasse(ClasseAtivo classe) {
		this.classe = classe;
	}

	public double getPercentual() {
		return percentual;
	}

	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}

}
