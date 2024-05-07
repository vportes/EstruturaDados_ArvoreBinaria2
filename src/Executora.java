public class Executora {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(6);
        arvoreBinaria.inserir(4);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(2);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(9);
        arvoreBinaria.inserir(11);
        //arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
        //arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
        System.out.print("\nPré-Ordem: ");
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());
        arvoreBinaria.mostrarCaminho(5);
    }
}