/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao;

import java.util.Scanner;

/**
 *
 * @author Laura
 */
public class Correcao {

    Scanner entrada = new Scanner(System.in);
    String[] produtos = new String[10];
    boolean[] consertado = new boolean[10];
    boolean[] entregue = new boolean[10];
    double[] precoConserto = new double[10];
    int quantidadeProdutos = 0;

    public static void main(String[] args) {
        Correcao correcao = new Correcao();
        int opcao;
        do {
            opcao = correcao.mostrarMenu();
            switch (opcao) {
                case 1:
                    correcao.cadastrarProduto();
                    break;
                case 2:
                    correcao.fazerConserto();
                    break;
                case 3:
                    correcao.fazerEntrega();
                    break;
                case 4:
                    correcao.mostrarRelatorio();
                    break;
                case 5:
                    correcao.exibirProdutosNaoConsertados();
                    break;
                case 6:
                    correcao.exibirProdutosConsertadosNaoEntregues();
                    break;
                case 7:
                    correcao.exibirFaturamento();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 8);
    }

    public int mostrarMenu() {
        System.out.println("MENU: "
                + "\n1. Cadastrar produto;"
                + "\n2. Fazer conserto;"
                + "\n3. Entregar o produto ao cliente;"
                + "\n4. Exibir o relatório completo de produtos;"
                + "\n5. Exibir o reletório de produtos que ainda não foram consertados;"
                + "\n6. Exibir o relatório de produtos concertados, mas que ainda não foram retirados pelo cliente;"
                + "\n7. Exibir o faturamento total da loja;"
                + "\n8. Sair da aplicação;");
        int opcaoEscolhida = entrada.nextInt();
        return opcaoEscolhida;
    }

    public void cadastrarProduto() {
        System.out.println("Informe o nome do produto: ");
        produtos[quantidadeProdutos] = entrada.next();
        quantidadeProdutos++;
    }

    public void fazerConserto() {
        System.out.println("Informe o produto a ser consertado: ");
        String produto = entrada.next();
        for (int i = 0; i < quantidadeProdutos; i++) {
            if (produtos[i].equalsIgnoreCase(produto)) {
                consertado[i] = true;
                System.out.println("Informe o valor do conserto: ");
                precoConserto[i] = entrada.nextByte();
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

    public void fazerEntrega() {
        System.out.println("Informe o produto a ser retirado: ");
        String produto = entrada.next();
        for (int i = 0; i < quantidadeProdutos; i++) {
            if (produtos[i].equalsIgnoreCase(produto)) {
                entregue[i] = true;
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

    public void mostrarRelatorio() {
        for (int i = 0; i < quantidadeProdutos; i++) {
            System.out.println(produtos[i]);
        }
    }

    public void exibirProdutosNaoConsertados() {
        for (int i = 0; i < quantidadeProdutos; i++) {
            if (!consertado[i]) {
                System.out.println(produtos[i]);
            }
        }
    }

    public void exibirProdutosConsertadosNaoEntregues() {
        for (int i = 0; i < quantidadeProdutos; i++) {
            if (consertado[i] && !entregue[i]) {
                System.out.println(produtos[i]);
            }
        }
    }

    public void exibirFaturamento() {
        System.out.println("FATURAMENTO: ");
        double faturamento = 0;
        for (int i = 0; i < quantidadeProdutos; i++) {
            faturamento = faturamento + precoConserto[i];
        }
        System.out.println("Total: " + faturamento);
    }
}
