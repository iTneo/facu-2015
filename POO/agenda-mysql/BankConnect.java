
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class BankConnect {
	public Statement stmt;

	public ResultSet rs;
	public String driver = "com.mysql.jdbc.Driver";
	private String usuario = "root";
	private String senha = "jona2210";
	private String caminho = "jdbc:mysql://localhost:3306/agenda";

	public Connection conn;

	public void conecta() {
		try {
			System.setProperty("jdbc.Drivers", driver);
			conn = DriverManager.getConnection(caminho, usuario, senha);
			JOptionPane.showMessageDialog(null, "Conectado ao banco!");
		} catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro de conexão!\nErro:" + ex.getMessage());
		}
	}

    public void desconecta() {
    	try {
    		conn.close();
     		JOptionPane.showMessageDialog(null, "Desconectado do banco.");
    	} catch (SQLException ex){
    		JOptionPane.showMessageDialog(null, "Erro de desconexão!\nErro:" + ex.getMessage());
    	}
	}

}
