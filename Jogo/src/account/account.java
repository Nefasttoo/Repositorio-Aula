package account;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public abstract class account<OrcMovement> extends JPanel implements ActionListener {

	private static final int[][] mapa1 = {
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
			{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
			{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1},
			{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
			{ 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1},
			{ 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1},
			{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1},
			{ 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
			{ 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1},
			{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
			{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1},
			{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1},
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
			{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 6, 1, 1},
			{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1},
			{ 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1},
			{ 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
			{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 9, 0, 1},
			{ 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
			{ 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1},
			{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 2},
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1} 
			};
	
			

	private static final int TILE_SIZE = 30; // Tamanho de cada célula no labirinto
	private static final int V = 0; // vazio
	private static final int P = 1; // parede
	private static final int S = 2; // próximo andar
	private static final int C = 6; // porta
	private static final int COMIDA = 3; // comida
	private static final int BAU = 4; // baú
	private static final int KEY = 8; // chave
	private static final int ORC = 7; // orc
	private static final int DG = 9; // dragão
	private static List<Item> inventario = new ArrayList<>();
	private static final int MAX_ORCS = 7; // Número máximo de orcs a serem colocados
	private static int orcsColocados = 0; // Contador de orcs já colocados
	private static List<Orc> orcs = new ArrayList<>();
	private static Timer orcTimer;


	private static int pontos = 0;
	private static int linha = 1;
	private static int coluna = 1;
	private static int andarAtual = 1;
	private static int vida = 100; // Vida inicial do jogador

    private static Image[] personagemImagens = new Image[4]; // 0: Cima, 1: Baixo, 2: Esquerda, 3: Direita
    private Image[] movimento;
    private static int quadroAtual = 0;
    private Timer timer;

    private static int[][] mapaAtual = mapa1;

    // Array para armazenar todos os mapas
    private static final int[][][] mapas = { mapa1 };

    // Inicializa o andar atual e o mapa atual
    private static int andarAtual1 = 0; // Começa no andar 1 (índice 0)

    // Variáveis do jogador
    private static int linha1 = 1, coluna1 = 1;

    // Visibilidade
    private static boolean[][] visibilidade = new boolean[mapaAtual.length][mapaAtual[0].length];

    // Imagens
    private static Image comidaImagem;
    private static Image bauImagem;
    private static Image keybronze;
    private static Image orcImagem;
    private static Image dgImagem;

    private static Image carregarImagem(String caminho) {
        try {
            return new ImageIcon(caminho).getImage();
        } catch (Exception e) {
            System.out.println("Erro ao carregar imagem: " + caminho + " - " + e.getMessage());
            return null; // Retorna null em caso de erro
        }
    }

    private static void inicializarImagens() {
        // Carregar outras imagens
        comidaImagem = carregarImagem("imagem/meat.jpg");
        bauImagem = carregarImagem("imagem/chest.png");
        keybronze = carregarImagem("imagem/keybronze.png");
        orcImagem = carregarImagem("imagem/orc1.png");
        dgImagem = carregarImagem("imagem/dragao.png");

	    // Carregar imagens do personagem
	    personagemImagens[0] = carregarImagem("imagem/player1.png"); // Cima
	    personagemImagens[1] = carregarImagem("imagem/player2.png"); // Baixo
	    personagemImagens[2] = carregarImagem("imagem/player3.png"); // Esquerda
	    personagemImagens[3] = carregarImagem("imagem/player4.png"); // Direita

	    // Carregar imagens do orc (considerando que você tenha várias poses ou estados)
	    //orcImagens[0] = carregarImagem("imagem/orc1.png"); // Exemplo de pose inicial
	    //orcImagens[1] = carregarImagem("imagem/orc2.png"); // Outras poses ou estados
	    //orcImagens[2] = carregarImagem("imagem/orc3.png");
	    //orcImagens[3] = carregarImagem("imagem/orc4.png");

	}
	
	
	// Método principal
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			TelaMenu telaMenu = new TelaMenu();
			telaMenu.setVisible(true);
		});
	}

	// Tela de Menu
	static class TelaMenu extends JFrame {
		TelaMenu() {
			setTitle("Menu");
			setSize(400, 300);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);

			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			JLabel label = new JLabel("Bem-vindo ao Jogo!", SwingConstants.CENTER);
			label.setFont(new Font("Arial", Font.BOLD, 24));
			panel.add(label, BorderLayout.CENTER);

			JButton novoJogoButton = new JButton("Novo Jogo");
			novoJogoButton.addActionListener(e -> iniciarJogo());
			panel.add(novoJogoButton, BorderLayout.SOUTH);

			add(panel);
		}

		public void iniciarJogo() {
			
			colocaOrc(); // Adiciona orcs no mapa atual
			colocaDg(); // adiciona dg no mapa atual
			inicializarImagens(); // Carregar imagens
			
			// Mostrar um diálogo com a história do jogo
			String historia = "Em uma noite nebulosa, o mago Arion despertou em um labirinto perdido,\n"
			                + "suas paredes de pedra cobertas por musgo e sombras dançantes.\n"
			                + "O último vislumbre que tinha era de uma caneca de cerveja gelada\n"
			                + "em uma taberna movimentada, risadas e histórias ressoando ao seu redor.\n"
			                + "Agora, sem memória de como chegou ali, ele se viu cercado por corredores sinuosos\n"
			                + "e armadilhas traiçoeiras. Com seu bastão em mãos e a determinação ardendo em seu coração,\n"
			                + "Arion sabia que para escapar, precisaria desvendar os mistérios deste lugar enigmático.\n"
			                + "Clique em OK para começar sua jornada!";

		    
			
		    // Exibe o diálogo com a história
		    JOptionPane.showMessageDialog(null, historia, "Início da História", JOptionPane.INFORMATION_MESSAGE);
			
			// Criação do JFrame para exibir o labirinto
			JFrame frame = new JFrame("Labirinto");
			frame.setSize(TILE_SIZE * mapaAtual[0].length, TILE_SIZE * mapaAtual.length);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Painel para desenhar o labirinto
			JPanel painel = new JPanel() {

				@Override
				protected void paintComponent(Graphics g) {
				    super.paintComponent(g);

				    int escalaPersonagem = 2; // Fator de escala para o jogador
				    int escalaOrc = 1; // Fator de escala para o orc (sem escala adicional)
				    int escalaDg = 2;

				 // Desenhar o jogador
				    if (personagemImagens[quadroAtual] != null) {
				        g.drawImage(personagemImagens[quadroAtual], coluna * TILE_SIZE, linha * TILE_SIZE, TILE_SIZE * escalaPersonagem, TILE_SIZE * escalaPersonagem, this);
				    } else {
				        System.out.println("Erro: Imagem do personagem não carregada.");
				    }

				    // Desenhar o mapa e itens
				    for (int l = 0; l < mapaAtual.length; l++) {
				        for (int c = 0; c < mapaAtual[l].length; c++) {
				            // Verifica a visibilidade
				            if (visibilidade[l][c]) {
				                switch (mapaAtual[l][c]) {
				                    case V -> g.setColor(Color.WHITE);
				                    case P -> g.setColor(Color.BLACK);
				                    case S -> g.setColor(Color.BLUE);
				                    case KEY -> g.drawImage(keybronze, c * TILE_SIZE, l * TILE_SIZE, TILE_SIZE, TILE_SIZE, this);
				                    case COMIDA -> g.drawImage(comidaImagem, c * TILE_SIZE, l * TILE_SIZE, TILE_SIZE, TILE_SIZE, this);
				                    case BAU -> g.drawImage(bauImagem, c * TILE_SIZE, l * TILE_SIZE, TILE_SIZE, TILE_SIZE, this);
				                    case ORC -> g.drawImage(orcImagem, c * TILE_SIZE, l * TILE_SIZE, TILE_SIZE, TILE_SIZE, this);
				                    case DG -> g.drawImage(orcImagem, c * TILE_SIZE, l * TILE_SIZE, TILE_SIZE, TILE_SIZE, this);
				                    
				                    default -> {
				                        System.out.println("Aviso: valor inesperado no mapa: " + mapaAtual[l][c]);
				                        g.setColor(Color.RED);
				                        g.fillRect(c * TILE_SIZE, l * TILE_SIZE, TILE_SIZE, TILE_SIZE);
				                    }
				                }

				             // Desenha o fundo do mapa, exceto para comida, baú, chave e orc
				                if (mapaAtual[l][c] != COMIDA && mapaAtual[l][c] != BAU && mapaAtual[l][c] != KEY && mapaAtual[l][c] != ORC && mapaAtual[l][c] != DG) {
				                    g.fillRect(c * TILE_SIZE, l * TILE_SIZE, TILE_SIZE, TILE_SIZE);
				                }


							}
						}
					}

					// Desenha o jogador (substituir o retângulo por uma imagem)
					if (personagemImagens[quadroAtual] != null) {
						g.drawImage(personagemImagens[quadroAtual], coluna * TILE_SIZE, linha * TILE_SIZE, TILE_SIZE,
								TILE_SIZE, this);
					} else {
						System.out.println("Erro: Imagem do personagem não carregada.");
					}
					
					
									
				}
				
			};
			
			
			// Carregar a imagem do coração
			ImageIcon coracaoIcon = new ImageIcon("imagem/coracao.png"); // Substitua pelo caminho correto da imagem

			// Criação da barra de status
			JPanel barraStatus = new JPanel();
			barraStatus.setLayout(new FlowLayout()); // Layout para a barra de status

			// Adicionar componentes à barra de status (ex: pontuação e vida)
			JLabel pontosLabel = new JLabel("Pontos: " + pontos);

			// Criar um JLabel para a vida com a imagem do coração
			JLabel vidaLabel = new JLabel("Vida: " + vida);
			vidaLabel.setIcon(coracaoIcon); // Adiciona a imagem do coração ao lado do texto
			vidaLabel.setHorizontalTextPosition(JLabel.RIGHT); // Texto à direita da imagem
			vidaLabel.setVerticalTextPosition(JLabel.CENTER); // Texto centralizado verticalmente

			barraStatus.add(pontosLabel);
			barraStatus.add(vidaLabel);
		    
		    // Adiciona controle via teclado
		    frame.addKeyListener(new KeyAdapter() {
		        @Override
		        public void keyPressed(KeyEvent e) {
		            // Lógica de movimento...
		            // Atualizar os labels de pontuação e vida
		            pontosLabel.setText("Pontos: " + pontos);
		            vidaLabel.setText("Vida: " + vida);
		        }
		    });

		    
		    //criacao de bordas do jogo
		    frame.add(painel, BorderLayout.CENTER); // Adiciona o painel do labirinto na parte central
		    frame.add(barraStatus, BorderLayout.SOUTH); // Adiciona a barra de status na parte inferior
		    frame.setVisible(true);
		    atualizaVisibilidade();
		    
		    		
			// Adiciona controle via teclado
			frame.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int novaLinha = linha;
					int novaColuna = coluna;
					switch (e.getKeyCode()) {
					case KeyEvent.VK_UP -> {
						novaLinha--;
						quadroAtual = 0;
					} // Cima
					case KeyEvent.VK_DOWN -> {
						novaLinha++;
						quadroAtual = 1;
					} // Baixo
					case KeyEvent.VK_LEFT -> {
						novaColuna--;
						quadroAtual = 2;
					} // Esquerda
					case KeyEvent.VK_RIGHT -> {
						novaColuna++;
						quadroAtual = 3;
					} // Direita
					}
					if (novaLinha < 0 || novaLinha >= mapaAtual.length || novaColuna < 0
							|| novaColuna >= mapaAtual[0].length) {
						System.out.println("Movimento fora dos limites: (" + novaLinha + ", " + novaColuna + ")");
						return;
					}

					if (mapaAtual[novaLinha][novaColuna] != P) {
						linha = novaLinha;
						coluna = novaColuna;

						// Chamar o método para coletar comida após o movimento
						coletarComida();
						coletarKey();
						colocaOrc();
						colocaDg();

						if (mapaAtual[linha][coluna] == BAU) {
							JOptionPane.showMessageDialog(frame,
									"Você encontrou um baú! Para abrir, resolva o enigma!");

							JOptionPane.showMessageDialog(frame,
									"Tenho o que muitos procuram, guardado com grande zelo. Para abrir-me, é preciso mais do que força, mas a palavra certa, dita na hora certa. O que sou eu!");
							// Apresenta as opções para o usuário
							String[] opcoes = { "1. Uma fechadura encantada.", "2. Um cofre de dragão.",
									"3. Um bau de tesouro.", "4. Uma caverna secreta." };

							String escolha = (String) JOptionPane.showInputDialog(frame,
									"Escolha o tipo de enigma para abrir o baú:", "Escolha do Enigma",
									JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

							// Verifica a escolha do usuário e responde de acordo
							if (escolha != null) {
								switch (escolha.charAt(0)) {
								case '1' -> JOptionPane.showMessageDialog(frame, "Resposta errada.");
								case '2' -> JOptionPane.showMessageDialog(frame, "Resposta errada.");
								case '3' -> JOptionPane.showMessageDialog(frame, "Parabéns! Você abriu o baú.");
								case '4' -> JOptionPane.showMessageDialog(frame, "Resposta errada.");
								default -> JOptionPane.showMessageDialog(frame, "Escolha inválida.");
								}

								mapaAtual[linha][coluna] = V; // Remover o baú do mapa após coletá-lo
								pontos += 500; // Adiciona os pontos após o baú ser coletado
							}
						}

						verificaProximoAndar();
						atualizaVisibilidade();
						frame.repaint();
					}
				}
			});

			frame.add(painel);
			frame.setVisible(true);
			atualizaVisibilidade();
			
			// Iniciar timer para movimento aleatório dos orcs
            orcTimer = new Timer(900, e -> moveOrc(painel));
            orcTimer.start();
		}
		
		//mover orc
		private void moveOrc(JPanel painel) {
		    for (Orc orc : orcs) {
		        orc.mover(mapaAtual);
		    }
		    repaint(); // Atualiza a tela
		}
		
		
		private static void colocaOrc() {
		    if (orcsColocados >= MAX_ORCS) {
		        System.out.println("Todos os orcs já foram colocados.");
		        return; // Não coloca mais orcs
		    }
		    
		    System.out.println("Iniciando a colocação de Orcs...");
		    Random random = new Random();

		    while (orcsColocados < MAX_ORCS) {
		        int l = random.nextInt(mapaAtual.length);
		        int c = random.nextInt(mapaAtual[0].length);

		        // Verifique se a posição é vazia e não é a posição do jogador
		        if (mapaAtual[l][c] == V && !(l == linha && c == coluna)) {
		            Orc novoOrc = new Orc(l, c); // Cria um novo orc na posição aleatória
		            orcs.add(novoOrc); // Adiciona o orc à lista
		            mapaAtual[l][c] = ORC; // Marca a posição no mapa
		            orcsColocados++;
		            System.out.println("Orc colocado na posição: (" + l + ", " + c + ")");
		        } else {
		            System.err.println("Tentativa de colocar Orc em posição inválida: (" + l + ", " + c + ")");
		        }
		    }
		    System.out.println("Colocação de Orcs concluída. Total de Orcs colocados: " + orcsColocados);
		}

		
		// metodo para imprimar mapa
		private static void imprimirMapa(int[][] mapa) {
			for (int i = 0; i < mapa.length; i++) {
				for (int j = 0; j < mapa[i].length; j++) {
					System.out.print(mapa[i][j] + " ");
				}
				System.out.println();
			}
		}

		// colocar comida no mapa e manipular
		private static void coletarComida() {
			try {
				// Verificar se a posição atual contém comida
				if (mapaAtual[linha][coluna] == COMIDA) {
					vida += 10; // Aumenta a saúde em 10 pontos
					if (vida > 200)
						vida = 200; // Garantir que a saúde não exceda o máximo
					mapaAtual[linha][coluna] = V; // Remove o item de comida do mapa

					System.out.println("Você coletou comida e ganhou 10 de saúde. Saúde atual: " + vida);
				} else {
					System.out.println("Não há comida na posição (" + linha + ", " + coluna + ").");
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.err
						.println("Erro: Tentativa de acessar uma posição fora dos limites do mapa. " + e.getMessage());
			} catch (Exception e) {
				System.err.println("Erro inesperado ao coletar comida: " + e.getMessage());
			}
		}
		
		

		// Colocar key no mapa e manipular
		private static void coletarKey() {
			try {
				// Verificar se a posição atual contém a chave
				if (mapaAtual[linha][coluna] == KEY) {
					mapaAtual[linha][coluna] = V; // Remove a chave do mapa

					System.out.println("Você coletou a chave!");
				} else {
					System.out.println("Não há chave na posição (" + linha + ", " + coluna + ").");
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.err
						.println("Erro: Tentativa de acessar uma posição fora dos limites do mapa. " + e.getMessage());
			} catch (Exception e) {
				System.err.println("Erro inesperado ao coletar chave: " + e.getMessage());
			}
		}
		
		
		private static void colocaDg() {
		    int posicaoDragaoLinha = 4; // Defina a linha fixa
		    int posicaoDragaoColuna = 4; // Defina a coluna fixa

		    // Verifique se a posição é vazia e não é a posição do jogador
		    if (mapaAtual[posicaoDragaoLinha][posicaoDragaoColuna] == V) {
		        mapaAtual[posicaoDragaoLinha][posicaoDragaoColuna] = DG; // Marca a posição no mapa
		        System.out.println("Dragão colocado na posição: (" + posicaoDragaoLinha + ", " + posicaoDragaoColuna + ")");
		    } else {
		        System.err.println("Tentativa de colocar Dragão em posição inválida: (" + posicaoDragaoLinha + ", " + posicaoDragaoColuna + ")");
		    }
		}


				

		// meotodo para ir mostrando o mapa
		private static void atualizaVisibilidade() {
		    System.out.println("Atualizando visibilidade ao redor do jogador...");
		    int alcance = 2; // Quantidade de células visíveis ao redor do jogador
		    for (int l = Math.max(0, linha - alcance); l <= Math.min(mapaAtual.length - 1, linha + alcance); l++) {
		        for (int c = Math.max(0, coluna - alcance); c <= Math.min(mapaAtual[0].length - 1, coluna + alcance); c++) {
		            visibilidade[l][c] = true;
		        }
		    }
		    System.out.println("Visibilidade atualizada.");
		}

		// mudar de andar
		private static void mudaAndar() {
			System.out.println("Mudando para o próximo andar...");
			andarAtual = (andarAtual + 1) % mapas.length; // Alterna para o próximo andar
			mapaAtual = mapas[andarAtual];

			linha = 1;
			coluna = 1;
			colocaOrc();
			visibilidade = new boolean[mapaAtual.length][mapaAtual[0].length]; // Resetar visibilidade no novo andar
			atualizaVisibilidade();
			System.out.println("Andar alterado para: " + andarAtual);
		}

		// proximi andar
		private static void verificaProximoAndar() {
			if (mapaAtual[linha][coluna] == S) {
				System.out.println("Verificando se é necessário mudar de andar...");
				mudaAndar();
			}
		}
	}
}