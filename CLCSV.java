import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CLCSV{
    private BufferedReader lector;
    private String linea;
    private String partes[] = null;
    private ArrayList<DispositivoElectronico> dispositivos = new ArrayList<DispositivoElectronico>();

    public ArrayList<DispositivoElectronico> getDispositivos() {
        return dispositivos;
    }

    public void MostrarDispositivos(){
        System.out.println("Listado de Dispositivos:");
        System.out.println("");
        for(DispositivoElectronico dispositivo : dispositivos){
            if(dispositivo instanceof Telefono){
                System.out.println("Telefono: " + ((Telefono) dispositivo).getModelo());
                System.out.println("-----------------------");
            }else if(dispositivo instanceof Computadora){
                System.out.println("Computadora: " + ((Computadora) dispositivo).getMarca());
                System.out.println("-----------------------");
            }
        }
    }

    public void MostrarDispositivosEstado(){
        System.out.println("Listado de Dispositivos:");
        System.out.println("");
        for (DispositivoElectronico dispositivo : dispositivos) {
            String tipo = (dispositivo instanceof Telefono) ? "Teléfono" : "Computadora";
            String estado = dispositivo.validarEstado() ? "Encendido" : "Apagado";
            
            if (dispositivo instanceof Telefono) {
                System.out.println("Modelo: " + ((Telefono) dispositivo).getModelo());
            } else if (dispositivo instanceof Computadora) {
                System.out.println("Marca: " + ((Computadora) dispositivo).getMarca());
            }
            
            System.out.println("Tipo: " + tipo);
            System.out.println("Estado: " + estado);
            System.out.println("-----------------------");
        }
    }
    public void CargarCSV(String nombreArchivo) {
        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            boolean primeraLinea = true;  // Variable para rastrear la primera línea
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(";");
                
                // Omitir la primera línea (encabezados)
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
    
                // Asegurarse de que haya suficientes campos para representar un dispositivo electrónico
                if (partes.length >= 4) {
                    String tipo = partes[0];
                    String modelo = partes[1];
                    String marca = partes[2];
                    boolean estado = partes[3].equalsIgnoreCase("Encendido");
    
                    if (tipo.equals("Telefono")) {
                        Telefono telefono = new Telefono(modelo, estado);
                        dispositivos.add(telefono);
                    } else if (tipo.equals("Computadora")) {
                        Computadora computadora = new Computadora(marca, estado);
                        dispositivos.add(computadora);
                    }
                }
            }
            lector.close();
            linea = null;
            partes = null;
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
            System.out.println(e);
        }
    }

    public void GuardarCSV(String nombreArchivo) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribe la línea de encabezados
            escritor.write("Tipo;Modelo;Marca;Estado");
            escritor.newLine();
    
            // Escribe los datos de los dispositivos electrónicos
            for (DispositivoElectronico dispositivo : dispositivos) {
                String tipo = (dispositivo instanceof Telefono) ? "Telefono" : "Computadora";
                String modelo = "";
                String marca = "";
                
                // Verificar el tipo de dispositivo y obtener el modelo o marca correspondiente
                if (dispositivo instanceof Telefono) {
                    modelo = ((Telefono) dispositivo).getModelo();
                } else if (dispositivo instanceof Computadora) {
                    marca = ((Computadora) dispositivo).getMarca();
                }
                
                String estado = dispositivo.validarEstado() ? "Encendido" : "Apagado";
    
                String linea = tipo + ";" + modelo + ";" + marca + ";" + estado;
                escritor.write(linea);
                escritor.newLine();
            }
            System.out.println("Datos guardados en " + nombreArchivo);
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo CSV");
            System.out.println(e);
        }
    }          
    
    
}