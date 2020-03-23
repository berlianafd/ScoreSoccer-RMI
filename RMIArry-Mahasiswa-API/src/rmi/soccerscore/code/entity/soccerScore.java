package rmi.soccerscore.code.entity;

import java.io.Serializable;
 
//Class untuk menyimpan data yang akan masuk
public class soccerScore implements Serializable {
 
    //Deklarasi variable untuk mewakili entitas entitas database
    private String TeamName,StatusOps;
    private int P,W,D,L,F,A,GD,PTS;

    public String getStatusOps() {
        return StatusOps;
    }

    public void setStatusOps(String StatusOps) {
        this.StatusOps = StatusOps;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String TeamName) {
        this.TeamName = TeamName;
    }

    public int getP() {
        return P;
    }

    public void setP(int P) {
        this.P = P;
    }

    public int getW() {
        return W;
    }

    public void setW(int W) {
        this.W = W;
    }

    public int getD() {
        return D;
    }

    public void setD(int D) {
        this.D = D;
    }

    public int getL() {
        return L;
    }

    public void setL(int L) {
        this.L = L;
    }

    public int getF() {
        return F;
    }

    public void setF(int F) {
        this.F = F;
    }

    public int getA() {
        return A;
    }

    public void setA(int A) {
        this.A = A;
    }

    public int getGD() {
        return GD;
    }

    public void setGD(int GD) {
        this.GD = GD;
    }

    public int getPTS() {
        return PTS;
    }

    public void setPTS(int PTS) {
        this.PTS = PTS;
    }
    
}
