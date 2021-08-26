package PKG.Common;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IServidor extends Remote{
    
    public boolean depositar(int id, double monto) throws RemoteException;
    public int extraer(int id, double monto) throws RemoteException;
    public double consultarSaldo (int id) throws RemoteException;
}
