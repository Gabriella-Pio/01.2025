# Main.py
# Este script integra os diferentes módulos do projeto e gerencia o fluxo principal.

import sys
import os

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '../..')))

from interface.CLI import menu

# Função principal que inicia o programa
def main():
    print("\nBem-vindo à Calculadora de Derivadas e Integrais!\n")
    while True:
        try:
            # Chama o menu da CLI
            menu()
            break  # Finaliza o programa após execução do menu
        except Exception as e:
            print(f"Ocorreu um erro: {e}")

if __name__ == "__main__":
    main()