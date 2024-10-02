package account;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Item {
    private String nome;
    private Image imagem;

    /**
     * Construtor da classe Item.
     * 
     * @param nome Nome do item.
     * @param caminhoImagem Caminho para o arquivo de imagem.
     */
    public Item(String nome, String caminhoImagem) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        if (caminhoImagem == null || caminhoImagem.isEmpty()) {
            throw new IllegalArgumentException("Caminho da imagem não pode ser nulo ou vazio.");
        }
        this.nome = nome;
        carregarImagem(caminhoImagem);
    }

    /**
     * Carrega a imagem a partir do caminho especificado.
     * 
     * @param caminhoImagem Caminho para o arquivo de imagem.
     */
    private void carregarImagem(String caminhoImagem) {
        try {
            // Usa getClass().getResource() para carregar a imagem do caminho fornecido
            this.imagem = new ImageIcon(getClass().getResource(caminhoImagem)).getImage();
        } catch (Exception e) {
            System.out.println("Erro ao carregar a imagem: " + caminhoImagem);
            e.printStackTrace();
        }
    }

    public String getNome() {
        return nome;
    }

    public Image getImagem() {
        return imagem;
    }
}
