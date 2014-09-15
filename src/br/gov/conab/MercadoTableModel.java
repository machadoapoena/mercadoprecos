package br.gov.conab;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.gov.conab.models.Mercado;

/**
 * Copyright (C) 2014 CONAB
 * Companhia Nacional de Abastecimento
 * www.conab.gov.br
 *
 * MercadoTableModel.java
 *
 * @date 11/09/2014
 * @author apoena.machado
 */
public class MercadoTableModel extends AbstractTableModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3370813178369626555L;
	
	/** The colunas nome. */
	private String[] columnNames = new String[]{"id", "Nome"};
	
	/** The mercados. */
	private List<Mercado> mercados;
	
	/**
	 * Instantiates a new mercado table model.
	 *
	 * @param mercados the mercados
	 */
	public MercadoTableModel(List<Mercado> mercados) {
        this.mercados = mercados;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return this.mercados.size();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Object value = null;
		Mercado mercado = this.mercados.get(rowIndex);
		switch (columnIndex) {
			case 0:
				value = mercado.getId();
				break;
			case 1:
				value = mercado.getNome();
				break;
		}
		return value;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Class<?> getColumnClass(int columnIndex) {

		 Class clazz = String.class;
         switch (columnIndex) {
             case 0:
                 clazz = Long.class;
                 break;
             case 1:
                 clazz = String.class;
                 break;
         }
         return clazz;
	}
	
	/**
	 * Gets the column name.
	 *
	 * @param column the column
	 * @return the column name
	 */
	@Override
	public String getColumnName(int column) {
	    return this.columnNames[column];
	}
}