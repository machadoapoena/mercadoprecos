package br.gov.conab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import br.gov.conab.frame.StartFrame;
import br.gov.conab.models.Mercado;

/**
 * Copyright (C) 2014 CONAB
 * Companhia Nacional de Abastecimento
 * www.conab.gov.br
 *
 * Start.java
 *
 * @date 10/09/2014
 * @author apoena.machado
 */
public class Start {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("appSwingCrudUnit");
	    EntityManager manager = factory.createEntityManager();
	    Mercado mercado = new Mercado("Carregour");
	    manager.getTransaction().begin();    
	    manager.persist(mercado);
	    manager.getTransaction().commit();  
	    System.out.println("ID da tarefa: " + mercado.getId());
	    manager.close();
	    factory.close();
	    SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	StartFrame frame;
				try {
					frame = new StartFrame();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
	
	}
}