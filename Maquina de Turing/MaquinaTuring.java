package MaquinaDeTuring;
//Arthur Silva Souza e Renato Luiz de Almeida

public class MaquinaTuring {
		public static void main(String[] args) {
			System.out.println("Linguagem: L = {a^n b^n a^n b^n : n>=0}");
			System.out.println("aaaabbbbaaaabbbb -> "+maquina("aaaabbbbaaaabbbb"));
			System.out.println("abab -> "+maquina("abab"));
			System.out.println("aaabbaaabbb -> "+maquina("aaabbaaabbb"));
			System.out.println("aabaaabbb -> "+maquina("aabaaabbb"));
			System.out.println("aabbaabb -> "+maquina("aabbaabb"));
		}

		public static String maquina(String palavra) {
			String estado = "q0";
			int i=0;
			int cont = 0;
			
			palavra += " ";
			char[] palavraVetor = palavra.toCharArray();
			while(i<palavra.length()) {
				if(estado.equals("q0")) {
					if(palavraVetor[i] == 'a') {
						palavraVetor[i] = 'u';
						i++;
						estado = "q1";
					}
					else {
						if(palavraVetor[i] == 'v') {
							i++;
							estado = "q5";
						}
					}
				}
				else {
					if(estado.equals("q1")) {
						if(palavraVetor[i] == 'v'||palavraVetor[i] == 'a') {
							i++;
						}
						else {
							if(palavraVetor[i] == 'b') {
								palavraVetor[i] = 'v';
								i++;
								estado = "q2";
							}
						}
					}
					else {
						if(estado.equals("q2")) {
							if(palavraVetor[i] == 'x'||palavraVetor[i] == 'b') {
								i++;
							}
							else {
								if(palavraVetor[i] == 'a') {
									palavraVetor[i] = 'x';
									i++;
									estado = "q3";
								}
							}
						}
						else {
							if(estado.equals("q3")) {
								if(palavraVetor[i] == 'z'||palavraVetor[i] == 'a') {
									i++;
								}
								else {
									if(palavraVetor[i] == 'b') {
										palavraVetor[i] = 'z';
										i--;
										estado = "q4";
									}
								}
								}
							else {
								if(estado.equals("q4")) {
									if(palavraVetor[i] == 'v'||palavraVetor[i] == 'x'||palavraVetor[i] == 'z'||palavraVetor[i] == 'b'||palavraVetor[i] == 'a') {
										i--;
									}
									else {
										if(palavraVetor[i] == 'u') {
											i++;
											estado = "q0";
										}
									}
								}
								else {
									if(estado.equals("q5")) {
										if(palavraVetor[i] == 'v'||palavraVetor[i] == 'x'||palavraVetor[i] == 'z') {
											i++;
											if(palavraVetor[i] =='z'&&palavraVetor[i+1] == ' ') {
												estado = "q6";
												break;
											}
									}
										if(i>=palavra.length()) {
											break;
										}
								}
							}
						}
					}
				}
					cont++;
					if(cont>500) {
						break;
					}
				}
			}
			if(estado.equals("q6")) {
				return("Palavra aceita");
			}
			else {
				return("Palavra não aceita");
			}
		}
	}
