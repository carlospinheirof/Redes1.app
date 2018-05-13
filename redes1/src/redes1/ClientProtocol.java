package redes1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ClientProtocol {
	
	private String[] commandosValidos = {"VERDADE", "CONSEQUENCIA", "SAIR"};
	
	private String[] verdades = {"nome de guerra?", "vc tem autismo?", "quenhé seu crush"};
	
	private String[] consequencia = {"Pega na bunda do glauber", "dar um abraço no carlos"};
	
	private Random random = new Random();
	
	public String Entrada(String clientString) throws Exception{
		
		if(Arrays.asList(this.commandosValidos).contains(clientString))
		{
			if(!clientString.equals("SAIR"))
			{
				//System.out.println("CODE#200\n");
				if(clientString.equals("VERDADE"))
				{
					return(verdades[random.nextInt(verdades.length)]);
				}
				else{
					return(consequencia[random.nextInt(consequencia.length)]);
				}
			}
			else{
				return "False";
			}
		}
		else{
			throw new Exception("Comando não permitido");
		}
		
	}

}
