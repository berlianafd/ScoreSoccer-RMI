package rmi.soccerscore.code.service;

import java.rmi.Remote; 
import java.rmi.RemoteException;
import java.util.List; 
import rmi.soccerscore.code.entity.soccerScore;

//Class Interface yang nantinya akan menjebatani permintaan client ke server 
//sebagai Remote Object
public interface soccerScoreService extends Remote {
    
    soccerScore insertScore(soccerScore mahasiswa) throws RemoteException;

    soccerScore updateScore(soccerScore mahasiswa) throws RemoteException;

    soccerScore deleteScore(soccerScore mahasiswa) throws RemoteException;

    List<soccerScore> getAllScore() throws RemoteException;
    
    List<soccerScore> getScore(String team) throws RemoteException;
}
