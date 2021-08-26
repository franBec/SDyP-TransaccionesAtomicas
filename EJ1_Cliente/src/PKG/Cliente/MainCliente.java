package PKG.Cliente;

import GUI.FramePrincipal;
import PKG.Common.IServidor;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.Naming;

public class MainCliente {
    
    private static IServidor servidor;
    
    public static void main(String[] args) throws IOException {  
        //args[0] = ipHost      por ejemplo localhost, 192.168.0.1
        //args[1] = puerto      por ejemplo 1099
        //args[2] = carpeta     por ejemplo /RMI
        
        String host = (args.length < 1) ? null : args[0];
        if(host!=null){
            try{  
                servidor = (IServidor) Naming.lookup("//" + args[0]+ ":" + args[1] + args[2]);

                //Llamo a ventana principal
                FramePrincipal frame = new FramePrincipal();
                frame.setVisible(true);
                frame.setServidor(servidor);
            }
            catch (NotBoundException | RemoteException e) {
               System.err.println("Client exception: " + e.toString()); 
            }
        }
        
        else{
            System.out.println("No se especificó ip del host. Presione enter para finalizar");
            System.in.read();
        }
    }
}