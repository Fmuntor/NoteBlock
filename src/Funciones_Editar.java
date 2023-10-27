public class Funciones_Editar {
    GUI gui;

    public Funciones_Editar(GUI gui){
        this.gui = gui;
    }

    public void undo(){
        gui.undoManager.undo();
    }

    public void redo(){
        gui.undoManager.redo();
    }
    
}
