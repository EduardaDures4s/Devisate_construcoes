package com.devisate.telas;

import java.awt.Color;
import java.awt.Font;

/**
 * Paleta de cores e fontes padrão do sistema Devisate Construções,
 * seguindo a identidade visual definida no Figma (industrial: amarelo + preto).
 */
public class Tema {

    public static final Color AMARELO = new Color(0xF5, 0xB4, 0x00);
    public static final Color PRETO = new Color(0x1C, 0x1C, 0x1C);
    public static final Color CINZA_CLARO = new Color(0xF1, 0xEF, 0xE8);
    public static final Color CINZA_MEDIO = new Color(0x88, 0x87, 0x80);
    public static final Color LARANJA_ALERTA = new Color(0xFF, 0x6B, 0x00);
    public static final Color VERDE_SUCESSO = new Color(0x27, 0x50, 0x0A);
    public static final Color VERMELHO_ERRO = new Color(0x99, 0x3C, 0x1D);
    public static final Color BRANCO = Color.WHITE;

    public static final Font FONTE_TITULO = new Font("SansSerif", Font.BOLD, 22);
    public static final Font FONTE_SUBTITULO = new Font("SansSerif", Font.BOLD, 15);
    public static final Font FONTE_TEXTO = new Font("SansSerif", Font.PLAIN, 13);
    public static final Font FONTE_BOTAO = new Font("SansSerif", Font.BOLD, 13);

    private Tema() {
    }
}
