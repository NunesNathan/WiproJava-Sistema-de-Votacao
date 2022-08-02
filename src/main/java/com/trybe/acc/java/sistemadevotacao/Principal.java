package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  /** Metodo main. */
  public static void main(String[] args) {
    GerenciamentoVotacao gv = new GerenciamentoVotacao();
    Scanner scan = new Scanner(System.in);
    byte option = 1;

    do {
      interacoes(1);
      option = scan.nextByte();
      if (option == 1) {
        novaPessoaCandidata(gv, scan);
      }
    } while (option == 1);

    do {
      interacoes(2);
      option = scan.nextByte();
      if (option == 1) {
        novaPessoaEleitora(gv, scan);
      }
    } while (option == 1);

    do {
      interacoes(3);
      option = scan.nextByte();

      if (option == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scan.next();

        System.out.println("Entre com o número da pessoa candidata:");
        Short numeroCandidato = scan.nextShort();
        gv.votar(cpf, numeroCandidato);
      } else if (option == 2) {
        gv.mostrarResultado();
      } else {
        gv.mostrarResultado();
        break;
      }
    } while (option != 3);

    scan.close();
  }

  private static void novaPessoaCandidata(GerenciamentoVotacao gv, Scanner scan) {
    System.out.println("Entre com o nome da pessoa candidata:");
    String nome = scan.next();

    System.out.println("Entre com o número da pessoa candidata:");
    short numero = scan.nextShort();

    gv.cadastrarPessoaCandidata(nome, numero);
  }

  private static void novaPessoaEleitora(GerenciamentoVotacao gv, Scanner scan) {
    System.out.println("Entre com o nome da pessoa eleitora:");
    String nome = scan.next();

    System.out.println("Entre com o cpf da pessoa eleitora:");
    String cpf = scan.next();

    gv.cadastrarPessoaEleitora(nome, cpf);
  }

  private static void interacoes(int interacao) {
    if (interacao == 1) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
    } else if (interacao == 2) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
    } else {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
    }
  }

}
