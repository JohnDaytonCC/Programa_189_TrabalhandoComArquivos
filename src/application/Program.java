package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import entities.ItensVendidos;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// Leitura de arquivos
		File file = new File("E:\\JOHN DAYTON\\CURSOS DE EXTENSÃO\\Java Completo\\summary.csv");		// Processo para armasenar o local do arquivo
		
		String nome;
		double preco;
		int quantidade;
		int count = 0;
		
		//ItensVendidos[] itensVendidos = ItensVendidos[n];
		// Inicialização do Scanner
		Scanner input = null;
		
		// Ao tentar instanciar o Scanner a partir do file, poderá gerar uma excessão do tipo IOException que deverá ser tratada.
		try {
			input = new Scanner(file);
			
			// Comando para testar a quantidade de linhas do arquivo
			while(input.hasNextLine()) {
				++count;
			}
			
			ItensVendidos[] itensVendidos = new ItensVendidos[count];
			
			for(int i=0; i<=count; i++) {
				String[] textoSeparado = input.nextLine().split(",|,\\s");
				nome = textoSeparado[0];
				preco = Double.parseDouble(textoSeparado[1]);
				quantidade = Integer.parseInt(textoSeparado[2]);
				itensVendidos[i] = new ItensVendidos(nome, preco, quantidade);			
			}
			
			for(ItensVendidos e : itensVendidos) {
				System.out.println(e.toString());
			}
			
		}
		catch(IOException e){
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			if(input != null) input.close();
		}
		
		sc.nextInt();
		
	}

}
