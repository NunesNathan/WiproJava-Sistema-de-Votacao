package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoVotacao {
  private static ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private static ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos;

  /** Metodo cadastrar pessoa candidata. */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (int i = 0; i < this.pessoasCandidatas.size(); i += 1) {
      if (this.pessoasCandidatas.get(i).getNumero() == numero) {
        System.out.println("Número pessoa candidata já utilizado!");
        break;
      }
    }

    this.pessoasCandidatas.add(new PessoaCandidata(nome, numero));
  }

  /** Metodo cadastrar pessoa eleitora. */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (int i = 0; i < pessoasEleitoras.size(); i += 1) {
      if (pessoasEleitoras.get(i).getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        break;
      }
    }

    pessoasEleitoras.add(new PessoaEleitora(nome, cpf));
  }

  /** Metodo votar. */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfComputado.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }

    for (int i = 0; i < this.pessoasCandidatas.size(); i += 1) {
      if (this.pessoasCandidatas.get(i).getNumero() == numeroPessoaCandidata) {
        this.pessoasCandidatas.get(i).receberVoto();
        cpfComputado.add(cpfPessoaEleitora);
        this.totalVotos += 1;
      }
    }
  }

  /** Metodo mostrar resultado. */
  public void mostrarResultado() {
    if (this.totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    }

    for (int i = 0; i < this.pessoasCandidatas.size(); i += 1) {
      System.out.println("Nome: "
                      + this.pessoasCandidatas.get(i).getNome()
                      + " - "
                      + this.pessoasCandidatas.get(i).getVotos()
                      + " votos  ( "
                      + Math.round(this.calcularPorcentagemVotos(i) * 100)
                      + "% )");
    }

    System.out.println("Total de votos: " + this.totalVotos);
  }

  private double calcularPorcentagemVotos(int index) {
    return (double) pessoasCandidatas.get(index).getVotos() / this.totalVotos;
  }
}
