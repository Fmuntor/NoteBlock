import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

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
        // Se ponen a null para saber si es un archivo nuevo
        nombreArchivo = null;
        direccionArchivo = null;
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
        try {
            BufferedReader br = new BufferedReader(new FileReader(direccionArchivo + nombreArchivo)); // Hay que añadir
                                                                                                      // el nombre a la
                                                                                                      // ruta

            gui.textArea.setText("");

            String linea = null;

            // Este BufferedReader lee el texto linea a linea
            while ((linea = br.readLine()) != null) {
                gui.textArea.append(linea + "\n");
            }
            br.close();

        } catch (Exception e) {
            System.out.println("ARCHIVO NO ABIERTO");
        }
    }

    public void guardarComo() {
        FileDialog fd = new FileDialog(gui.window, "Guardar como...", FileDialog.SAVE);
        fd.setVisible(true);

        // Si no se ha seleccioado un archivo nulo, se cambian las caracteristicas de la
        // ventana
        if (fd.getFile() != null) {
            nombreArchivo = fd.getFile();
            direccionArchivo = fd.getDirectory();
            gui.window.setTitle(nombreArchivo);
        }

        try {
            FileWriter fw = new FileWriter(direccionArchivo + nombreArchivo);
            fw.write(gui.textArea.getText());
            fw.close();
        } catch (Exception e) {
            System.out.println("ERROR AL GUARDAR EL ARCHIVO");
        }
    }

    public void guardar() {
        if (nombreArchivo == null) {
            guardarComo(); // Si es un archivo nuevo, se llama a guardar como
        } else {
            try {
                FileWriter fw = new FileWriter(direccionArchivo + nombreArchivo);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(nombreArchivo);
                fw.close();
            } catch (Exception e) {
                System.out.println("No se ha podido guardar.");
            }
        }
    }

    public void salir(){
        System.exit(0);
    }
}
