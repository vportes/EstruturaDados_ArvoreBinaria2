import java.util.Scanner;

public class Executora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir elemento na árvore");
            System.out.println("2. Remover elemento da árvore");
            System.out.println("3. Buscar elemento na árvore");
            System.out.println("4. Mostrar caminho até um elemento na árvore");
            System.out.println("5. Imprimir árvore");
            System.out.println("6. Sair");

            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a ser inserido: ");
                    int elementoInserir = scanner.nextInt();
                    arvoreBinaria.inserir(elementoInserir);
                    break;
                case 2:
                    System.out.print("Digite o elemento a ser removido: ");
                    int elementoRemover = scanner.nextInt();
                    arvoreBinaria.remover(elementoRemover);
                    break;
                case 3:
                    System.out.print("Digite o elemento a ser buscado: ");
                    int elementoBuscar = scanner.nextInt();
                    No resultadoBusca = arvoreBinaria.buscar(elementoBuscar);
                    if (resultadoBusca != null) {
                        System.out.println("Elemento encontrado na árvore.");
                    } else {
                        System.out.println("Elemento não encontrado na árvore.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o elemento para mostrar o caminho: ");
                    int elementoCaminho = scanner.nextInt();
                    arvoreBinaria.mostrarCaminho(elementoCaminho);
                    System.out.println("\n");
                    break;
                case 5:
                    arvoreBinaria.imprimirArvore();
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }

        scanner.close();
    }
}
