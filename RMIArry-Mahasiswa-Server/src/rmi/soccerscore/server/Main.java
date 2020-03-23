package rmi.soccerscore.server;
 
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.soccerscore.server.service.SoccerScoreServiceServer;
 
//Class Main Server
public class Main{
    
    public static void main(String[] args) throws RemoteException {
        
        System.out.println("====================================================");
        System.out.println("========              SERVER              ==========");
        System.out.println("====================================================");
        
        try{
        //Port yang digunakan
        int port = 2302;
        
        //Mendaftarkan Remote Interface untuk server pada port 2302 
        Registry server = LocateRegistry.createRegistry(port);
        //Membuat Objek MahasiswaServiceServer
        SoccerScoreServiceServer userService = new SoccerScoreServiceServer();
        
//        //Mendaftarkan Obejek userService dengan nama "service" pada port RMI
        server.rebind("service", userService);
        
        //Feedback ketika Server RMI berhasil dijalankan
        System.out.println("[Server] Server sedang berjalan pada port "+port+"...\n");
        }catch(RemoteException e){
            //Feedback ketika Server RMI gagl dijalankan
            System.out.println("[Server] Server gagal dijalankan, baca keterangan lebih lanjut..\n\t "+e);
        }
    }
}