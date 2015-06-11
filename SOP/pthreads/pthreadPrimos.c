#include <pthread.h>
#include <stdio.h>

// A biblioteca abaixo é necessário para obtermos o 
// numero de processadores. Biblioteca nao testada
// wm Windows. Nem pretendo testar!
#include <unistd.h>

// Variavel que define se haverá ou nao debug do codigo
// Identificar saidas de debug pelo if(debug == 1)
#define debug 0 

// Variavel que define se haverá ou não a informação de
// comparação do numeros de processadores e threads
#define cores 0 

// Numero de threads a serem executadas
#define num_threads 3

// Numero maximo que sera calculado os numeros primos
#define max 30

// Matriz que guardará os resultados
int resultado[max][num_threads]; 

// Define os blocos de valores que serão divididos entre as threads
// Exemplo: Se forem calculados numeros ate 15 em 3 threads serão
// separados blocos de 5, por que 15/3 = 5
int calc = max/num_threads;

int calcula(void *maxt){
  int numero;
  int base = maxt - calc;
  int prox = 0;

  // Converte a variavel recebida para ponteiro
  // Mais informações em:
  // http://www.unix.com/programming/138074-pthread_exit-pthread_join-usage.html
  int max2 = (int*)maxt;

  // Calcula qual o numero da thread com base no maximo passado para thread
  int num_thread = ((max2 - 1) / calc) - 1; 
  
  // Este for irá calcular os números primos
  for(numero=base;numero<max2;numero++){
    int i;
    int flag = 0;
    for(i=2;i<numero;i++){
      if(numero % i == 0 ){
        flag = 1;
        break;
      }
    }
    if(flag == 0){
      // Se identificado um numero primo o mesmo é gravado
      // na matriz de resultados
      resultado[prox][num_thread]=numero;
      if(debug == 1){
        printf("Gravado na posição (%d,%d). Max2 = %d. calc = %d. Numero = %d\n",prox,num_thread,max2,calc,numero);
      }
      prox++;
    }
  }
  // finalizada a execução da thread
  pthread_exit('0');
}


int main(){
  int i;
  // Cria array de threads
  pthread_t thread[num_threads];

  // Busca o numero de processadores
  int num_cores = sysconf(_SC_NPROCESSORS_ONLN);

  int x;
  int y;
  
  printf("Calculando números primos até %d utilizando-se de %d threads.\n\n",max,num_threads);
  
  // Se habilitado, esse bloco apresenta a mensagem sobre num de 
  // processadores e threads utilizadas.
  if(cores == 1){
    if(num_threads != num_cores){
        printf("Atenção: Este programa não está utilizando o mesmo número de threads do que o número de núcleos disponíveis.\n");
        printf("\tNúcleos: %d\n\tThreads: %d\n\n",num_cores,num_threads);
    }
  }
  
  // Zera matriz de resultado
  for(y=0;y<num_threads;y++){
    for(x=0;x<max;x++){
      resultado[x][y]=0;
    }
  }

  // Cria as threads conforme o numero de threads configurado
  for(i=0;i<num_threads;i++){
    int max2 = ((i+1)*calc)+1;
    if(debug == 1){
      printf("O max2 sai assim aqui => %d\n",max2);
    }
    // Cria a thread passando como parametro max2
    // Max2 contem o numero maximo para calcular em cada thread
    pthread_create(&thread[i],NULL,calcula,(void *) max2);
  }

  // Espera todas as threads terminarem
  for(i=0;i<num_threads;i++){
    pthread_join(thread[i], NULL);
  }
  
  // Varre a matriz de resultado e lança o mesmo na tela
  printf("Resultado:\n\t============\n");
  for(y=0;y<num_threads;y++){
    for(x=0;x<max;x++){
      if(resultado[x][y]!=0){
        printf("\t %d é primo",resultado[x][y]);
	if(debug == 1){
	  printf(" -> Posição (%d,%d)",x,y);
	}
	printf("\n");
      }
    }
  }
  printf("\t============\n");
  pthread_exit(NULL);
}
