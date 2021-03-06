package com.bikuta.cursomc.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"), QUITADO(2, "Quitado"), CANCELADO(3, "Cancelado");

	private Integer cod;
	private String descricao;

	private EstadoPagamento(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return this.cod;
	}

	private String getDescricao() {
		return this.descricao;
	}

	public static EstadoPagamento toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (EstadoPagamento estado : EstadoPagamento.values()) {
			if (cod.equals(estado.getCod())) {
				return estado;
			}
		}

		throw new IllegalArgumentException("ID inválido: " + cod);
	}
}
