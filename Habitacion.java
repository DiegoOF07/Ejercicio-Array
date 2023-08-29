/**
 * @autor: Diego Oswaldo Flores Rivas
 * @version: 28/08/23b
 */
public class Habitacion {
    private int id;
    private int capacidadMaxima;
    private String tipo;
    private double precioNoche;

    public Habitacion(int id, int capacidadMaxima, String tipo, double precioNoche) {
        this.id = id;
        this.capacidadMaxima = capacidadMaxima;
        this.tipo = tipo;
        this.precioNoche = precioNoche;
    }

    public Habitacion(){}

    
    /** 
     * @return int
     */
    public int getId() {
        return id;
    }

    
    /** 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /** 
     * @return int
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    
    /** 
     * @param capacidadMaxima
     */
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    
    /** 
     * @return String
     */
    public String getTipo() {
        return tipo;
    }

    
    /** 
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    /** 
     * @return double
     */
    public double getPrecioNoche() {
        return precioNoche;
    }

    
    /** 
     * @param precioNoche
     */
    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Id: " + id + " | Capacidad maxima: " + capacidadMaxima + " | Tipo: " + tipo + " | Precio noche: "
                + precioNoche;
    }

    

    
}
