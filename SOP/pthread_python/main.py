from consumidor import Consumidor
from produtor import Produtor
from reservatorio import Reservatorio

res = Reservatorio(100)
num_cons = raw_input("Quantos consumidores devem ser instanciados?")
try:
    num_cons = int(num_cons)
except:
    print "O valor digitado precisa ser um inteiro"

produtor = Produtor('produtor', res)
produtor.start()

consumidores = []

for i in range(0,num_cons):
    consumidor = Consumidor("consumidor" + str(i+1), res)
    consumidores.append(consumidor)
    consumidor.start()

for consumidor in consumidores:
    consumidor.join()

produtor.execute = False
print "[\tMAIN\t] Reservatorio terminou com %s litros" % res.capacidade
