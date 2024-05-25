import java.util.InputMismatchException;
import java.util.Scanner;

public class Executora {
    static Scanner sc = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_VERMELHO = "\u001B[91m";
    public static final String ANSI_VERDE = "\u001B[92m";
    public static final String ANSI_CIANO = "\u001B[94m";
    public static final String ANSI_NEGRITO = "\u001B[1m";

    public static String colorir(String texto, String cor) {
        return cor + texto + ANSI_RESET;
    }
    public static void mensagemErro() {
        System.out.println(ANSI_VERMELHO + ANSI_NEGRITO + "Entrada inválida!" + ANSI_RESET);
        esperar();
    }

    public static void esperar() {
        System.out.print("\n\n" + ANSI_NEGRITO + "Aperte " + ANSI_CIANO + "Enter " + ANSI_RESET + ANSI_NEGRITO + "para continuar..." + ANSI_RESET);
        sc.nextLine();
        sc.nextLine();
    }

    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        int opcao = 0;
        while (opcao != 9) {
            System.out.println("\nMenu:");
            System.out.println("1. " + colorir("Inserir elemento na árvore", ANSI_VERDE));
            System.out.println("2. " + colorir("Remover elemento da árvore", ANSI_VERDE));
            System.out.println("3. " + colorir("Buscar elemento na árvore", ANSI_VERDE));
            System.out.println("4. " + colorir("Mostrar caminho até um elemento na árvore", ANSI_VERDE));
            System.out.println("5. " + colorir("Imprimir árvore", ANSI_VERDE));
            System.out.println("6. " + colorir("Imprimir pré-ordem", ANSI_VERDE));
            System.out.println("7. " + colorir("Imprimir em ordem", ANSI_VERDE));
            System.out.println("8. " + colorir("Imprimir pós-ordem", ANSI_VERDE));
            System.out.println("9. " + colorir("Sair", ANSI_VERMELHO));

            System.out.print("\nEscolha uma opção: ");
            try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 0:
                    int[] numeros = {10, 5, 15, 3, 7, 12, 18, 2, 4, 9};
                    for (int num : numeros) {
                        arvoreBinaria.inserir(num);
                    }
                    System.out.println("\nNúmeros inseridos: 10, 5, 15, 3, 7, 12, 18, 2, 4, 9");
                    esperar();
                    break;
                case 1:
                    System.out.print("Digite o elemento a ser inserido: ");
                    try {
                        int elementoInserir = sc.nextInt();
                        arvoreBinaria.inserir(elementoInserir);
                    } catch (InputMismatchException e) {
                        mensagemErro();
                    }
                    break;
                case 2:
                    System.out.print("Digite o elemento a ser removido: ");
                    try {
                        int elementoRemover = sc.nextInt();
                        arvoreBinaria.remover(elementoRemover);
                    } catch (InputMismatchException e) {
                        mensagemErro();
                    }
                    break;
                case 3:
                    System.out.print("Digite o elemento a ser buscado: ");
                    try {
                        int elementoBuscar = sc.nextInt();
                        No resultadoBusca = arvoreBinaria.buscar(elementoBuscar);
                        if (resultadoBusca != null) {
                            System.out.println("Elemento encontrado na árvore.");
                        } else {
                            System.out.println("Elemento não encontrado na árvore.");
                        }
                        esperar();
                    } catch (InputMismatchException e) {
                        mensagemErro();
                    }
                    break;
                case 4:
                    System.out.print("Digite o elemento para mostrar o caminho: ");
                    try {
                        int elementoCaminho = sc.nextInt();
                        arvoreBinaria.mostrarCaminho(elementoCaminho);
                        esperar();
                    } catch (InputMismatchException e) {
                        mensagemErro();
                    }
                    break;
                case 5:
                    System.out.println("\n\nArvore binária: ");
                    System.out.println(ANSI_CIANO);
                    arvoreBinaria.imprimirArvore();
                    System.out.println(ANSI_RESET);
                    esperar();
                    break;
                case 6:
                    System.out.print("Pré-ordem: ");
                    arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
                    esperar();
                    break;
                case 7:
                    System.out.print("Em ordem: " + ANSI_NEGRITO);
                    arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
                    System.out.print(ANSI_RESET);
                    esperar();
                    break;
                case 8:
                    System.out.print("Pós-ordem: ");
                    arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());
                    esperar();
                    break;
                case 9:
                    System.out.println("\nEncerrando o programa...");
                    break;
                default:
                    System.out.println(ANSI_VERMELHO + "\nOpção "  + ANSI_NEGRITO + "inválida. " + ANSI_RESET
                            + ANSI_VERMELHO + "Por favor, escolha uma opção válida." + ANSI_RESET);
                    esperar();
                    break;
            }
        }
    }
}
