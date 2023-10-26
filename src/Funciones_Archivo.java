import java.awt.FileDialog;

public class Funciones_Archivo {
    
    GUI gui;

    public Funciones_Archivo(GUI gui){
        this.gui = gui;
    }
    public void nuevo(){
        gui.textArea.setText("");
        gui.window.setTitle("Nuevo");
    }
    public void abrir(){
        FileDialog fd = new FileDialog(gui.window, "Abrir", FileDialog.LOAD);
        fd.setVisible(true);
    }
}
