package EstruturaDeDadosAtv;

public class Main {
    public static void main(String[] args) {
        ListaSimples listaSimples = new ListaSimples(5);
        listaSimples.exibirElementos();
        listaSimples.adicionarElemento("Arroz");
        listaSimples.adicionarElemento("Feijão");
        listaSimples.adicionarElemento("Batata");
        //listaSimples.adicionarElemento("Arroz2");
        listaSimples.adicionarElemento("Feijão");
        //listaSimples.removerElemento("Batata");
        listaSimples.quantidadeElementos();
        System.out.println("-=-=-=-=-=-=-");
        listaSimples.exibirElementos();
        //System.out.println("Quantidade de ocorrências removidas: "+listaSimples.removerTodas("Feijão"));
        //listaSimples.exibirElementos();
        System.out.println(listaSimples.contar());
        String[] vetor = {"Leite", "Carne"};
        listaSimples.adicionarVarios(vetor);
        System.out.println("-=-=-=-=-=-=-");
        listaSimples.exibirElementos();
        System.out.println("-=-=-=-=-=-=-");
        System.out.println(listaSimples.obter(1));
        System.out.println("-=-=-=-=-=-=-");
        listaSimples.inserir(5, "Laranja");
        System.out.println("-=-=-=-=-=-=-");
        listaSimples.exibirElementos();
        System.out.println("-=-=-=-=-=-=-");
        listaSimples.removerPorIndice(2);
        listaSimples.exibirElementos();
        System.out.println(listaSimples.ultimoIndiceDe("Feijão"));
        System.out.println(listaSimples.contarOcorrencias("Feijão"));
        System.out.println(listaSimples.substituir("Feijão", "Maria"));
        System.out.println("-=-=-=-=-=-");
        listaSimples.exibirElementos();
    }
}