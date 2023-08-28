import java.util.Scanner;

public class Hotel {
    Scanner sc = new Scanner(System.in);
    private Cliente[] listaEspera;
    private Habitacion[] habitaciones;
    private Reserva[] reservaciones;

    public Hotel(){
        listaEspera = new Cliente[1000];
        habitaciones = new Habitacion[1000];
        reservaciones = new Reserva[2000];
    }

    public void agregarCliente(String nombre){
        boolean isDone = false;
        Cliente miCliente = new Cliente(nombre);
        validarCliente(miCliente);
        for(int i=0; i<listaEspera.length; i++){
            if(listaEspera[i]==null && !isDone){
                listaEspera[i]=miCliente;
                isDone = true;
                System.out.println(listaEspera[i].getNombre());
            }
        }
    }

    public void validarCliente(Cliente cliente){
        int contador = 1;
        for(Reserva reservacion : reservaciones){
            if(reservacion!=null){
                if (reservacion.getCliente().getNombre().equals(cliente.getNombre())){
                    contador++;
                }
            }
        }
        cliente.setCantVisitas(contador);
        if(cliente.getCantVisitas()<=4){
            cliente.setTipoCliente("Regular");
        }else if(cliente.getCantVisitas()>4 && cliente.getCantVisitas()<=9){
            cliente.setTipoCliente("Frecuente");
        }else if(cliente.getCantVisitas()>9){
            cliente.setTipoCliente("VIP");
        }
    }

    public void crearHabitaciones(int id, int capacidadMaxima, String tipo, double precioNoche){
        //validar el id que no exista dos veces
        boolean isDone = false;
        Habitacion miHabitacion = new Habitacion(id, capacidadMaxima, tipo, precioNoche);
        for(int i=0; i<habitaciones.length; i++){
            if(habitaciones[i]==null && !isDone){
                habitaciones[i]=miHabitacion;
                isDone = true;
                System.out.println(habitaciones[i].getId());
            }
        }
    }

    public boolean validarHabitacion(Habitacion habitacion){
        int contador = 0;
        for (Reserva reservacion : reservaciones) {
            if(reservacion!=null){
                if(reservacion.getHabitacion().getId()==habitacion.getId()){
                    contador++;
                }
            }
        }
        if(contador>=habitacion.getCapacidadMaxima()){
            return false;
        }else{
            return true;
        }
    }

    public void asignarReservacion(){
        System.out.println("Estos son los clientes disponibles");
        for (Cliente cliente : listaEspera) {
            if(cliente != null){
                System.out.println(cliente);
            }
        }
        System.out.print("Cliente a asignar: ");
        System.out.println("\nEstas son las habitaciones disponibles");
        for (Habitacion habitacion : habitaciones){
            if(habitacion != null){
                System.out.println(habitacion);
            }
        }
        System.out.print("Habitacion a asignar: ");

        
    }
}
