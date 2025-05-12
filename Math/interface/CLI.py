import sys
import os

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '../src')))

from operations.Derivatives import derivative, second_derivative
from operations.Integrals import indefinite_integral, definite_integral

def menu():
    while True:
        print("Calculadora de Derivadas e Integrais")
        print("1. Derivada")
        print("2. Derivada de segunda ordem")
        print("3. Integral indefinida")
        print("4. Integral definida")
        print("0. Sair")
        opcao = input("Escolha uma opção: ")

        if opcao == '1':
            expr = input("Digite a função: ")
            print("Derivada:", derivative(expr))
        elif opcao == '2':
            expr = input("Digite a função: ")
            print("Derivada de segunda ordem:", second_derivative(expr))
        elif opcao == '3':
            expr = input("Digite a função: ")
            print("Integral indefinida:", indefinite_integral(expr))
        elif opcao == '4':
            expr = input("Digite a função: ")
            lower = float(input("Digite o limite inferior: "))
            upper = float(input("Digite o limite superior: "))
            print("Integral definida:", definite_integral(expr, lower, upper))
        elif opcao == '0':
            break
        else:
            print("Opção inválida!")

menu()
