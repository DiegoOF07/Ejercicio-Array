import java.util.Scanner;
/**
 * @autor: Diego Oswaldo Flores Rivas
 * @version: 28/08/23b
 */

public class Hotel {
    Scanner sc = new Scanner(System.in);
    private Cliente[] listaEspera;
    private Habitacion[] habitaciones;
    private Reserva[] reservaciones;

    public Hotel(){
        listaEspera = new Cliente[1000];
        habitaciones = new Habitacion[1000];
        reservaciones = new Reserva[2000];
        habitacionesPorDefecto();
    }

    public void habitacionesPorDefecto(){
        habitaciones[0]= new Habitacion(1, 2, "Estandar", 15.5);
        habitaciones[1]= new Habitacion(2, 3, "Deluxe", 20.5);
        habitaciones[2]= new Habitacion(3, 2, "Suite", 40.5);
    }

    /** 
     * @param nombre
     */
    public void agregarCliente(String nombre){
        boolean isDone = false;
        Cliente miCliente = new Cliente(nombre);
        validarCliente(miCliente);
        for(int i=0; i<listaEspera.length; i++){
            if(listaEspera[i]==null && !isDone){
                listaEspera[i]=miCliente;
                isDone = true;
                System.out.println("Cliente agregado correctamente");
            }
        }
    }

    
    /** 
     * @param cliente
     */
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

    
    /** 
     * @param id
     * @param capacidadMaxima
     * @param tipo
     * @param precioNoche
     */
    public void crearHabitaciones(int id, int capacidadMaxima, String tipo, double precioNoche){
        if(buscarHabitacion(id) == null){
            boolean isDone = false;
            Habitacion miHabitacion = new Habitacion(id, capacidadMaxima, tipo, precioNoche);
            for(int i=0; i<habitaciones.length; i++){
                if(habitaciones[i]==null && !isDone){
                    habitaciones[i]=miHabitacion;
                    isDone = true;
                    System.out.println("Habitacion creada con exito");
                }
            }
        }else{
            System.out.println("Ya existe una habitacion con ese Id");
        }
    }

    
    /** 
     * @param habitacion
     * @return boolean
     */
    public boolean validarHabitacion(Habitacion habitacion){
        int contador = 0;
        if(habitacion != null){
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
        }else{
            return false;
        }
    }

    public void asignarReservacion(){
        boolean isDone = false;
        System.out.println("Estos son los clientes disponibles");
        for (Cliente cliente : listaEspera) {
            if(cliente != null){
                System.out.println(cliente);
            }
        }
        System.out.print("Cliente a asignar: ");
        String nombreCliente = sc.nextLine();
        mostrarHabitacionesPorTipo(buscarCliente(nombreCliente).getTipoCliente());
        System.out.print("Habitacion a asignar: ");
        int idHabitacion = sc.nextInt();
        sc.nextLine();
        if(validarHabitacion(buscarHabitacion(idHabitacion))){
            switch(buscarCliente(nombreCliente).getTipoCliente()){
                case "Regular":
                    if(buscarHabitacion(idHabitacion).getTipo().equals("Estandar")){
                        Reserva miReserva = new Reserva(buscarCliente(nombreCliente), buscarHabitacion(idHabitacion));
                        for(int i=0; i<reservaciones.length; i++){
                            if(reservaciones[i]==null && !isDone){
                                reservaciones[i]=miReserva;
                                validarCliente(buscarCliente(nombreCliente));
                                isDone = true;
                                System.out.println(reservaciones[i]);
                            }
                        }
                        System.out.println("Reservacion completada con exito");
                    }else{
                        System.out.println("No puedes reservar esa habitacion");
                    }  
                    break;
                case "Frecuente":
                    if(buscarHabitacion(idHabitacion).getTipo().equals("Estandar") || buscarHabitacion(idHabitacion).getTipo().equals("Deluxe") ){
                        Reserva miReserva = new Reserva(buscarCliente(nombreCliente), buscarHabitacion(idHabitacion));
                        for(int i=0; i<reservaciones.length; i++){
                            if(reservaciones[i]==null && !isDone){
                                reservaciones[i]=miReserva;
                                validarCliente(buscarCliente(nombreCliente));
                                isDone = true;
                                System.out.println(reservaciones[i]);
                            }
                        }
                        System.out.println("Reservacion completada con exito");
                    }else{
                        System.out.println("No puedes reservar esa habitacion");
                    } 
                    break;
                case "VIP":
                    Reserva miReserva = new Reserva(buscarCliente(nombreCliente), buscarHabitacion(idHabitacion));
                    for(int i=0; i<reservaciones.length; i++){
                        if(reservaciones[i]==null && !isDone){
                            reservaciones[i]=miReserva;
                            validarCliente(buscarCliente(nombreCliente));
                            isDone = true;
                            System.out.println(reservaciones[i]);
                        }
                    }
                    System.out.println("Reservacion completada con exito");
            }
        }else{
            System.out.println("La habitacion que ha ingresado no puede ser reservada ya que no existe o se encuentra llena");
        }

        
    }

    
    /** 
     * @param id
     * @return Habitacion
     */
    public Habitacion buscarHabitacion(int id){
        Habitacion miHabitacion = null;
        for (Habitacion habitacion : habitaciones) {
            if(habitacion!=null){
                if(habitacion.getId()==id){
                    miHabitacion=habitacion;
                }
            }
        }
        return miHabitacion;
    }

    
    /** 
     * @param nombre
     * @return Cliente
     */
    public Cliente buscarCliente(String nombre){
        Cliente miCliente = null;
        for (Cliente cliente : listaEspera) {
            if(cliente!=null){
                if(cliente.getNombre().equals(nombre)){
                    miCliente = cliente;
                }
            }
        }
        return miCliente;
    }

    
    /** 
     * @param tipoCliente
     */
    public void mostrarHabitacionesPorTipo(String tipoCliente){
        System.out.println("\nEstas son las habitaciones disponibles");
        switch(tipoCliente){
            case "Regular":
                for (Habitacion habitacion : habitaciones){
                    if(habitacion != null && habitacion.getTipo().equals("Estandar")){
                        System.out.println(habitacion);
                    }
                }
                break;
            case "Frecuente":
                for (Habitacion habitacion : habitaciones){
                    if(habitacion != null && (habitacion.getTipo().equals("Estandar") || (habitacion.getTipo().equals("Deluxe")))){
                        System.out.println(habitacion);
                    }
                }
                break;
            case "VIP":
                for (Habitacion habitacion : habitaciones){
                    if(habitacion != null){
                        System.out.println(habitacion);
                    }
                }
                break;   
        }
    }

    public void mostrarListaEspera(){
        for (Cliente cliente : listaEspera) {
            if(cliente!=null){
                System.out.println(cliente);
            }
        }
    }

    public void mostrarHabitaciones(){
        for (Habitacion habitacion : habitaciones) {
            if(habitacion!=null){
                System.out.println(habitacion);
            }
        }
    }

    public void mostrarReservaciones(){
        for (Reserva reservacion : reservaciones) {
            if(reservacion!=null){
                System.out.println(reservacion);
            }
        }
    }
}
