#!/usr/bin/python
# -*- coding: utf-8 -*-

import sys
from datetime import datetime

# Variáveis estáticas
OPCOES = ['receita', 'despesa', 'saldo']

# Inicializar variáveis
cont_linha = 1
cont_receita = 0
cont_despesa = 0
saldo = 0
receita = 0
despesas = 0

while True:
    try:
        linha = raw_input()
    except EOFError:
        break
    linha = linha.split(":")
    tipo_de_dados = linha[0]
    if tipo_de_dados in OPCOES:
        valor = linha[1]
        if tipo_de_dados in ['saldo', 'receita']:
            if tipo_de_dados == 'saldo':
                saldo += float(valor.split(" ")[1])
            else:
                valor = float(valor.split(" ")[2])
                saldo += valor
                receita += valor
                cont_receita += 1
        else:
            valor = float(valor.split(" ")[2])
            despesas += valor
            saldo -= valor
            cont_despesa += 1
    else:
        hora = datetime.now()
        sys.stderr.write(hora.strftime("%H:%M:%S - %d/%m/%Y - "))
        sys.stderr.write(str(cont_linha) + " - Erro: Opção não válida!\n")
    
    cont_linha += 1


# Imprime resultados
print str(saldo) + " reais de saldo"
print "%.2f reais de despesas distribuídos em %d vezes" % (despesas, cont_despesa)
print "%.2f reais de receita distribuídos em %d vezes" % (receita, cont_receita)
