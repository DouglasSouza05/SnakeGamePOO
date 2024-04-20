Snake Game - Projeto de Programação Orientada a Objetos
Este é um projeto de um jogo Snake Game desenvolvido como parte da disciplina de Programação Orientada a Objetos. O jogo foi implementado em Java, utilizando o framework Maven para gerenciamento de dependências e construção do projeto.

Sobre o Projeto
O Snake Game é um clássico jogo de arcade onde o jogador controla uma cobra que cresce de acordo com os itens que ela consome no cenário. O objetivo do jogo é guiar a cobra para que ela se alimente de maçãs e outras frutas, evitando colidir com as bordas da tela ou com o próprio corpo.

Conceitos de Programação Orientada a Objetos (POO)
O projeto utiliza os princípios fundamentais da Programação Orientada a Objetos:

Classes e Objetos: As entidades do jogo, como a cobra, as frutas e o cenário, são representadas por classes. Os objetos são instâncias dessas classes.
Herança: A hierarquia de classes é utilizada para reutilizar código comum e estabelecer relações de especialização entre as entidades do jogo. Por exemplo, a classe Fruit pode ser herdada pelas classes Apple e Pineapple.
Encapsulamento: Os detalhes de implementação de cada classe são encapsulados, expondo apenas interfaces públicas para interação. Isso promove a modularidade e facilita a manutenção do código.
Abstração: O código é organizado em classes e métodos que representam conceitos abstratos do jogo, como a cobra, as frutas e o cenário. Isso simplifica a implementação e torna o código mais compreensível.
Polimorfismo: O jogo utiliza polimorfismo para tratar objetos de classes diferentes de maneira uniforme. Por exemplo, várias entidades do jogo podem ser renderizadas na tela usando o mesmo método render().
Como Executar o Projeto
Pré-requisitos
JDK (Java Development Kit) instalado
Maven instalado
IDE Java (por exemplo, Eclipse, IntelliJ IDEA, VSCode)
Iniciando o Projeto
Clone o repositório do projeto para o seu ambiente local.
Abra o terminal na pasta raiz do projeto.
Execute o comando mvn install para instalar as dependências do Maven.
Em seguida, execute o comando mvn compile javafx:run para compilar e executar o projeto.
Após seguir esses passos, o jogo Snake Game será iniciado e você poderá começar a jogar!

Ambiente de Desenvolvimento
Este projeto foi desenvolvido utilizando o editor de código Visual Studio Code (VSCode), mas pode ser executado em qualquer IDE Java compatível com Maven.

Sinta-se à vontade para explorar o código-fonte do projeto e modificar conforme necessário. Divirta-se jogando o Snake Game!
