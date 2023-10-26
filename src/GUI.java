import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI {

    JFrame window;
    // Crear area de texto
    JTextArea textArea;
    // Crear scroll lateral
    JScrollPane scrollPane;
    // Crear barra de menu
    JMenuBar menuBar;
    // Crear items de barra de menu
    JMenu menuArchivo, menuEditar, menuFormato, menuColor;
    // Crear items de la pestaña Archivo
    JMenuItem iNuevo, iAbrir, iGuardar, iGuardarComo, iSalir;//itemCortar, itemPegar

    public static void main(String[] args) throws Exception {
        new GUI();
    }

    public GUI() {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
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

    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuArchivo = new JMenu("Archivo");
        menuBar.add(menuArchivo);

        menuEditar = new JMenu("Editar");
        menuBar.add(menuEditar);

        menuFormato = new JMenu("Formato");
        menuBar.add(menuFormato);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }

    public void createFileMenu(){

        iNuevo = new JMenuItem("Nuevo");
        menuArchivo.add(iNuevo);

        iAbrir = new JMenuItem("Abrir");
        menuArchivo.add(iAbrir);

        iGuardar = new JMenuItem("Guardar");
        menuArchivo.add(iGuardar);

        iGuardarComo = new JMenuItem("Guardar como");
        menuArchivo.add(iGuardarComo);

        iSalir = new JMenuItem("Salir");
        menuArchivo.add(iSalir);

    }
}
