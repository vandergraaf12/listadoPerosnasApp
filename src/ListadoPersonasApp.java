import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        // Definimos la lista fuera del ciclo while
        List<Persona> personas = new ArrayList<>();
        // Empezamos con el menu
        var salir = false;
        while(!salir){
            mostrarMenu();
            try{
                salir = ejecutarOperacion(consola, personas);
            }catch (Exception e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void mostrarMenu(){
        System.out.print("""
                **** Listado personas App ****
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Proporciona la opción? ");
    }

    private static Boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        // Revisamos la opción proporcionada
        switch (opcion){
            case 1 -> {// Agregar persona a la lista
                System.out.print("Proporciona el nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Proporciona el telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Proporciona el email: ");
                var email = consola.nextLine();
                // Crear el objeto Persona
                var persona = new Persona(nombre, telefono, email);
                // Lo agregamos a la lista
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " elementos");
            }// Fin caso 1
            case 2 -> {
                System.out.println("Listado de personas: ");
                // Listado usando lambda
                //personas.forEach((persona) -> System.out.println(persona));*/
                // Listado por metodo de referencia
                personas.forEach(System.out::println);
            }
            case 3 -> { //Salimos de ciclo
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("Opción erronea: " + opcion);
        }// Fin Switch
        return salir;
    }
}