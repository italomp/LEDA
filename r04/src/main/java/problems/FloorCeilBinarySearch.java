package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: - Algoritmo in-place (nao pode usar memoria extra a nao ser
 * variaveis locais) - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Italo Modesto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {
   @Override
   public Integer floor(Integer[] array, Integer x) {
      Integer CandidatoFloor = array[array.length / 2];
      return auxFloor(array, 0, array.length - 1, x, CandidatoFloor);
   }

   /**
    * Ideia do algoritmo:
    * 
    * Se cara do meio eh igual x, retorno ele
    * 
    * Se cara do meio eh menor que x, guardo ele, pois ele pode ser o menor mais proximo.
    * E aplico o metodo recursivamente na metade da direita
    * 
    * Se cara do meio eh maior, simplesmente aplico o metodo novamente na metadade da esqueda
    */
   public Integer auxFloor(Integer[] array, int leftIndex, int rightIndex, Integer x, Integer candidatoFloor) {
      Integer floor = candidatoFloor;
      if (leftIndex > rightIndex) {
         if (!floor.equals(null) && floor < x) {
            return floor;
         }
         return null;
      }

      int mid = (leftIndex + rightIndex) / 2;
      if (x == array[mid]) {
         return array[mid];
      } else if (x > array[mid]) {
         floor = array[mid];
         return auxFloor(array, mid + 1, rightIndex, x, floor);
      } else {
         return auxFloor(array, leftIndex, mid - 1, x, floor);
      }

   }

   @Override
   public Integer ceil(Integer[] array, Integer x) {
      Integer CandidatoCeil = array[array.length / 2];
      return auxCeil(array, 0, array.length - 1, x, CandidatoCeil);
   }

   /**
    * Ideia do algoritmo:
    * 
    * Se cara do meio eh igual x, retorno ele
    * 
    * se cara do meio eh maior que x, guardo ele, pois ele pode ser o maior mais proximo.
    * E aplico o metodo recursivamente na metade da esquerda
    * 
    * Se cara do meio eh menor, simplesmente aplico o metodo novamente na metadade da direita
    */
   public Integer auxCeil(Integer[] array, int leftIndex, int rightIndex, Integer x, Integer candidatoCeil) {
      Integer ceil = candidatoCeil;
      if (leftIndex > rightIndex) {
         if (!ceil.equals(null) && ceil > x) {
            return ceil;
         }
         return null;
      }

      int mid = (leftIndex + rightIndex) / 2;
      if (x == array[mid]) {
         return array[mid];
      } else if (x < array[mid]) {
         ceil = array[mid];
         return auxCeil(array, leftIndex, mid - 1, x, ceil);
      } else {
         return auxCeil(array, mid + 1, rightIndex, x, ceil);
      }
   }
   
	public static void main(String[] args) {
		FloorCeilBinarySearch floorAndCeil = new FloorCeilBinarySearch();
		Integer[] a1 = {10,20,30,40,50,60,70,80,90};
		
		System.out.println(floorAndCeil.floor(a1, 10));
		System.out.println(floorAndCeil.floor(a1, 90));
		System.out.println(floorAndCeil.floor(a1, 60));
		System.out.println(floorAndCeil.floor(a1, 55));
		System.out.println();
		System.out.println(floorAndCeil.ceil(a1, 10));
		System.out.println(floorAndCeil.ceil(a1, 90));
		System.out.println(floorAndCeil.ceil(a1, 60));
		System.out.println(floorAndCeil.ceil(a1, 55));
	}
}
