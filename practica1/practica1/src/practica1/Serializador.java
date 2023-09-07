package practica1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Serializador {
	public static List<Usuario> personas = new ArrayList<>();

	public static void serializar(Usuario[] array, int noRegistros, String name, String name2) {
		
		File archivo = new File("");
		
		try {
			File ruta = new File(archivo.getAbsolutePath()+"/src/baseDatos/"+name+".txt");
			
			ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream(ruta));
			
			escribiendo_fichero.writeObject(array);
			
			File ruta2 = new File(archivo.getAbsolutePath()+"/src/baseDatos/"+name2+".txt");
			
			ObjectOutputStream escribiendo_fichero2 = new ObjectOutputStream(new FileOutputStream(ruta2));
			
			escribiendo_fichero2.writeInt(noRegistros);
			
			
			escribiendo_fichero.close();
			escribiendo_fichero2.close();
		} catch (FileNotFoundException e) {
			File ruta = new File(archivo.getAbsolutePath()+"/src/baseDatos/"+name+".txt");
			System.out.print("FileNotFound"+ "  "+ ruta);
		} catch (IOException e) {
			System.out.print("IOException");
		}
		
	}
	
	public static void serializar() {
		Serializador.serializar(Registro.getRegistro(), Registro.getnoRegistro(), "registro", "noRegistros");
	}
	
	
	
	public static void leer_archivo(String name) {
		
		File archivo = new File("");
		
		try {
			File ruta = new File(archivo.getAbsolutePath()+"/src/baseDatos/"+name+".txt");
			
            FileReader fileReader = new FileReader(ruta);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                // Divide la línea en componentes utilizando la coma como separador
                String[] partes = linea.split(",");
                if (partes.length == 13) {
                    // Crea una instancia de Persona con los datos
                    long id = Long.parseLong(partes[0]);
                    String nombre = partes[1];
                    int dd = Integer.parseInt(partes[2]);
                    int mm = Integer.parseInt(partes[3]);
                    int aa = Integer.parseInt(partes[4]);
                    String ciudad_nac = partes[5];
                    String calle = partes[6];
                    int noCalle = Integer.parseInt(partes[7]);
                    String nomenclatura = partes[8];
                    String barrio = partes[9];
                    String ciudad = partes[10];
                    long tel = Long.parseLong(partes[11]);
                    String email = partes[12];
                    
                    Fecha fecha= new Fecha(dd,mm,aa);
                    Direccion direccion = new Direccion(calle,noCalle,nomenclatura,barrio,ciudad);
                    Usuario usuario= new Usuario(id,nombre,fecha,ciudad_nac,direccion,tel,email);
                    
                    // Agrega la instancia a la lista de personas
                    personas.add(usuario);
                }     
            }
            bufferedReader.close();
            for (Usuario persona:personas) {
         	   System.out.println(persona);
            }
            
            
		} catch (FileNotFoundException e) {
			System.out.print("FileNotFound");
		} catch (IOException e) {
			System.out.print("IOException");
		}
	}
	
	public static void leer_archivo() {
		Serializador.leer_archivo("datos");
        for (Usuario persona:Serializador.personas) {
        	Registro.agregar(persona);
        }
	}
	
	public static void deserializar(Usuario[] array,  int noRegistros, String name, String name2) {
		File archivo = new File("");
		
		try {
			File ruta = new File(archivo.getAbsolutePath()+"/src/baseDatos/"+name+".txt");
			
			ObjectInputStream recuperando_fichero = new ObjectInputStream(new FileInputStream(ruta));
			
			Registro.setRegistro(recuperando_fichero.readObject());
			
			File ruta2 = new File(archivo.getAbsolutePath()+"/src/baseDatos/"+name2+".txt");
			
			ObjectInputStream recuperando_fichero2 = new ObjectInputStream(new FileInputStream(ruta2));
			
			Registro.setnoRegistro(recuperando_fichero2.readInt());
			
			recuperando_fichero.close();
			recuperando_fichero2.close();
		} catch (FileNotFoundException e) {
			File ruta = new File(archivo.getAbsolutePath()+"/src/baseDatos/"+name+".txt");
			System.out.print("FileNotFound"+ "  "+ ruta);
		} catch (IOException e) {
			System.out.print("IOException");
		} catch (ClassNotFoundException e) {
			System.out.print("ClassNotFoundException");
		}
	}
	
	public static void deserializar() {
		Serializador.deserializar(Registro.getRegistro(), Registro.getnoRegistro(),"registro", "noRegistros");
	}
}