package br.gov.conab.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Copyright (C) 2014 CONAB
 * Companhia Nacional de Abastecimento
 * www.conab.gov.br
 *
 * JPAUtil.java
 * 
 * @date 10/09/2014
 * @author apoena.machado
 */
public class JPAUtil {

	/** The log. */
	private static Logger log = LogManager.getLogger(JPAUtil.class.getName());
	
	/** Unidade de persistencia definida no arquivo <code>persistence.xml</code> */
	private static final String PERSISTENCE_UNIT_NAME = "appSwingCrudUnit";
	
	/** The emf. */
	private static EntityManagerFactory emf;
	 
	public static EntityManager getEntityManager() {

		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		return emf.createEntityManager();
	}
}