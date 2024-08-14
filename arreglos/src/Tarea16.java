public class Tarea16 {
    public static void main(String[] args) {

        int[] numeros = {1, 2, 3, 3, 4, 5, 5, 5, 6, 7};
        int[] ocurrencias = new int[numeros.length];
        int cantidad = 0;
        int indice = 0;
        int max = 0;

        for (int i = 0; i < numeros.length; i++){
            cantidad = 0;
            for (int j = 0; j < numeros.length; j++) {
                if(numeros[i]==numeros[j]){
                    cantidad++;
                }
            }
            ocurrencias[i]= cantidad;
        }

        for (int i = 0; i < numeros.length; i++){
            if(ocurrencias[i] > max ){
                max = ocurrencias[i];
                indice = i;
            }
        }
        System.out.println("La mayor ocurrencia es: " + max);
        System.out.println("El elemento que mas se repite es: " + numeros[indice]);
        System.out.println("el elemento " + numeros[indice] + " esta repetido " + max + "veces!");
    }
}
