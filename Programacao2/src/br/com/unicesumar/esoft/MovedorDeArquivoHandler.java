package br.com.unicesumar.esoft;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MovedorDeArquivoHandler implements Runnable{

    private List<File> arquivosParaMover;
    private File destino;

    public MovedorDeArquivoHandler(List<File> arquivosParaMover, File destino) {
        this.arquivosParaMover = arquivosParaMover;
        this.destino = destino;
    }

    @Override
    public void run() {
        arquivosParaMover.forEach(arquivo -> {
            try {
                Files.copy(arquivo.toPath(), Paths.get(destino.getPath(), arquivo.getName()));
            } catch (IOException e) {
                throw new RuntimeException("Impossivel mover o arquivo, error:" + e.getMessage());
            }
        });
    }
}
