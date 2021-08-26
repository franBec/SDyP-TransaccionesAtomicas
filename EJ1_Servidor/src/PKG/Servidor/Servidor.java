package PKG.Servidor;

import PKG.Common.IServidor;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Servidor extends java.rmi.server.UnicastRemoteObject implements IServidor{
    
    private ArrayList<Double> cuentas = new ArrayList<>();
    
    public Servidor() throws RemoteException {
        super();
        cuentas.add(2000.0);
        cuentas.add(2500.0);
        cuentas.add(1500.0);
        cuentas.add(3000.0);
        cuentas.add(1750.0);
    }

    @Override
    public boolean depositar(int id, double monto) throws RemoteException {
        if(id<=cuentas.size() && id>0){
            cuentas.set(id-1, cuentas.get(id-1) + monto);
            return true;
        }
        return false;
    }

    @Override
    public int extraer(int id, double monto) throws RemoteException {
        if(id<=cuentas.size() && id>0){
            if(cuentas.get(id-1)<monto){
                return 0;
            }
            cuentas.set(id-1, cuentas.get(id-1) - monto);
            return 1;
        }        
        return -1;
    }

    @Override
    public double consultarSaldo(int id) throws RemoteException {
        if(id<=cuentas.size() && id>0){
            return cuentas.get(id-1);
        }
        return -1; //Valor de Error
    }
}
