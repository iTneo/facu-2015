#!/usr/bin/python
# -*- coding: utf-8 -*-

import sys
from datetime import datetime

# Variáveis estáticas
OPCOES = ['receita', 'despesa', 'saldo']

# Inicializar variáveis
saldo=0
receita=0
despesas=0

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
        else:
            valor = float(valor.split(" ")[2])
            despesas += valor
            saldo -= valor
    else:
        hora = datetime.now()
        sys.stderr.write(hora.strftime("%H:%M - %d:%m:%Y - "))
        sys.stderr.write("Erro: Opção não válida!\n")

# Imprime resultados
print str(saldo) + " reais de saldo"
print str(despesas) + " reais de despesas"
print str(receita) + " reais de receita"
