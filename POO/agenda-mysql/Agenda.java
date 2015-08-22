
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Agenda {
	
	private Scanner entrada = new Scanner(System.in);
    private BankConnect bo = new BankConnect();
	
	public void adicionarContato() {
		System.out.println("Digite o nome:");
		String nome = entrada.next();
		System.out.println("Digite o endereço:");
		String endereco = entrada.next();
		System.out.println("Digite o telefone");
		String telefone = entrada.next();
		System.out.println("Digite seu email:");
		String email = entrada.next();


		try {
			PreparedStatement pst = (PreparedStatement) bo.conn.prepareStatement("insert into agenda (nome, endereco, telefone, email) values (?, ?, ?, ?)");
			pst.setString(1, nome);
			pst.setString(2, endereco);
			pst.setString(3, telefone);
			pst.setString(4, email);
			pst.executeUpdate();
			System.out.println("Adicionado com sucesso!");
		} catch (SQLException ex) {
			System.out.println("Falha ao adicionar !");
		}
	}

	public String consultar_id(){
		System.out.println("Digite um nome");
		String nomeBusca = entrada.next();
		ResultSet rs = null;
		try {
			PreparedStatement pst = (PreparedStatement) bo.conn.prepareStatement("select id, nome from agenda where nome like ?");
			nomeBusca = "%" + nomeBusca + "%";
			pst.setString(1, nomeBusca);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			System.out.println("Nome não Encontrado!\n");
			return "-1";
		}
		try{
			System.out.println("ID - Nome");
			while(rs.next()) {
				System.out.println(rs.getInt("id") + " - " + rs.getString("nome"));
			}
		} catch (SQLException e) {
			System.out.println("Falha ao ler dados");
		}
		System.out.println("Digite o id desejado:");
		return entrada.next();
	}
	
	public void consultar(){
		String id = consultar_id();
		ResultSet rs = null;
		try {
			PreparedStatement pst = (PreparedStatement) bo.conn.prepareStatement("select nome, endereco, telefone, email from agenda where id like ?");
			pst.setString(1, id);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			System.out.println("Nome não Encontrado!\n");
		}
		try{
			while(rs.next()) {
				System.out.println("#######################################");
				System.out.println("############     Consulta     #########");
				System.out.println("#######################################");
				System.out.println("Numero: " + rs.getInt("telefone"));
				System.out.println("Nome: " + rs.getString("nome"));
				System.out.println("Endereco: " + rs.getString("endereco"));
				System.out.println("E-mail: " + rs.getString("email"));
				System.out.println("#######################################");
			}
		} catch (SQLException e) {
			System.out.println("Falha ao ler dados");
		}
	}
	public void remover() {
		String id = consultar_id();
		try {
			PreparedStatement pst = (PreparedStatement) bo.conn
					.prepareStatement("delete from agenda where id = ?");
			pst.setString(1, id);
			pst.execute();
			System.out.println("Removido com sucesso!");
		} catch (SQLException ex) {
			System.out.println("Falha ao remover!");
		}
			
	}
	public void editar() {
		Boolean alteracoes = false;
		Boolean nomeChange = false;
		Boolean enderecoChange = false;
		Boolean numeroChange = false;
		Boolean emailChange = false;
		
		String sql = "update agenda set ";
		String id = consultar_id();
		System.out.println("Digite os novos valores ou 'n' para não alterar");
		System.out.println("Digite o novo nome:");
		entrada.nextLine();
		String nomeAltera2 = entrada.nextLine();
		if (nomeAltera2 != "n") {
			sql += "nome = ?,";  
			nomeChange = true;
			alteracoes = true;
		}
		System.out.println("Digite o novo endereço:");
		String enderecoAltera = entrada.next();
		if (enderecoAltera != "n") {
			sql += "endereco = ?,";
			enderecoChange = true;
			alteracoes = true;
		}
		System.out.println("Digite o novo número:");
		String numeroAltera = entrada.next();
		System.out.println(numeroAltera == "n");
		if (numeroAltera != "n") {
			sql += "telefone= ?,"; 
			numeroChange = true;
			alteracoes = true;
		}
		System.out.println("Digite o novo e-mail:");
		String emailAltera = entrada.next();
		if (emailAltera != "n") {
			sql += "email = ? "; 
			emailChange = true;
			alteracoes = true;
		} else {
			sql = sql.substring(0, sql.length());
		}	
		System.out.println(sql);
		
		sql += "where id = ?";
		try {
			if(alteracoes){
				PreparedStatement pst = (PreparedStatement) bo.conn
						.prepareStatement(sql);
				int pos = 1;
				if(nomeChange){
					pst.setString(pos, nomeAltera2);
					pos++;
				}
				if(enderecoChange){
					pst.setString(pos, enderecoAltera);
					pos++;
				}
				if(numeroChange){
					pst.setString(pos, numeroAltera);
					pos++;
				}
				if(emailChange){
					pst.setString(pos, emailAltera);
					pos++;
				}
				pst.setString(pos, id);
				pst.execute();
				System.out.println("Alterado com sucesso!");
			}else{
				System.out.println("Sem alterações!");
			}
		} catch (SQLException ex) {
			System.out.println("Falha ao alterar!");
		}
	}
	public void conectar() {
		bo.conecta();
	}
	public void desconectar() {
		bo.desconecta();
	}
	
}
