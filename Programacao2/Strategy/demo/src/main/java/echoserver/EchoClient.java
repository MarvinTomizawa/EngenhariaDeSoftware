package echoserver;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        EchoClient client = new EchoClient();
        client.doIt();
    }

    private void doIt() throws Exception {
        InputStream consoleInput = System.in;

        String comando = "";
        Scanner scannerConsole = new Scanner(consoleInput);
        while (!comando.equalsIgnoreCase("sair")) {
            System.out.print("Digite um comando>>  ");

            comando = scannerConsole.nextLine();

            handleServerCommunication(comando);
        }

        System.out.println("Saiu.");
    }

    private void handleServerCommunication(String comando) throws UnknownHostException, IOException {
        Socket connection = new Socket(SERVER_ADDRESS, PORT);
        Scanner serverInput = new Scanner(connection.getInputStream());
        PrintWriter serverOutput = new PrintWriter(connection.getOutputStream());
        serverOutput.println(comando);
        serverOutput.flush();
        while(serverInput.hasNext()){
            var teste1 = serverInput.nextLine();
            System.out.println(teste1);
        }

        serverInput.close();
        connection.close();
    }


}
