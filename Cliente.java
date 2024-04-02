
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente{
    public static void main(String[] args){
        int puerto = 9001;
        try{
            Socket cs = new Socket("localhost",puerto);
            PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
            BufferedReader in = new BufferedReader( new InputStreamReader(cs.getInputStream()));

            String lineaReacibida;
            while(!(lineaReacibida = in.readLine()).equalsIgnoreCase("EOF")){
                System.out.println("Servidor: " +lineaReacibida);

            }

            out.println("Recepción de datos correcta");
            out.close();
            in.close();
            cs.close();
        }catch(IOException exception){
            System.err.println(exception);
        }
    }
} 