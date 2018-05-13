package redes1;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {
	
	
	public static void main(String args[]) throws IOException{
		System.out.println("Bem vindo ao Truth or Dare");
		
		int port = 6789;
		int cnt = 0;
		
		ServerSocket welcomeSocket = new ServerSocket(port);		//instancia de servidor
		
		while(true){
			
			Socket connectionSocket = welcomeSocket.accept();		//accept mantem a linha parada esperando uma conexao do cliente
			System.out.println("Cliente " + ++cnt + " reconhecido");
			ClientThread tc = new ClientThread(connectionSocket, cnt);
			tc.start();
		}
		
	}

}
