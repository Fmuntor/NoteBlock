import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener, ChangeListener {

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
    JMenuItem iNuevo, iAbrir, iGuardar, iGuardarComo, iSalir;
    // Crear objeto de Funciones_Archivo para poder acceder a sus metodos
    Funciones_Archivo archivo = new Funciones_Archivo(this);
    // Items pensaña Formato
    JMenuItem iWrap, iArial, iCSMS, iTNR, iSize8, iSize12, iSize16, iSize24, iSize28;
    JMenu menuFont, menuFontSize; // Al tener dentro más opciones, es un JMenu
    boolean wordWrapOn = false;
    Funciones_Formato formato = new Funciones_Formato(this);
    // Pestaña Color
    /*JMenuItem iColorBlanco, iColorNegro, iColorAzul;
    Funciones_Color color = new Funciones_Color(this);
    */
    JColorChooser cc1, cc2;
    JMenu menuColorTXT, menuColorFondo;
    JPanel elegirColorTXT, elegirColorFondo;
    // Pestaña Editar
    JMenuItem iUndo, iRedo;
    UndoManager undoManager = new UndoManager();
    Funciones_Editar editar = new Funciones_Editar(this);

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
        crearMenuEditar();

        formato.fuenteSeleccionada = "Arial"; // Seleccionar una fuente como predeterminada
        formato.crearFuente(16); // Seleccionar tamaño como predeterminado
        formato.wordWrap(); // Asignar a ON el WordWrap por defecto
        window.setVisible(true);

        /*color.cambiarColor("Blanco");*/
        textArea.setBackground(Color.white);
        textArea.setForeground(Color.black);
        window.setVisible(true);
        
        

    }

    public void createWindow() {
        window = new JFrame("NoteBlock");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {
        textArea = new JTextArea();
        textArea.getDocument().addUndoableEditListener(
            new UndoableEditListener() {
                public void undoableEditHappened(UndoableEditEvent e){
                    undoManager.addEdit(e.getEdit());
                }
            }
        );

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

    public void crearMenuEditar(){
        iUndo = new JMenuItem("Deshacer");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEditar.add(iUndo);

        iRedo = new JMenuItem("Rehacer");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEditar.add(iRedo);
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
        /*
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
        */

        menuColorTXT = new JMenu("Color del texto");
        menuColor.add(menuColorTXT);

        elegirColorTXT = new JPanel();
        elegirColorTXT.setBounds(100,50,600,300);
        elegirColorTXT.setBackground(Color.black);
        menuColorTXT.add(elegirColorTXT);

        cc1 = new JColorChooser();
        cc1.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Color nuevoColor = cc1.getColor();
                textArea.setForeground(nuevoColor);
            }
        });
        //cc.setPreviewPanel(new JPanel());// Para que no salga la ventana preview
        //cc.removeChooserPanel(cc.getChooserPanels()[]); // Seleccionar que pestañas eliminar 0-4
        elegirColorTXT.add(cc1);

        menuColorFondo = new JMenu("Color del fondo");
        menuColor.add(menuColorFondo);

        elegirColorFondo = new JPanel();
        elegirColorFondo.setBounds(100,50,600,300);
        elegirColorFondo.setBackground(Color.black);
        menuColorFondo.add(elegirColorFondo);

        cc2 = new JColorChooser();
        cc2.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Color nuevoFondo = cc2.getColor();
                textArea.setBackground(nuevoFondo);
            }
        });
        //cc.setPreviewPanel(new JPanel());// Para que no salga la ventana preview
        //cc.removeChooserPanel(cc.getChooserPanels()[]); // Seleccionar que pestañas eliminar 0-4
        elegirColorFondo.add(cc2);
        
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
                undoManager.setLimit(0);
                archivo.abrir();
                undoManager.setLimit(100);
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
            /*case "Blanco":
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
            */
            // Pestaña Editar
            case "Undo":
                try {
                    editar.undo();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(window, "ERROR: No puedes echar patrás.", "¡¡¡HA PETAO!!!",JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Redo":
                try {
                    editar.redo();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(window, "ERROR: No puedes echar palante.", "¡¡¡HA PETAO!!!",JOptionPane.ERROR_MESSAGE);
                }
                break;
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        
    }

    
}
