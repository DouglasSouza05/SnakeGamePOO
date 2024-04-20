package poo.food;

import poo.config.Config;

public abstract class Food {

    protected abstract void creatingFood();

    // Setando um valor aleatório para a posição X e Y de Food Método randomNumbers
    // sendo usado a partir de herança (Apple e Pineapple Classe filha de Food)
    public Integer randomNumbers(Integer min, Integer max) {
        // Fórmula para receber Números Aleatórios
        int value = (int) (Math.random() * ((max - min) + 1)) + min;

        // necessário pegar valor múltiplo de 40 para encaixar na Tela
        return value - (value % Config.squareSize);
    }

    // Método usado para pegar a coordenada X de Food
    public abstract Integer getPosicionX();

    // Método usado para pegar a coordenada Y de Food
    public abstract Integer getPosicionY();

}
