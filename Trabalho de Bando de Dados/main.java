package trabalho;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	dados novoUnimed = new dados("", 0, "", "");
	
	ArrayList<String> listaProduto = new ArrayList();
	ArrayList<String> listaUnimed = new ArrayList();
	
	
	
	System.out.println("Digite o nome do primeiro arquivo:");
	String caminho1 = "C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\Arthur\\\\\\\\\\\\\\\\Desktop\\\\\\\\\\\\\\\\"+sc.nextLine()+".txt";
	System.out.println("Digite o nome do segundo arquivo");
	String caminho2 = "C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\Arthur\\\\\\\\\\\\\\\\Desktop\\\\\\\\\\\\\\\\"+sc.nextLine()+".txt";
	listaProduto = retornaProduto(caminho1);
	listaUnimed = retornaUnimed(caminho2);
	
	BufferedWriter bwProduto = new BufferedWriter(new FileWriter(caminho1));
	BufferedWriter bwUnimed = new BufferedWriter(new FileWriter(caminho2));
	
	if(!listaProduto.isEmpty()&&!listaUnimed.isEmpty()) {
		for(int i=0; i<listaProduto.size();i++) {
			bwProduto.write(listaProduto.get(i));
			bwProduto.flush();
			bwProduto.newLine();
			bwUnimed.write(listaUnimed.get(i));
			bwUnimed.flush();
			bwUnimed.newLine();
		}
	}
	
	int op;	
	do {
	System.out.println("Digite: ");
	System.out.println("1- Adicionar");
	System.out.println("2- Atualizar");
	System.out.println("3- Consultar");
	System.out.println("4- Deletar");
	System.out.println("5- Apagar tudo");
	op = sc.nextInt();
	switch(op) {
	case 1:
		System.out.println("Digite o preço: ");
		novoUnimed.setPreco(sc.nextDouble());
		sc.nextLine();
		System.out.println("Digite o codigo: ");
		novoUnimed.setCodigo(sc.nextLine());
		boolean encontrou = false;
		if(!listaProduto.isEmpty()&&!listaUnimed.isEmpty()) {
			for(int i=0; i<listaProduto.size();i++) {
				if(retornaCodigo(listaProduto.get(i)).equals(novoUnimed.getCodigo().toString())){
					System.out.println("O Codigo ja existe!");
					encontrou = true;
					break;
				}
			}
		}
		if(!encontrou) {
		System.out.println("Digite a descrição: ");
		novoUnimed.setDescricao(sc.nextLine());
		System.out.println("Digite a classificação: ");
		novoUnimed.setClassificacao(sc.nextLine());
		
	
	bwProduto.write(novoUnimed.retornaLinhaProduto());
	listaProduto.add(novoUnimed.retornaLinhaProduto());
	bwUnimed.write(novoUnimed.retornaLinhaUnimed());
	listaUnimed.add(novoUnimed.retornaLinhaUnimed());
	bwProduto.newLine();
	bwProduto.flush();
	bwUnimed.newLine();
	bwUnimed.flush();
	}
	break;
	case 2:
		sc.nextLine();
		if(listaProduto.isEmpty()) {
		 System.out.println("Lista de dados vazia");
		}
		else {
		System.out.println("digite o codigo do produto que sera modificado");
		dados atual = new dados("",0, "", "");
		atual.setCodigo(sc.nextLine());
		encontrou = false;
		for(int i=0;i<listaProduto.size();i++) {
			if(retornaCodigo(listaProduto.get(i)).equals(atual.getCodigo())) {
				encontrou = true;
				System.out.println("Digite o preço: ");
				atual.setPreco(sc.nextDouble());
				sc.nextLine();
				System.out.println("Digite a Classificação: ");
				atual.setClassificacao(sc.nextLine());
				System.out.println("Digite a descrição: ");
				atual.setDescricao(sc.nextLine());
				listaProduto.set(i, atual.retornaLinhaProduto());
				listaUnimed.set(i, atual.retornaLinhaUnimed());
				break;
			}
		}
		if(encontrou) {
			bwProduto = new BufferedWriter(new FileWriter(caminho1));
			bwUnimed = new BufferedWriter(new FileWriter(caminho2));
			   for(int i=0; i<listaProduto.size();i++) {
				    bwProduto.write(listaProduto.get(i));
					bwUnimed.write(listaUnimed.get(i));
				    bwProduto.flush();
					bwProduto.newLine();
					bwUnimed.flush();
					bwUnimed.newLine();
			   }
		}
		else {
			System.out.println("Nao encontrado.");
		}
		}
		break;
	case 3:
		if(listaProduto.isEmpty()) {
			System.out.println("Lista de dados vazia.");
		}else {
		System.out.println("1- procurar apenas um dado");
		System.out.println("2- mostrar todos os dados");
		int procura = sc.nextInt();
		sc.nextLine();
		if(procura==1) {
			System.out.println("Digite o codigo do dado que sera procurado: ");
			String code = sc.nextLine();
			encontrou = false;
			for(int i=0;i<listaProduto.size();i++) {
				if(retornaCodigo(listaProduto.get(i)).equals(code)) {
					encontrou = true;
					mostraDados(listaProduto.get(i), listaUnimed.get(i));
					break;
				}
			}
			if(!encontrou) {
				System.out.println("Nao foi encontrado");
			}
		}
		else {
		if(procura==2){
			for(int i=0; i<listaProduto.size();i++) {
				mostraDados(listaProduto.get(i), listaUnimed.get(i));
			}
		}
		else {
				System.out.println("Opção invalida");
			}
		}
		}
		break;
	case 4:
		if(listaProduto.isEmpty()) {
			System.out.println("Lista de dados vazia");
		}
		else {
		sc.nextLine();
		System.out.println("Digite o codigo do produto que sera removido: ");
		String code = sc.nextLine();
		encontrou = false;
		for(int i=0;i<listaProduto.size();i++) {
			if(retornaCodigo(listaProduto.get(i)).equals(code)) {
				encontrou = true;
				listaUnimed.remove(i);
				listaProduto.remove(i);
				break;
			}
		}
		if(encontrou) {
			bwProduto = new BufferedWriter(new FileWriter(caminho1));
			bwUnimed = new BufferedWriter(new FileWriter(caminho2));
			for(int i=0; i<listaProduto.size();i++) {
				    bwProduto.write(listaProduto.get(i));
					bwUnimed.write(listaUnimed.get(i));
				    bwProduto.flush();
					bwProduto.newLine();
					bwUnimed.flush();
					bwUnimed.newLine();
			   }
		}
		else {
			System.out.println("Nao encontrado.");
		}
		}
		break;
	case 5:
		if(listaProduto.isEmpty()) {
			 System.out.println("Lista de dados ja está vazia");
			}
			else {
		bwProduto = new BufferedWriter(new FileWriter(caminho1));
		bwUnimed = new BufferedWriter(new FileWriter(caminho2));
		listaUnimed.removeAll(listaUnimed);
		listaProduto.removeAll(listaProduto);
		System.out.println("Todos os dados foram removidos");}
		break;
	default: System.out.println("Opção Invalida");
	break;
	}
	System.out.println("Se deseja encerrar, digite 0");
	op = sc.nextInt();
}while(op!=0);
	bwProduto.close();
	bwUnimed.close();
}

