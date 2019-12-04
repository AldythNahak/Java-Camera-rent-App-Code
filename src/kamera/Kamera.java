/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kamera;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Criteria;
import pojos.Sewa;
import java.time.LocalDate;

/**
 *
 * @author Aldyth M. V. Nahak (672017081)
 */
public class Kamera {

    static void update(){
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
         Date date = new Date();
          Scanner input = new Scanner(System.in);
          Scanner text = new Scanner (System.in);
          String expectedPattern = "yyyy-MM-dd";
          SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
          LocalDate ambil = LocalDate.now();
   
         int id, nohp,unit,biaya,no ;
         String nama, alamat, kembali;

        System.out.println("Rental Kamera");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%");
    
        System.out.print("1.Input Data\n ");
        System.out.print("2.Read Data\n ");
        System.out.print("3.Update Data\n");
        System.out.print("4.Delete Data\n");
        System.out.print("(untuk berhenti tekan nomor lain selain yang tertera)\n");
        System.out.print("________________________\n");
        System.out.print("masukan pilihan: ");
        int pilihan = input.nextInt();
        System.out.print("\n________________________\n");
        

          switch(pilihan){
            
 case 1:
        Session s = connection.connection.getSessionFactory().openSession();
        Transaction tr = s.beginTransaction();
        pojos.Sewa save = new pojos.Sewa();
//            System.out.println("ID:");
////            id = input.nextInt();
////            save.setId(id);
//             save.setId(input.nextInt());
            
            System.out.println("nama:");
            nama = text.nextLine();
            save.setNama(nama);
            //save.setNama(input.nextLine());
            
//            System.out.println("alamat:");
////            alamat = input.nextLine();
////            save.setAlamat(alamat);
//            save.setAlamat(input.nextLine());
            
            System.out.println("no hp:");
//            nohp = input.nextInt();
//            save.setNomorHp(nohp);
            save.setNomorHp(input.nextInt());
            
            System.out.println("unit:");
//            unit = input.nextInt();
//            save.setUnit(unit);
             save.setUnit(input.nextInt());
            
            System.out.println("Tanggal pengambilan:");
//            ambil = input.nextLine();
//            Date date = formatter.parse(ambil);
//            save.setTanggalPengambilan(date);
            save.setTanggalPengambilan(ambil);
//            
//            System.out.println("Tanggal pengembalian:");
////            kembali = input.nextLine();
////            Date date1 = formatter.parse(kembali);
////            save.setTanggalPengembalian(date1);
//            save.setTanggalPengembalian(formatter.parse(input.nextLine()));
//            
//            System.out.println("Biaya:");
////            biaya= input.nextInt();
////            save.setBiaya(biaya);
//            save.setBiaya(input.nextInt());
            
           s.save(save);
           tr.commit();
            System.out.println("Success save.........");
           s.close();
           tr = null;
           break;
 case 2:
        Session r = connection.connection.getSessionFactory().openSession();
        Criteria c = r.createCriteria(pojos.Sewa.class);
            List<pojos.Sewa> st = c.list();
            for (pojos.Sewa stu : st){
                System.out.println("ID: "+stu.getId()+"\n"+
                                   "Nama: "+stu.getNama()+"\n"+
                                   "Alamat: "+stu.getAlamat()+"\n"+
                                   "no. Telp: "+stu.getNomorHp()+"\n"+
                                   "unit Sewa: "+stu.getUnit()+"\n"+
                                   "tanggal Sewa: "+stu.getTanggalPengambilan()+"\n"+
                                   "tanggal Kembali: "+stu.getTanggalPengembalian()+"\n"+
                                   "Biaya: "+stu.getBiaya()+"\n"
                                    );
            }
        System.out.print("1.Update Data? \n");
        System.out.print("2.Delete Data? \n");
        System.out.println("Masukan pilihan: ");
        int pilih = input.nextInt();
        System.out.print("\n________________________\n");
        
        switch(pilih){
         case 1:
        Session u = connection.connection.getSessionFactory().openSession();
        Transaction up = u.beginTransaction();
        
        System.out.println("Update data nomor berapa?");
        no = input.nextInt();
        
        pojos.Sewa stu = (pojos.Sewa) u.load(pojos.Sewa.class, no);
        Sewa data = st.get(no);
        System.out.println(data); 
            
            System.out.println("Tanggal pengembalian:");
            kembali = text.nextLine();
           Date date1 = formatter.parse(kembali);
           stu.setTanggalPengembalian(kembali);
            
            System.out.println("Biaya:");
            stu.setBiaya(input.nextInt());
            
            u.update(stu);
            up.commit();
             System.out.println("Success update.........");
            u.close();
            up = null;
       
        break;
        
            case 2 :
                Session d = connection.connection.getSessionFactory().openSession();
                Transaction dl = d.beginTransaction();
                
                System.out.println("Delete data nomor berapa?");
                no = input.nextInt();
        
                pojos.Sewa del = (pojos.Sewa) d.load(pojos.Sewa.class, no);
                d.delete(del);
                dl.commit();
                System.out.println("Success Delete.........");
                d.close();
                dl = null;
                
                break;
        }
        
        break;
 case 3:
 Session u = connection.connection.getSessionFactory().openSession();
        Transaction up = u.beginTransaction();
        
        System.out.println("Update data nomor berapa?");
        no = input.nextInt();
        
        pojos.Sewa stu = (pojos.Sewa) u.load(pojos.Sewa.class, no);

            
            System.out.println("Tanggal pengembalian:");
            kembali = input.nextLine();
            Date date1 = formatter.parse(kembali);
           stu.setTanggalPengembalian(kembali);
            
            System.out.println("Biaya:");
//            biaya= input.nextInt();
//            save.setBiaya(biaya);
            stu.setBiaya(input.nextInt());
            
             u.update(stu);
            up.commit();
            u.close();
            tr = null;
            System.out.println("Success update.........");
            break;
            
 case 4:
           Session d = connection.connection.getSessionFactory().openSession();
                Transaction dl = d.beginTransaction();
                
                System.out.println("Delete data nomor berapa?");
                no = input.nextInt();
        
                pojos.Sewa del = (pojos.Sewa) d.load(pojos.Sewa.class, no);
                d.delete(del);
                dl.commit();
                System.out.println("Success Delete.........");
                d.close();
                dl = null;
     break;
        }
      
    }
}
    
