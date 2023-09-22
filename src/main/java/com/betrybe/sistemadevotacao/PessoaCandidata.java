package com.betrybe.sistemadevotacao;

/**
 * Classe PessoaCandidata.
 */
public class PessoaCandidata extends Pessoa {

  private int numero;
  private int votos;

  /**
   * Construtor PessoaCandidata.
   */
  public PessoaCandidata(String nome, int numero) {
    this.setNome(nome);
    this.setNumero(numero);
    this.setVotos(0);
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }

  @Override
  public String getNome() {
    return super.getNome();
  }

  @Override
  public void setNome(String name) {
    super.setNome(name);
  }

  public void receberVoto() {
    this.votos++;
  }
}