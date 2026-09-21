package com.devisate.telas.usuario;

import com.devisate.modelo.Usuario;
import com.devisate.telas.Tema;

import javax.swing.*;
import java.awt.*;

/**
 * Tela inicial da Área do Usuário, com acesso ao Perfil (8),
 * Solicitação de agendamento (9), Histórico de empréstimos (10)
 * e Histórico de agendamentos (11).
 *
 * Esta tela é o ponto de partida da área do usuário; as demais
 * (TelaPerfil, TelaSolicitarAgendamento, TelaHistoricoEmprestimos,
 * TelaHistoricoAgendamentos) seguem o mesmo padrão visual e serão
 * adicionadas neste mesmo pacote (com.devisate.telas.usuario).
 */
public class TelaHomeUsuario extends JFrame {

    private final Usuario usuarioLogado;

    public TelaHomeUsuario(Usuario usuarioLogado) {
        super("Devisate Construções - Área do Usuário");
        this.usuarioLogado = usuarioLogado;
        montarTela();
    }

    private void montarTela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 520);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painelTopo = new JPanel(new BorderLayout());
        painelTopo.setBackground(Tema.PRETO);
        painelTopo.setPreferredSize(new Dimension(720, 60));
        painelTopo.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        JLabel saudacao = new JLabel("Olá, " + usuarioLogado.getNome() + "...");
        saudacao.setFont(Tema.FONTE_SUBTITULO);
        saudacao.setForeground(Tema.AMARELO);
        painelTopo.add(saudacao, BorderLayout.WEST);

        add(painelTopo, BorderLayout.NORTH);

        JPanel painelCentro = new JPanel(new GridLayout(2, 2, 16, 16));
        painelCentro.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));
        painelCentro.setBackground(Tema.CINZA_CLARO);

        painelCentro.add(criarAtalho("Solicitar agendamento"));
        painelCentro.add(criarAtalho("Histórico de empréstimos"));
        painelCentro.add(criarAtalho("Histórico de agendamentos"));
        painelCentro.add(criarAtalho("Meu perfil"));

        add(painelCentro, BorderLayout.CENTER);
    }

    private JButton criarAtalho(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(Tema.FONTE_BOTAO);
        botao.setBackground(Tema.AMARELO);
        botao.setForeground(Tema.PRETO);
        botao.setFocusPainted(false);
        // TODO: adicionar ActionListener para abrir a tela correspondente
        // (TelaSolicitarAgendamento, TelaHistoricoEmprestimos, etc.)
        return botao;
    }
}
