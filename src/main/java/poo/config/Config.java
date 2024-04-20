package poo.config;

//Clase criada para armazenar variaveis Static para Configuração geral do Snake Game
public class Config {

    public static final Integer width = 880; // Usando INTEGER para caso algum momento o valor seja nulo
    public static final Integer height = 640;
    public static final Integer squareSize = 40;
    public static final Integer oneQuarterWidthUp = 660; // Três quartos
    public static final Integer oneQuarterWidthDown = 220; // Um quarto
    public static final Integer oneQuarterfHeightUp = 480;
    public static final Integer oneQuarterfHeightDown = 160;
    public static Integer score = 0;
    public static Integer tries = 0; // Usado para guardar o número de Tentativas

}
