/**
 * @autor: Diego Oswaldo Flores Rivas
 * @version: 28/08/23b
 */
public class Cliente {
    private String nombre;
    private int cantVisitas;
    private String tipoCliente;
    
    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public Cliente(){}

    
    /** 
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /** 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /** 
     * @return int
     */
    public int getCantVisitas() {
        return cantVisitas;
    }

    
    /** 
     * @param cantVisitas
     */
    public void setCantVisitas(int cantVisitas) {
        this.cantVisitas = cantVisitas;
    }

    
    /** 
     * @return String
     */
    public String getTipoCliente() {
        return tipoCliente;
    }

    
    /** 
     * @param tipoCliente
     */
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Cantidad de visitas: " + cantVisitas + " | Tipo de cliente: " + tipoCliente;
    }

    
    
}