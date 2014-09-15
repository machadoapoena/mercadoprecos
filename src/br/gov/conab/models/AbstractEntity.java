package br.gov.conab.models;

/**
 * Copyright (C) 2014 CONAB
 * Companhia Nacional de Abastecimento
 * www.conab.gov.br
 *
 * AbstractEntity.java
 *
 * @date 10/09/2014
 * @author apoena.machado
 */
public interface AbstractEntity {

	/**
	 * @return A refer�ncia para a chave prim�ria (Primary Key) de cada objeto persistido.
	 * 		   Caso o objeto ainda n�o tenha sido persistido, deve retornar <code>null</code>.
	 */
	public Long getId();
}