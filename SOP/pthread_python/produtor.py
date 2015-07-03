# coding=utf-8
from threading import Thread
from random import randrange
from time import sleep


class Produtor(Thread):

    def __init__(self, nome, reservatorio):
        Thread.__init__(self)
        self.nome = nome
        self.dormindo = True
        self.execute = True
        self.res = reservatorio

    def run(self):
        while self.execute:
            if self.dormindo:
                self.dormindo = False
                litros = randrange(100, 500)
                print "[ produtor\t] Vou produzir %d litros" % litros
                for litros in range(0, litros):
                    self.res.add(1)
                    sleep(0.025)
            else:
                self.dormindo = True
                tempo_sono = randrange(8000, 15000)
                print "[ produtor\t] Vou dormir por %d milisegundos" % tempo_sono
                sleep(tempo_sono/1000.0)
