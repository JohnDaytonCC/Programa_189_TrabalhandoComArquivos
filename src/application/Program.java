package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ItensVendidos;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		// Inicialização da lista da classe itens vendidos
		List<ItensVendidos> list = new ArrayList<>();
		
		
		// Entrada via teclado do endereço do arquivo
		// /media/johndayton/6A74C73674C70433/JOHN DAYTON/CURSOS DE EXTENSÃO/Java Completo/summary.csv
		// E:\\JOHN DAYTON\\CURSOS DE EXTENSÃO\\Java Completo\\summary.csv
		System.out.println("Entre com o endereço do arquivo:");
		String nomeCaminho = sc.nextLine();
		
		// Conversão da string para objeto do tipo File
		File fonteDoArquivo = new File(nomeCaminho);
		String caminhoDaPasta = fonteDoArquivo.getParent();
		
		// Criação de uma subpasta
		boolean success = new File(caminhoDaPasta + "/out").mkdir();
		
		// Descrição do nome do caminho do arquivo que será criado.
		String caminhoSubArquivo = caminhoDaPasta + "/out/summary.csv";

		// Ao tentar instanciar o Scanner a partir do file, poderá gerar uma excessão do tipo IOException que deverá ser tratada.
		// 
		try (BufferedReader br = new BufferedReader(new FileReader(nomeCaminho))){
			
			
			String arquivoCsv = br.readLine();

			// Comando para ler as linhas do arquivo e salvar os dados.
			while (arquivoCsv != null) {
				
				// Comando para separação dos dodas da linha separados por vígulas
				// Salva os dados em um vetor chamado de <campos>.
				String[] campos = arquivoCsv.split(",");
				
				// Alocação dos dados em variáveis específicas para carregar na classe <ItensVendidos>.
				String nome = campos[0];
				Double preco = Double.parseDouble(campos[1]);
				Integer quantidade = Integer.parseInt(campos[2]);
				list.add(new ItensVendidos(nome, preco, quantidade));
				
				// Comando para verificar se existe outra linha no arquivo.
				arquivoCsv = br.readLine();
			}

			// Comandos para editar o arquivo criado, incluindo os dados nele.
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoSubArquivo))){
				
				for(ItensVendidos item : list) {
					bw.write(item.getName() + "," + String.format("%.2f", item.valorTotal()));
					bw.newLine();
				}
				
				System.out.println("Arquivo criado com SUCESSO!");
				
			}
			catch(IOException e){
				System.out.println("Erro de escrita do arquivo: " + e.toString());
			}

		} catch (IOException e) {
			System.out.println("Erro de leitura do arquivo: " + e.getMessage());
		}

		sc.close();

	}

}
