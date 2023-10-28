public class Computadora implements DispositivoElectronico {
    private String marca;
    private Boolean encendido;

    public Computadora(String marca, Boolean encendido) {
        this.marca = marca;
        this.encendido = encendido;
    }

    //Getters
    public String getMarca() {
        return marca;
    }

    @Override
    public void encender() {
        if (!encendido) {
            System.out.println("La computadora ya está encendida");
        } else {
            encendido = true;
            System.out.println("La computadora se ha encendido");
        }
    }
    
    @Override
    public void apagar(){
        if(encendido){
            encendido = false;
            System.out.println("La computadora se ha apagado");
        }else{
            System.out.println("La computadora ya está apagada");
        }
    }

    @Override
    public boolean validarEstado() {
        return encendido;
    }
}
