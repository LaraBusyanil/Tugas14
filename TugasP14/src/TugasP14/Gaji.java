package TugasP14;

import java.util.Scanner;

public class Gaji implements PTABC {
public String namaPegawai;
public String noPegawai;


Scanner input = new Scanner(System.in);




    @Override
    public void noPegawai(){
        System.out.println("-----INPUT DATA GAJI PEGAWAI-----");
        System.out.println("No Pegawai : ");
        noPegawai = input.next();
    }
    
    @Override
    public void namaPegawai(){
    System.out.println("Nama Pegawai : " );
    namaPegawai = input.next();
    }


    
    @Override
    public void jabatan(){
     
    }

    @Override
    public void jumlahHariMasuk(){
 }
       
     @Override
    public void Potongan() {
        
        
    }
    @Override
    public void totalGaji() {
    }

    @Override
    public Integer gajiPokok(Integer jabatan) {
        // TODO Auto-generated method stub
        return null;
    }
}
 



  
    


