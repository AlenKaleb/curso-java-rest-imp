package com.stefanini.hackathon.rest.parses;

import com.stefanini.hackathon.rest.dto.PessoaDTO;
import com.stefanini.hackathon.rest.entity.Pessoa;

public class PessoaParser extends AbstractParser<Pessoa, PessoaDTO>{

	@Override
	public Pessoa toEntity(PessoaDTO dto) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(dto.getNome());
		return pessoa;
	}

	@Override
	public PessoaDTO toDTO(Pessoa e) {
		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO.setNome(e.getNome());
		return pessoaDTO;
	}

	
	
}
