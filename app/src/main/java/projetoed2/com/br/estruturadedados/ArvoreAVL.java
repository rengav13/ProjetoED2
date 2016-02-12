package projetoed2.com.br.estruturadedados;

import projetoed2.com.br.model.Contato;
import projetoed2.com.br.model.Node;

/**
 * Created by Vagner on 12/02/2016.
 */
public class ArvoreAVL {

    private Node raiz;

    public ArvoreAVL() {
        super();
    }

    public ArvoreAVL(Node raiz) {
        this.raiz = raiz;
    }

    public Node buscarNode(int chave){
        return this.buscarNode(this.raiz,chave);
    }

    private Node buscarNode(Node no, int chave) {
        if (no == null) {
            return null;
        } else {
            if (no.getChave() == chave) {
                return no;
            } else if (chave > no.getChave()) {
                return buscarNode(no.getDireita(), chave);
            } else {
                return buscarNode(no.getEsquerda(), chave);
            }
        }
    }

    public void inserirNode(Contato valor) {
        Node n = new Node(valor.getId(),valor);
        this.inserirNode(this.raiz, n);
    }

    private void inserirNode(Node aComparar, Node aInserir) {
        if (aComparar == null) {
            this.raiz = aInserir;
        } else {
            if (aInserir.getChave() < aComparar.getChave()) {
                if (aComparar.getEsquerda() == null) {
                    aComparar.setEsquerda(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);

                } else {
                    inserirNode(aComparar.getEsquerda(), aInserir);
                }

            } else if (aInserir.getChave() > aComparar.getChave()) {

                if (aComparar.getDireita() == null) {
                    aComparar.setDireita(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);

                } else {
                    inserirNode(aComparar.getDireita(), aInserir);
                }

            } else {
                System.out.println("O nó ja esta na arvore");
            }
        }
    }

    private void verificarBalanceamento(Node atual) {
        this.setBalanceamento(atual);
        int balanceamento = atual.getBalanceamento();

        if (balanceamento == -2) {

            if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
                atual = this.rotacaoDireita(atual);

            } else {
                atual = this.duplaRotacaoEsquerdaDireita(atual);
            }

        } else if (balanceamento == 2) {

            if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
                atual = this.rotacaoEsquerda(atual);

            } else {
                atual = this.duplaRotacaoDireitaEsquerda(atual);
            }
        }

        if (atual.getPai() != null) {
            verificarBalanceamento(atual.getPai());
        } else {
            this.raiz = atual;
        }
    }

    private void setBalanceamento(Node no) {
        no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
    }

    public int altura(Node atual) {
        if (atual == null) {
            return -1;
        }
        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            return 0;
        } else if (atual.getEsquerda() == null) {
            return 1 + altura(atual.getDireita());

        } else if (atual.getDireita() == null) {
            return 1 + altura(atual.getEsquerda());

        } else {
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
        }
    }

    private Node rotacaoEsquerda(Node inicial) {

        Node direita = inicial.getDireita();
        direita.setPai(inicial.getPai());

        inicial.setDireita(direita.getEsquerda());

        if (inicial.getDireita() != null) {
            inicial.getDireita().setPai(inicial);
        }

        direita.setEsquerda(inicial);
        inicial.setPai(direita);

        if (direita.getPai() != null) {

            if (direita.getPai().getDireita() == inicial) {
                direita.getPai().setDireita(direita);

            } else if (direita.getPai().getEsquerda() == inicial) {
                direita.getPai().setEsquerda(direita);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(direita);

        return direita;
    }

    private Node rotacaoDireita(Node inicial) {
        Node esquerda = inicial.getEsquerda();
        esquerda.setPai(inicial.getPai());

        inicial.setEsquerda(esquerda.getDireita());

        if (inicial.getEsquerda() != null) {
            inicial.getEsquerda().setPai(inicial);
        }

        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);

        if (esquerda.getPai() != null) {

            if (esquerda.getPai().getDireita() == inicial) {
                esquerda.getPai().setDireita(esquerda);

            } else if (esquerda.getPai().getEsquerda() == inicial) {
                esquerda.getPai().setEsquerda(esquerda);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(esquerda);

        return esquerda;
    }

    private Node duplaRotacaoEsquerdaDireita(Node inicial) {
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
        return rotacaoDireita(inicial);
    }

    private Node duplaRotacaoDireitaEsquerda(Node inicial) {
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial);
    }

    public void removerNode(int chave) {
        this.removerNode(this.raiz, chave);
    }

    private void removerNode(Node atual, int k) {
        if (atual == null) {
            return;
        } else {
            if (atual.getChave() > k) {
                removerNode(atual.getEsquerda(), k);
            } else if (atual.getChave() < k) {
                removerNode(atual.getDireita(), k);
            } else if (atual.getChave() == k) {
                this.removerNoEncontrado(atual);
            }
        }
    }

    private void removerNoEncontrado(Node aRemover) {
        Node r;
        if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) {
            if (aRemover.getPai() == null) {
                this.raiz = null;
                aRemover = null;
                return;
            }
            r = aRemover;
        } else {
            r = this.sucessor(aRemover);
            aRemover.setChave(r.getChave());
        }
        Node p;
        if (r.getEsquerda() != null) {
            p = r.getEsquerda();
        } else {
            p = r.getDireita();
        }
        if (p != null) {
            p.setPai(r.getPai());
        }
        if (r.getPai() == null) {
            this.raiz = p;
        } else {
            if (r == r.getPai().getEsquerda()) {
                r.getPai().setEsquerda(p);
            } else {
                r.getPai().setDireita(p);
            }
            verificarBalanceamento(r.getPai());
        }
        r = null;
    }

    //Pega o minimo da subarvore da direita
    private Node sucessor(Node q) {
        if (q.getDireita() != null) {
            Node r = q.getDireita();
            while (r.getEsquerda() != null) {
                r = r.getEsquerda();
            }
            return r;
        } else {
            Node p = q.getPai();
            while (p != null && q == p.getDireita()) {
                q = p;
                p = q.getPai();
            }
            return p;
        }
    }

    public Node buscarNodeMax(Node no) {
        if (no.getDireita() == null) {
            return no;
        } else {
            return buscarNodeMax(no.getDireita());
        }
    }

    public Node buscarNodeMin(Node no) {
        if (no.getEsquerda() == null) {
            return no;
        } else {
            return buscarNodeMin(no.getEsquerda());
        }
    }

    public Node getMaiorNo(){
        if(this.raiz == null){
            return null;
        }else{
            return this.buscarNodeMax(this.raiz);
        }
    }

    public Node getMenorNo(){
        if(this.raiz == null){
            return null;
        }else{
            return this.buscarNodeMin(this.raiz);
        }
    }

    public Node getRaiz() {
        return raiz;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }

}
