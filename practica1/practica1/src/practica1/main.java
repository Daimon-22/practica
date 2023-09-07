package practica1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Serializador.deserializar();
        int tamaño = 0;
        if (Registro.getRegistro()==null) {
            System.out.println("Ingrese el tamaño del arreglo:");
            tamaño=scanner.nextInt();
            scanner.nextLine();
            Registro.setRegistro(tamaño);
            System.out.println("Creado nuevo registro");
            }
        else{
            tamaño=Registro.getRegistro().length;
        }
        if (tamaño != 0) {
            int eleccion;
            do {
                System.out.println("Elija la acción que desea realizar");
                System.out.println("1. Registrar un nuevo usuario");
                System.out.println("2. Eliminar usuario");
                System.out.println("3. Buscar en el Registro");
                System.out.println("4. Mostrar lista de registro");
                System.out.println("5. Cargar en el registro los usuarios del archivo de texto");
                
                System.out.println("Ingrese una opción");

                eleccion = scanner.nextInt();
                scanner.nextLine();

                switch (eleccion) {
                    case 1:
                        Scanner sc= new Scanner(System.in);

                        System.out.println("Por favor introduce la información del Usuario");
                        System.out.println("Ingrese el número de cédula: ");
                        long id = sc.nextLong();
                        System.out.println("Ingrese el nombre del paciente:");
                        String nombre = sc.nextLine();
                        nombre = sc.nextLine();
                        System.out.println("Igrese el dia de su nacimiento:");
                        int dd = sc.nextInt();
                        System.out.println("Igrese el mes en el que nació:");
                        int mm = sc.nextInt();
                        System.out.println("Igrese el año en el que nació:");
                        int aa = sc.nextInt();

                        System.out.println("Ingrese su ciudad natal:");
                        String ciudad_nac = sc.nextLine();
                        ciudad_nac = sc.nextLine();
                        System.out.println("Ingrese la calle en la cual reside: ");
                        String calle = sc.nextLine();
                        System.out.println("Ingrese el número de la calle:");
                        int noCalle = sc.nextInt();
                        System.out.println("Igrese la nomenclatura de la dirección:");
                        String nomenclatura = sc.nextLine();
                        nomenclatura = sc.nextLine();
                        System.out.println("Igrese el barrio de residencia:");
                        String barrio = sc.nextLine();
                        System.out.println("Ingrese su ciudad de residencia:");
                        String ciudad = sc.nextLine();

                        System.out.println("Ingrese el número de telefono: ");
                        long tel = sc.nextLong();

                        System.out.println("Ingrese su email:");
                        String email = sc.nextLine();
                        email = sc.nextLine();

                        Fecha fecha= new Fecha(dd,mm,aa);
                        Direccion direccion = new Direccion(calle,noCalle,nomenclatura,barrio,ciudad);
                        Usuario usuario= new Usuario(id,nombre,fecha,ciudad_nac,direccion,tel,email);

                        if (Registro.agregar(usuario)) {
                            System.out.println("Usuario agregado con éxito");
                            Serializador.serializar();
                        } else {
                            System.out.println("No se pudo agregar el usuario. El registro está lleno.");
                            Serializador.serializar();
                        }
                        break;
                    case 2:
                        Scanner sc1= new Scanner(System.in);

                        System.out.println("Ingrese el número de cédula del usuario que desea eliminar del registro: ");
                        long Id = sc1.nextLong();
                        Usuario usuarioEliminado=Registro.eliminar(Id);
                        if (usuarioEliminado !=null){
                            usuarioEliminado.toString();
                            System.out.println("Ha sido elimininado correctamente del registro");
                            Serializador.serializar();
                        } else {
                            System.out.println("No se encontró un usuario con el ID especificado.");
                            Serializador.serializar();
                        }
                        break;
                    case 3:
                        Scanner scanner1 = new Scanner(System.in);
                        int eleccion2;
                        do {
                            System.out.println("Elija la acción que desea realizar");
                            System.out.println("1. Buscar la posición de usuario en el registro");
                            System.out.println("2. Verificar si el usuario esta registrado");
                            System.out.println("Ingrese una opción");

                            eleccion2 = scanner1.nextInt();
                            scanner1.nextLine();

                            switch (eleccion2) {
                                case 1:
                                    Scanner sc2= new Scanner(System.in);
                                    System.out.println("Ingrese el número de cédula: ");
                                    long cedula = sc2.nextLong();
                                    int posicion= Registro.buscarPosicion(cedula);
                                    if (posicion !=-1){
                                    	posicion++;
                                        System.out.println("La posición del usuario es: "+posicion);
                                    }
                                    else {
                                        System.out.println("No se encontró un usuario con el ID especificado.");
                                    }
                                    Serializador.serializar();
                                    break;
                                case 2:
                                    Scanner sc3= new Scanner(System.in);
                                    System.out.println("Ingrese el número de cédula: ");
                                    long documento = sc3.nextLong();
                                    Usuario u = Registro.buscarUsuario(documento);
                                    if (u != null){
                                        System.out.println("Los datos del usuario encontrado son:");
                                        System.out.println(u.toString());
                                    }
                                    else {
                                        System.out.println("No se encontró un usuario con el ID especificado.");
                                    }
                                    Serializador.serializar();
                                    break;
                                default:
                                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
                                    Serializador.serializar();
                                    break;
                            }
                        } while (eleccion2 != 1 && eleccion2 != 2 );

                        break;
                    case 4:
                    	Registro.mostrar();
                    	break;
                    case 5: 
                    	Serializador.leer_archivo();
                    	break;
                    default:
                        System.out.println("Opción inválida. Por favor, intente de nuevo.");
                        break;
                }
            } while (eleccion != 1 && eleccion != 2 && eleccion != 3 && eleccion != 4 && eleccion != 5);
        }
        else {
            System.out.println("Ingrese el número distinto de 0");
            Serializador.serializar();
        }

    }
}

