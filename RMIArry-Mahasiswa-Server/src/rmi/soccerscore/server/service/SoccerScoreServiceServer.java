package rmi.soccerscore.server.service;

//Import package yang diperlukan
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rmi.soccerscore.code.entity.soccerScore;
import rmi.soccerscore.server.utilities.DatabaseUtilities;
import rmi.soccerscore.code.service.soccerScoreService;

// Kelas Server Service berisi pengimplementasian method-method yang ada pada 
// pada Package API, Method inilah yang akan memproses permintaan dari client
public class SoccerScoreServiceServer extends UnicastRemoteObject implements soccerScoreService {
   
    public SoccerScoreServiceServer() throws RemoteException {
    }
   
    //Method INSERT untuk penambahan data kedalam database
    @Override
    public soccerScore insertScore(soccerScore score) throws RemoteException {
        System.out.println("[Server] Client memanggil fungsi insert");
        
        //Membuat variable statement yang akan diisi dengan perintah query
        PreparedStatement statement = null;
        
        try {
            //Membuat query Insert ke DB 
            statement = DatabaseUtilities.getConnection().prepareStatement( 
                    "INSERT INTO `soccerscore` VALUES (?,?,?,?,?,?,?,?,?)"); 
            
            //mengisi symbol '?' pada query dengan data yang diambil dari interface remote object / API
            statement.setString(1, score.getTeamName());           
            statement.setString(2, Integer.toString(score.getP()));
            statement.setString(3, Integer.toString(score.getW()));
            statement.setString(4, Integer.toString(score.getD()));
            statement.setString(5, Integer.toString(score.getL()));
            statement.setString(6, Integer.toString(score.getF()));
            statement.setString(7, Integer.toString(score.getA()));
            statement.setString(8, Integer.toString(score.getGD()));
            statement.setString(9, Integer.toString(score.getPTS()));
            
            //menjalankan perintah query diatas
            statement.executeUpdate();
            
            //Feedback ketika query berhasil dijalankan
            System.out.println("\t "+statement+"\n\t Permintaan berhasil diproses.\n"); //feedback untuk server
            score.setStatusOps("Data Berhasil Ditambahkan");  //feedback untuk client
            
            return score;   //mengembalikan nilai yang dimasukkan ke variable mahasiswa
                                //dalam konteks ini adalah variable 'setLaporan' untuk feedback ke client.
        } catch (SQLException e) {
            
            //Feedback ketika query gagal dijalankan
            System.out.println("\t Permintaan gagal diproses.\n");
            score.setStatusOps("Data Gagal Ditambahkan");
            e.printStackTrace();
            return score;
            
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {        
                }
            }
        }
    }
        
    //Method UPDATE untuk mengedit data pada Db
    @Override
    public soccerScore updateScore(soccerScore score) throws RemoteException {
        System.out.println("[Server] Client memanggil fungsi update");
        
        //Membuat variable statement yang akan diisi dengan perintah query
        PreparedStatement statement = null;
        
        try {
            //membuat query UPDATE
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "UPDATE soccerscore SET P=?, W=?, D=?, L=?, F=?, A=?, GD=?, PTS=? WHERE teamName=?");
            
            //mengisi symbol '?' pada query dengan data yang diambil dari interface remote object / API          
            statement.setString(1, Integer.toString(score.getP()));
            statement.setString(2, Integer.toString(score.getW()));
            statement.setString(3, Integer.toString(score.getD()));
            statement.setString(4, Integer.toString(score.getL()));
            statement.setString(5, Integer.toString(score.getF()));
            statement.setString(6, Integer.toString(score.getA()));
            statement.setString(7, Integer.toString(score.getGD()));
            statement.setString(8, Integer.toString(score.getPTS()));
            statement.setString(9, score.getTeamName()); 
            
            //menjalankan perintah query diatas
            statement.executeUpdate();
            
            //feedback ketika query berhasil dijalanlan
            System.out.println("\t "+statement+"\n\t Permintaan berhasil diproses.\n"); //feedback untuk server
            score.setStatusOps("Data Berhasil Diperabarui");  //feedback untuk client
            
            return score;   //mengembalikan nilai yang dimasukkan ke variable mahasiswa
                                //dalam konteks ini adalah variable 'setLaporan' untuk feedback ke client.
        
        } catch (SQLException e) {
            
            //feedback ketika query gagal dijalankan
            System.out.println("\t Permintaan gagal diproses.\n");
            score.setStatusOps("Data Gagal Diperbarui");
            e.printStackTrace();    //keterangan gagal lebih lanjut
            
            return score;   //mengembalikan nilai yang dimasukkan ke variable mahasiswa
                                //dalam konteks ini adalah variable 'setLaporan' untuk feedback ke client.
        
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
    
    //Method DELETE untuk penghapusan data pada db
    @Override
    public soccerScore deleteScore(soccerScore score) throws RemoteException {
        System.out.println("[Server] Client memanggil fungsi delete");
        
        //Membuat variable statement
        PreparedStatement statement = null;
        try {
            //mengisi statement dengan perintah query DELETE
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "DELETE FROM soccerscore WHERE teamName=?");
            
            //Mengisi simbol '?' pada query dengan Npm mahasiswa yang didapat dari interface remote object
            statement.setString(1, score.getTeamName());
            
            //Menjalanakan query
            statement.executeUpdate();
            
            //feedback ketika query berhasil dijalankan
            System.out.println("\t "+statement+"\n\t Permintaan berhasil diproses.\n");
            score.setStatusOps("Data Berhasil Dihapus");
            return score;
            
        } catch (SQLException e) {
            //feedback ketika query gagal dijalankan
            System.out.println("\t Permintaan gagal diproses.\n");
            score.setStatusOps("Data Gagal Dihapus!");
            e.printStackTrace(); //keterangan kegagalan lebih lanjut
            return score;
            
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Menagambil serluruh data yang ada pada Db
    @Override
    public List<soccerScore> getAllScore() throws RemoteException {
        System.out.println("[Server] Client memanggil data pada database");
        
        //membuat variable statement
        Statement statement = null;
        try {
            
            //membuat koneksi dengan database
            statement = DatabaseUtilities.getConnection().createStatement();
            
            //menjalankan query untuk mendapatkan seluruh data yang ada pada table soccerscore
            ResultSet resultSet = statement.executeQuery("SELECT * FROM soccerscore");
            
            //membuat variable tipe data Array
            List<soccerScore> list = new ArrayList<>();
            
            //infinity looping sampai seluruh data tersimpan
            while (resultSet.next()) {
                soccerScore soccerScore = new soccerScore();
                
                //menyimpan setiap data pada variable soccerscore
                soccerScore.setTeamName(resultSet.getString("teamName"));
                soccerScore.setP(Integer.parseInt(resultSet.getString("P"))); 
                soccerScore.setW(Integer.parseInt(resultSet.getString("W")));
                soccerScore.setD(Integer.parseInt(resultSet.getString("D")));
                soccerScore.setL(Integer.parseInt(resultSet.getString("L")));
                soccerScore.setF(Integer.parseInt(resultSet.getString("F")));
                soccerScore.setA(Integer.parseInt(resultSet.getString("A")));
                soccerScore.setGD(Integer.parseInt(resultSet.getString("GD")));
                soccerScore.setPTS(Integer.parseInt(resultSet.getString("PTS"))); 
                list.add(soccerScore);
            }
            
            //feedback ketika query berhasil dijalankan
            System.out.println("\t Data berhasil ditampilkan.\n");
            
            return list;
            
        } catch (SQLException e) {
            //feedback ketika query gagal dijalankan
            e.printStackTrace();      
            return null;
        
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public List<soccerScore> getScore(String team) throws RemoteException {
        System.out.println("[Server] Client memanggil data pada database");
        
        //membuat variable statement
        Statement statement = null;
        try {
            
            //membuat koneksi dengan database
            statement = DatabaseUtilities.getConnection().createStatement();
            
            //menjalankan query untuk mendapatkan seluruh data yang ada pada table soccerscore
            ResultSet resultSet = statement.executeQuery("SELECT * FROM soccerscore where teamName='"+team+"'");
            
            //membuat variable tipe data Array
            List<soccerScore> list = new ArrayList<>();
            
            //infinity looping sampai seluruh data tersimpan
            while (resultSet.next()) {
                soccerScore soccerScore = new soccerScore();
                
                //menyimpan setiap data pada variable soccerscore
                soccerScore.setTeamName(resultSet.getString("teamName"));
                soccerScore.setP(Integer.parseInt(resultSet.getString("P"))); 
                soccerScore.setW(Integer.parseInt(resultSet.getString("W")));
                soccerScore.setD(Integer.parseInt(resultSet.getString("D")));
                soccerScore.setL(Integer.parseInt(resultSet.getString("L")));
                soccerScore.setF(Integer.parseInt(resultSet.getString("F")));
                soccerScore.setA(Integer.parseInt(resultSet.getString("A")));
                soccerScore.setGD(Integer.parseInt(resultSet.getString("GD")));
                soccerScore.setPTS(Integer.parseInt(resultSet.getString("PTS"))); 
                list.add(soccerScore);
            }
            
            //feedback ketika query berhasil dijalankan
            System.out.println("\t Data berhasil ditampilkan.\n");
            
            return list;            
        } catch (SQLException e) {
            //feedback ketika query gagal dijalankan
            System.out.println("x");
            e.printStackTrace();      
            return null;
        
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("xx");
                    e.printStackTrace();
                }
            }
        }
    }
}