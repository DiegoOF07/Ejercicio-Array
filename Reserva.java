/**
 * @autor: Diego Oswaldo Flores Rivas
 * @version: 28/08/23b
 */

public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;

    public Reserva(Cliente cliente, Habitacion habitacion) {
        this.cliente = cliente;
        this.habitacion = habitacion;
    }

    public Reserva(){}

    
    /** 
     * @return Cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    
    /** 
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    /** 
     * @return Habitacion
     */
    public Habitacion getHabitacion() {
        return habitacion;
    }

    
    /** 
     * @param habitacion
     */
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Cliente: " + cliente + " | Habitacion: " + habitacion;
    }

    
    
}
