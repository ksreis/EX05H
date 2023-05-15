package controller;


import java.util.ArrayList;
import java.util.List;

public class TabelaEspalhamento {
    private List<List<ContaBancaria>> tabela;
    private int tamanho;

    public TabelaEspalhamento(int tamanho) {
        this.tamanho = tamanho;
        tabela = new ArrayList<>(tamanho);
        for (int i = 0; i < tamanho; i++) {
            tabela.add(new ArrayList<>());
        }
    }

    public void inserir(ContaBancaria conta) {
        int posicao = hash(conta.getNumeroConta());
        tabela.get(posicao).add(conta);
    }

    public List<ContaBancaria> consultar(int numeroConta) {
        int posicao = hash(numeroConta);
        return tabela.get(posicao);
    }

    public boolean remover(int numeroConta) {
        int posicao = hash(numeroConta);
        List<ContaBancaria> contas = tabela.get(posicao);
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                contas.remove(conta);
                return true;
            }
        }
        return false;
    }

    private int hash(int numeroConta) {
        return numeroConta % tamanho;
    }
}