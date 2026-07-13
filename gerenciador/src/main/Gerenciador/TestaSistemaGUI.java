package Gerenciador;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TestaSistemaGUI extends JFrame {

    private GerenciadorDeConsoles gerenciador;

    public TestaSistemaGUI() {
        gerenciador = new GerenciadorDeConsoles();
        try {
            gerenciador.recuperarDados();
        } catch (IOException e) {}

        setTitle("Gerenciador de Consoles");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBackground(new Color(240, 240, 240));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel painelSuperior = criarPainelSuperior();
        painel.add(painelSuperior, BorderLayout.NORTH);

        JPanel painelCentral = criarPainelBotoes();
        painel.add(painelCentral, BorderLayout.CENTER);

        JPanel painelInferior = criarPainelInferior();
        painel.add(painelInferior, BorderLayout.SOUTH);

        add(painel);
    }

    private JPanel criarPainelSuperior() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        painel.setBackground(new Color(240, 240, 240));

        try {
            ImageIcon icone = new ImageIcon("imgs/console.png");
            Image img = icone.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            JLabel lblImagem = new JLabel(new ImageIcon(img));
            painel.add(lblImagem);
        } catch (Exception e) {
            JLabel lblImagem = new JLabel("");
            lblImagem.setFont(new Font("Arial", Font.PLAIN, 50));
            painel.add(lblImagem);
        }

        JLabel lblTitulo = new JLabel("Gerenciador de Consoles");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(33, 33, 33));
        painel.add(lblTitulo);

        return painel;
    }

    private JPanel criarPainelBotoes() {
        JPanel painel = new JPanel(new GridLayout(3, 1, 10, 15));
        painel.setBackground(new Color(240, 240, 240));

        JButton cadastrarButton = criarBotao("Cadastrar Console", new Color(76, 175, 80));
        cadastrarButton.addActionListener(e -> cadastrarConsole());

        JButton pesquisarButton = criarBotao("Pesquisar Console", new Color(33, 150, 243));
        pesquisarButton.addActionListener(e -> pesquisarConsole());

        JButton removerButton = criarBotao("Remover Console", new Color(244, 67, 54));
        removerButton.addActionListener(e -> removerConsole());

        painel.add(cadastrarButton);
        painel.add(pesquisarButton);
        painel.add(removerButton);

        return painel;
    }

    private JButton criarBotao(String texto, Color cor) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setForeground(Color.WHITE);
        botao.setBackground(cor);
        botao.setOpaque(true);
        botao.setBorderPainted(false);
        botao.setFocusPainted(false);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botao.setPreferredSize(new Dimension(250, 50));

        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botao.setBackground(cor.brighter());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                botao.setBackground(cor);
            }
        });

        return botao;
    }

    private JPanel criarPainelInferior() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painel.setBackground(new Color(240, 240, 240));

        JLabel lblInfo = new JLabel("Organize seus consoles de forma fácil e intuitiva");
        lblInfo.setFont(new Font("Arial", Font.ITALIC, 11));
        lblInfo.setForeground(new Color(100, 100, 100));
        painel.add(lblInfo);

        return painel;
    }

    private void cadastrarConsole() {
        String marca = JOptionPane.showInputDialog(this, "Digite a marca do console:");
        String modelo = JOptionPane.showInputDialog(this, "Digite o modelo do console:");
        int geracao = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite a geração do console:"));
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o ID do console:"));
        gerenciador.cadastrarConsole(marca, modelo, geracao, id);
        salvarDados();
        JOptionPane.showMessageDialog(this, "Console cadastrado com sucesso!");
    }

    private void pesquisarConsole() {
        String modelo = JOptionPane.showInputDialog(this, "Digite o modelo do console para pesquisar:");
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o ID do console para pesquisar:"));
        var consolesAchados = gerenciador.pesquisarConsole(modelo, id);
        if (consolesAchados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum console encontrado.");
        } else {
            StringBuilder resultado = new StringBuilder("Consoles encontrados:\n");
            for (var console : consolesAchados) {
                resultado.append(console.getMarca()).append(" - ").append(console.getModelo()).append("\n");
            }
            JOptionPane.showMessageDialog(this, resultado.toString());
        }
    }

    private void removerConsole() {
        String modelo = JOptionPane.showInputDialog(this, "Digite o modelo do console para remover:");
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o ID do console para remover:"));
        try {
            gerenciador.removerConsole(modelo, id);
            salvarDados();
            JOptionPane.showMessageDialog(this, "Console removido com sucesso!");
        } catch (ConsoleInexistenteException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salvarDados() {
        try {
            gerenciador.salvarDados();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Não foi possível salvar os dados: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TestaSistemaGUI tela = new TestaSistemaGUI();
            tela.setVisible(true);
        });
    }
}