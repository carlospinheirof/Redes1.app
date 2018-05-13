package redes1;

//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.InputStreamReader;
//import java.net.Socket;
import java.net.*;
import java.io.*;

public class ClientThread extends Thread {
	
	private Socket connectionSocket;
	private int jogador;
	
	public ClientThread(Socket s, int jogador){
		this.connectionSocket = s;
		this.jogador = jogador;
	}
	
	public void run(){
		
		System.out.println("Run funcionando");
		
		String clienteEntrada = "";
		String clientResult = "";
		
		String x;
		BufferedReader inFromClient = null;
		DataOutputStream outToClient = null;
		
		try{
			inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			
            outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			
			
		}catch(Exception e){
			System.out.println("Erro ao obter streams");
		}
		
		boolean conectado = true;
		while(conectado){
				try{
					clienteEntrada = inFromClient.readLine();
					//System.out.println(clienteEntrada);
					ClientProtocol cp = new ClientProtocol();
					
					if(clienteEntrada != "")
					{
						x = cp.Entrada(clienteEntrada);
						if(x == "False")
						{
							outToClient.writeBytes("CODE 500#" + "JOGADOR "+ this.jogador + " #" + "DESCONECTADO" + "\n");
							conectado = false;
							continue;
						}
						else{
							outToClient.writeBytes("CODE 200#" + "JOGADOR " + this.jogador+ " #" + x + "\n");
						}
					}
				}catch(Exception e){
					System.out.println("Comando inválido");
				}
			}
		
		
		
		
		
		
		}
}

