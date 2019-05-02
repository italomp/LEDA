package adt.linkedList.extended;

import adt.linkedList.LinkedList;

/**
 * Interface especificando uma lista que pode ser invertida usando-se um algoritmo
 * especifico mostrado na figura/animacao.
 * 
 * OBSERVE OS COMENTARIOS E RESTRICOES ESPECIFICAS DE CADA METODO
 * 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public interface ListInversion<T extends Comparable<T>> extends LinkedList<T>{
	
	/**
	 * Metodo que inverte a lista, implementado de forma iterativa.
	 * 
	 * Restricoes:
	 * - voce NAO pode usar estrutura auxiliar, apenas variaveis simples
	 * - voce DEVE seguir o algoritmo mostrado pela figura.
	 * - voce NAO pode criar uma lista nova
	 * - voce pode criar um metodo auxiliar (se achar necessario) mas deve respeitar as restricoes
	 */
	public void reverseIterative();
	
	/**
	 * Metodo que inverte a lista, implementado de forma RECURSIVA.
	 * 
	 * Restricoes:
	 * - voce NAO pode usar estrutura auxiliar, apenas variaveis simples
	 * - voce DEVE seguir o algoritmo mostrado pela figura.
	 * - voce NAO pode criar uma lista nova
	 * - voce pode criar metodo auxiliar (se achar necessario)  mas deve respeitar as restricoes
	 */
	public void reverseRecursive();
}
