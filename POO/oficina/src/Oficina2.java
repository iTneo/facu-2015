package oficina;

import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.sun.crypto.provider.RSACipher;

public class Oficina2 {

	public static void main(String[] args) throws IOException, SQLException {
		Scanner ler = new Scanner(System.in);

		int opc = 0;
		int opc2 = 0;
		int opc3 = 0;

		// String Nome;
		// String caminho;
		// String dir;
		// String aux;

		/*
		 * System.out.println("Entre com o Diretorio do Arquivo:"); caminho =
		 * ler.next();
		 * System.out.println("Entre com o nome do arquivo com formato"); dir =
		 * ler.next();
		 * 
		 * 
		 * aux = caminho+dir; System.out.println(aux); FileWriter arq = new
		 * FileWriter(aux); PrintWriter gravarArq = new PrintWriter(arq);
		 */
		FileWriter arq = new FileWriter("z:\\oficina.txt");
		PrintWriter gravarArq = new PrintWriter(arq);

		Conexao conecta = new Conexao();
		do {
			System.out.println("Oficina do Sr.Graxa");
			System.out.println("1 - Realizar Cadastro");
			System.out.println("2 - Consultar Cadastros");
			System.out.println("3 - Editar Cadastros");
			System.out.println("4 - Excluir Cadastros");
			System.out.println("5 - Produzir OS");
			System.out.println("6 - Sair");
			opc = ler.nextInt();
			ler.nextLine();
			switch (opc) {

			case 1:
				do {
					System.out.println("1 - Cadastrar Cliente");
					System.out.println("2 - Cadastrar Veículo");
					System.out.println("3 - Cadastrar Serviços");
					System.out.println("4 - Cadastrar Itens");
					System.out.println("5 - Cadastrar Ordem de Serviço");
					opc2 = ler.nextInt();
					ler.nextLine();
					switch (opc2) {
					case 1:
						conecta.conecta();
						System.out.println("Cadastro de Cliente");
						System.out.println("\n");
						System.out.println("Entre com o nome do cliente: ");
						String nome = ler.nextLine();
						System.out.println("Entre com o telefone do cliente: ");
						String telefone = ler.nextLine();
						System.out.println("Entre com o endereco do cliente: ");
						String endereco = ler.nextLine();
						System.out.println("Entre com o email do cliente: ");
						String email = ler.nextLine();
						PreparedStatement pst = (PreparedStatement) conecta.conn
								.prepareStatement("insert into clientes (nome,telefone,endereco,email) values (?,?,?,?)");
						pst.setString(1, nome);
						pst.setString(2, telefone);
						pst.setString(3, endereco);
						pst.setString(4, email);
						pst.executeUpdate();
						System.out.println("Tecle ENTER para continuar.");
						System.in.read();
						System.out.println("Cadastro realizado com sucesso.");
						conecta.desconecta();
						break;
					case 2:
						conecta.conecta();
						System.out.println("Cadastro de Veículo");
						System.out.println("\n");
						System.out.println("Entre com a marca do veículo: ");
						String marca = ler.nextLine();
						System.out.println("Entre com a cor do veículo: ");
						String cor = ler.nextLine();
						System.out.println("Entre com a placa do veículo: ");
						String placa = ler.nextLine();

						PreparedStatement pst2 = (PreparedStatement) conecta.conn
								.prepareStatement("insert into veiculos (marca,cor,placa) values (?,?,?)");
						pst2.setString(1, marca);
						pst2.setString(2, cor);
						pst2.setString(3, placa);
						pst2.executeUpdate();
						System.out.println("Tecle ENTER para continuar.");
						System.in.read();
						System.out.println("Cadastro realizado com sucesso.");
						conecta.desconecta();
						break;
					case 3:
						conecta.conecta();
						System.out.println("Cadastro de Serviços");
						System.out.println("\n");
						System.out.println("Entre com o nome do serviço: ");
						String servico = ler.nextLine();
						System.out
								.println("Entre com a descrição do serviço: ");
						String descricao = ler.nextLine();
						System.out.println("Entre com o preço do serviço: ");
						int precoservico = ler.nextInt();

						PreparedStatement pst3 = (PreparedStatement) conecta.conn
								.prepareStatement("insert into servicos (servico,descricao,precoservico) values (?,?,?)");
						pst3.setString(1, servico);
						pst3.setString(2, descricao);
						pst3.setInt(3, precoservico);
						pst3.executeUpdate();
						System.out.println("Tecle ENTER para continuar.");
						System.in.read();
						System.out.println("Cadastro realizado com sucesso.");
						conecta.desconecta();
						break;
					case 4:
						conecta.conecta();
						System.out.println("Cadastro de Itens");
						System.out.println("\n");
						System.out.println("Entre com o nome do item: ");
						String item = ler.nextLine();
						System.out.println("Entre com a quantidade: ");
						int quantidade = ler.nextInt();
						System.out.println("Entre com o preço do item: ");
						int precoitem = ler.nextInt();

						PreparedStatement pst4 = (PreparedStatement) conecta.conn
								.prepareStatement("insert into itens (item,quantidade,precoitem) values (?,?,?)");
						pst4.setString(1, item);
						pst4.setInt(2, quantidade);
						pst4.setInt(3, precoitem);
						pst4.executeUpdate();
						System.out.println("Tecle ENTER para continuar.");
						System.in.read();
						System.out.println("Cadastro realizado com sucesso.");
						conecta.desconecta();
						break;
					case 5:
						conecta.conecta();
						System.out.println("Cadastro de Ordem de Serviço");
						System.out.println("\n");
						System.out.println("Entre com o número do veículo");
						int veiculoos = ler.nextInt();
						PreparedStatement pst5 = (PreparedStatement) conecta.conn
								.prepareStatement("select id,marca,cor,placa from veiculos where id = ?");
						pst5.setInt(1, veiculoos);
						pst5.executeQuery();
						ResultSet rs = pst5.executeQuery();
						System.out.println("Veiculo encontrado");
						while (rs.next()) {
							System.out.println("Código" + rs.getInt("id"));
							System.out.println("Marca" + rs.getString("marca"));
							System.out.println("Cor" + rs.getInt("cor"));
							System.out.println("Placa" + rs.getInt("placa"));
						}
						System.out.println("Entre com o nome do item: ");
						String itemos = ler.nextLine();
						pst5 = (PreparedStatement) conecta.conn
								.prepareStatement("select id,item,precoitem from itens where item like ?");
						itemos = "%" + itemos + "%";
						pst5.setString(1, itemos);
						pst5.executeQuery();
						rs = pst5.executeQuery();
						System.out.println("Item encontrado");
						while (rs.next()) {
							System.out.println("Código" + rs.getInt("id"));
							System.out.println("Nome" + rs.getString("item"));
							System.out
									.println("Preço" + rs.getInt("precoitem"));
						}
						System.out
								.println("Entre com o Veiculo a ser cadastrado");
						int id_veiculo = ler.nextInt();
						pst5 = (PreparedStatement) conecta.conn
								.prepareStatement("insert into os (id_veiculo) values (?)");
						pst5.setInt(id_veiculo, 1);
						pst5.executeQuery();
						System.out
								.println("Entre com o código do item a ser utilizado");
						int id_item = ler.nextInt();
						System.out.println("Entre com a quantidade:");
						int qtde = ler.nextInt();
						pst5 = (PreparedStatement) conecta.conn
								.prepareStatement("insert into os_item (id_item,quantidade_item) values (?,?)");
						pst5.setInt(id_item, 1);
						pst5.setInt(qtde, 2);
						pst5.executeQuery();
						System.out
								.println("Deseja cadastrar mais algum item ? Sim/Nao");
						String resposta = ler.nextLine();
						do {
							if (resposta == "Sim") {
								System.out
										.println("Entre com o código do item a ser utilizado");
								id_item = ler.nextInt();
								System.out.println("Entre com a quantidade:");
								qtde = ler.nextInt();
								pst5 = (PreparedStatement) conecta.conn
										.prepareStatement("insert into os_item (id_item,quantidade_item) values (?,?)");
								pst5.setInt(id_item, 1);
								pst5.setInt(qtde, 2);
								pst5.executeQuery();
							} else {
								System.out
										.println("Cadastro Realizado com sucesso");
							}
						} while (resposta == "Sim");
						System.out.println("Entre com o nome do Serviço: ");
						String servicoos = ler.nextLine();
						pst5 = (PreparedStatement) conecta.conn
								.prepareStatement("select id,servico,precoservico from servicos where servico like ?");
						servicoos = "%" + servicoos + "%";
						pst5.setString(1, servicoos);
						pst5.executeQuery();
						System.out.println("Servico encontrado");
						while (rs.next()) {
							System.out.println("Código" + rs.getInt("id"));
							System.out
									.println("Nome" + rs.getString("servico"));
							System.out.println("Preço"
									+ rs.getInt("precoservico"));
						}
						System.out
								.println("Entre com o código do servico a ser utilizado");
						int id_servico = ler.nextInt();
						pst5 = (PreparedStatement) conecta.conn
								.prepareStatement("insert into os_servico (id_servico) values (?)");
						pst5.setInt(id_servico, 1);
						pst5.executeQuery();
						System.out
								.println("Deseja cadastrar mais algum servico ? Sim/Nao");
						String resposta2 = ler.nextLine();
						do {
							if (resposta2 == "Sim") {
								System.out
										.println("Entre com o código do servico a ser utilizado");
								id_servico = ler.nextInt();
								pst5 = (PreparedStatement) conecta.conn
										.prepareStatement("insert into os_servico (id_servico) values (?)");
								pst5.setInt(id_servico, 1);
								pst5.executeQuery();
							} else {
								System.out
										.println("Cadastro Realizado com sucesso");
							}
						} while (resposta2 == "Sim");
						System.in.read();
						System.out.println("Cadastro realizado com sucesso.");
						conecta.desconecta();
						break;
					default:
						System.out.println("Opção Invalida");
					}
				} while (opc2 != 5);

			case 2:
				do {
					System.out.println("1 - Consultar Cliente");
					System.out.println("2 - Consultar Veículo");
					System.out.println("3 - Consultar Serviço");
					System.out.println("4 - Consultar Item");
					System.out.println("5 - Consultar OS");
					opc2 = ler.nextInt();
					ler.nextLine();
					switch (opc2) {
					case 1:
						conecta.conecta();
						try {
							System.out
									.println("Entre com o nome que deseja consultar: ");
							String nome = ler.next();
							PreparedStatement pst6 = (PreparedStatement) conecta.conn
									.prepareStatement("select id,nome,telefone,endereco,email from clientes where nome like ?");
							nome = nome + "%";
							pst6.setString(1, nome);
							pst6.execute();
							ResultSet rs = pst6.executeQuery();
							while (rs.next()) {
								System.out.println("Nome Encontrado");
								System.out.println("ID" + rs.getInt("id"));
								System.out.println("Nome: "
										+ rs.getString("nome"));
								System.out.println("Telefone: "
										+ rs.getString("telefone"));
								System.out.println("Endereco: "
										+ rs.getString("endereco"));
								System.out.println("Email: "
										+ rs.getString("email"));
								// JOptionPane.showMessageDialog(null,
								// "Nome Encontrado!");
							}

						} catch (SQLException e) {
							System.out.println("Não Encontrado...");
							// JOptionPane.showMessageDialog(null,
							// "Nome não Encontrado!\n"+e.getMessage());
						}
						conecta.desconecta();
						break;
					case 2:
						conecta.conecta();
						try {
							System.out
									.println("Entre com a placa do veículo que deseja consultar: ");
							String placa = ler.next();
							PreparedStatement pst7 = (PreparedStatement) conecta.conn
									.prepareStatement("select id,marca,cor,placa from veiculos where nome like ?");
							pst7.setString(3, placa);
							pst7.execute();
							ResultSet rs = pst7.executeQuery();
							while (rs.next()) {
								System.out.println("Carro Encontrado");
								System.out.println("ID" + rs.getInt("id"));
								System.out.println("Marca: "
										+ rs.getString("marca"));
								System.out.println("Cor: "
										+ rs.getString("cor"));
								System.out.println("Placa: "
										+ rs.getString("placa"));
								// JOptionPane.showMessageDialog(null,
								// "Nome Encontrado!");
							}

						} catch (SQLException e) {
							System.out.println("Não Encontrado...");
							// JOptionPane.showMessageDialog(null,
							// "Nome não Encontrado!\n"+e.getMessage());
						}
						conecta.desconecta();
						break;
					case 3:
						conecta.conecta();
						try {
							System.out
									.println("Entre com o serviço que deseja consultar: ");
							String servico = ler.next();
							PreparedStatement pst8 = (PreparedStatement) conecta.conn
									.prepareStatement("select id,servico,descricao,precoservico from servicos where nome like ?");
							pst8.setString(1, servico);
							pst8.execute();
							ResultSet rs = pst8.executeQuery();
							while (rs.next()) {
								System.out.println("Servico Encontrado");
								System.out.println("ID" + rs.getInt("id"));
								System.out.println("Nome: "
										+ rs.getString("servico"));
								System.out.println("Descrição: "
										+ rs.getString("descricao"));
								System.out.println("Preço: "
										+ rs.getString("preço"));
								// JOptionPane.showMessageDialog(null,
								// "Nome Encontrado!");
							}

						} catch (SQLException e) {
							System.out.println("Não Encontrado...");
							// JOptionPane.showMessageDialog(null,
							// "Nome não Encontrado!\n"+e.getMessage());
						}
						conecta.desconecta();
						break;
					case 4:
						conecta.conecta();
						try {
							System.out
									.println("Entre com o item que deseja consultar: ");
							String item = ler.next();
							PreparedStatement pst9 = (PreparedStatement) conecta.conn
									.prepareStatement("select id,item,quantidade,precoitem from itens where nome like ?");
							pst9.setString(1, item);
							pst9.execute();
							ResultSet rs = pst9.executeQuery();
							while (rs.next()) {
								System.out.println("Item Encontrado");
								System.out.println("ID" + rs.getInt("id"));
								System.out.println("Item: "
										+ rs.getString("item"));
								System.out.println("Quantidade: "
										+ rs.getString("quantidade"));
								System.out.println("Preço: "
										+ rs.getString("precoitem"));
								// JOptionPane.showMessageDialog(null,
								// "Nome Encontrado!");
							}

						} catch (SQLException e) {
							System.out.println("Não Encontrado...");
							// JOptionPane.showMessageDialog(null,
							// "Nome não Encontrado!\n"+e.getMessage());
						}
						conecta.desconecta();
						break;
					case 5:
						conecta.conecta();
						try {
							System.out
									.println("Entre com a OS que deseja consultar: ");
							int os = ler.nextInt();
							PreparedStatement pst10 = (PreparedStatement) conecta.conn
									.prepareStatement("select id_veiculo,id_servico,id_item,quantidade_item,valor_unit, valortotal, "
											+ "from os, os_item, os_servico where"
											+ "os.id = os_servico.id_os and"
											+ "os_servico.id_os = os_item.id_os and"
											+ "os.id = '?' ");
							pst10.setInt(1, os);
							ResultSet rs = pst10.executeQuery();
							while (rs.next()) {
								System.out.println("OS encontrada");
								System.out.println("ID" + rs.getInt("id"));
								System.out.println("Veiculo: "
										+ rs.getString("id_veiculo"));
								System.out.println("Serviço: "
										+ rs.getString("id_servico"));
								System.out.println("Item: "
										+ rs.getString("id_servico"));
								System.out.println("Quantidade: "
										+ rs.getString("quantidade_item"));
								System.out.println("Valor Unitário: "
										+ rs.getString("valor_unit"));
								System.out.println("Valor Total: "
										+ rs.getString("valortotal"));
								// JOptionPane.showMessageDialog(null,
								// "Nome Encontrado!");
							}
						} catch (SQLException e) {
							System.out.println("Não Encontrado...");
							// JOptionPane.showMessageDialog(null,
							// "Nome não Encontrado!\n"+e.getMessage());
						}
						conecta.desconecta();
						break;
					default:
						System.out.println("Opção Invalida");
					}
				} while (opc2 != 5);
			case 3:
				do {
					System.out.println("1 - Editar Cliente");
					System.out.println("2 - Editar Veículo");
					System.out.println("2 - Editar Serviço");
					System.out.println("2 - Editar Item");
					opc2 = ler.nextInt();
					ler.nextLine();
					switch (opc2) {
					case 1:
						do {
							conecta.conecta();
							System.out
									.println("Qual o ID do Cliente que deseja atualizar?");
							int id = ler.nextInt();
							System.out.println("Qual item deseja atualizar?");
							System.out.println("1 - Nome");
							System.out.println("2 - Telefone");
							System.out.println("3 - Endereço");
							System.out.println("4 - Mail");
							opc3 = ler.nextInt();
							ler.nextLine();
							switch (opc3) {
							case 1:
								try {
									System.out
											.println("Entre com o novo nome: ");
									String nomenovo = ler.nextLine();
									PreparedStatement pst11 = (PreparedStatement) conecta.conn
											.prepareStatement("update clientes set nome = ? where id = ?");
									pst11.setString(1, nomenovo);
									pst11.setInt(2, id);
									pst11.executeUpdate();
									System.out.println("Alterado com Sucesso");
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(
											null,
											"Erro na Inserção!\n"
													+ e.getMessage());
								}
								break;
							case 2:
								try {
									System.out
											.println("Entre com o novo Telefone: ");
									String telefonenovo = ler.next();
									PreparedStatement pst12 = (PreparedStatement) conecta.conn
											.prepareStatement("update clientes set telefone where id = ?");
									pst12.setString(2, telefonenovo);
									pst12.executeUpdate();
									JOptionPane.showMessageDialog(null,
											"Salvo com Sucesso");
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(
											null,
											"Erro na Inserção!\n"
													+ e.getMessage());
								}
								break;
							case 3:
								try {
									System.out
											.println("Entre com o novo Endereço: ");
									String endereconovo = ler.next();
									PreparedStatement pst13 = (PreparedStatement) conecta.conn
											.prepareStatement("update clientes set endereco where id = ?");
									pst13.setString(3, endereconovo);
									pst13.executeUpdate();
									JOptionPane.showMessageDialog(null,
											"Salvo com Sucesso");
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(
											null,
											"Erro na Inserção!\n"
													+ e.getMessage());
								}
								break;
							case 4:
								try {
									System.out
											.println("Entre com o novo email: ");
									String emailnovo = ler.next();
									PreparedStatement pst14 = (PreparedStatement) conecta.conn
											.prepareStatement("update clientes set email where id = ?");
									pst14.setString(4, emailnovo);
									pst14.executeUpdate();
									JOptionPane.showMessageDialog(null,
											"Salvo com Sucesso");
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(
											null,
											"Erro na Inserção!\n"
													+ e.getMessage());
								}
							default:
								System.out.println("Opção Inválida.");
							}
						} while (opc != 4);
						conecta.desconecta();
						break;
					case 2:
						do {
							conecta.conecta();
							System.out
									.println("Qual o ID do veículo que deseja atualizar?");
							int id = ler.nextInt();
							System.out.println("Qual item deseja atualizar?");
							System.out.println("1 - Marca");
							System.out.println("2 - Cor");
							System.out.println("3 - Placa");
							opc3 = ler.nextInt();
							ler.nextLine();
							switch (opc3) {
							case 1:
								try {
									System.out
											.println("Entre com a nova marca: ");
									String marcanova = ler.nextLine();
									PreparedStatement pst15 = (PreparedStatement) conecta.conn
											.prepareStatement("update veiculos set nome = ? where id = ?");
									pst15.setString(1, marcanova);
									pst15.setInt(2, id);
									pst15.executeUpdate();
									System.out.println("Alterado com Sucesso");
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(
											null,
											"Erro na Inserção!\n"
													+ e.getMessage());
								}
								break;
							case 2:
								try {
									System.out
											.println("Entre com o novo Telefone: ");
									String cornova = ler.next();
									PreparedStatement pst16 = (PreparedStatement) conecta.conn
											.prepareStatement("update veiculos set telefone where id = ?");
									pst16.setString(2, cornova);
									pst16.executeUpdate();
									JOptionPane.showMessageDialog(null,
											"Salvo com Sucesso");
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(
											null,
											"Erro na Inserção!\n"
													+ e.getMessage());
								}
								break;
							case 3:
								try {
									System.out
											.println("Entre com o novo Endereço: ");
									String placanova = ler.next();
									PreparedStatement pst17 = (PreparedStatement) conecta.conn
											.prepareStatement("update veiculos set endereco where id = ?");
									pst17.setString(3, placanova);
									pst17.executeUpdate();
									JOptionPane.showMessageDialog(null,
											"Salvo com Sucesso");
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(
											null,
											"Erro na Inserção!\n"
													+ e.getMessage());
								}
								break;

							default:
								System.out.println("Opção Inválida.");
							}
						} while (opc != 3);
						conecta.desconecta();
						break;
					case 3:
						do {
							conecta.conecta();
							System.out
									.println("Qual o ID do serviço que deseja atualizar?");
							int id = ler.nextInt();
							System.out.println("Qual item deseja atualizar?");
							System.out.println("1 - Nome do serviço");
							System.out.println("2 - Descrição do serviço");
							System.out.println("3 - Preço do serviço");
							opc3 = ler.nextInt();
							ler.nextLine();
							switch (opc3) {
							case 1:
								try {
									System.out
											.println("Entre com a novo nome: ");
									String novonome = ler.nextLine();
									PreparedStatement pst18 = (PreparedStatement) conecta.conn
											.prepareStatement("update servicos set servico = ? where id = ?");
									pst18.setString(1, novonome);
									pst18.setInt(2, id);
									pst18.executeUpdate();
									System.out.println("Alterado com Sucesso");
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(
											null,
											"Erro na Inserção!\n"
													+ e.getMessage());
								}
								break;
							case 2:
								try {
									System.out
											.println("Entre com a nova descrição: ");
									String descricaonova = ler.next();
									PreparedStatement pst19 = (PreparedStatement) conecta.conn
											.prepareStatement("update servicos set descricao where id = ?");
									pst19.setString(2, descricaonova);
									pst19.executeUpdate();
									JOptionPane.showMessageDialog(null,
											"Salvo com Sucesso");
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(
											null,
											"Erro na Inserção!\n"
													+ e.getMessage());
								}
								break;
							case 3:
								try {
									System.out
											.println("Entre com o novo preço: ");
									int preçonovo = ler.nextInt();
									PreparedStatement pst20 = (PreparedStatement) conecta.conn
											.prepareStatement("update servicos set precoservico where id = ?");
									pst20.setInt(3, preçonovo);
									pst20.executeUpdate();
									JOptionPane.showMessageDialog(null,
											"Salvo com Sucesso");
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(
											null,
											"Erro na Inserção!\n"
													+ e.getMessage());
								}
								break;
							default:
								System.out.println("Opção Inválida.");
							}
						} while (opc != 3);
						conecta.desconecta();
						break;
					case 4:
						do {
							conecta.conecta();
							System.out
									.println("Qual o ID do Item que deseja atualizar?");
							int id = ler.nextInt();
							System.out.println("Qual item deseja atualizar?");
							System.out.println("1 - Nome");
							System.out.println("2 - Quantidade");
							System.out.println("3 - Preço");
							opc3 = ler.nextInt();
							ler.nextLine();
							switch (opc3) {
							case 1:
								try {
									System.out
											.println("Entre com o novo nome: ");
									int nomenovo = ler.nextInt();
									PreparedStatement pst21 = (PreparedStatement) conecta.conn
											.prepareStatement("update itens set item = ? where id = ?");
									pst21.setInt(1, nomenovo);
									pst21.setInt(2, id);
									pst21.executeUpdate();
									System.out.println("Alterado com Sucesso");
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(
											null,
											"Erro na Inserção!\n"
													+ e.getMessage());
								}
								break;
							case 2:
								try {
									System.out
											.println("Entre com a nova quantidade: ");
									String novaqtd = ler.next();
									PreparedStatement pst23 = (PreparedStatement) conecta.conn
											.prepareStatement("update itens set quantidade where id = ?");
									pst23.setString(2, novaqtd);
									pst23.executeUpdate();
									JOptionPane.showMessageDialog(null,
											"Salvo com Sucesso");
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(
											null,
											"Erro na Inserção!\n"
													+ e.getMessage());
								}
								break;
							case 3:
								try {
									System.out
											.println("Entre com o novo preço: ");
									String novopreco = ler.next();
									PreparedStatement pst24 = (PreparedStatement) conecta.conn
											.prepareStatement("update itens set precoitem where id = ?");
									pst24.setString(3, novopreco);
									pst24.executeUpdate();
									JOptionPane.showMessageDialog(null,
											"Salvo com Sucesso");
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(
											null,
											"Erro na Inserção!\n"
													+ e.getMessage());
								}
								break;

							default:
								System.out.println("Opção Inválida.");
							}
						} while (opc != 3);
						conecta.desconecta();
						break;
					default:
						System.out.println("Opção Invalida");
					}
				} while (opc2 != 4);
			case 4:
				do {
					System.out.println("1 - Deletar Cliente");
					System.out.println("2 - Deletar Veículo");
					System.out.println("3 - Deletar Serviço");
					System.out.println("4 - Deletar Item");
					opc2 = ler.nextInt();
					ler.nextLine();
					switch (opc2) {
					case 1:
						try {
							System.out
									.println("Entre com o nome do cliente que deseja excluir: ");
							String nome = ler.next();
							PreparedStatement pst25 = (PreparedStatement) conecta.conn
									.prepareStatement("delete from clientes where id,nome,telefone,endereco,email = ?,?,?,?,?");
							pst25.setString(1, nome);
							pst25.execute();
							System.out.println("Excluido com sucesso");
							// JOptionPane.showMessageDialog(rootPane,
							// "Excluído com Sucesso");
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null,
									"Erro na Deleção!\n" + e.getMessage());
						}
						conecta.desconecta();
					case 2:
						try {
							System.out
									.println("Entre com a placa do veículo que deseja excluir: ");
							String placa = ler.next();
							PreparedStatement pst26 = (PreparedStatement) conecta.conn
									.prepareStatement("delete from veiculos where id,marca,cor,placa = ?,?,?,?");
							pst26.setString(3, placa);
							pst26.execute();
							System.out.println("Excluido com sucesso");
							// JOptionPane.showMessageDialog(rootPane,
							// "Excluído com Sucesso");
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null,
									"Erro na Deleção!\n" + e.getMessage());
						}
						conecta.desconecta();
						break;
					case 3:
						try {
							System.out
									.println("Entre com o serviço que deseja excluir: ");
							String servico = ler.next();
							PreparedStatement pst27 = (PreparedStatement) conecta.conn
									.prepareStatement("delete from servicos where id,servico,descricao,precoservico = ?,?,?,?");
							pst27.setString(1, servico);
							pst27.execute();
							System.out.println("Excluido com sucesso");
							// JOptionPane.showMessageDialog(rootPane,
							// "Excluído com Sucesso");
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null,
									"Erro na Deleção!\n" + e.getMessage());
						}
						conecta.desconecta();
						break;
					case 4:
						try {
							System.out
									.println("Entre com o item que deseja excluir: ");
							String item = ler.next();
							PreparedStatement pst28 = (PreparedStatement) conecta.conn
									.prepareStatement("delete from itens where id,item,quantidade,precoitem = ?,?,?,?");
							pst28.setString(1, item);
							pst28.execute();
							System.out.println("Excluido com sucesso");
							// JOptionPane.showMessageDialog(rootPane,
							// "Excluído com Sucesso");
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null,
									"Erro na Deleção!\n" + e.getMessage());
						}
						conecta.desconecta();
						break;
					default:
						System.out.println("Opção Invalida");
					}
				} while (opc2 != 4);
			case 5:
				conecta.conecta();
				try {
					System.out
							.println("Entre com a ordem de serviço que deseja imprimir: ");
					int id = ler.nextInt();
					gravarArq.printf("+--ORDEM DE SERVIÇO--+%n");
					PreparedStatement pst29 = (PreparedStatement) conecta.conn
							.prepareStatement("select id_veiculo,id_servico,id_item,quantidade_item,valor_unit, valortotal, "
									+ "from os, os_item, os_servico where"
									+ "os.id = os_servico.id_os and"
									+ "os_servico.id_os = os_item.id_os and"
									+ "os.id p= '?' ");
					pst29.setInt(1, id);
					ResultSet rs = pst29.executeQuery();
					while (rs.next()) {
						gravarArq.printf("OS encontrada");
						gravarArq.printf("ID" + rs.getInt("id"));
						gravarArq.printf("Veiculo: "
								+ rs.getString("id_veiculo"));
						gravarArq.printf("Serviço: "
								+ rs.getString("id_servico"));
						gravarArq.printf("Item: " + rs.getString("id_servico"));
						gravarArq.printf("Quantidade: "
								+ rs.getString("quantidade_item"));
						gravarArq.printf("Valor Unitário: "
								+ rs.getString("valor_unit"));
						gravarArq.printf("Valor Total: "
								+ rs.getString("valortotal"));
						// JOptionPane.showMessageDialog(null,
						// "Nome Encontrado!");
					}
					arq.close();
				} catch (SQLException e) {
					System.out.println("Não Encontrado...");
					// JOptionPane.showMessageDialog(null,
					// "Nome não Encontrado!\n"+e.getMessage());
				}
				conecta.desconecta();
				break;

			default:
				System.out.println("Opção Invalida");
			}
		} while (opc != 6);
		ler.close();
	}
}
