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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    @Override
    public String toString() {
        return "Id: " + id + " | Capacidad maxima: " + capacidadMaxima + " | Tipo: " + tipo + " | Precio noche: "
                + precioNoche;
    }

    

    
}
