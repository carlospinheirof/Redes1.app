package redes1;
import java.io.*;
import java.net.*;

public class Cliente {
	
	public static void main(String[] args) throws Exception {
		
		String comando = "";
		String sentense = "";
		String resposta = "";
		
		System.out.println("Cliente multi-thread");
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		Socket clientSocket = new Socket("localhost", 6789);
		
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		
		boolean conectado = true;
		
		while(conectado){
			System.out.println("Digite um comando (VERDADE, CONSEQUENCIA, SAIR):");
			comando = inFromUser.readLine();
			outToServer.writeBytes(comando + "\n");
			resposta = inFromServer.readLine();
			String[] res = resposta.split("#");
			System.out.println(res[0] + "\n" + res[1]+ "\n" + res[2]);
			if(comando.equals("SAIR"))
			{
				conectado = false;
				clientSocket.close();
				continue;
			}
			
		}
		
	}

}
