package br.gov.conab.frame;

import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import org.hibernate.type.CustomCollectionType;

import br.gov.conab.CustomTableListener;
import br.gov.conab.MercadoComboBoxModel;
import br.gov.conab.MercadoTableModel;
import br.gov.conab.components.Menu;
import br.gov.conab.controllers.MercadoController;
import br.gov.conab.textfield.JMoneyFieldValor;

/**
 * Copyright (C) 2014 CONAB
 * Companhia Nacional de Abastecimento
 * www.conab.gov.br
 *
 * StartFrame.java
 *
 * @date 11/09/2014
 * @author apoena.machado
 */
public class StartFrame extends JFrame {

	private static final String TITULO = "Mercado Preços";
	private static final long serialVersionUID = -3597357612204209122L;
	private JLabel lbMercado;
	private JLabel lbProduto;
	private JLabel lbPreco;
	private JFormattedTextField txPreco;
	private JComboBox c;
	private JButton btnSalvar;
	
	public StartFrame() throws Exception {
		super(TITULO);
		setSize(800, 600);
		Container tela = getContentPane();
		setLayout(null);
		this.lbMercado = new JLabel("Mercado");
		this.lbMercado.setBounds(10, 10, 240, 15);
		//this.lbMercado.setFont(new Font("Courier New", Font.BOLD, 14));
		tela.add(this.lbMercado);
		this.lbProduto = new JLabel("Produto");
		this.lbProduto.setBounds(300, 10, 240, 15);
		tela.add(this.lbProduto);
		this.lbPreco = new JLabel("Preço");
		this.lbPreco.setBounds(10, 40, 240, 15);
		tela.add(this.lbPreco);
		MercadoComboBoxModel model = new MercadoComboBoxModel(new MercadoController().listaMercados());
		this.c = new JComboBox(model);
		this.c.setBounds(90, 10, 200, 20);
		tela.add(this.c);
		this.txPreco = new JMoneyFieldValor();
		this.txPreco.setBounds(90, 40, 80, 20);
		tela.add(this.txPreco);
		this.btnSalvar = new JButton("Salvar");
		this.btnSalvar.setBounds(185, 40, 105, 20);
		tela.add(this.btnSalvar);
		this.setJMenuBar(new Menu());
		
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Tabela de Preços");
		JPanel pnPrecos = new JPanel();
		pnPrecos.setLayout(new BoxLayout(pnPrecos, BoxLayout.LINE_AXIS));
//		buttonPane.add(Box.createHorizontalStrut(5));
//		buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
//		buttonPane.add(Box.createHorizontalStrut(5));
		pnPrecos.setBorder(title);
		//pnPrecos.setBackground(Color.DARK_GRAY);
		JTable tbMercados = new JTable(new MercadoTableModel(new MercadoController().listaMercados()));
		tbMercados.getColumnModel().getColumn(0).setMaxWidth(40);
		tbMercados.getModel().addTableModelListener(new CustomTableListener());
		JScrollPane scrollPane = new JScrollPane(tbMercados);
		pnPrecos.add(scrollPane);
		pnPrecos.setBounds(10, 70, this.getWidth()-30, this.getHeight()-135);
		this.add(pnPrecos);

		
//		JSeparator jSeparator = new JSeparator(SwingConstants.HORIZONTAL);
//		jSeparator.setBounds(185, 40, 105, 20);
//		tela.add(jSeparator);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}