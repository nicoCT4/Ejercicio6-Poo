public class Telefono implements DispositivoElectronico{
    private String modelo;
    private Boolean encendido;

    public Telefono(String modelo, Boolean encendido) {
        this.modelo = modelo;
        this.encendido = encendido;
    }

    //Getters
    public String getModelo() {
        return modelo;
    }

    

    @Override
    public void encender() {
        if (encendido) {
            System.out.println("El teléfono ya está encendido");
        } else {
            encendido = true;
            System.out.println("El teléfono se ha encendido");
        }
    }

    @Override
    public void apagar() {
        if (encendido) {
            encendido = false;
            System.out.println("El teléfono se ha apagado");
        } else {
            System.out.println("El teléfono ya está apagado");
        }
    }

    @Override
    public boolean validarEstado() {
        return encendido;
    }

}
