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
public class Avaliacao {

    /**
     * @param args the command line arguments
     */
    Scanner entrada = new Scanner(System.in);
    String[] produtos = new String[10];
    boolean[] consertado = new boolean[10];
    boolean[] entregue = new boolean[10];
    int[] conserto = new int[10];
    double[] preco = new double[10];
    double[] faturamento = new double[10];
    int valor = 0;

    public static void main(String[] args) {
        // TODO code application logic here
        Avaliacao minhaClasse = new Avaliacao();
        int opcao = 0;
        do {
            opcao = minhaClasse.mostrarMenu();
            switch (opcao) {
                case 1:
                    minhaClasse.mostrarMenu();
                    break;
                case 2:
                    minhaClasse.fazerConserto();
                    break;
                case 3:
                    minhaClasse.entregarProdutoAoCliente();
                    break;
                case 4:
                    minhaClasse.motrarRelatorioDeProdutos();
                    break;
                case 7:
                    minhaClasse.exibirFaturamento();
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
        System.out.println("Informe o produto: ");
        produtos[valor] = entrada.next();
    }

    public void fazerConserto() {
        System.out.println("Informe o produto: ");
        String produto = entrada.next();
        System.out.println("Informe o valor do conserto: ");
        int valorConserto = entrada.nextInt();
        for (int i = 0; i < valor; i++) {
            if (produto.equalsIgnoreCase(produtos[i])) {
                if (valorConserto <= conserto[i]) {
                    conserto[i] = conserto[i] - valorConserto;
                    faturamento[i] += valorConserto * preco[i];
                    System.out.println("Produto concertado!");
                    return;
                } else {
                    System.out.println("Produto ainda não foi consertado.");
                    return;
                }
            }
        }
    }

    public void entregarProdutoAoCliente() {
        System.out.println("");
    }

    public void motrarRelatorioDeProdutos() {
        System.out.println(
                formatarSaida("Nome", 20)
                + formatarSaida("Preço", 10));
        for (int i = 0; i < valor; i++) {
            System.out.println(formatarSaida(produtos[i], 20)
                    + formatarSaida("R$ " + preco[i], 10));
        }
    }

    public String formatarSaida(String texto, int tamanho) {
        while (texto.length() < tamanho) {
            texto = " " + texto;
        }
        return texto;
    }

    public void exibirFaturamento() {
        System.out.println("Faturamento: ");
        for (int i = 0; i < valor; i++) {
            System.out.println(produtos[i] + ": " + faturamento[i]);
        }
    }
}
