package account;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;


public class Orc {
    int linha;
    int coluna;

    public Orc(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public void mover(int[][] mapa) {
        Random rand = new Random();
        int direcao = rand.nextInt(4);
        int novaLinha = linha;
        int novaColuna = coluna;

        switch (direcao) {
            case 0 -> novaLinha--; // Cima
            case 1 -> novaLinha++; // Baixo
            case 2 -> novaColuna--; // Esquerda
            case 3 -> novaColuna++; // Direita
        }

        if (novaLinha >= 0 && novaLinha < mapa.length &&
            novaColuna >= 0 && novaColuna < mapa[0].length &&
            mapa[novaLinha][novaColuna] == V) {
            mapa[linha][coluna] = V; // Libera a posição antiga
            linha = novaLinha;
            coluna = novaColuna;
            mapa[linha][coluna] = ORC; // Atualiza a nova posição do orc
        }
    }
    
	private static final int V = 0; // vazio
	private static final int ORC = 7; // orc
}
