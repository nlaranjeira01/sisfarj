package utils;

import java.security.SecureRandom;
import java.util.Locale;

public class StringAleatoria
{
    private static final String MAIUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String MINUSCULAS = MAIUSCULAS.toLowerCase(Locale.ROOT);
    private static final String DIGITOS = "0123456789";
    private static final String ALFANUMERICOS = MAIUSCULAS + MINUSCULAS + DIGITOS;
    private final SecureRandom random;
    private final char[] simbolos;
    private final char[] buffer;

	public String novaString()
    {
        for(int i = 0; i < buffer.length; i++)
        {
            buffer[i] = simbolos[random.nextInt(simbolos.length)];        	
        }
        
        return new String(buffer);
    }

    public StringAleatoria(int tamanho)
    {
        if(tamanho < 1)
        {
        	throw new IllegalArgumentException();
        }
                
        this.random = new SecureRandom();
        this.simbolos = ALFANUMERICOS.toCharArray();
        this.buffer = new char[tamanho];
    }
}