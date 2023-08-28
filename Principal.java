public class Principal {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.agregarCliente("Ratils");
        hotel.agregarCliente("Rateigo");
        hotel.crearHabitaciones(1, 10, "Estandar", 15.50);
        hotel.crearHabitaciones(2, 15, "Estandar", 20.5);
        hotel.asignarReservacion();
    }
}
