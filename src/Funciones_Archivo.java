import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;

public class Funciones_Archivo {

    GUI gui;
    String nombreArchivo;
    String direccionArchivo;

    public Funciones_Archivo(GUI gui) {
        this.gui = gui;
    }

    public void nuevo() {
        gui.textArea.setText("");
        gui.window.setTitle("Nuevo");
    }

    public void abrir() {
        FileDialog fd = new FileDialog(gui.window, "Abrir", FileDialog.LOAD);
        fd.setVisible(true);
        if (fd.getFile() != null) {
            // Leer el nombre y direccion del archivo seleccionado
            nombreArchivo = fd.getFile();
            direccionArchivo = fd.getDirectory();
            // Asignar a la ventana el nombre del archivo seleccionado
            gui.window.setTitle(nombreArchivo);
        }
        try{
            BufferedReader br = new BufferedReader(new FileReader(direccionArchivo + nombreArchivo)); // Hay que añadir el nombre a la ruta

            gui.textArea.setText("");

            String linea = null;

            // Este BufferedReader lee el texto linea a linea
            while((linea= br.readLine())!=null){
                gui.textArea.append(linea + "\n");
            }
            br.close();

        } catch(Exception e){
            System.out.println("ARCHIVO NO ABIERTO");
        }
    }
}
