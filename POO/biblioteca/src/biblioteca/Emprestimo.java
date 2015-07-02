package biblioteca;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Emprestimo {
	private Date dataEmprestimo;
	private Date dataDevolucao;
	private Aluno aluno;
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public void imprimirComprovante(String arquivoNome) throws IOException{
		SimpleDateFormat formatoSimples = new SimpleDateFormat(
				"[ dd/MM/yyyy - hh:mm:ss a ]");
		FileWriter arquivo = new FileWriter(arquivoNome);
		PrintWriter gravarArq = new PrintWriter(arquivo);

		gravarArq.printf("+-------Comprovante de emprestimo---------+");
		gravarArq.printf("+-------Comprovante de emprestimo---------+");
		
		
		arquivo.close();
	}
}
