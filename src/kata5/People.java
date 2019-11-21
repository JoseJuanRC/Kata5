package kata5;

class People {

    private String nombre;
    private String apellido;
    private String departamento;

    public People(String nombre, String apellido, String departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDepartamento() {
        return departamento;
    }
    
    
    
}
