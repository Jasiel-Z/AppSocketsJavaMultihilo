package ServidorMultihilo;

import java.io.IOException;
import java.net.ServerSocket;

public class ServidorMultihilo{
    public static void main(String[] args ){
        int puerto = 9001;
        int cont = 0;
        try (ServerSocket ss = new ServerSocket(puerto)){
            System.out.println("Servidor escuchando en el puerto: " + puerto + "...");
            System.out.println("El servidor tiene " + cont + " clientes conectados");
            while(true){
                HiloHandler cliente = new HiloHandler(ss.accept(), cont + 1);
                Thread h1 = new Thread(cliente);
                h1.start();
                cont++;
            }
        }catch(IOException ex) {
            System.err.println(ex);
        }



        
    }
}