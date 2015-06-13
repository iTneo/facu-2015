import java.util.Scanner;
import java.io.FileWriter; 
import java.io.IOException;
import java.io.PrintWriter; 
import java.util.Vector;

public class Exercicio_Agenda{
    public static void main(String[] args)throws IOException {
        Scanner entrada = new Scanner(System.in); 
        Vector nome = new Vector<String>(); 
        Vector endereco = new Vector<String>(); 
        Vector telefone = new Vector<String>(); 
        Vector email = new Vector<String>();
        int menu = 0;
        
        do{
            System.out.println("MENU PRINCIPAL");
            System.out.println("1 - Incluir novo");
            System.out.println("2 - Consultar");
            System.out.println("3 - Remover");
            System.out.println("4 - Editar");
            System.out.println("5 - Sair");
            menu = entrada.nextInt(); 
            if (menu == 5){
                System.out.println ("Saindo..."); 
                break; 
            }
            
            switch (menu){ 
                    case 1:
                        System.out.println("Digite o nome:");
                        String nomeTemp = entrada.next();
                        entrada.nextLine();
                        //entrada.nextLine();
                        nome.add(nomeTemp); 
                        
                        System.out.println("Digite o endereço");
                        String enderecoTemp = entrada.next();
                        entrada.nextLine(); 
                        endereco.add(enderecoTemp);
                        
                        System.out.println("Digite o telefone");
                        String telefoneTemp = entrada.next();  
                        telefone.add(telefoneTemp);
                        
                        System.out.println("Digite seu e-mail");
                        String emailTemp = entrada.next();  
                        email.add(emailTemp);
                        
                        System.out.println("Adicionado com sucesso!");
                        break;
                        
                    case 2:
                        System.out.println("<< Consultar >> \n");
                        System.out.println("Digite o nome para consultar que deseja consultar >>");
                        String nome_consulta = entrada.next(); 
                        System.out.println("Buscando na lista o contato... >>  " +nome_consulta);
                        System.out.println("\n\n");
                            for (int i=0; i<nome.size();i++){
                                if (nome.get(i).equals(nome_consulta)){
                                    System.out.println("Esse nome existe na lista!!");
                                    System.out.println("\n");
                                    System.out.println("Nome >>  " +nome.get(i));
                                    System.out.println("\n");
                                    System.out.println("Telefone >>  " +telefone.get(i));
                                    System.out.println("\n");
                                    System.out.println("Endereço >>  " +endereco.get(i));
                                    System.out.println("\n");
                                    System.out.println("E-mail >>  " +email.get(i));
                                }
                            }
                        break;
                        
                    case 3:
                        System.out.print("Digite o nome do contato que deseja excluir >>"); 
                        String nome_exclusao = entrada.next(); 
                        for (int i=0; i<nome.size();i++){
                            if (nome.get(i).equals(nome_exclusao)){
                                nome.remove(i);
                                telefone.remove(i);
                                endereco.remove(i);
                                email.remove(i);
                                System.out.println("REMOÇÃO DO CONTATO FEITA COM O SUCESSO!");
                            }
                        }
                    break;
                    
                    case 4: 
    					System.out.println("DIGITE O NOME QUE DESEJA ALTERAR: >> ");
    					String nomeAltera = entrada.next();

    					if (nome.contains(nomeAltera)) {
    						int index = nome.indexOf(nomeAltera);

    						System.out.println("Entre com o novo nome: ");
    						nomeAltera=entrada.next();
    						nome.set(index, nomeAltera);
    						System.out.println("Nome alterado com sucesso!!");


    						System.out.println("Entre com o novo Endereço: ");
    						nomeAltera=entrada.next();
    						endereco.set(index, nomeAltera);
    						System.out.println("Endereço alterado com sucesso!!");


    						System.out.println("Entre com o novo Telefone: ");
    						nomeAltera=entrada.next();
    						telefone.set(index, nomeAltera);
    						System.out.println("Telefone alterado com sucesso!!");

    	
    						System.out.println("Entre com o novo mail: ");
    						nomeAltera=entrada.next();
    						email.set(index, nomeAltera);
    						System.out.println("Mail alterado com sucesso!!");

    					}else{	
    					System.out.println("Contato digitado não existe!!");
    					}
    					break;
                     
                }    
        }while (menu != 6); 
        
    	System.out.println("Deseja salvar a sua lista de contatos?");
    	System.out.println("1 - SIM || 2 - NÃO"); 
    	int opcao_gravar = entrada.nextInt(); 
    	
    	if (opcao_gravar == 1){
    		System.out.println("\n\nImprimindo em arquivo de gravação!\n\n");
        	
    		FileWriter arquivo = new FileWriter ("//home/mateus/Dados/Algoritimos - Exercicios/JAVA/EXERCICIO_GRAVA_ARQ/agendaemoji.txt");
        	PrintWriter gravarArq = new PrintWriter(arquivo);
        	
        	gravarArq.printf("+-------Contatos da Agenda Telefonica---------+");
        	for(int i=0;i<nome.size();i++){
        		gravarArq.printf((i+1)+ "\n Nome: > " +nome.elementAt(i)+ "\n Endereço: >" +endereco.elementAt(i)+ "\n Telefone: >"+telefone.elementAt(i)+ "\nE-mail: ."+email.elementAt(i));
        	
        		gravarArq.printf("\n+-----------------------------------+%n");
        	}
        	arquivo.close(); 
        	
        	System.out.println("Agenda salva com sucesso! Abra o arquivo de gravação especificado!"); 
        	
    	}else{
    		System.out.println("Os contatos NÃO foram salvos!");
    		System.out.println("Saindo...");
    	}
    }
}

