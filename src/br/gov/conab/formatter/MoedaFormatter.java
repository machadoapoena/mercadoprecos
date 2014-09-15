package br.gov.conab.formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.text.MaskFormatter;

/**
 * Copyright (C) 2014 CONAB
 * Companhia Nacional de Abastecimento
 * www.conab.gov.br
 *
 * MoedaFormatter.java
 *
 * @date 11/09/2014
 * @author apoena.machado
 */
public class MoedaFormatter extends MaskFormatter {

	public MoedaFormatter() {
		super();
		try {
			setMask("##.####,##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	

    @Override
    public Object stringToValue(String string) throws ParseException {
		NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));     
		moneyFormat.setMinimumFractionDigits(2);
        return moneyFormat.parse(string);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
    	if (!(value instanceof Double)) {  
	      return super.valueToString(value);  
	    }  
    	if (value != null){
    		NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));     
    		moneyFormat.format(value);     
    		moneyFormat.setMinimumFractionDigits(2);   
            return moneyFormat.toString();
    	}
    	return "";
    }

	
	//public Object stringToValue(String string) throws ParseException {
		
//		NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));     
//		moneyFormat.format(valor2);     
//		moneyFormat.setMinimumFractionDigits(2);     
//		String valor3 = String.valueOf(valor2);     
//		ttf_5.setText(valor3);  
		
//		java.text.DecimalFormat decimal = new java.text.DecimalFormat("######,##");  
//        javax.swing.text.NumberFormatter numFormatter = new javax.swing.text.NumberFormatter(decimal);  
//        numFormatter.setFormat(decimal);  
//        numFormatter.setAllowsInvalid(false);  
//	  }
}
