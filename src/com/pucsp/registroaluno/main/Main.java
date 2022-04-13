package com.pucsp.registroaluno.main;

import com.pucsp.registroaluno.aluno.Cadastro;
import com.pucsp.registroaluno.exceptions.*;

import javax.swing.JOptionPane;

/**
 * Classe main.
 *
 * @author Guilherme Monteiro de Oliveira, Gustavo Scaglione Vilmar, Pietro Tadeu Viera Giorgi
 * @version 1.0 2022/03/30
 */

public class Main {

	public static void main(String[] args){
		boolean sair = false;

		Cadastro cadastro = new Cadastro();

		while(!sair){
			String menuDeOpcoes = 	"1: Cadastrar aluno\n" +
								  	"2: Remover aluno\n" +
									"3: Consultar Cadastro\n" +
									"4: Mostrar Alunos Cadastrados\n" +
									"5: Salvar\n" +
									"6: Carregar Dados\n" +
									"7: Sair\n\nSelecione uma opcao:";

			String op = JOptionPane.showInputDialog(menuDeOpcoes);
			if(op == null) {
				op = "7";
			}

			boolean sairMenu = false;
			switch (op){
				case "1":
					while(!sairMenu) {
						try {
							sairMenu = cadastro.cadastrarAlunos();
						} catch (CampoIncorretoException | CadastroCheioException e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}
					break;

				case "2":
					while(!sairMenu) {
						try {
							sairMenu = cadastro.removerCadastro();
						} catch (RaNaoExistenteException | FormatoRaIncorretoException e){
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}
					break;

				case "3":
					while(!sairMenu) {
						try {
							sairMenu = cadastro.mostrarCadastro();
						} catch (RaNaoExistenteException | FormatoRaIncorretoException e){
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}
					break;

				case "4":
					try {
						cadastro.mostrarTodosCadastros();
					} catch (CadastrosVaziosException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;

				case "5":
					cadastro.salvarCadastro();
					break;

				case "6":
					cadastro.carregarCadastro();
					break;

				case "7":
					sair = true;
					break;

				default: break;
			}
		}
	}
}
