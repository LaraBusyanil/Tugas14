package TugasP14;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class Program {
   
	static Connection conn;

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner (System.in);
		String pil;
		boolean lanjut = true;
						
		String url = "jdbc:mysql://localhost:3306/gaji";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,"root","");
			System.out.println("Class Driver ditemukan");
			
			while (lanjut) {
				System.out.println("\n-------------------");
				System.out.println("Database Terima Gaji");
				System.out.println("--------------------");
				System.out.println("1. View Data Pegawai");
				System.out.println("2. Insert Data Pegawai");
				System.out.println("3. Update Data Pegawai");
				System.out.println("4. Delete Data Pegawai");
				System.out.println("5. Search Data Pegawai");
				
				System.out.print("\nMasukkan Pilihan Anda (1-5): ");
				pil = input.next();
				
				switch (pil) {
				case "1":
					view();
					break;
				case "2":
					insert();
					break;
				case "3":
					update();
					break;
				case "4":
					delete();
					break;
				case "5":
					search();
					break;
				default:
					System.err.println("\nInput anda tidak ditemukan\nSilahkan pilih [1-5]");
				}
				
				System.out.print("\nApakah Anda ingin melanjutkan [y/n]? ");
				pil = input.next();
				lanjut = pil.equalsIgnoreCase("y");
			}
			System.out.println("\nSelamat Berjumpa Kembali!!!");
			
		}
		catch(ClassNotFoundException ex) {
			System.err.println("Driver Error");
			System.exit(0);
		}
		catch(SQLException e){
			System.err.println("Tidak berhasil terkoneksi");
		}finally{
			input.close();
		}
	}
	
	private static void view() throws SQLException {
		String text1 = "\n===Daftar Seluruh Data Pegawai PTABC===";
		System.out.println(text1.toUpperCase());
						
		String sql ="SELECT * FROM pegawai";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next()){

            System.out.print("\nNama Pegawai\t  : ");
            System.out.print(result.getString("namaPegawai"));
            System.out.print("\nNo. Pegawai\t  : ");
            System.out.print(result.getInt("noPegawai"));
			System.out.print("\nJabatan\t\t  : ");
            System.out.print(result.getString("jabatan"));
            System.out.print("\nGaji Pokok\t  :");
			System.out.print(result.getInt("gajiPokok"));
            System.out.print("\nJumlah Hari Masuk : ");
			System.out.print(result.getInt("jumlahHariMasuk"));
            System.out.print("\nPotongan\t  :");
			System.out.print(result.getInt("potongan"));
            System.out.print("\nTotal Gaji\t  :");
			System.out.print(result.getInt("totalGaji"));
			System.out.println("\n\n");
           
		}
	}
		
	private static void insert() throws SQLException{
		String text2 = "\n===Tambah Data Pegawai===";
		System.out.println(text2.toUpperCase());
		
		Scanner input = new Scanner (System.in);
				
		try {
		

		System.out.print("Nama Pegawai\t: ");
		String namaPegawai = input.next();
		System.out.print("No. Pegawai\t: ");
		int noPegawai = input.nextInt();
		System.out.print("Jabatan\t: ");
		String jabatan = input.next();
		System.out.print("gaji Pokok\t: ");
		int gajiPokok = input.nextInt();
		System.out.print("jumlah Hari Masuk\t: ");
		int jumlahHariMasuk = input.nextInt();
		System.out.print("Potongan\t: ");
		int potongan = input.nextInt();
		System.out.print("Total Gaji\t: ");
		int totalGaji = input.nextInt();
		
		String sql = "INSERT INTO pegawai (namaPegawai, noPegawai, jabatan, gajiPokok, jumlahHariMasuk, potongan, totalGaji) VALUES ('"+namaPegawai+"','"+noPegawai+"', '"+jabatan+"', '"+gajiPokok+"', '"+jumlahHariMasuk+"','"+potongan+"', '"+totalGaji+"')";
					
        Statement statement = conn.createStatement();
        statement.execute(sql);
        System.out.println("Berhasil menginput data");
	


	    } catch (SQLException e) {
	        System.err.println("Terjadi kesalahan saat menginput data");
	    } catch (InputMismatchException e) {
	    	System.err.println("Inputlah dengan benar!");
	   	}finally{
			   input.close();
		   }
	} 
	
	private static void update() throws SQLException{
		String text3 = "\n===Ubah Data Pegawai===";
		System.out.println(text3.toUpperCase());
		
		Scanner input = new Scanner (System.in);
		
		try {
            view();
            System.out.print("\nMasukkan No. Pegawai yang akan di update : ");
            Integer noPegawai = Integer.parseInt(input.nextLine());
            
            String sql = "SELECT * FROM pegawai WHERE noPegawai = " +noPegawai;
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            if(result.next()){
                
                System.out.print("Nama ["+result.getString("namaPegawai")+"]\t: ");
                String namaPegawai = input.nextLine();
                
                System.out.print("Jabatan ["+result.getString("jabatan")+"]\t: ");
                String jabatan = input.nextLine();

				System.out.print("Gaji Pokok ["+result.getString("gajiPokok")+"]\t: ");
                int gajiPokok = input.nextInt();

				System.out.print("Jumlah Hari Masuk ["+result.getString("jumlahHariMasuk")+"]\t: ");
                int jumlahHariMasuk = input.nextInt();

				System.out.print("Potongan ["+result.getString("potongan")+"]\t: ");
                int potongan = input.nextInt();

				System.out.print("Total Gaji ["+result.getString("totalGaji")+"]\t: ");
                int totalGaji = input.nextInt();
                   
                sql = "UPDATE pegawai SET namaPegawai='"+namaPegawai+"',jabatan= '"+jabatan+"',gajiPokok='"+gajiPokok+"', jumlahHariMasuk='"+jumlahHariMasuk+"', potongan='"+potongan+"', totalGaji='"+totalGaji+"' WHERE noPegawai='"+noPegawai+"'";
                //System.out.println(sql);

                if(statement.executeUpdate(sql) > 0){
                    System.out.println("Berhasil memperbaharui data pegawai (No. Pegawai "+noPegawai+")");
                }
            }
            statement.close();        
        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan dalam mengedit data");
            System.err.println(e.getMessage());
        }
		
	finally{
			input.close();
	}
		}
	
	private static void delete() {
		String text4 = "\n===Hapus Data Pegawai===";
		System.out.println(text4.toUpperCase());
		
		Scanner input = new Scanner (System.in);
		
		try{
	        view();
	        System.out.print("\nMasukkan No.Pegawai yang akan Anda Hapus : ");
	        Integer noPegawai= Integer.parseInt(input.nextLine());
	        
	        String sql = "DELETE FROM pegawai WHERE noPegawai = "+ noPegawai;
	        Statement statement = conn.createStatement();
	        //ResultSet result = statement.executeQuery(sql);
	        
	        if(statement.executeUpdate(sql) > 0){
	            System.out.println("Berhasil menghapus data pegawai (No. Pegawai "+noPegawai+")");
	        }
	   }catch(SQLException e){
	        System.out.println("Terjadi kesalahan dalam menghapus data pegawai");
	        }finally{
				input.close();
			}
		}
	
	private static void search () throws SQLException {
		String text5 = "\n===Cari Data Pegawai===";
		System.out.println(text5.toUpperCase());
		
		Scanner input = new Scanner (System.in);
		try{
				
		System.out.print("Masukkan Nama Pegawai : ");
        
		String i = input.nextLine();
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM pegawai WHERE namaPegawai LIKE '%"+i+"%'";
        ResultSet result = statement.executeQuery(sql); 
                
        while(result.next()){
        	System.out.print("\nNama Pegawai\t: ");
            System.out.print(result.getString("namaPegawai"));
            System.out.print("\nNo. Pegawai\t: ");
            System.out.print(result.getInt("noPegawai"));
			System.out.print("\nJabatan\t: ");
            System.out.print(result.getString("jabatan"));
            System.out.print("\nGaji Pokok\t :");
			System.out.print(result.getInt("gajiPokok"));
            System.out.print("\nJumlah Hari Masuk\t: ");
			System.out.print(result.getInt("jumlahHariMasuk"));
            System.out.print("\nPotongan\t:");
			System.out.print(result.getInt("potongan"));
            System.out.print("\nTotal Gaji\t:");
			System.out.print(result.getInt("totalGaji"));
        }
		
	}finally{
		input.close();
	}
	}
}


     