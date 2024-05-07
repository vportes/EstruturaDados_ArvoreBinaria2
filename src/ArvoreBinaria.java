public class ArvoreBinaria {

    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int conteudo) {
        No novoNo = new No(conteudo);
        No pai;
        if(raiz == null) {
            //System.out.println("A raiz foi criada com o conteúdo " + novoNo.getConteudo() + ".");
            raiz = novoNo;
        } else {
            //Verificar se ficara a esq ou direita
            No atual = raiz;
            while(true) {
                pai = atual;
                if(novoNo.getConteudo() <= atual.getConteudo()) {
                    //posicionar o nó à esq
                    atual = atual.getEsquerda();
                    if(atual == null) {
                        pai.setEsquerda(novoNo);
                        //System.out.println("O nó com conteúdo " + novoNo.getConteudo() + " foi inserido com sucesso, onde seu pai é igual a: " + pai.getConteudo());
                        return;
                    }
                } else {
                    //posicionar o nó à dir
                    atual = atual.getDireita();
                    if(atual == null) {
                        pai.setDireita(novoNo);
                        //System.out.println("O nó com conteúdo " + novoNo.getConteudo() + " foi inserido com sucesso, onde seu pai é igual a: " + pai.getConteudo());
                        return;
                    }
                }
            }

        }
    }

    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.print(no.getConteudo()+" ");
    }

    public No getRaiz() {
        return raiz;
    }
    public No buscar(int numero) {
        return buscaRecursiva(raiz, numero);
    }

    private No buscaRecursiva(No raiz, int numero) {
        if (raiz == null)
            return null;
        if (raiz.getConteudo() == numero)
            return raiz;
        if (numero < raiz.getConteudo())
            return buscaRecursiva(raiz.getEsquerda(), numero);
        else
            return buscaRecursiva(raiz.getDireita(), numero);
    }

    public void mostrarCaminho(int numero) {
        System.out.println("\n");
        if (buscaRecursiva(raiz, numero) == null) {
            System.out.println("Número não encontrado na árvore.");
        } else {
            System.out.print("Caminho até o número: ");
            buscaMostrarCaminho(raiz, numero);
        }
    }

    private boolean buscaMostrarCaminho(No raiz, int numero) {
        if (raiz == null) {
            return false;
        }
        if (raiz.getConteudo() == numero) {
            System.out.print(raiz.getConteudo());
            return true;
        }
        if (numero < raiz.getConteudo()) {
            System.out.print(raiz.getConteudo() + " -> ");
            return buscaMostrarCaminho(raiz.getEsquerda(), numero);
        } else {
            System.out.print(raiz.getConteudo() + " -> ");
            return buscaMostrarCaminho(raiz.getDireita(), numero);
        }
    }

}