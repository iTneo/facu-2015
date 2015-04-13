#include <sys/wait.h>
int main(){
    int pid[3];
    pid[0]= fork();
    if(pid[0]==0){
	pid[1]=fork();
	if(pid[1]==0){
	    pid[2]=fork(); 
	    sleep(20);
	}else{
	    sleep(30);
	}
    }else{
	sleep(40);
    }
}
