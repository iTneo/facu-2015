# coding=utf-8
from threading import Thread
from random import randrange
from time import sleep


class Consumidor(Thread):
    def __init__(self, nome, reservatorio):
        Thread.__init__(self)
        self.nome = nome
        self.num_consumo = randrange(1, 100)
        self.reservatorio = reservatorio

    def run(self):
        print "[ %s\t] Irei tentar cosumir água %d  vezes" \
              % (self.nome, self.num_consumo)
        for contador in range(0, self.num_consumo):
            self.__consumir(contador)
            espera = randrange(1000, 5000)
            espera /= 1000.0
            print(
                '[ %s\t] Vou esperar %.2f segundos até consumir água denovo!'
                % (self.nome, espera)
            )
            sleep(espera)

    def __consumir(self, contador):
        val_consumo = randrange(1, 100)
        print "[ %s\t] Tentarei consumir %d litros de água. Estou em minha %d vez"\
              % (self.nome, val_consumo, contador + 1)
        for contador in range(0, val_consumo):
            if self.reservatorio.remove(1):
                sleep(0.1)
            else:
                print "[ %s\t] Sem água!" % self.nome
        print "[\tMAIN\t] O reservatorio está com %s litros" \
               % self.reservatorio.capacidade
