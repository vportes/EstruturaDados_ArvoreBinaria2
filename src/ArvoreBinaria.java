public class ArvoreBinaria {

    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int conteudo) {
        No novoNo = new No(conteudo);
        if (raiz == null) {
            raiz = novoNo;
        } else {
            No atual = raiz;
            No pai;
            while (true) {
                pai = atual;
                if (novoNo.getConteudo() <= atual.getConteudo()) {
                    atual = atual.getEsquerda();
                    if (atual == null) {
                        pai.setEsquerda(novoNo);
                        return;
                    }
                } else {
                    atual = atual.getDireita();
                    if (atual == null) {
                        pai.setDireita(novoNo);
                        return;
                    }
                }
            }
        }
    }

    public void remover(int conteudo) {
        raiz = removerRecursivo(raiz, conteudo);
    }

    private No removerRecursivo(No raiz, int conteudo) {
        if (raiz == null) {
            return raiz;
        }

        if (conteudo < raiz.getConteudo()) {
            raiz.setEsquerda(removerRecursivo(raiz.getEsquerda(), conteudo));
        } else if (conteudo > raiz.getConteudo()) {
            raiz.setDireita(removerRecursivo(raiz.getDireita(), conteudo));
        } else {
            // Caso 1: nó folha
            if (raiz.getEsquerda() == null && raiz.getDireita() == null) {
                return null;
            }
            // Caso 2: nó com um filho
            if (raiz.getEsquerda() == null) {
                return raiz.getDireita();
            } else if (raiz.getDireita() == null) {
                return raiz.getEsquerda();
            }
            // Caso 3: nó com dois filhos
            No sucessor = getSucessor(raiz.getDireita());
            raiz.setConteudo(sucessor.getConteudo());
            raiz.setDireita(removerRecursivo(raiz.getDireita(), sucessor.getConteudo()));
        }
        return raiz;
    }

    private No getSucessor(No raiz) {
        No atual = raiz;
        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }
        return atual;
    }

    public void preOrdem(No no) {
        if (no == null) {
            return;
        }
        System.out.print(no.getConteudo() + " ");
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    public void emOrdem(No no) {
        if (no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.print(no.getConteudo() + " ");
        emOrdem(no.getDireita());
    }

    public void posOrdem(No no) {
        if (no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.print(no.getConteudo() + " ");
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
        if (buscaRecursiva(raiz, numero) == null) {
            System.out.println("Elemento não encontrado na árvore.");
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

    public void imprimirArvore() {
        System.out.print("\n    ");
        imprimirArvoreRecursivo(raiz, "", true, true);
    }

    private void imprimirArvoreRecursivo(No no, String prefixo, boolean eFolha, boolean eNo) {
        if (no != null) {
            System.out.println(prefixo + (eNo ? "" : (eFolha ? "└── " : "├── ")) + no.getConteudo());
            if (no.getEsquerda() != null || no.getDireita() != null) {
                if (no.getDireita() != null) {
                    imprimirArvoreRecursivo(no.getDireita(), prefixo + (eNo ? "    " : (eFolha ? "    " : "│   ")), no.getEsquerda() == null, false);
                }
                if (no.getEsquerda() != null) {
                    imprimirArvoreRecursivo(no.getEsquerda(), prefixo + (eNo ? "    " : (eFolha ? "    " : "│   ")), true, false);
                }
            }
        }
    }
}
