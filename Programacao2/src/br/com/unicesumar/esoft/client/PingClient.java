package br.com.unicesumar.esoft.client;

import br.com.unicesumar.esoft.server.PingServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class PingClient {
    public static void main(String[] args) {
        PingClient client = new PingClient();
        client.run();
    }

    private void run() {
        try (Socket connection = new Socket(PingServer.HOSTNAME, PingServer.PORT)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            PrintWriter out = new PrintWriter(connection.getOutputStream());

            for (int numberOfPings = 0; numberOfPings < 1000; numberOfPings++) {
                out.write("ping\n");
                out.flush();

                String message = in.readLine();

                System.out.println(message);
            }
            out.write("end\n");
            out.flush();
            System.out.println(in.readLine());
        } catch (UnknownHostException e) {
            System.out.println("UnkownHostException: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
