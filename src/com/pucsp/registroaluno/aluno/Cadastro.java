package com.pucsp.registroaluno.aluno;
import com.pucsp.registroaluno.exceptions.*;

import javax.swing.JOptionPane;
import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.io.FileOutputStream;
import static java.nio.file.Files.isDirectory;

/**
 * Classe feita para realizar cadastros (de alunos) usando a classe
 * aluno, tendo metodos de: criar, remover, e/ou mostrar o aluno cadastrado.
 *
 * @author Guilherme Monteiro de Oliveira, Gustavo Scaglione Vilmar, Pietro Tadeu Viera Giorgi
 * @version 1.0 2022/03/30
 */

public class Cadastro {

	private static int QTD_ALUNOS = 10;
	private Aluno[] aluno = new Aluno[QTD_ALUNOS];
	
	/**
	 * Construtor
	 * Usa o metodo de iniciar a lista com todos os elementos nulos
	 */
	public Cadastro (){
		iniciarLista();
	}

	/**
	 * Cadastro de alunos armanzenando eles no vetor da instancia alunos
	 */
	public boolean cadastrarAlunos() throws CampoIncorretoException, CadastroCheioException {
		boolean cancelado = false;
		int j = 0;
		boolean vazio = false;
		for (int i = 0; i < aluno.length; i++) {
			if (aluno[i] == null) {
				vazio = true;
				j = i;
				break;
			}
		}

		if(!vazio) {
			throw new CadastroCheioException();
		} else {
			String nome;
			String idadeS;
			String ra;
			String curso;
			String notaS;

			/**
			 * Guardando os dados e verificando a validade deles.
			 */
			do {
				nome = JOptionPane.showInputDialog("Nome do aluno: ");
				if(nome == null || nome.trim().equals("") || nome.matches(".*[1-9].*")) {
					if(nome == null) {
						cancelado = true;
						return cancelado;
					}
					throw new CampoIncorretoException();
				}
			}while(nome.trim().equals("") || nome.matches(".*[1-9].*"));
			
			nome = nome.trim().replaceAll("\\s+", " ");
				
			do {
				idadeS = JOptionPane.showInputDialog("Idade do aluno: ");
				if(idadeS == null || idadeS.trim().equals("") || idadeS.matches(".*[A-Za-z].*") || (Integer.parseInt(idadeS) < 18 || Integer.parseInt(idadeS) > 100)) {
					if(idadeS == null) {
						cancelado = true;
						return cancelado;
					}
					throw new CampoIncorretoException();
				}
			}while(idadeS.trim().equals("") || idadeS.matches(".*[A-Za-z].*") || (Integer.parseInt(idadeS) < 18 || Integer.parseInt(idadeS) > 100));
				
			do {
				ra = JOptionPane.showInputDialog("RA do aluno: ");
				if(ra == null || ra.trim().equals("") || !ra.matches("ra.*")) {
					if(ra == null) {
						cancelado = true;
						return cancelado;
					}
					throw new CampoIncorretoException();
				}
			} while(ra.trim().equals("") || !ra.matches("ra.*"));
			
			do {
				curso = JOptionPane.showInputDialog("Curso do aluno: ");
				if(curso == null || curso.trim().equals("") || curso.matches(".*[1-9].*")) {
					if(curso == null) {
						cancelado = true;
						return cancelado;
					}
					throw new CampoIncorretoException();
				}
			}while(curso.trim().equals("") || curso.matches(".*[1-9].*"));
				
			do {
				notaS = JOptionPane.showInputDialog("Nota do aluno: ");
				if(notaS == null || notaS.trim().equals("") || notaS.matches(".*[A-Za-z].*") || (Double.parseDouble(notaS) < 0 || Double.parseDouble(notaS) > 10)) {
					if(notaS == null) {
						cancelado = true;
						return cancelado;
					}
					throw new CampoIncorretoException();
				}
			}while(notaS.trim().equals("") || notaS.matches(".*[A-Za-z].*") || (Double.parseDouble(notaS) < 0 || Double.parseDouble(notaS) > 10));

			int idade = Integer.parseInt(idadeS);
			double nota = Double.parseDouble(notaS);

			aluno[j] = new Aluno(nome, idade, ra, curso, nota);
			JOptionPane.showMessageDialog(null, "Cadastro realizado!");
		}
		cancelado = true;
		return cancelado;
	}

