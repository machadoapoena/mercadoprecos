package br.gov.conab.frame;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.gov.conab.components.Menu;

/**
 * Copyright (C) 2014 CONAB
 * Companhia Nacional de Abastecimento
 * www.conab.gov.br
 *
 * MercadoFrame.java
 *
 * @date 11/09/2014
 * @author apoena.machado
 */
public class MercadoFrame extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6923355947619542294L;
	
	/** The Constant TITULO. */
	private static final String TITULO = "Mercado Preços";
	
	/** The lb nome. */
	private JLabel lbNome;
	
	/** The tx nome. */
	private JTextField txNome;
	
	/** The btn salvar. */
	private JButton btnSalvar;
	
	public MercadoFrame() throws Exception {
		
		super(TITULO);
		setSize(800, 600);
		Container tela = getContentPane();
		setLayout(null);
		this.lbNome = new JLabel("Mercado");
		this.lbNome.setBounds(10, 10, 240, 15);
		tela.add(this.lbNome);
		this.txNome = new JTextField();
		this.txNome.setBounds(90, 10, 200, 20);
		tela.add(this.txNome);
		this.btnSalvar = new JButton("Salvar");
		this.btnSalvar.setBounds(185, 40, 105, 20);
		tela.add(this.btnSalvar);
		this.setJMenuBar(new Menu());
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}