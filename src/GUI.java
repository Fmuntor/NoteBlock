import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI implements ActionListener {

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
    JMenuItem iNuevo, iAbrir, iGuardar, iGuardarComo, iSalir;// itemCortar, itemPegar
    // Crear objeto de Funciones_Archivo para poder acceder a sus metodos
    Funciones_Archivo archivo = new Funciones_Archivo(this);
    // Items pensaña Formato
    JMenuItem iWrap, iArial, iCSMS, iTNR, iSize8, iSize12, iSize16, iSize24, iSize28;
    JMenu menuFont, menuFontSize; // Al tener dentro más opciones, es un JMenu
    boolean wordWrapOn = false;
    Funciones_Formato formato = new Funciones_Formato(this);
    // Pestaña Color
    JMenuItem iColorBlanco, iColorNegro, iColorAzul;
    Funciones_Color color = new Funciones_Color(this);

    public static void main(String[] args) throws Exception {
        new GUI();
    }

    public GUI() {
        createWindow();
        createTextArea();
        createMenuBar();

        crearMenuArchivo();
        crearMenuFormato();
        crearMenuColor();

        formato.fuenteSeleccionada = "Arial"; // Seleccionar una fuente como predeterminada
        formato.crearFuente(16); // Seleccionar tamaño como predeterminado
        formato.wordWrap(); // Asignar a ON el WordWrap por defecto
        window.setVisible(true);

        color.cambiarColor("Blanco");
        window.setVisible(true);

    }

    public void createWindow() {
        window = new JFrame("NoteBlock");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {
        textArea = new JTextArea();

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Eliminar el borde al scroll
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);

        // window.add(textArea);
    }

    public void createMenuBar() {
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

    public void crearMenuArchivo() {

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

    public void crearMenuFormato() {
        iWrap = new JMenuItem("Word Wrap: OFF");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormato.add(iWrap);

        menuFont = new JMenu("Fuente");
        menuFormato.add(menuFont);

        iArial = new JMenuItem("Arial");
        iArial.addActionListener(this);
        iArial.setActionCommand("Arial");
        menuFont.add(iArial);

        iCSMS = new JMenuItem("Comic Sans MS");
        iCSMS.addActionListener(this);
        iCSMS.setActionCommand("ComicSansMS");
        menuFont.add(iCSMS);

        iTNR = new JMenuItem("Times New Roman");
        iTNR.addActionListener(this);
        iTNR.setActionCommand("TimesNewRoman");
        menuFont.add(iTNR);

        menuFontSize = new JMenu("Tamaño de letra");
        menuFormato.add(menuFontSize);

        iSize8 = new JMenuItem("8");
        iSize8.addActionListener(this);
        iSize8.setActionCommand("8pt");
        menuFontSize.add(iSize8);

        iSize12 = new JMenuItem("12");
        iSize12.addActionListener(this);
        iSize12.setActionCommand("12pt");
        menuFontSize.add(iSize12);

        iSize16 = new JMenuItem("16");
        iSize16.addActionListener(this);
        iSize16.setActionCommand("16pt");
        menuFontSize.add(iSize16);

        iSize24 = new JMenuItem("24");
        iSize24.addActionListener(this);
        iSize24.setActionCommand("24pt");
        menuFontSize.add(iSize24);

        iSize28 = new JMenuItem("28");
        iSize28.addActionListener(this);
        iSize28.setActionCommand("28pt");
        menuFontSize.add(iSize28);
    }

    public void crearMenuColor() {
        iColorBlanco = new JMenuItem("Blanco");
        iColorBlanco.addActionListener(this);
        iColorBlanco.setActionCommand("Blanco");
        menuColor.add(iColorBlanco);

        iColorNegro = new JMenuItem("Negro");
        iColorNegro.addActionListener(this);
        iColorNegro.setActionCommand("Negro");
        menuColor.add(iColorNegro);

        iColorAzul = new JMenuItem("Azul");
        iColorAzul.addActionListener(this);
        iColorAzul.setActionCommand("Azul");
        menuColor.add(iColorAzul);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch (command) {
            // Pestaña archivo
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
            // Pestaña Formato
            case "Arial":
                formato.setFuente(command);
                break;
            case "TimesNewRoman":
                formato.setFuente(command);
                break;
            case "ComicSansMS":
                formato.setFuente(command);
                break;
            case "Word Wrap":
                formato.wordWrap();
                break;
            case "8pt":
                formato.crearFuente(8);
                break;
            case "12pt":
                formato.crearFuente(12);
                break;
            case "16pt":
                formato.crearFuente(16);
                break;
            case "24pt":
                formato.crearFuente(24);
                break;
            case "28pt":
                formato.crearFuente(28);
                break;
            // Pestaña Color
            case "Blanco":
                color.cambiarColor(command);
                break;
            case "Negro":
                color.cambiarColor(command);
                break;
            case "Azul":
                color.cambiarColor(command);
                break;
            default:
                break;
        }

    }
}
