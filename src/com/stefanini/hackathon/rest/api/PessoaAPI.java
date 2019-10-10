package com.stefanini.hackathon.rest.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.hackathon.rest.dto.PessoaDTO;
import com.stefanini.hackathon.rest.entity.Pessoa;
import com.stefanini.hackathon.rest.exceptions.NegocioException;
import com.stefanini.hackathon.rest.parses.PessoaParser;
import com.stefanini.hackathon.rest.persistence.ConnectorBD;
import com.stefanini.hackathon.rest.persistence.Repositorio;


@Path("/pessoa")
@Produces(MediaType.APPLICATION_JSON)
public class PessoaAPI {

	@Inject 
	Repositorio repositorio;
	
	@Inject
	ConnectorBD bd;
	
	@GET
	public Response consultar() throws NegocioException {
//		new PessoaParser().toMapDTO(repositorio.getMapPessoa())
		return Response.ok(bd.getPessoa()).build();
	}
	
	@GET
	@Path("/{cpf}")
	public Response consultar(@PathParam("cpf") String cpf) throws NegocioException {
		Pessoa pessoa;
		if(repositorio.getMapPessoa().get(cpf) == null) {
			throw new NegocioException("Pessoa nao encotrada!");
		}else {
			pessoa = repositorio.getMapPessoa().get(cpf);
		}
		return Response.ok(new PessoaParser().toDTO(pessoa)).build();
	}
	
	@POST
	public Response inserir(Pessoa pessoa) throws NegocioException {
		if(repositorio.getMapPessoa().get(pessoa.getCpf()) != null) {
			throw new NegocioException("Pessoa j� cadastrada.");
		}else {
			repositorio.getMapPessoa().put(pessoa.getCpf(), pessoa);
		}
		return Response.ok(new PessoaParser().toDTO(repositorio.getMapPessoa().get(pessoa.getCpf()))).build();
	}
	
	@PUT
	@Path("/{cpf}")
	public Response alterar(Pessoa pessoa, @PathParam("cpf") String cpf) {
		repositorio.getMapPessoa().put(cpf, pessoa);
		return Response.ok(repositorio.getMapPessoa().get(cpf)).build();
	}
	
	@DELETE
	@Path("/{cpf}")
	public Response excluir(@PathParam("cpf") String cpf) {
		repositorio.getMapPessoa().remove(cpf);
		return Response.ok(repositorio.getMapPessoa().get(cpf)).build();
	}
	
}
