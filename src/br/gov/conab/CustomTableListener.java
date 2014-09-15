package br.gov.conab;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;


public class CustomTableListener implements TableModelListener {

	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println(e.getClass());
		System.out.println(e.getColumn());
	}

}
