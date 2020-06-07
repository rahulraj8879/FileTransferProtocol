package com.rahulraj.FileTransferProtocol;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) {

//output after running server first and client class next and adding 127.0.0.1 and note we don.t have ip address validators
//    Please enter a valid Server Ip address: 127.0.0.1
//    Please enter a file name: read.txt
//            .
//            File: read.txt was successfully downloaded!

    try
    {
      //initialize the Server Socket class
      ServerSocket serverSocket = new ServerSocket(9090);

      //boolean variable to stop the server
      boolean isStopped = false;
      while(!isStopped)
      {
        //create client socket object
        Socket clientSocket = serverSocket.accept();
        //create and start client thread
        ClientThread clientThread = new ClientThread(clientSocket);
        clientThread.start();
      }
    }
    catch(IOException e)
    {
      System.out.println("Port 9090 is already opened! Please use another port.");
    }
    catch(Exception e)
    {
      System.out.println(e.toString());
    }
  }
}
