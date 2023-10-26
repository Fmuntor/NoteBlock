import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI implements ActionListener{

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
    // Crear objeto de Funciones_Archivo para poder acceder a sus metodos
    Funciones_Archivo archivo = new Funciones_Archivo(this);



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
        iNuevo.addActionListener(this);
        iNuevo.setActionCommand("Nuevo");
        menuArchivo.add(iNuevo);

        iAbrir = new JMenuItem("Abrir");
        iAbrir.addActionListener(this);
        iAbrir.setActionCommand("Abrir");
        menuArchivo.add(iAbrir);

        iGuardar = new JMenuItem("Guardar");
        iGuardar.addActionListener(this);
        iGuardar.setActionCommand("Guardar");
        menuArchivo.add(iGuardar);

        iGuardarComo = new JMenuItem("Guardar como");
        iGuardarComo.addActionListener(this);
        iGuardarComo.setActionCommand("Guardar como");
        menuArchivo.add(iGuardarComo);

        iSalir = new JMenuItem("Salir");
        iSalir.addActionListener(this);
        iSalir.setActionCommand("Salir");
        menuArchivo.add(iSalir);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch (command) {
            case "Nuevo": 
                archivo.nuevo();
                break;
            case "Abrir": 
                archivo.abrir();
                break;
            case "Guardar como":
                archivo.guardarComo();
                break;
            case "Guardar":
                archivo.guardar();
                break;
            case "Salir":
                archivo.salir();
                break;
            default:
                break;
        }
        
    }
}
