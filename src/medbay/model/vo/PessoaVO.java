package medbay.model.vo;

import java.util.InputMismatchException;

import medbay.model.util.CPF;

public abstract class PessoaVO {
	private int id;
	private String nome;
	private int idade;
	private CPF cpf;
	private String genero;
	
	public int getId() {
		    return this.id;
	}

	public boolean setId(int id) {
		if(id < 0x00) return false;
		this.id = id;
		return true;
	}
	
	public String getNome() {
		return new String(this.nome);
	}
	
	public boolean setNome(String nome) {
		if(nome == null || nome.isEmpty()) return false;
		this.nome = new String(nome.toUpperCase());
		return true;
	}
	
	public int getIdade() {			
		return this.idade;
	}
	
	public boolean setIdade(int idade) {
		if(idade < 0) return false; // Provavelmente uma futura excepcion para idades menores que 0
		this.idade = idade;
		return true;
	}
	
	public String getCpf() {
		return new String(this.cpf);
	}
	
	public boolean setCpf(String cpf) {
		if(CPF.itsValid(cpf) == true) {
			this.cpf = new CPF(cpf);
            return true;
		}
        return false;
	}

	public boolean setCPF(CPF cpf) {
		return this.setCPF(cpf.get());
	}
	
	public String getGenero() {
		return this.genero;
	}
	
	public boolean setGenero(String genero) {
		genero = genero.toUpperCase();
		if(genero.equals("M") || genero.equals("F") || genero.equals("O")){
			this.genero = genero;
			return true;
		}
		return false;
	}
	
	/*
	Está no pacote medbay.mode.util
	public static boolean isCPF(String CPF) // M�todo para validar CPF, (https://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097)
	{	
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }
	*/
}
