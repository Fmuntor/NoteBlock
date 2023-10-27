import java.awt.Font;

public class Funciones_Formato {

    GUI gui;
    Font arial, comicSansMS, timesNewRoman;
    String fuenteSeleccionada;

    public Funciones_Formato(GUI gui) {
        this.gui = gui;
    }

    public void wordWrap() {
        // Si clicamos estando en off
        if (gui.wordWrapOn == false) {
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iWrap.setText("Word Wrap: ON");
        } else if (gui.wordWrapOn == true) {
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap: OFF");

        }

    }

    public void crearFuente(int fontSize){
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFuente(fuenteSeleccionada);
    }
    public void setFuente(String font){
        fuenteSeleccionada = font;

        switch (fuenteSeleccionada) {
            case "Arial":
                gui.textArea.setFont(arial);
                break;
            case "ComicSansMS":
                gui.textArea.setFont(comicSansMS);
                break;
            case "TimesNewRoman":
                gui.textArea.setFont(timesNewRoman);
                break;
        }

    }
}
