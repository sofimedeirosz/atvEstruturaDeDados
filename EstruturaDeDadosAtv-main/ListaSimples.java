package EstruturaDeDadosAtv;

public class ListaSimples implements ListaOperacoes{
    String[] lista;

    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
    }

    public void exibirElementos() {
        if(!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                System.out.println("Lista[" + i + "] = " + this.lista[i]);
            }
        }
    }

    public void adicionarElemento(String elemento) {
        if (!estaCheia()) {
            this.lista[encontrarPosicaoVazia()] = elemento;
            System.out.println("Elemento " + elemento + " adicionado com sucesso!");
        }
    }


    private boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("A lista está cheia!");
        return true;
    }

    private boolean estaVazio() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                return false;
            }
        }
        System.out.println("A lista está vazia!");
        return true;
    }

    private int encontrarPosicaoVazia() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return i;
            }
        }
        return i;
    }

    public void removerElemento(String elemento) {
        if (!estaVazio()) {
            if (this.buscarElemento(elemento) >= 0) {
                this.lista[this.buscarElemento(elemento)] = null;
                System.out.println("Elemento " + elemento + " removido com sucesso!");
            }
        }
    }

    public int buscarElemento(String elemento){
        int i;
        if (!estaVazio()) {
            for (i = 0; i < this.lista.length; i++) {
                if (this.lista[i].equals(elemento)) {
                    return i;
                }
            }
        }
        System.out.println("Elemento não encontrado na lista.");
        return -1;
    }

    public void alterarElemento(String elementoASerAlterado, String alteracao) {
        if(buscarElemento(elementoASerAlterado) >= 0) {
            this.lista[buscarElemento(elementoASerAlterado)] = alteracao;
            System.out.println("Elemento " + elementoASerAlterado + " alterado com sucesso para " + alteracao);
        }
    }

    public void quantidadeElementos() {
        int cont = 0;
        if(!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null) {
                    cont++;
                }
            }
        }
        System.out.println("A lista possui " + cont + " elementos!");
    }

    //Interfaceeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
    @Override
    public int removerTodas(String elemento) {
        int i;
        int contador = 0;
        if (!estaVazio()) {
            for (i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null) {
                    if (this.lista[i].equals(elemento)) {
                        this.lista[i] = null;
                        contador ++;
                    }
                }
            }
            return contador;
        }
        System.out.println("Elemento não encontrado.");
        return 0;
    }

    @Override
    public int contar() {
        int contador = 0;
        for(int i =0; i < lista.length; i++){
            if(lista[i] != null){
                contador ++;
            }
        }
        return contador;
    }

    @Override
    public void adicionarVarios(String[] vetor) {
        for(int j = 0; j < vetor.length; j++){
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] == null){
                    this.lista[i] = vetor[j];
                    break;
                }
            }
        }
    }

    @Override
    public String obter(int indice) {
        return lista[indice];
    }

    @Override
    public boolean inserir(int posicao, String elemento) {
        if(!estaCheia()) {
            try {
                for (int i= 0; i < lista.length; i++) {
                    if (lista[i] == null) {
                        for(int j = i; j >= posicao; j--) {
                            lista[j] = lista[j-1];
                        }
                    }
                }
                lista[posicao] = elemento;
                return true;
            }catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("número de índice inválido");
                return false;
            }
        }
        return false;
    }

    @Override
    public String removerPorIndice(int posicao) {
        if (estaVazio()) {
            return null;
        }
        if (posicao < 0 || posicao >= lista.length) {
            System.out.println("Indice inválido.");
            return null;
        }

        String removido = lista[posicao];

        for (int i = posicao; i < lista.length-1; i++) {
            lista[i] = lista[i+1];
        }
        lista[lista.length - 1] = null;
        return removido;
    }

    @Override
    public void limpar() {
        int i = 0;
        while (lista[i] != null) {
            lista[i] = null;
            i++;
        }
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        int indexUtimoElemento = -1;
        if (!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null) {
                    if (this.lista[i].equals(elemento)) {
                        indexUtimoElemento = i;
                    }
                }
            }
            return indexUtimoElemento;
        }
        if (indexUtimoElemento != -1) {
            return indexUtimoElemento;
        }else{
            System.out.println("Elemento não encontrado.");
            return indexUtimoElemento;
        }
    }

    @Override
    public int contarOcorrencias(String elemento) {
        int contador = 0;
        for (int i=0; i < lista.length; i++) {
            if(elemento.equals(lista[i])) {
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("Nenhuma ocorrência encontrada");
        }
        return contador;
    }

    @Override
    public int substituir(String elemento, String novoElemento) {
        int contador = contarOcorrencias(elemento);
        for (int i = 0; i < lista.length; i ++) {
            if (elemento.equals(lista[i])) {
                lista[i] = novoElemento;
            }
        }
        return contador;
    }
}