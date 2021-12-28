package TugasP14;

import java.util.Scanner;

public class TerimaGaji extends Gaji {


        public Integer jabatan;
        public Integer gajiPokok=0;
        public int jmlHariMasuk;
        public Integer potongan=0;
        public Integer totalGaji;
        public Integer absen;
        public Integer denda;
        
        String direkturUtama, direkturKeuangan,direkturPersonalia, manager, managerPemasaran;
        
        
        Scanner input2 = new Scanner(System.in);
 
        
        
        
            
            @Override
            public void jabatan(){
                System.out.println("Jabatan : ");
                 System.out.println("1       :  Direktur Utama");
                 System.out.println("2       :  Direktur Keuangan");
                 System.out.println("3       :  Direktur Personalia");
                 System.out.println("4       :  Manager");
                 System.out.println("5       :  Manager Pemasaran");
                    System.out.println("Pilihan Jabatan : ");
                  jabatan = input.nextInt(); 
                }
            
        
        
             @Override
            public Integer gajiPokok(Integer jabatan){
            switch(jabatan){
            case 1 :
            gajiPokok = 70000000;
            break;
            case 2 :
            gajiPokok = 50000000;
            break;
            case 3 : 
            gajiPokok = 45000000;
            break;
            case 4 :
            gajiPokok = 15000000;
            break;
            case 5 :
            gajiPokok = 6000000;
            break;
            default :
            gajiPokok = 0;
          } return gajiPokok;
             
            }
        
            @Override
            public void jumlahHariMasuk(){
                System.out.println("Jumlah Hari Absen : ");
                 absen = input.nextInt();
                if(jmlHariMasuk<=30){
                jmlHariMasuk=30-absen;
            } else if(jmlHariMasuk>=30){
                System.out.println("Perhitungan Jumlah Hari Masuk hanya untuk 1 bulan");
            } else if(jmlHariMasuk<0){
                System.out.println("Tidak bisa menginput data negatif");
            }
         }
               
             @Override
            public void Potongan() {
                denda=50000;
                potongan = denda*absen;
                
            }
            @Override
            public void totalGaji() {
                totalGaji = this.gajiPokok - this.potongan;
            }
        }
    
    
  



   