	/**
	 * Remove o cadastro de um aluno com base no seu ra e deixa os valores nulos
	 */
	public boolean removerCadastro() throws RaNaoExistenteException, FormatoRaIncorretoException {
		boolean cancelado = false;
		String ra;
		do {
			ra = JOptionPane.showInputDialog("RA do aluno a ser removido: ");
			if (ra == null || ra.trim().equals("") || !ra.matches("ra.*")) {
				if (ra == null) {
					cancelado = true;
					return cancelado;
				}
				throw new FormatoRaIncorretoException();
			}
		} while (ra.trim().equals("") || !ra.matches("ra.*"));


		boolean removido = false;

		for (int i = 0; i < aluno.length; i++) {
			if (aluno[i] != null && aluno[i].getRa().equals(ra)) {
				aluno[i] = null;
				removido = true;
				break;
			}
		}
		if (!removido) {
			throw new RaNaoExistenteException();
		} else {
			JOptionPane.showMessageDialog(null, "Cadastro removido.");
		}
		cancelado = true;
		return cancelado;
	}

	/**
	 * Printa na tela em uma janela de dialogo o cadastro de uma aluno com base em seu ra
	 */
	public boolean mostrarCadastro() throws RaNaoExistenteException, FormatoRaIncorretoException {
		String ra;
		boolean cancelado;
		do {
			ra = JOptionPane.showInputDialog("RA do aluno a ser mostrado: ");
			if (ra == null || ra.trim().equals("") || !ra.matches("ra.*")) {
				if(ra == null) {
					cancelado = true;
					return cancelado;
				}
				throw new FormatoRaIncorretoException();
			}
		} while(ra.trim().equals("") || !ra.matches("ra.*"));

		boolean achou = false;
		for (int i = 0; i < aluno.length; i++){
			if(aluno[i] != null && aluno[i].getRa().equals(ra)){
				achou = true;
				JOptionPane.showMessageDialog(null, aluno[i].getNome() + '\n'
						+ aluno[i].getIdade() + '\n' + aluno[i].getRa() + '\n' + aluno[i].getCurso() + '\n' + aluno[i].getNota());
				break;
			}
		}
		if(!achou){
			throw new RaNaoExistenteException();
		}
		cancelado = true;
		return cancelado;
	}

	public boolean verificaListaVazia() {
		int cont = 0;
		boolean vazia = false;

		for (int i = 0; i < aluno.length; i++)
			if (aluno[i] == null) cont++;

		if (cont == aluno.length) vazia = true;

		return vazia;
	}

	public void mostrarTodosCadastros() throws CadastrosVaziosException {
		if (verificaListaVazia()) {
			throw new CadastrosVaziosException();
		} else {
			for (int i = 0; i < aluno.length; i++) {
				int aux = i + 1;
				if (aluno[i] != null) {
					JOptionPane.showMessageDialog(null, "Aluno " + aux + ":\n" + aluno[i].getNome() + "\n"
							+ aluno[i].getIdade() + "\n" + aluno[i].getRa() + "\n" + aluno[i].getCurso() + "\n" + aluno[i].getNota());
				}
			}
		}
	}

	public String toString(){
		return (Arrays.toString(aluno));
	}

	public void salvarCadastro() {
		try {
			if (isDirectory(Path.of("arquivo.txt"))){
				File arquivo = new File("arquivo.txt");
				System.out.println("Arquivo criado em: " + arquivo.getCanonicalPath()); //returns the path string
				FileOutputStream fos = new FileOutputStream("arquivo.txt", true);
				String entrada;
				for (int i = 0; i < aluno.length; i++) {
					int aux = i + 1;
					if (aluno[i] != null) {
						entrada = "Aluno " + aux + ":\n" + aluno[i].getNome() + "\n"
								+ aluno[i].getIdade() + "\n" + aluno[i].getRa() + "\n" + aluno[i].getCurso() + "\n" + aluno[i].getNota();
						byte[] b = entrada.getBytes();
						fos.write(b);
					}
				}
				fos.close();
				System.out.println("Arquivo salvo.");
			}
			else {
				FileOutputStream fos = new FileOutputStream("arquivo.txt", true);
				String entrada;
				for (int i = 0; i < aluno.length; i++) {
					int aux = i + 1;
					if (aluno[i] != null) {
						entrada = "Aluno " + aux + ":\n" + aluno[i].getNome() + "\n"
								+ aluno[i].getIdade() + "\n" + aluno[i].getRa() + "\n" + aluno[i].getCurso() + "\n" + aluno[i].getNota();
						byte[] b = entrada.getBytes();
						fos.write(b);
					}
				}
				fos.close();
				System.out.println("Arquivo salvo.");
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void carregarCadastro() {

	}

	/**
	 * Iniciando a lista com todos os espacos vazios
	 */
	public void iniciarLista() {
		Arrays.fill(aluno, null);
	}
}
