package com.betrybe.sistemadevotacao;

/**
 * Classe abistrata Pessoa.
 */
public abstract class Pessoa {

  private String nome;

  public String getNome() {
    return nome;
  }

  public void setNome(String name) {
    this.nome = name;
  }
}
