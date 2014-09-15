package br.gov.conab.util;

import java.net.URL;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/**
 * Copyright (C) 2014 CONAB
 * Companhia Nacional de Abastecimento
 * www.conab.gov.br
 *
 * ApplicationProperties.java
 * Recupera e disponibiliza informações do <code>MANIFEST.MF</code> para o aplicativo.
 * @date 10/09/2014
 * @author apoena.machado
 */
public class ApplicationProperties {

	/** The manifest. */
	private Manifest manifest;
	
	/** The instance. */
	private static ApplicationProperties instance;
	
	/**
	 * Instantiates a new application properties.
	 *
	 * @param manifest the manifest
	 */
	private ApplicationProperties(Manifest manifest){
		this.manifest = manifest;
	}
	
	static {
		try {
			Enumeration<URL> resources = ApplicationProperties.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
			while (resources.hasMoreElements()) {
				Manifest manifest = new Manifest(resources.nextElement().openStream());
				if (manifest.getMainAttributes().getValue("Built-By") != null && manifest.getMainAttributes().getValue("Built-By").equals("YaW Tecnologia")) {
					instance = new ApplicationProperties(manifest);
					break;
				}
			}
	    } catch (Exception e) {}
	}
	
	/**
	 * Gets the titulo.
	 *
	 * @return the titulo
	 */
	public static String getTitulo(){
		return checkProperty("Implementation-Title");
	}
	
	/**
	 * Gets the versao.
	 *
	 * @return the versao
	 */
	public static String getVersao(){
		return checkProperty("Implementation-Version");
	}
	
	/**
	 * Gets the builds the.
	 *
	 * @return the builds the
	 */
	public static String getBuild(){
		return checkProperty("Implementation-Build");
	}
	
	/**
	 * Gets the desenvolvido por.
	 *
	 * @return the desenvolvido por
	 */
	public static String getDesenvolvidoPor(){
		return checkProperty("Built-By");
	}
	
	/**
	 * Gets the site.
	 *
	 * @return the site
	 */
	public static String getSite(){
		return checkProperty("Implementation-Site");
	}
	
	/**
	 * Check property.
	 *
	 * @param p the p
	 * @return the string
	 */
	private static String checkProperty(String p) {
		if (instance == null)
			return "";
		
		return instance.getManifestProperty(p);
	}
	
	/**
	 * Gets the manifest property.
	 *
	 * @param property the property
	 * @return the manifest property
	 */
	private String getManifestProperty(String property) {
		Attributes attributes = this.manifest.getMainAttributes();
		return attributes.getValue(property);
	}
	
	/**
	 * Gets the URL logo.
	 *
	 * @return the URL logo
	 */
	public static URL getURLLogo() { 
        URL imageURL = ApplicationProperties.class.getClassLoader().getResource("logo_yaw.png");  
        return imageURL;  
    }
}