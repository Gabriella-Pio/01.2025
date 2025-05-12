# Calculadora de Derivadas e Integrais

Este projeto é uma calculadora que realiza operações matemáticas básicas como cálculo de derivadas e integrais, desenvolvida para a disciplina de Cálculo I.

## Estrutura do Projeto

A organização do projeto segue a seguinte estrutura:

```
calculadora_derivadas_integrais/
├── src/                # Código-fonte principal do projeto
│   ├── main/           # Ponto de entrada do programa
│   │   └── Main.py     # Contém a lógica principal
│   ├── operations/     # Lógica de cálculo matemático
│   │   ├── Derivatives.py   # Módulo para cálculo de derivadas
│   │   └── Integrals.py     # Módulo para cálculo de integrais
│   └── utils/          # Funções auxiliares e utilitárias
│       └── Parser.py   # Função para interpretar e validar a entrada do usuário
├── docs/               # Documentação
│   ├── README.md       # Explica o funcionamento do projeto
│   ├── ERS.md          # Documento explicando o código e métodos usados
│   └── relatorio.pdf   # Relatório final do projeto
├── interface/          # Interface gráfica ou CLI
│   ├── GUI.py          # Interface gráfica (se for usada)
│   └── CLI.py          # Interface por terminal
└── tests/              # Testes para validação
    ├── test_derivatives.py   # Testes para derivadas
    ├── test_integrals.py     # Testes para integrais
    └── test_parser.py        # Testes para utilitários
```

## Funcionalidades

1. **Derivadas**:

   * Calcula a derivada de uma função dada.
   * Calcula a derivada de segunda ordem.

2. **Integrais**:

   * Calcula a integral indefinida de uma função.
   * Calcula a integral definida, dados os limites inferior e superior.

3. **Interface**:

   * **CLI (Command-Line Interface)**: Interface interativa no terminal para entrada de dados e exibição de resultados.
   * **GUI (opcional)**: Interface gráfica para interação visual com o programa.

4. **Validação de Entradas**:

   * Assegura que a função fornecida seja válida e processável.

5. **Testes Automatizados**:

   * Garante a confiabilidade das operações principais por meio de testes unitários.

## Tecnologias Utilizadas

* **Python 3.10+**
* **SymPy**: Biblioteca para manipulação simbólica.
* **unittest** ou **pytest**: Para testes automatizados.

## Como Contribuir no Projeto

### 1. Configuração do Ambiente

1. Clone o repositório:

   ```bash
   git clone <link-do-repositorio>
   ```

2. Acesse o diretório do projeto:

   ```bash
   cd calculadora_derivadas_integrais
   ```

3. Crie um ambiente virtual (opcional, mas recomendado):

   ```bash
   python -m venv venv
   source venv/bin/activate  # Linux/Mac
   venv\Scripts\activate   # Windows
   ```

4. Instale as dependências:

   ```bash
   pip install -r requirements.txt
   ```

### 2. Tarefas do Projeto

Cada integrante pode assumir responsabilidades de acordo com os módulos descritos:

* **Operações MatSemáticas (`Derivatives.py`, `Integrals.py`)**:

  * Implementar e testar as funções principais para cálculos.

* **Parser (`Parser.py`)**:

  * Validar e processar as entradas dos usuários.

* **CLI (`CLI.py`)**:

  * Criar a interface do terminal para interação com o usuário.

* **Testes (`tests/`)**:

  * Escrever testes para garantir que todas as funcionalidades estão funcionando corretamente.

* **Documentação (`docs/`)**:

  * Redigir o relatório, README, e outros documentos explicativos.

### 3. Fluxo de Trabalho

1. Crie uma branch para a tarefa que está desenvolvendo:

   ```bash
   git checkout -b nome-da-branch
   ```

2. Após concluir a tarefa, faça commit e envie para o repositório remoto:

   ```bash
   git add .
   git commit -m "Descrição do que foi feito"
   git push origin nome-da-branch
   ```

3. Abra um Pull Request para revisão do código.

## Próximos Passos

1. Implementar as operações básicas de derivadas e integrais.
2. Garantir que o Parser está funcionando para validar entradas.
3. Criar a CLI para interagir com o usuário.
4. Escrever testes para validar as funcionalidades implementadas.
5. Trabalhar na documentação e no relatório final.

## Referências

* [Documentação SymPy](https://docs.sympy.org)
* [PEP 8 - Guia de Estilo para Python](https://peps.python.org/pep-0008/)
* [unittest](https://docs.python.org/3/library/unittest.html)
* [SymPy Youtube Playlist - TM Quest](https://www.youtube.com/watch?v=VKOYjemQRqw&list=PLSE7WKf_qqo1T5VV1nqXTj2iNiSpFk72T)

---

**Importante**: Colabore com o grupo, compartilhe avanços regularmente e tire dúvidas para garantir que o projeto seja concluído com sucesso!
