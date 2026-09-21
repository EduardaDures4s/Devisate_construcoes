package com.devisate.telas.admin;

import com.devisate.modelo.Usuario;
import com.devisate.telas.Tema;

import javax.swing.*;
import java.awt.*;

/**
 * Tela 12 - Dashboard com indicadores (RF21, RF22).
public class TelaDashboardAdmin extends JFrame {

    private final Usuario usuarioLogado;

    public TelaDashboardAdmin(Usuario usuarioLogado) {
        super("Devisate Construções - Painel Administrativo");
        this.usuarioLogado = usuarioLogado;
        montarTela();
    }

    private void montarTela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painelTopo = new JPanel(new BorderLayout());
        painelTopo.setBackground(Tema.PRETO);
        painelTopo.setPreferredSize(new Dimension(900, 60));
        painelTopo.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        JLabel titulo = new JLabel("Dashboard");
        titulo.setFont(Tema.FONTE_SUBTITULO);
        titulo.setForeground(Tema.AMARELO);
        painelTopo.add(titulo, BorderLayout.WEST);

        JLabel usuarioLabel = new JLabel(usuarioLogado.getNome() + " (admin)");
        usuarioLabel.setForeground(Tema.BRANCO);
        painelTopo.add(usuarioLabel, BorderLayout.EAST);

        add(painelTopo, BorderLayout.NORTH);

        // TODO: substituir pelos indicadores reais (RF21, RF22), consultando
        // EquipamentoDAO e EmprestimoDAO para contagens por status e ranking.
        JPanel painelIndicadores = new JPanel(new GridLayout(1, 3, 16, 16));
        painelIndicadores.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));
        painelIndicadores.setBackground(Tema.CINZA_CLARO);

        painelIndicadores.add(criarCardIndicador("Disponíveis", "--"));
        painelIndicadores.add(criarCardIndicador("Alugados", "--"));
        painelIndicadores.add(criarCardIndicador("Em manutenção", "--"));

        add(painelIndicadores, BorderLayout.CENTER);
    }

    private JPanel criarCardIndicador(String label, String valor) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Tema.BRANCO);
        card.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        JLabel valorLabel = new JLabel(valor);
        valorLabel.setFont(Tema.FONTE_TITULO);
        valorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel textoLabel = new JLabel(label);
        textoLabel.setFont(Tema.FONTE_TEXTO);
        textoLabel.setForeground(Tema.CINZA_MEDIO);
        textoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(valorLabel);
        card.add(textoLabel);
        return card;
    }
}
