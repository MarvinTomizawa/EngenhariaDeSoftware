package br.com.unicesumar.esoft;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TransferenciaArquivosThreads {
    public static void main(String[] args) {
        var diretorioOrigem = new File("/testeOrigem");
        var diretorioDestino = new File("/testeDestino");

        var arquivos = listarArquivos(diretorioOrigem);
        var arquivosParaCadaThread = separarEmGruposDe100(arquivos);

        arquivosParaCadaThread.forEach(arquivosParaMover -> {
            var thread = new Thread(new MovedorDeArquivoHandler(arquivosParaMover, diretorioDestino));
            thread.start();
        });
    }

    private static List<File> listarArquivos(File origem) {
        var arquivos = origem.listFiles();

        if(arquivos == null){
            throw new RuntimeException("Não foi possivel encontrar os arquivos");
        }

        return List.of(arquivos);
    }

    private static List<List<File>> separarEmGruposDe100(List<File> arquivos){
        var arquivosSeparados = new ArrayList<List<File>>();
        int numeroDeArquivosParaSeparar = arquivos.size();

        while (numeroDeArquivosParaSeparar > 0)
        {
            var indexOrigemDosArquivos = arquivosSeparados.size() * 100;
            var quantidadeSeparada = arquivos.size() - indexOrigemDosArquivos;


            if(quantidadeSeparada > 100){
                var grupoDeArquivo = arquivos.subList(indexOrigemDosArquivos, indexOrigemDosArquivos + 100);
                arquivosSeparados.add(grupoDeArquivo);
                numeroDeArquivosParaSeparar -= 100;

            }else{
                var grupoDeArquivo = arquivos.subList(indexOrigemDosArquivos, indexOrigemDosArquivos + quantidadeSeparada);
                arquivosSeparados.add(grupoDeArquivo);

                numeroDeArquivosParaSeparar -= quantidadeSeparada;
            }
        }

        return arquivosSeparados;
    }
}

