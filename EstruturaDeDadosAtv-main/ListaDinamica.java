package EstruturaDeDadosAtv;

public class ListaDinamica implements ListaOperacoes {
    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista Dinâmica criada com sucesso!");
    }

    public void adicionarElemento(String conteudo) {
        if(!this.existeInicio()) {
            this.inicio.setConteudo(conteudo);
        } else {
            No novoNo = new No(conteudo);
            No aux = this.inicio;
            while(aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
        }
    }

    private boolean existeInicio() {
        if(this.inicio.getConteudo() == null) {
            return false;
        } else {
            return true;
        }
    }

    public void exibirElementos() {
        if(existeInicio()) {
            No aux = this.inicio;
            while(aux.getProx() != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
            System.out.println(aux.getConteudo());
        } else {
            System.out.println("Não existem elementos na Lista Dinâmica.");
        }
    }

    public void removerElemento(String elemento) {
        if(existeInicio()) {
            if(buscarElemento(elemento)) {
                //removendo primeiro
                if(this.inicio.getConteudo().equals(elemento)) {
                    this.inicio = this.inicio.getProx();
                } else if(this.inicio.getProx() != null) {
                    No aux = this.inicio;
                    do {
                        if(aux.getProx().getConteudo().equals(elemento)) {
                            aux.setProx(aux.getProx().getProx());
                            return;
                        }
                        aux = aux.getProx();
                    } while (aux != null);
                } else {
                    this.inicio.setConteudo(null);
                }
            }

        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public boolean buscarElemento(String elemento) {
        No aux = this.inicio;

        do {
            if(aux.getConteudo().equals(elemento)) {
                System.out.println("Elemento " + elemento + " encontrado.");
                return true;
            }
            aux = aux.getProx();
        } while(aux != null);
        System.out.println("Elemento " + elemento + " não encontrado!");
        return false;
    }

    //Interface
    @Override
    public int removerTodas(String elemento) {
        int contador = 0;
        if(existeInicio()){
            if(buscarElemento(elemento)){
                No aux = this.inicio;
                while(aux != null) {
                    if(aux.getConteudo().equals(elemento)){

                        removerElemento(aux.getConteudo());
                        contador ++;
                    }
                    aux = aux.getProx();
                }
            }
        }
        return contador;
    }

    @Override
    public int contar() {
        int contador = 0;
        No aux = this.inicio;
        while(aux != null){

            contador ++;
            aux = aux.getProx();
        }
        return contador;
    }

    @Override
    public void adicionarVarios(String[] vetor) {
        for(int i = 0; i < vetor.length; i++) {
            adicionarElemento(vetor[i]);
        }
    }

    @Override
    public String obter(int indice) {
        int contador = 0;

        if (tamanhoLista()-1 >= indice) {
            No aux = this.inicio;
            while(aux != null) {
                if(contador == indice) {
                    break;
                }
                aux = aux.getProx();
                contador++;
            }
            return aux.getConteudo();
        } else {
            System.out.println("número de índice inválido");
            return null;
        }
    }

    private int tamanhoLista() {
        int tamanho = 0;
        No aux = this.inicio;
        while(aux != null) {
            aux = aux.getProx();
            tamanho++;
        }
        return tamanho;
    }

    public boolean inserir(int posicao, String elemento) {
        int contador = 0;
        No novoElemento = new No(elemento);

        if (posicao == 0) {
            novoElemento.setProx(inicio);
            inicio = novoElemento;
            return true;
        }

        if (tamanhoLista()-1 >= posicao) {
            No aux = this.inicio;
            while(aux != null) {
                if(contador+1 == posicao) {
                    break;
                }
                aux = aux.getProx();
                contador++;
            }
            No prox = aux.getProx();
            aux.setProx(novoElemento);
            novoElemento.setProx(prox);
            return true;
        } else {
            System.out.println("número de índice inválido");
            return false;
        }
    }


    public String removerPorIndice(int posicao) {
        int contador = 0;
        String elementoRemovido;

        if(posicao == 0) {
            elementoRemovido = inicio.getConteudo();
            inicio = inicio.getProx();
            return elementoRemovido;
        }

         if (tamanhoLista()-1 >= posicao) {
            No aux = this.inicio;
            while(aux != null) {
                if(contador+1 == posicao) {
                    break;
                }
                aux = aux.getProx();
                contador++;
            }
            elementoRemovido = aux.getProx().getConteudo();
            aux.setProx(aux.getProx().getProx());
            return elementoRemovido;
        } else {
            System.out.println("número de índice inválido");
            return null;
        }
    }

    @Override
    public void limpar() {
        inicio.setConteudo(null);
        inicio.setProx(null);
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        No aux = this.inicio;
        int indexUltimoElemento = -1;
        int contador = 0;

        while(aux != null) {
            if(elemento.equals(aux.getConteudo())) {
                indexUltimoElemento = contador;
            }
            aux = aux.getProx();
            contador++;
        }
        if(indexUltimoElemento != -1) {
            return indexUltimoElemento;
        }else {
            System.out.println("Elemento não encontrado");
            return -1;
        }

    }

    @Override
    public int contarOcorrencias(String elemento) {
        No aux = inicio;
        int contador = 0;

        while(aux != null) {
            if (elemento.equals(aux.getConteudo())) {
                contador++;
            }
            aux = aux.getProx();
        }
        if (contador == 0) {
            System.out.println("Nenhuma ocorrência encontrada");
        }
        return contador;
    }

    @Override
    public int substituir(String elemento, String novoElemento) {
        int contador = contarOcorrencias(elemento);
        No aux = inicio;

        while (aux != null) {
            if (elemento.equals(aux.getConteudo())) {
                aux.setConteudo(novoElemento);
            }
            aux = aux.getProx();
        }

        return contador;
    }
}
