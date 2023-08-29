import java.util.Scanner;

/**
 * @autor: Diego Oswaldo Flores Rivas
 * @version: 28/08/23b
 */

public class Principal {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();
        boolean continuar = true;
        while(continuar){
            System.out.println("\nGESTION DE RESERVACIONES\n");
            System.out.println("1. Agregar clientes");
            System.out.println("2. Agregar habitaciones");
            System.out.println("3. Realizar una reservacion");
            System.out.println("4. Ver clientes ingresados");
            System.out.println("5. Ver todas las habitaciones");
            System.out.println("6. Ver reservaciones");
            System.out.println("7. Salir");
            String op = sc.nextLine();
            switch(op){
                case "1":
                    System.out.println("Ingresa el nombre del cliente");
                    String nombre = sc.nextLine();
                    hotel.agregarCliente(nombre);
                    break;

                case "2":
                    System.out.println("Ingresa el ID de la habitacion");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingresa la capacidad maxima de la habitacion");
                    int capacidad = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingresa el tipo de habitacion");
                    String tipo = sc.nextLine();
                    System.out.println("Ingresa el precio por noche de la habitacion");
                    double precio = sc.nextDouble();
                    sc.nextLine();
                    hotel.crearHabitaciones(id, capacidad, tipo, precio);
                    break;

                case "3":
                    System.out.println("\nReservacion de habitaciones\n");
                    hotel.asignarReservacion();
                    break;

                case "4":
                    System.out.println("\nTodos los clientes\n");
                    hotel.mostrarListaEspera();
                    break;

                case "5":
                    System.out.println("\nTodas las habitaciones\n");
                    hotel.mostrarHabitaciones();
                    break;
                
                case "6":
                    System.out.println("\nTodas las reservaciones hechas\n");
                    hotel.mostrarReservaciones();
                    break;
                case "7":
                    continuar = false;
                    break;
                default:
                    System.out.println("La opcion ingresada no es valida");

            }
        }
        sc.close();
    }
}
