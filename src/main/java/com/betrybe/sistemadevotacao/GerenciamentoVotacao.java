package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe GerenciamentoVotacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private final ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  private final ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  private final ArrayList<String> cpfsComputados = new ArrayList<>();

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (!this.pessoasCandidatas.isEmpty()) {
      for (PessoaCandidata pc :
          this.pessoasCandidatas) {
        if (pc.getNumero() == numero) {
          System.out.println("Número da pessoa candidata já utilizado!");
          return;
        }
      }
    }

    PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
    this.pessoasCandidatas.add(pessoaCandidata);
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (!this.pessoasEleitoras.isEmpty()) {
      for (PessoaEleitora pe :
          this.pessoasEleitoras) {
        if (pe.getCpf().equals(cpf)) {
          System.out.println("Pessoa eleitora já cadastrada!");
          return;
        }
      }
    }

    PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
    this.pessoasEleitoras.add(pessoaEleitora);
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (this.cpfsComputados.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }

    for (PessoaCandidata pessoaCandidata :
        this.pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numeroPessoaCandidata) {
        pessoaCandidata.receberVoto();
      }
    }

    this.cpfsComputados.add(cpfPessoaEleitora);
  }

  @SuppressWarnings("checkstyle:WhitespaceAfter")
  @Override
  public void mostrarResultado() {
    if (this.cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }

    int total = this.cpfsComputados.size();

    for (PessoaCandidata pessoaCandidata :
        this.pessoasCandidatas) {
      String nome = pessoaCandidata.getNome();
      int voto = pessoaCandidata.getVotos();
      int porcentagem = (int) Math.round((double) 100 * voto / total);

      System.out.printf("Nome: %s - %d votos ( %d%% )\n", nome, voto, porcentagem);
    }

    System.out.println("Total de votos: " + total);
  }
}
