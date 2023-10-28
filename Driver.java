/**
 * Autor: Nicolás Concuá
 * Fecha: 28/10/2023
 * Carnet: 23197
 * Universidad del Valle de Guatemala
 * Ejercicio 6- Polimorfismo via interfaces
 */
import java.util.Scanner;
/**
 *  * La clase `Driver` es la clase principal que inicia la aplicación del torneo de volleyball.
 */
public class Driver{
    /**
     * Método principal para ejecutar la aplicación.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean go = true;
        int opcion = 0;
        CLCSV csv = new CLCSV();
        csv.CargarCSV("ElectroTech.csv");

        while(go){
            PrintMenu();
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    csv.MostrarDispositivos();
                    break;
                case 2:
                    csv.MostrarDispositivosEstado();
                    break;
                case 3:
                    // Mostrar la lista de dispositivos disponibles
                    csv.MostrarDispositivosEstado();
                
                    // Pedir al usuario que ingrese la posición del dispositivo que desea encender
                    System.out.print("Ingrese la posición del dispositivo que desea encender: ");
                    int posicion = sc.nextInt();
                
                    // Validar que la posición esté dentro de los límites de la lista
                    if (posicion >= 1 && posicion <= csv.getDispositivos().size()) {
                        DispositivoElectronico dispositivo = csv.getDispositivos().get(posicion - 1);
                        dispositivo.encender();
                    } else {
                        System.out.println("Posición inválida. Por favor, seleccione una posición válida.");
                    }
                    break;              
                case 4:
                    // Mostrar la lista de dispositivos disponibles
                    csv.MostrarDispositivosEstado();
                
                    // Pedir al usuario que ingrese la posición del dispositivo que desea apagar
                    System.out.print("Ingrese la posición del dispositivo que desea apagar: ");
                    int posicion1 = sc.nextInt();
                
                    // Validar que la posición esté dentro de los límites de la lista
                    if (posicion1 >= 1 && posicion1 <= csv.getDispositivos().size()) {
                        DispositivoElectronico dispositivo = csv.getDispositivos().get(posicion1 - 1);
                        dispositivo.apagar();
                    } else {
                        System.out.println("Posición inválida. Por favor, seleccione una posición válida.");
                    }
                    break;
                case 5:
                    csv.GuardarCSV("ElectroTech.csv");
                    break;
                case 6:
                    go = false;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }

    public static void PrintMenu(){
        System.out.println("\nBienvenido a ElectroTech");
        System.out.println("1. Desplegar informacion de dispositivos");
        System.out.println("2. Desplegar los dispositivos encendidos y apagados");
        System.out.println("3. Encender dispositivo");
        System.out.println("4. Apagar dispositivo");
        System.out.println("5. Guardar cambios");
        System.out.println("6. Salir");
        System.out.println("Ingrese su opcion: ");
    }

}