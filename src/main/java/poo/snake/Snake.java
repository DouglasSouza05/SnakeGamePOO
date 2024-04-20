package poo.snake;

import poo.canvas_utils_square.CanvasUtilsSquares;
import poo.config.Config;
import poo.scenario.Scenario;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import java.util.ArrayList;
import java.util.List;

//Construção do personagem - Snake
public class Snake {

    private Canvas head; // Cabeça da snake
    // Armazena os blocos (corpo) em Canvas
    private List<Canvas> body = new ArrayList<Canvas>(); // Lista para armazenar o corpo da snake

    // Vai armazenar o historico de posições (Integer) da snake
    // Será usado para fazer com que os bodyPart fiquem exatamente uma posição
    // anterio a da cabeça
    private List<Integer[]> positionHistory = new ArrayList<>();

    public Snake() {
        buildingSnake();
    }

    public void setHeadOnCenter() {
        // Setando a posição de head no meio da scene
        this.head.setTranslateX(Config.width / 2 - Config.squareSize);
        this.head.setTranslateY(Config.height / 2 - Config.squareSize);
    }

    // Construindo a snake
    private void buildingSnake() {
        this.head = CanvasUtilsSquares.buildingSquare(Color.TRANSPARENT); // Cria um canvas transparente
        GraphicsContext gc = this.head.getGraphicsContext2D(); // Obtém o contexto gráfico 2D
        gc.setFill(Color.GREEN); // Define a cor de preenchimento como verde
        double radius = Config.squareSize / 2; // Calcula o raio do círculo
        gc.fillOval(0, 0, radius * 2, radius * 2); // Desenha um círculo na posição (0, 0) com o raio calculado
        this.setHeadOnCenter(); // Define a posição da cabeça no centro
    }

    // Retorna o Canvas de head
    public Canvas getHead() {
        return this.head; // Retornando instância de snake
    }

    // Método usado para pegar a coordenada X
    public Integer getPosicionX() {
        return (int) this.head.getTranslateX(); // Pega a posição X e faz o Casting de double para int
    }

    // Método usado para pegar a coordenada Y
    public Integer getPosicionY() {
        return (int) this.head.getTranslateY();
    }

    // Faz toda a movimentação da head e do body da snake
    public void setPosition(Integer x, Integer y) {
        this.head.setTranslateX(x);
        this.head.setTranslateY(y);

        // Vai funcionar como uma pilha
        for (int i = 0; i < body.size(); i++) {
            Canvas bodyPart = body.get(i); // Armazendo em bodyPart o item da lista na posição i

            // Obs: O item mais velho fica no final da pilha, logo possuir o menor index
            // Pegando a posição de maior valor (maior indice)
            // Tamanho 10 (0 a 9) por isso a subtração. O i na primeiro loop vale 0, por
            // isso a soma de 1.
            Integer[] posicion = this.positionHistory.get(positionHistory.size() - (i + 1));

            // Setando as posições para 0
            bodyPart.setTranslateX(posicion[0]);
            bodyPart.setTranslateY(posicion[1]); // ?

            // Removendo posições desnecessárias
            // Necessário somente o tamanho da snake e + uma posição
            if (positionHistory.size() > body.size() + 1) {
                positionHistory.remove(0); // Remove o item mais velho, no caso o menor index (0)
            }
        }

        // Instanciando um novo Array de Integer, inicializando com as posições x e y
        this.positionHistory.add(new Integer[] { x, y });

    }

    // Método retornando Canvas
    public Canvas resetGame() {
        setHeadOnCenter(); // Setado para o Centro
        Canvas headInstance;
        headInstance = getHead();

        changeSnakeColor(Color.GREEN); // Alterando a cor Vermelha para Verde ao resetar

        this.positionHistory.clear(); // Limpando o histórico
        this.body.clear(); // Limpando a lista de body

        return headInstance;
    }

    public void deadSnake() {
        changeSnakeColor(Color.BLACK);
    }

    public void changeSnakeColor(Paint color) {
        GraphicsContext gc = getHead().getGraphicsContext2D();
        gc.clearRect(0, 0, Config.squareSize, Config.squareSize); // Limpando o Canvas
        gc.setFill(Color.BLACK); // Preenchendo o círculo com a cor preta
        double radius = Config.squareSize / 2; // Calculando o raio do círculo
        gc.fillOval(0, 0, radius * 2, radius * 2); // Desenhando um círculo preto na posição (0, 0) com o raio calculado
    }

    public void eatApple(Scenario scenario) {
        // Cada parte da snake sendo um square da cor Verde
        Canvas bodyPart = CanvasUtilsSquares.buildingSquare(Color.GREEN);
        scenario.addSnakeBodyPart(bodyPart);
        this.body.add(bodyPart); // Adiciona o bodyPart a lista (body) que terá todos
        Config.score += 3;
    }

    public void eatPineapple(Scenario scenario) {
        Canvas bodyPart = CanvasUtilsSquares.buildingSquare(Color.GREEN);
        scenario.addSnakeBodyPart(bodyPart);
        this.body.add(bodyPart);
        Config.score += 1;
    }

    // Faz a verificação da collision entre a snake e body
    // Os parametros x e y são as coordenadas da head da snake. Faço uso do for each
    // com a lista de body
    // Caso a cebeça colida com algum objeto de body, return true
    public boolean bodyCollision(Integer x, Integer y) {

        // Variavel bodyPart recebe cada elemento da lista (pilha) body
        for (Canvas bodyPart : this.body) {
            Integer bodyPositionX = (int) bodyPart.getTranslateX(); // Pegando a posição X de bodyPart
            Integer bodyPositionY = (int) bodyPart.getTranslateY(); // Pegando a posição Y de bodyPart

            // Se a posiçoes de bodyPart forem iguais a positions mandadas pelo parâmetro
            if (bodyPositionX.equals(x) && bodyPositionY.equals(y)) {
                return true;
            }
        }

        return false;
    }
}
