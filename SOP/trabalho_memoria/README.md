Mem2Chart
=========

## Por que usar?

Geração de gráficos do uso de memória física e virtual do sistema

## Legal e como eu uso?

Clone o repositório:
```
git clone https://github.com/jonathan.beber/facu-2015
```

Entrena pasta do arquivo:
```
cd facu-2015/SOP/trabalho_memoria
```

Execute  o comando abaixo:
```
free -m | grep '[MS]'| awk '{print $2 ";" $3}' | python mem2chart.py > chart.svg; firefox chart.svg
``` 

