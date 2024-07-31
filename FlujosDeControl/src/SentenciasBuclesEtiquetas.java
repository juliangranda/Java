public class SentenciasBuclesEtiquetas {
    public static void main(String[] args) {

        //etiqueta: nombre:
        bucle:
        for (int i = 1; i <= 7; i++) {
            int j = 1;
            while ( j <= 8) {
                if (i == 6 || i == 7) {
                    System.out.println("Dia " + i + ": descanso de fin de semana!");
                    //referencia a una etiqueta
                    continue bucle;
                }
                System.out.println("Día " + i + ", trabajando a las " + j + "hrs. ");
                j++;
            }
        }
        System.out.println("\n=================================================");

        //etiqueta bucle1:
        bucle1:
        for (int i = 0; i < 5; i++) {

            System.out.println();
            int j = 0;
            while ( j < 5) {
                if (i == 2) {
                    //referencia a la etiqueta bucle1
                    //se salta imprimir en i=2
                    continue bucle1;
                }
                System.out.print("[i = " + i + ", j = " + j + "], ");
                j++;
            }
        }
        System.out.println("\n=================================================");
        etiqueta:
        for (int i = 0; i < 5; i++) {

            System.out.println();
            for (int j = 0; j < 5; j++) {
                if (i == 2) {
                    break etiqueta;
                }
                System.out.print("[i = " + i + ", j = " + j + "], ");
            }
        }
    }
}
