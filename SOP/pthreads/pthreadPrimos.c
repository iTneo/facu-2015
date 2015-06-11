#include <pthread.h>
#include <stdio.h>
#include <unistd.h>


#define debug 0 
#define cores 0 
#define num_threads 3
#define max 30
int resultado[max][num_threads]; 

int calcula(void *maxt){
  int numero;
  int calc = max/num_threads;
  int base = maxt - calc;
  int prox = 0;
  int max2 = (int*)maxt;
  int num_thread = ((max2 - 1) / calc) - 1; 
  for(numero=base;numero<max2;numero++){
    int i;
    int flag = 0;
    for(i=2;i<numero;i++){
      // Meu debug! printf("Aqui -> %d || %d\n",numero,i);
      if(numero % i == 0 ){
        flag = 1;
        break;
      }
    }
    if(flag == 0){
      resultado[prox][num_thread]=numero;
      if(debug == 1){
        printf("Gravado na posição (%d,%d). Max2 = %d. calc = %d. Numero = %d\n",prox,num_thread,max2,calc,numero);
      }
      prox++;
    }
  }
  pthread_exit('c');
}


int main(){
  int i;
  int cont_resul;
  pthread_t thread[num_threads];
  int num_cores = sysconf(_SC_NPROCESSORS_ONLN);
  int calc = max / num_threads;
  int x;
  int y;
  
  printf("Calculando números primos até %d utilizando-se de %d threads.\n\n",max,num_threads);
  if(cores == 1){
    if(num_threads != num_cores){
        printf("Atenção: Este programa não está utilizando o mesmo número de threads do que o número de núcleos disponíveis.\n");
        printf("\tNúcleos: %d\n\tThreads: %d\n\n",num_cores,num_threads);
    }
  }
   
  for(y=0;y<num_threads;y++){
    for(x=0;x<max;x++){
      resultado[x][y]=0;
    }
  }
  for(i=0;i<num_threads;i++){
    int max2 = ((i+1)*calc)+1;
    if(debug == 1){
      printf("O max2 sai assim aqui => %d\n",max2);
    }
    pthread_create(&thread[i],NULL,calcula,(void *) max2);
  }
  for(i=0;i<num_threads;i++){
    pthread_join(thread[i], NULL);
  }
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
