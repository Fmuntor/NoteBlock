import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI {

    JFrame window;
    // Crear area de texto
    JTextArea textArea;
    // Crear scroll lateral
    JScrollPane scrollPane;

    public static void main(String[] args) throws Exception {
        new GUI();
    }

    public GUI() {
        createWindow();
        createTextArea();
        window.setVisible(true);

    }

    public void createWindow(){
        window = new JFrame("NoteBlock");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea(){
        textArea = new JTextArea();

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //Eliminar el borde al scroll
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);

        //window.add(textArea);
    }
}
