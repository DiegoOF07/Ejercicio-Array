/**
 * Cliente
 */
public class Cliente {
    private String nombre;
    private int cantVisitas;
    private String tipoCliente;
    
    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public Cliente(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantVisitas() {
        return cantVisitas;
    }

    public void setCantVisitas(int cantVisitas) {
        this.cantVisitas = cantVisitas;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Cantidad de visitas: " + cantVisitas + " | Tipo de cliente: " + tipoCliente;
    }

    
    
}