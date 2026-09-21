package com.devisate.telas.publica;

import com.devisate.dao.UsuarioDAO;
import com.devisate.modelo.Usuario;
import com.devisate.telas.Tema;
import com.devisate.telas.admin.TelaDashboardAdmin;
import com.devisate.telas.usuario.TelaHomeUsuario;

import javax.swing.*;
import java.awt.*;

/**
 * Tela 5 - Login (RF01).
 * Ao autenticar com sucesso, direciona para a Área Administrativa
 * ou para a Área do Usuário, dependendo do perfil (RF03).
 */
public class TelaLogin extends JFrame {

    private JTextField campoEmail;
    private JPasswordField campoSenha;

    public TelaLogin() {
        super("Devisate Construções - Login");
        montarTela();
    }

    private void montarTela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 480);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        // Cabeçalho amarelo com o nome da empresa
        JPanel painelTopo = new JPanel();
        painelTopo.setBackground(Tema.AMARELO);
        painelTopo.setPreferredSize(new Dimension(420, 140));
        JLabel titulo = new JLabel("Devisate Construções");
        titulo.setFont(Tema.FONTE_TITULO);
        titulo.setForeground(Tema.PRETO);
        painelTopo.add(titulo);
        add(painelTopo, BorderLayout.NORTH);

        // Formulário central
        JPanel painelForm = new JPanel();
        painelForm.setBackground(Tema.BRANCO);
        painelForm.setLayout(new BoxLayout(painelForm, BoxLayout.Y_AXIS));
        painelForm.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel labelEmail = new JLabel("E-mail");
        labelEmail.setFont(Tema.FONTE_TEXTO);
        labelEmail.setAlignmentX(Component.LEFT_ALIGNMENT);

        campoEmail = new JTextField();
        campoEmail.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        campoEmail.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel labelSenha = new JLabel("Senha");
        labelSenha.setFont(Tema.FONTE_TEXTO);
        labelSenha.setAlignmentX(Component.LEFT_ALIGNMENT);

        campoSenha = new JPasswordField();
        campoSenha.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        campoSenha.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton botaoLogin = new JButton("Login");
        botaoLogin.setFont(Tema.FONTE_BOTAO);
        botaoLogin.setBackground(Tema.AMARELO);
        botaoLogin.setForeground(Tema.PRETO);
        botaoLogin.setFocusPainted(false);
        botaoLogin.setAlignmentX(Component.LEFT_ALIGNMENT);
        botaoLogin.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));
        botaoLogin.addActionListener(e -> autenticar());

        JLabel labelEsqueceu = new JLabel("Esqueceu a senha?");
        labelEsqueceu.setFont(Tema.FONTE_TEXTO);
        labelEsqueceu.setForeground(Tema.CINZA_MEDIO);
        labelEsqueceu.setAlignmentX(Component.LEFT_ALIGNMENT);

        painelForm.add(labelEmail);
        painelForm.add(Box.createRigidArea(new Dimension(0, 4)));
        painelForm.add(campoEmail);
        painelForm.add(Box.createRigidArea(new Dimension(0, 16)));
        painelForm.add(labelSenha);
        painelForm.add(Box.createRigidArea(new Dimension(0, 4)));
        painelForm.add(campoSenha);
        painelForm.add(Box.createRigidArea(new Dimension(0, 6)));
        painelForm.add(labelEsqueceu);
        painelForm.add(Box.createRigidArea(new Dimension(0, 20)));
        painelForm.add(botaoLogin);

        add(painelForm, BorderLayout.CENTER);
    }

    private void autenticar() {
        String email = campoEmail.getText().trim();
        String senha = new String(campoSenha.getPassword());

        if (email.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Preencha e-mail e senha.",
                    "Campos obrigatórios",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.autenticar(email, senha);

        if (usuario == null) {
            JOptionPane.showMessageDialog(this,
                    "E-mail ou senha inválidos.",
                    "Erro no login",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        dispose();

        if (usuario.isAdmin()) {
            new TelaDashboardAdmin(usuario).setVisible(true);
        } else {
            new TelaHomeUsuario(usuario).setVisible(true);
        }
    }
}
