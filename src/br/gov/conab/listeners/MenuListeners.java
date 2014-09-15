package br.gov.conab.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.gov.conab.frame.MercadoFrame;


public class MenuListeners implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Mercado")){
			try {
				new MercadoFrame();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		System.out.println("Menu item [" + e.getActionCommand() + "] was pressed.");
	}

}
