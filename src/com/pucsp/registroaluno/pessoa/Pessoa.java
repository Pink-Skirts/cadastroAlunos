package com.pucsp.registroaluno.pessoa;

/**
 * Classe com as caracteristicas de uma pessoa.
 *
 * @author Guilherme Monteiro de Oliveira, Gustavo Scaglione Vilmar, Pietro Tadeu Viera Giorgi (extends Julio Arakaki)
 * @version 1.0 2022/03/30
 */

public class Pessoa {
	private NomePessoa nome;
	private int idade;

	/**
	 * Construtor
	 * @param nome String com o nome que será armazenado
	 * @param idade Integer que sera armazenada a idade
	 */
	public Pessoa(String nome, int idade) {
		setNome(nome);
		setIdade(idade);
	}

	//Getters e setters
	public void setNome(String nome){
		this.nome = new NomePessoa(nome);
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getNome() {
		return this.nome.getNome();
	}
	
	public int getIdade() {
		return idade;
	}

	/**
	 * @return nome ivertido
	 */
	public String getNomeInvertido() {
		return this.nome.getNomeInvertido();
	}

	/**
	 * @return nome bibliografico
	 */
	public String getNomeBiblio() {
		return this.nome.getNomeBiblio();
	}
	
	public String toString() {
		return ("Nome: " + getNome() + "\nIdade: " + getIdade());
	}
}
