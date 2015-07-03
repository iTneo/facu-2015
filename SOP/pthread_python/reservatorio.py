class Reservatorio(object):
    def __init__(self, capacidade=100):
        self.capacidade = capacidade

    def remove(self, val):
        if self.capacidade >= val:
            self.capacidade -= val
            return True
        else:
            return False

    def add(self, val):
        self.capacidade += 1
