package echoserver;

import java.io.File;

public class FileHandler {
    public String buscarArquivos(){
        File raiz = new File("/teste");
        return listarArquivosNoConsole(raiz, ">");
    }

    private String listarArquivosNoConsole(File diretório, String nível) {
        File[] arquivos = diretório.listFiles();
        String stringRetornada = "";
        for (File file : arquivos) {
            stringRetornada += nível + " " + file.getName() + "\n";
            if (file.isDirectory()) {
                stringRetornada += listarArquivosNoConsole(file, nível + ">");
            }
        }

        return stringRetornada;
    }
}
