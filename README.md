# Snake Game - Projeto de Programação Orientada a Objetos

Este é um Projeto Desktop do famoso Snake Game desenvolvido para a disciplina de Programação Orientada a Objetos. O jogo foi implementado em Java, utilizando a Framework Maven para Gerenciamento de Dependências e construção do Projeto.

## Sobre o Projeto

O Snake Game é um clássico jogo de arcade onde o jogador controla uma cobra que cresce de acordo com os itens que ela consome no cenário. O objetivo do jogo é guiar a cobra para que ela se alimente de frutas como Maças e Abacaxis, evitando colidir com as bordas da tela ou com o próprio corpo.

## Conceitos de Programação Orientada a Objetos (POO)

O Projeto utiliza os conceitos fundamentais de Programação Orientada a Objetos:

### Classes e Objetos:

As entidades do Jogo, como a Cobra, as Frutas e o Cenário, são representadas por Classes. Os Objetos são Instâncias dessas Classes.

### Herança:

A Hierarquia de Classes é utilizada para reutilizar código comum e estabelecer relações de especialização entre as entidades do Jogo. Por exemplo, a Classe Food pode ser Herdada pelas Classes Apple e Pineapple.

### Encapsulamento:

Os detalhes de implementação de cada classe são encapsulados, definindo Classes Públicas, Privadas e Protegidas. Isso promove a modularidade e facilita a manutenção do código.

### Abstração:

O código é organizado em Classes e Métodos que representam conceitos abstratos do jogo, como a Cobra, as Frutas e o Cenário. Isso simplifica a implementação e torna o código mais compreensível.

### Polimorfismo:

O jogo utiliza Polimorfismo para tratar Objetos de Classes com diferentes comportamentos com base no Contexto utilizado. Isso contribui para a flexibilidade do código.

## Como Executar o Projeto

### Pré-requisitos:

- JDK (Java Development Kit) instalado.
- Maven instalado.
- IDE Java (por exemplo, Eclipse, IntelliJ IDEA, VSCode).

### Iniciando o Projeto:

- Clone o repositório do Projeto para o seu ambiente Local.
- Abra o Terminal na pasta raiz do projeto.
- Execute o Comando para instalar as Dependências do Maven.

```
mvn install
```

- Em seguida, execute o Comando para Compilar e Executar o Projeto.

```
mvn compile javafx:run
```

- Após seguir esses passos, o Snake Game será iniciado e você poderá começar a jogar!

## Ambiente de Desenvolvimento:

Este projeto foi desenvolvido utilizando o editor de código Visual Studio Code (VSCode), mas pode ser executado em qualquer IDE Java compatível com Maven.
