package br.gov.conab.dao;

import br.gov.conab.models.Mercado;

/**
 * Copyright (C) 2014 CONAB
 * Companhia Nacional de Abastecimento
 * www.conab.gov.br
 *
 * MercadoDAO.java
 *
 * @date 10/09/2014
 * @author apoena.machado
 */
public class MercadoDAO extends GenericDAO<Mercado> {

	/**
	 * Salvar.
	 *
	 * @param mercado the mercado
	 */
	public void salvar(Mercado mercado) {
		save(mercado);
	}

	/**
	 * Alterar.
	 *
	 * @param mercado the mercado
	 */
	public void alterar(Mercado mercado) {
		update(mercado);
	}
	 
	/**
	 * Excluir.
	 *
	 * @param id the id
	 */
	public void excluir(long id) {
		Mercado c = findById(id);
		delete(c);
	}
}