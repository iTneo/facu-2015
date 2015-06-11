#!/bin/bash
arquivo="pthreadPrimos"
clear
if [ "$1" == "--help" ];then
    echo "USO: $0 [OPÇÃO]
Programa de execução da calculadora de números primos.

Opções disponíveis:
    --cores	    Exibe comparação do número de núcleos e número de threads sendo executadas
    --debug	    Ativa o modo de debug da calculadora. (desenvolvimento)
"
    exit
fi

if [ "$1" == "--debug" -o "$2" == "--debug" ];then
   debug=1
   sed "s/^#define debug 0/#define debug 1/g" ${arquivo}.c > /tmp/${arquivo}.c
fi

if [ "$1" == "--cores" -o "$2" == "--cores" ];then
    if [ "$debug" == "1" ]; then
        sed "s/^#define cores 0/#define cores 1/g" -i /tmp/${arquivo}.c 
    else
        sed "s/^#define cores 0/#define cores 1/g" ${arquivo}.c > /tmp/${arquivo}.c
    fi
else 
    cat ${arquivo}.c > /tmp/${arquivo}.c
fi   
gcc -o /tmp/$arquivo -pthread /tmp/$arquivo.c &> /dev/null
/tmp/$arquivo
