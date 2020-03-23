package rmi.code.client.table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rmi.soccerscore.code.entity.soccerScore;

//Class untuk menampilkan data yang ada pada database ke table JFrame
public class TableModelScore1 extends AbstractTableModel {
    private List<soccerScore> list = new ArrayList<soccerScore>();
    
    //untuk mendapatkan data dan menampilkannya ke dalam table
    public soccerScore get(int row) {
        return list.get(row);
    }
    
    //untuk merubah data yang ada pada table
    public void setData(List<soccerScore> list) {
        this.list = list;
        fireTableDataChanged();
    }
    
    //menentukan jumlah baris pada table berdasarkan data yang ada
    @Override
    public int getRowCount() {
        return list.size();
    }
    
    //menentukan banyak jumlah kolom pada table
    @Override
    public int getColumnCount() {
        return 9; //5 Kolom
    }
    
    //Mengambil dan menampilkan data ke dalam kolom yang ditentukan
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getTeamName();
            case 1:
                return list.get(rowIndex).getP();
            case 2:
                return list.get(rowIndex).getW();
            case 3:
                return list.get(rowIndex).getD();
            case 4:
                return list.get(rowIndex).getL();
            case 5:
                return list.get(rowIndex).getF();
            case 6:
                return list.get(rowIndex).getA();
            case 7:
                return list.get(rowIndex).getGD();
            case 8:
                return list.get(rowIndex).getPTS();
          
            default:
                return null;
        }
    }
    
    //Menentukan judul setiap kolom
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Team Name";
            case 1:
                return "P";
            case 2:
                return "W";
            case 3:
                return "D";
            case 4:
                return "L";
            case 5:
                return "F";
            case 6:
                return "A";
            case 7:
                return "GD";
            case 8:
                return "PTS";
            
            default:
                return null;
        }
    }
    
}