public static ArrayList<String> retornaProduto(String caminho1){
	ArrayList <String> list = new ArrayList();
	try {
	      FileReader arq = new FileReader(caminho1);
	      BufferedReader lerArq = new BufferedReader(arq);
	 
	      String linha = lerArq.readLine();
	      while (linha != null) {
	    	list.add(linha);
	        linha = lerArq.readLine();
	      }
	 
	      arq.close();
	    } catch (IOException e) {
	        System.err.printf("",
	          e.getMessage());
	    }
	return list;
}

public static ArrayList<String> retornaUnimed(String caminho2){
	ArrayList <String> list = new ArrayList();
	try {
	      FileReader arq = new FileReader(caminho2);
	      BufferedReader lerArq = new BufferedReader(arq);
	 
	      String linha = lerArq.readLine();
	      while (linha != null) {
	    	list.add(linha);
	        linha = lerArq.readLine();
	      }
	 
	      arq.close();
	    } catch (IOException e) {
	        System.err.printf("",
	          e.getMessage());
	    }
	return list;
}

public static String retornaCodigo(String linha) {
	return(linha.substring(linha.indexOf(" ")+1, linha.indexOf(",")));
}
public static void mostraDados(String produto, String unimed) {
	System.out.println(produto+", "+unimed.substring(unimed.indexOf(", ")+2));
}

}
