package br.gov.conab.components;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.gov.conab.listeners.MenuListeners;

/**
 * Copyright (C) 2014 CONAB
 * Companhia Nacional de Abastecimento
 * www.conab.gov.br
 *
 * Menu.java
 *
 * @date 11/09/2014
 * @author apoena.machado
 */
public class Menu extends JMenuBar {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9084121924468680935L;
	
	/** The cadastrar items. */
	String[ ] cadastrarMenuItems = new String[ ] { "Mercado", "Produto", "Sair" };
	
	/** The edit items. */
	String[ ] relatorioMenuItems = new String[ ] { "Gerencial", "Outros"};

	public Menu() {
		
		super();
		JMenu cadastrarMenu = new JMenu("Cadastrar");
		JMenu relatorioMenu = new JMenu("Relatorios");
		JMenu subMenuRGerencial = new JMenu("Gerencial");
		JMenu subMenuROutros = new JMenu("Outros");
		MenuListeners menuListener = new MenuListeners();
		for (int i = 0; i < this.cadastrarMenuItems.length; i++) {
			JMenuItem item = new JMenuItem(this.cadastrarMenuItems[i]);
			item.addActionListener(menuListener);
			cadastrarMenu.add(item);
		}
		JMenuItem item;
		subMenuRGerencial.add(item = new JMenuItem("Relatorio 1"));
		item.addActionListener(menuListener);
		relatorioMenu.add(subMenuRGerencial);
		subMenuROutros.add(item = new JMenuItem("Relatorio 2"));
		item.addActionListener(menuListener);
		relatorioMenu.add(subMenuROutros);
		add(cadastrarMenu);
		add(relatorioMenu);
	}
}