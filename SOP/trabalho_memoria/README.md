Mem2Chart
=========

## Por que usar?

Geração de gráficos do uso de memória física e virtual do sistema

## Legal e como eu uso?

Calma, moleque, primeiro você precisa instalar o firefox! Tem o firefox? Agora instale o pygal. Para Ubuntu tem o passo-a-passo abaixo, outras distro e sistemas operacionais READ THE FUCKING MANUAL AT http://pygal.readthedocs.org/ .

```
sudo apt-get install -y python-pip
sudo pip install pygal
```

## Instalei tudo e agora??

Clone o repositório:
```
git clone https://github.com/jonathan.beber/facu-2015
```

Entre na pasta do arquivo:
```
cd facu-2015/SOP/trabalho_memoria
```

Execute  o comando abaixo:
```
free -m | grep '[MS]'| awk '{print $2 ";" $3}' | python mem2chart.py > chart.svg; firefox chart.svg
``` 
![alt tag](http://dicionarioinformal.com.br/image/v/493.png)

Seja feliz!



