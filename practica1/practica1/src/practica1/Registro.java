package practica1;

import java.io.Serializable;

public class Registro implements Serializable{
	private static final long serialVersionUID = 5737430106364807312L;
	private static Usuario[] registro;
    private static int noRegistros = 0;

    
    public Registro(int capacity){
        registro = new Usuario[capacity];
    }



    public static boolean agregar(Usuario u){
        if (Registro.noRegistros < registro.length && buscarUsuario(u.getId())==null) {
            registro[Registro.noRegistros] = u;
            noRegistros++;
            int numReg=registro.length;
            if (numReg > 1){
                int temp = numReg-1;
                while(temp>0 && registro[temp].getId()<registro[temp-1].getId()){
                    registro[temp] = registro[temp-1];
                    registro[temp-1] = u;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }

    public static void mostrar(){
        for (int i=0; i < registro.length+1; i++){
            System.out.println(registro[i]);
        }
    }

    public static Usuario eliminar(long id) {
        int i = 0;
        int pos = buscarPosicion(id);
        if (pos>=0) {
        	Usuario Usuario = registro[pos];
    		for (i=pos; i<Registro.noRegistros-1; i++) {
    			registro[i] = registro[i+1];
    		}
    		registro[Registro.noRegistros-1] = null;
    		Registro.noRegistros--;
            return Usuario;
    	}
    	return null;
    }
    public static int buscarPosicion(long id){
        for (int i = 0; i < Registro.noRegistros; i++) {
            if (registro[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
    public static Usuario buscarUsuario(long id){
        for (int i = 0; i < Registro.noRegistros; i++) {
            if (registro[i].getId() == id) {
                return registro[i];
            }
        }
        return null;
    }
    
    public static Usuario[] getRegistro() {
        	return Registro.registro;
    }
    
    public static void setRegistro(Object object) {
    	Registro.registro = (Usuario[]) object;
    }
    
    public static void display() {
    	for (Usuario rank:Registro.getRegistro()) {
    		System.out.println(rank);
    	}System.out.println(Registro.noRegistros);
    }
    public static int getnoRegistro() {
    	return Registro.noRegistros;
    }
	public static void setnoRegistro(int readInt) {
		Registro.noRegistros = readInt;
		
	} 


}
