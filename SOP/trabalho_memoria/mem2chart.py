#!/usr/bin/python
# -*- coding: utf8 -*-

import pygal
from pygal.style import DefaultStyle

def gerar_grafico(fisica, virtual):
	grafico = pygal.Bar(print_values=True, style=DefaultStyle(
                  value_font_family='googlefont:Raleway',
                  value_font_size=30,
                  value_colors=('white',)))
	grafico.title = 'Uso de memoria (%)'
	grafico.add('Fisica', fisica)
	grafico.add('Virtual', virtual)
	print grafico.render()

if __name__ == '__main__':
	i = 0
	while True:
		try:
			linha = raw_input()
			linha = linha.split(';') 
			mem_total = int(linha[0])
			mem_usada = int(linha[1])
			porcent = (mem_usada * 100) / mem_total
			if i == 0:
				fisica = porcent
			elif i == 1:
				virtual = porcent
			else:
				print 'Tem linha demais ai'
			i += 1
		except EOFError:
			break
	gerar_grafico(fisica, virtual)
	
