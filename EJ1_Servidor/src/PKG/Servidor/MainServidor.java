package PKG.Servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.io.IOException;
import PKG.Common.IServidor;
import PKG.Common.Utils;

public class MainServidor {
   public static void main(String[] args) throws Exception {
        //args[0] = puerto                          se recomienda 1099 
        //args[1] = carpeta (cualquier /String)     por ejemplo /RMI
        
        int puerto = 1099; //Se inicializa por defecto en 1099. Es sobreescrito por args[0]
        
        if(args.length!=0)
           puerto = Integer.parseInt(args[0]);
       
        try{
            Utils.setCodeBase(IServidor.class);
            Servidor servidor = new Servidor();
            Registry registry = LocateRegistry.createRegistry(puerto);
            java.rmi.Naming.rebind("rmi://" + java.net.InetAddress.getLocalHost().getHostAddress() +":" + args[0] + args[1], servidor);
            System.out.println("Servidor en marcha en el puerto "+args[0]+" en la carpeta "+args[1]);
            System.out.println("Presione ENTER para detener el servidor");
            System.in.read();
            UnicastRemoteObject.unexportObject(servidor, true);
            System.out.println("Servidor Detenido");
            
        }catch (IOException e){
            System.out.println("Excepcion de servidor: "+ e.toString());
        }
    }
}
