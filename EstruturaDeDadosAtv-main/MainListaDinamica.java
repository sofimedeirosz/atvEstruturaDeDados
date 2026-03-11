package EstruturaDeDadosAtv;

public class MainListaDinamica {
    public static void main(String[] args) {
        ListaDinamica listaDinamica = new ListaDinamica();
        listaDinamica.adicionarElemento("Arroz");
        listaDinamica.adicionarElemento("Feijão");
        listaDinamica.adicionarElemento("Feijão");
        //listaDinamica.removerOcorrencias("Feijão");
        listaDinamica.exibirElementos();
        System.out.println(listaDinamica.contar());
        String[] vetor = {"Leite", "Carne", "Cenoura"};
        listaDinamica.adicionarVarios(vetor);
        listaDinamica.exibirElementos();
        System.out.println("-=--=-=--=-=-");
        System.out.println(listaDinamica.obter(5));
        System.out.println("-=-=-=-=-=-=-");
        listaDinamica.inserir(0, "Água");
        listaDinamica.exibirElementos();
        System.out.println("-=-=-=-=-=-=-");
        listaDinamica.removerPorIndice(0);
        listaDinamica.exibirElementos();
        System.out.println(listaDinamica.ultimoIndiceDe("Cenoura"));
        System.out.println(listaDinamica.contarOcorrencias("Feijão"));
        listaDinamica.substituir("Feijão", "Maria");
        System.out.println("-=-=-=-=-=-");
        listaDinamica.exibirElementos();
    }
}
