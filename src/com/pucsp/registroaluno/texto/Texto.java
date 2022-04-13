package com.pucsp.registroaluno.texto;

/**
 * Armazena um texto. Inverte texto e limpa espaços extras
 *
 * @author Guilherme Monteiro de Oliveira, Gustavo Scaglione Vilmar, Pietro Tadeu Viera Giorgi
 * @version 1.0 2022/03/30
 */

public class Texto {
    private String txt;

    /**
     * Construtor: armazena o texto e limpa os espaços excedentes
     * @param txt String com o texto que será armazenado
     */
    public Texto(String txt) {
        setTxt(txt);
        concatenarEspacos();
    }

    //Getters e setters
    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getTxt(){
        return this.txt;
    }

    public String toString() {
        return getTxt();
    }

    /**
     * Retorna um texto invertido
     * @return txtInvertido String contendo o texto invertido
     */
    public String inverter() {
        String txtInvertido = "";
        if(!(getTxt() == null || this.txt.equals(""))){
            int tamanho = obterTamanho();
            for(int i = tamanho-1; i >= 0; i--) {
                txtInvertido = txtInvertido + getTxt().charAt(i);
            }
        }else {
            return null;
        }

        return txtInvertido;
    }

    /**
     * Retorna quantidade de palavras do nome
     * @return palavras numero de palavras
     */
    public int contarPalavras() {
        int palavras = 1;
        if(!(getTxt() == null || this.txt.equals(""))){

            int tamanho = obterTamanho();

            for(int i = 0; i < tamanho; i++) {
                int aux = i + 1;
                if(getTxt().charAt(i) == ' ') {
                    if(getTxt().charAt(aux) != ' ') {
                        palavras++;
                    }
                }
            }
        }else {
            return 0;
        }

        return palavras;

    }

    /**
     * Devolve o tamanho do texto
     * @return o tamanho do txt
     */
    public int obterTamanho() {
    	return getTxt().length();
    }

    /**
     * Retira espacos excedentes de uma string
     * @return txtConcatenada string sem espacos excedentes
     */
    public void concatenarEspacos(){
        String txtConcatenada = "";
        int tamanho = obterTamanho();
        
        this.txt = this.txt.trim();

        if(!(getTxt() == null || this.txt.equals(""))) {
        	for(int i = 0; i < tamanho; i++) {
        		txtConcatenada = txtConcatenada + getTxt().charAt(i);
        		if(getTxt().charAt(i) == ' ') {
        			while(getTxt().charAt(i+1) == ' ') {
        				i++;
        			}
        		}
        	}
        }
        setTxt(txtConcatenada);
    }
 }
