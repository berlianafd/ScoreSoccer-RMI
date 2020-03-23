package rmi.code.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.SwingUtilities;
import rmi.code.client.view.FormClient;
import rmi.soccerscore.code.service.soccerScoreService;

//class main client
public class Main{
    public static void main(String[] args) throws RemoteException, NotBoundException {
        System.out.println("====================================================");
        System.out.println("========              Client              ==========");
        System.out.println("====================================================");
        
        try{
        //port yang digunakan
        int port = 2302;
        
        //getRegistry, Menghubungkan interface client dengan server yg telah dibuat
        Registry client = LocateRegistry.getRegistry("localhost", port);
        //membuat objek 'Remote Object' ScoreService yang ada di Program API
        soccerScoreService service = (soccerScoreService) client.lookup("service");
        
        //Menjalankan JFrame client yang telah dibuat
        SwingUtilities.invokeLater(() -> {
            FormClient formSoccer= new FormClient(service);
            formSoccer.setVisible(true);
        });
        
        //Feedback ketika client berhasil dijalnkan
        System.out.println("[Cleint] Client berhasil berjalan........");
        }catch(RemoteException e){
            //Feedback ketika client gagal dijalankan
            System.out.println("[Client] Client gagal dijalankan, baca keterangan lebih lanjut..\n\t "+e);
        }
    
    }
}
