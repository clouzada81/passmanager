package br.com.clouzada.senha.util;

import br.com.clouzada.senha.exception.GeracaoSenhaException;

import java.util.ArrayList;
import java.util.List;

public class GeradorSenha {
    private static final char[] LETRAS_MINUSCULAS = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    };

    private static final char[] LETRAS_MAIUSCULAS = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    private static final char[] NUMEROS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    private static final char[] CARACTERES_ESPECIAIS = {
            '!', '@', '#', '$', '%', '*', '^', '&'
    };

    public static String gerarSenha(int tamanhoSenha, boolean minusculas, boolean maiusculas, boolean numeros, boolean caracteresEspeciais) {
        if (tamanhoSenha < 8) {
            throw new GeracaoSenhaException("A senha deve ter mais de 8 caracteres");
        }

        if (!minusculas && !maiusculas && !numeros && !caracteresEspeciais) {
            throw new GeracaoSenhaException("Pelo menos um tipo de caracteres deve ser selecionado para gerar a senha");
        }

        List<Character> caracteresList = new ArrayList<Character>();
        if (minusculas) {
            for (char c: LETRAS_MINUSCULAS) {
                caracteresList.add(Character.valueOf(c));
            }
        }

        if (maiusculas) {
            for (char c: LETRAS_MAIUSCULAS) {
                caracteresList.add(Character.valueOf(c));
            }
        }

        if (numeros) {
            for (char c: NUMEROS) {
                caracteresList.add(Character.valueOf(c));
            }
        }

        if (caracteresEspeciais) {
            for (char c: CARACTERES_ESPECIAIS) {
                caracteresList.add(Character.valueOf(c));
            }
        }

        StringBuffer sbRetorno = new StringBuffer("");
        for (int i = 0; i < tamanhoSenha; i++) {
            int index = (int) Math.round(Math.random() * (caracteresList.size() - 1));
            sbRetorno.append(caracteresList.get(index));
        }

        return sbRetorno.toString();
    }
}
