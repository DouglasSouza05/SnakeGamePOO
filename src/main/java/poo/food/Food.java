package poo.food;

import poo.config.Config;

public class Food {

    // Metodo usado para setar valores aleatórios na scene, nem menor que 0, nem
    // maior que a tela
    public Integer randomNumbers(Integer min, Integer max) {
        // Fórmula pega na internet para receber numeros aleatório
        int value = (int) (Math.random() * ((max - min) + 1)) + min;

        // necessário pegarmos um valor múltiplo de 40 para encaixar de forma correta na
        // tela
        return value - (value % Config.squareSize);
    }

}
