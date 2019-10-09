package com.stefanini.hackathon.rest.parses;

import com.stefanini.hackathon.rest.dto.ContaDTO;
import com.stefanini.hackathon.rest.entity.Conta;

public class ContaParser extends AbstractParser<Conta, ContaDTO>{

	@Override
	public Conta toEntity(ContaDTO dto) {
		Conta conta = new Conta();
		conta.setAgencia(dto.getAgencia());
		conta.setConta(dto.getConta());
		return conta;
	}

	@Override
	public ContaDTO toDTO(Conta e) {
		ContaDTO contaDTO = new ContaDTO();
		contaDTO.setId(e.getId());
		contaDTO.setAgencia(e.getAgencia());
		contaDTO.setConta(e.getConta());
		contaDTO.setSenha(e.getSenha());
		contaDTO.setPessoa(e.getPessoa());
		return contaDTO;
	}

}
