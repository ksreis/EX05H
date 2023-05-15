package controller;

import java.util.List;
import javax.swing.JOptionPane;

public class BancoApp {

    public static void main(String[] args) {
        TabelaEspalhamento tabela = new TabelaEspalhamento(100); // Defina o tamanho adequado para a tabela

        while (true) {
            String opcao = JOptionPane.showInputDialog("Escolha uma opção:\n1. Inserir conta\n2. Consultar conta\n3. Remover conta\n4. Sair");

            switch (opcao) {
                case "1":
                    String numeroContaStr = JOptionPane.showInputDialog("Digite o número da conta:");
                    int numeroConta = Integer.parseInt(numeroContaStr);
                    String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
                    String saldoStr = JOptionPane.showInputDialog("Digite o saldo:");
                    double saldo = Double.parseDouble(saldoStr);

                    ContaBancaria conta = new ContaBancaria(numeroConta, nomeCliente, saldo);
                    tabela.inserir(conta);
                    JOptionPane.showMessageDialog(null, "Conta inserida com sucesso.");
                    break;
                
                case "2":
                    String numeroConsultaStr = JOptionPane.showInputDialog("Digite o número da conta para consulta:");
                    int numeroConsulta = Integer.parseInt(numeroConsultaStr);
                    List<ContaBancaria> contas = tabela.consultar(numeroConsulta);
                    StringBuilder resultadoConsulta = new StringBuilder();
                    for (ContaBancaria c : contas) {
                        resultadoConsulta.append("Número da conta: ").append(c.getNumeroConta())
                            .append("\nNome do cliente: ").append(c.getNomeCliente())
                            .append("\nSaldo: ").append(c.getSaldo())
                            .append("\n\n");
                    }
                    if (resultadoConsulta.length() == 0) {
                        JOptionPane.showMessageDialog(null, "Nenhuma conta encontrada.");
                    } else {
                        JOptionPane.showMessageDialog(null, resultadoConsulta.toString());
                    }
                    break;
                
                case "3":
                    String numeroRemocaoStr = JOptionPane.showInputDialog("Digite o número da conta para remoção:");
                    int numeroRemocao = Integer.parseInt(numeroRemocaoStr);
                    boolean removido = tabela.remover(numeroRemocao);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Conta removida com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada.");
                    }
                    break;
                
                case "4":
                    System.exit(0);
                
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, tente novamente.");
            }
        }
    }
}