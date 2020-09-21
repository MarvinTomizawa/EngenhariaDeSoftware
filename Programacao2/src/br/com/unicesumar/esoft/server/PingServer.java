package br.com.unicesumar.esoft.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PingServer {
    public static final int PORT = 8081;

    public static final String HOSTNAME = "localhost";

    public static void main(String[] args) {
        PingServer pingServer = new PingServer();
        pingServer.runServer();
    }

    private void runServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                PingThread pingServerHandler = new PingThread(serverSocket.accept());
                System.out.println("Nova conexão aberta!! " + pingServerHandler.getName());
                pingServerHandler.start();
            }
        } catch (Exception e) {
            throw new RuntimeException("Exception", e);
        }
    }

    public class PingThread extends Thread {
        private final Socket _socket;

        public PingThread(Socket socket) {
            _socket = socket;
        }

        @Override
        public void run() {
            try {
                Writer out = new PrintWriter(_socket.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
                while (true) {
                    String message = in.readLine();
                    if (message.equals("end")) {
                        out.write("Fechando conexão!!\n");
                        out.flush();
                        _socket.close();
                        break;
                    }
                    if (message.equals("ping")) {
                        out.write("pong\n");
                        out.flush();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("IOException: " + e.getMessage(), e);
            } finally {
                try {
                    _socket.close();
                } catch (IOException e) {
                    System.out.println("IOException: " + e.getMessage());
                }
            }
        }
    }
}
