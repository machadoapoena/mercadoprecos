package br.gov.conab;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import br.gov.conab.models.Mercado;

/**
 * Copyright (C) 2014 CONAB
 * Companhia Nacional de Abastecimento
 * www.conab.gov.br
 *
 * MercadoComboBoxModel.java
 *
 * @date 10/09/2014
 * @author apoena.machado
 */
public class MercadoComboBoxModel extends AbstractListModel implements ComboBoxModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1457785332017943627L;

	/** The selected item. */
	private String selectedItem;
	
	/** The mercados. */
	private List<Mercado> mercados;
	
	public MercadoComboBoxModel(List<Mercado> mercados) {
        this.mercados = mercados;
      }
	
	/* (non-Javadoc)
	 * @see javax.swing.ListModel#getSize()
	 */
	@Override
	public int getSize() {
		return this.mercados.size();
	}

	/* (non-Javadoc)
	 * @see javax.swing.ListModel#getElementAt(int)
	 */
	@Override
	public Object getElementAt(int index) {

		return this.mercados.get(index).getNome();
	}

	/* (non-Javadoc)
	 * @see javax.swing.ComboBoxModel#setSelectedItem(java.lang.Object)
	 */
	@Override
	public void setSelectedItem(Object anItem) {

	    for (Mercado o: this.mercados){
            if (anItem==o){
                this.selectedItem=o.getNome();
                break;
            }
        }
	}

	/* (non-Javadoc)
	 * @see javax.swing.ComboBoxModel#getSelectedItem()
	 */
	@Override
	public Object getSelectedItem() {
		return this.selectedItem;
	}
}