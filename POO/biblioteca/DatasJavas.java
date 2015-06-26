package biblioteca;

import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;


public class DatasJavas {
	public static void main(String[] args) throws InterruptedException {
		//DateFormat formato = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,new Locale("PT", "br"));
		//System.out.println(formato.format(agora));
		/*
		while(true){
			Date agora = new Date();
				
			SimpleDateFormat formatoSimples = new SimpleDateFormat("#               dd/MM/yyyy' - 'hh:mm:ss  a           #");
			
			
			System.out.println("#####################################################");
			System.out.println("#                                                   #");
			System.out.println("#             Relógio feito na melhor               #");
			System.out.println("#                   linguagem                       #");
			System.out.println("#                                                   #");
			System.out.println(formatoSimples.format(agora));
			System.out.println("#                                                   #");
			System.out.println("#         of the HOLE WORLD!!!                      #");
			System.out.println("#               The big one!! SHEMALE               #");
			System.out.println("#####################################################");
			Thread.currentThread().sleep(10);
			for(int i=0;i<100;i++){
				System.out.println();
			}
		}
		*/
		
		SimpleDateFormat formatoSimples = new SimpleDateFormat("[ dd/MM/yyyy - hh:mm:ss a ]");
		Calendar data = Calendar.getInstance();
		data.set(Calendar.YEAR, 2016);
		data.set(Calendar.MONTH, 01);
		data.set(Calendar.DAY_OF_MONTH, 26);
		System.out.println(formatoSimples.format(data.getTime()));
		data.add(Calendar.DAY_OF_MONTH, 5);
		System.out.println(formatoSimples.format(data.getTime()));
	}
}
