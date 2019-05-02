package adt.stack.parenthesis;

import java.util.Stack;

/**
 * @author Cláudio Campelo
 * Ver comentários na interface LongestValidParenthesisSubstring.
 *
 */
public class LongestValidParenthesisSubstringImpl implements LongestValidParenthesisSubstring {

    /* (non-Javadoc)
     * @see adt.stack.parenthesis.LongestValidParenthesisSubstring#findLongest(java.lang.String)
     */
    public String findLongest(String parenthesis) {
    	String[] entrada = new String[parenthesis.length()];
    	Stack<String> stack = new Stack<>();
    	entrada = parenthesis.split("");
    	int validador = 0;
    	String retorno = "";
    	
    	if(parenthesis.equals(null)) {
    		return null;
    	}
    	
    	if(entrada[0].equals(")")){
    		return null;
    	}
    
    	for(int i = 0; i < parenthesis.length(); i++) {
    		stack.push(entrada[i]);
    		if(entrada[i].equals("(")) {
    			validador++;
    		}
    		else if(entrada[i].equals(")")) {
    			validador--;
    		}
    	}
    	
    	validador = calculaModulo(validador);
    	for(int i = validador; i >= 0; i--){
    		stack.pop();
    	}
    	
    	for(int i = 0; i < stack.size(); i++) {
    		retorno += stack.pop();
    	}
    	
    	retorno = retornaEspelhoDaString(retorno);
    	
    	if(validador != 0) {
    		retorno = findLongest(retorno);
    	}
    	
    	return retorno;
    		
    	
    }
    
    /**
     * nao sei se pode usar biblioteca Math
     * @return modulo de um inteiro
     */
    public int calculaModulo(int x) {
    	int result = x;
    	if(x < 0) {
    		result = result * (-1);
    	}
    	return result;	
    }
    /**
     * A pilha vai retornar a String "de tras pra frente" por causa do pop ser de tras pra frente.
     * Este metodo deixa a string como se tivesse saido da pilha do comeco ao final
     * @param str
     * @return espelho de uma string.
     */
    public String retornaEspelhoDaString(String str) {
    	Stack<String> stack = new Stack<String>();
    	String mirrorStr = "";
    	String[] stringInArray = new String[str.length()];
    	stringInArray = str.split("");
    	
    	for(int i = str.length() - 1; i >= 0; i--) {
    		stack.push(stringInArray[i]);
    	}
    	
    	for(int i = 0; i < str.length(); i++) {
    		mirrorStr += stack.pop();
    	}
    	
		return mirrorStr;
    }
    
    /*
     * Este é um método utilitário que calcula o "espelho" de uma String.
     * Ou seja, é uma espécie de flip horizontal. Veja os exemplos abaixo
     * para entender como o método deve ser comportar.
     * 
     * A implementação deste método não é obrigatória, porém, é fortemente
     * recomendada, visto que pode ser muito útil para a implementação
     * do findLongest.
     * 
     * Neste método, implemente uma solução baseada em PILHA. 
     * 
     * Exemplo 1:
     * input		   = ((()
     * expected_output = ()))
     * 
     * Exemplo 2:
     * input		   = ()()
     * expected_output = ()()
     * 
     * Exemplo 2:
     * input		   = (((((
     * expected_output = )))))
     */
    private String parenthesisMirror(String str){
        
    	Stack<String> stack = new Stack<String>();
    	String mirrorStr = "";
    	
    	//digite seu código aqui
    	
		return mirrorStr;
    	

    }

}
