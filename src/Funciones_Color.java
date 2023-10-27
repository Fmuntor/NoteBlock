import java.awt.Color;

public class Funciones_Color {

    GUI gui;

    public Funciones_Color(GUI gui) {
        this.gui = gui;
    }

    public void cambiarColor(String color) {
        switch (color) {
            case "Blanco":
                // gui.window.getContentPane().setBackground(Color.red);
                gui.textArea.setBackground(Color.white);
                gui.textArea.setForeground(Color.black);
                break;
            case "Negro":
                gui.textArea.setBackground(Color.black);
                gui.textArea.setForeground(Color.white);
                break;
            case "Azul":
                gui.textArea.setBackground(Color.blue);
                gui.textArea.setForeground(Color.white);
                break;
            default:
                break;
        }
    }
}
