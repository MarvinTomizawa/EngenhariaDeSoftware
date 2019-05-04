import java.util.*;
import java.util.stream.Collectors;

public class app {
    public static void main(String args[]){
        List<Livro> acervo = new ArrayList<Livro>();
        acervo.add(new Livro("Conceitos de Computação com Java","Horstmann"));
        acervo.add(new Livro("Big Java","Horstmann"));
        acervo.add(new Livro("Objects First","Horstmann"));
        acervo.add(new Livro("Applying UML and patterns","Larmann"));
        acervo.add(new Livro("UML Complete Reference","Larmann"));
        acervo.add(new Livro("Object Analysis and Design","Booch"));

        Set<String> autoresDistintos = recuperarAutoresDistintos(acervo);
        System.out.println("Autores:");
        autoresDistintos.forEach(System.out::println);

        System.out.println();

        Map<String, Integer> contagemDeLivrosPorAutor = recuperarContagemDeLivrosPorAutor(acervo,autoresDistintos);
        contagemDeLivrosPorAutor
                .forEach((autor , quantidadeDeLivros) -> System.out.println("Autor :" + autor + " Quantidade de livros :" + quantidadeDeLivros));
    }

    public static Set<String> recuperarAutoresDistintos(List<Livro> livros){
        final Set<String> autores = new HashSet<>();
        livros.forEach(livro -> autores.add(livro.getAutor()));
        return autores;
    }

    public static Map<String,Integer> recuperarContagemDeLivrosPorAutor(List<Livro> livros, Set<String> autores){
        Map<String,Integer> contagemDeLivroPorAutor = new HashMap<>();

        List<String> autorFiltrado = autores.stream()
                .filter(autore -> autore.equals("Horstmann"))
                .collect(Collectors.toList());

        autores.forEach(System.out::println);

        livros.forEach(livro -> {
            if(!contagemDeLivroPorAutor.containsKey(livro.getAutor())){
                contagemDeLivroPorAutor.put(livro.getAutor(),0);
            }
            contagemDeLivroPorAutor.replace(livro.getAutor(),contagemDeLivroPorAutor.get(livro.getAutor()) + 1);
        });

        return contagemDeLivroPorAutor;
    }

}
