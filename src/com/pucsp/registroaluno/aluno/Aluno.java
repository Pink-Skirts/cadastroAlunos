package com.pucsp.registroaluno.aluno;

import com.pucsp.registroaluno.pessoa.Pessoa;

/**
 * Classe com as caracteristicas de um aluno que esta estendida para a classe pessoa.
 *
 * @author Guilherme Monteiro de Oliveira, Gustavo Scaglione Vilmar, Pietro Tadeu Viera Giorgi.
 * @version 1.0 2022/03/30
 */

public class Aluno extends Pessoa{
	
	private String ra;
	private String curso;
	private double nota;

	/**
	 * Construtor:
	 * @param nome String que armazena o nome - herdado de pessoa
	 * @param idade Integer que armazena a idade - herdado de pessoa
	 * @param ra	Strings que armazenam o ra
	 * @param curso Strings que armazenam o curso
	 * @param nota Double que armazenam a nota
	 */
	public Aluno(String nome, int idade, String ra, String curso, double nota) {
		super(nome, idade);
		setCurso(curso);
		setRa(ra);
		setNota(nota);
	}

	//Getters e setters
	public String setCurso(String curso) {
		return this.curso = curso;
	}

	public String setRa(String ra) {
		return this.ra = ra;
	}

	public double setNota(double nota) {
		return this.nota = nota;
	}

	public String getRa() {
		return ra;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public double getNota() {
		return nota;
	}

	public String toString() {
		return (super.toString() + "\nCurso: " + getCurso() + "\nRA: " + getRa() + "\nNota: " + getNota());
	}

}
