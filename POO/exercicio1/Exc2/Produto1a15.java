
package javaapplication4;

public class Produto1a15 {
    public static void main(String[] args) {
       int impares=0; 
       int total=1; 
       for (int i=0;i<=15;i++){
           if (i %2 != 0){
               total *= i;
           }
       }
       System.out.println("O produto dos numeros impares de 1 a 15 é:>>" +total); 
    }
    
}
