package br.gov.conab.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.gov.conab.dao.MercadoDAO;
import br.gov.conab.models.Mercado;

public class MercadoController {

	/**
	 * Salvar.
	 *
	 * @param nome the nome
	 * @throws Exception the exception
	 */
	public static void salvar(String nome) throws Exception {

		Mercado mercado = new Mercado(nome);
		mercado.setNome(nome);
		new MercadoDAO().salvar(mercado);
	}
	 
	/**
	 * Alterar.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @throws Exception the exception
	 */
	public static void alterar(long id, String nome) throws Exception {

		Mercado mercado = new Mercado(nome);
		mercado.setNome(nome);
		new MercadoDAO().alterar(mercado);
	}
	 
	/**
	 * Lista mercados.
	 *
	 * @return the list
	 */
	public List<Mercado> listaMercados() throws Exception {

		MercadoDAO dao = new MercadoDAO();
		try {
			return dao.findAll();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Problemas ao localizar mercados" + e.getLocalizedMessage());
		}
		return null;
	}
	 
	/**
	 * Excluir.
	 *
	 * @param id the id
	 * @throws Exception the exception
	 */
	public static void excluir(long id) throws Exception {
		new MercadoDAO().excluir(id);
	}

	/**
	 * Busca mercado por nome.
	 *
	 * @param nome the nome
	 * @return the mercado
	 * @throws Exception the exception
	 */
	public static Mercado buscaMercadoPorNome(String nome) throws Exception {

		MercadoDAO dao = new MercadoDAO();
		return dao.findByName(nome);
	}
}