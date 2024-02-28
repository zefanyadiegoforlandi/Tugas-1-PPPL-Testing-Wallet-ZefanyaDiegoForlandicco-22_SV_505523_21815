package org.example;

import java.util.ArrayList;
import java.util.Iterator;

public class Wallet {
    String owner ;
    ArrayList<String> listKartu;
    ArrayList<Integer> listUangKoin;
    ArrayList<Integer> listUangLembaran;


    public Wallet (String owner){
        this.owner = owner;
        listKartu = new ArrayList<>();
        listUangLembaran = new ArrayList<>();
        listUangKoin = new ArrayList<>();
    }

    public void setOwner(String owner){

        this.owner = owner;
    }
    public String getOwner() {

        return owner;
    }

    public void tambahKartu(String namaKartu){
        this.listKartu.add(namaKartu);
    }

    public ArrayList<String> getListKartu() {
        return listKartu;
    }

    public String ambilKartu(String namaKartu){
        boolean isDeleted = this.listKartu.remove(namaKartu);
        if (isDeleted){
            return namaKartu;
        }
        return null;
    }

    public void tambahUangRupiah (Integer jumlahUang){
        if (jumlahUang < 0){
            throw new Error("Jumlah Uang Tidak dapat Minus");
        }
        if (jumlahUang >= 1000){
            listUangLembaran.add(jumlahUang);
        }
        if (jumlahUang < 1000 && jumlahUang > 0){
            listUangKoin.add(jumlahUang);
        }
    }

    public ArrayList<Integer> getListUangLembaran() {
        return listUangLembaran;
    }

    public ArrayList<Integer> getListUangKoin() {
        return listUangKoin;
    }

    public int ambilUang(int jumlahUang){
        boolean isAmbilUangLembaran = this.listUangLembaran.remove(
                Integer.valueOf(jumlahUang));
        if (isAmbilUangLembaran){
            return jumlahUang;
        }

        boolean isAmbilUangKoin = this.listUangKoin.remove(
                Integer.valueOf(jumlahUang));
        if (isAmbilUangKoin){
            return jumlahUang;
        }

        return 0;
    }

    public int tampilkanUang(){
        int totalUang = 0;
        for (Integer uang : listUangKoin){
            totalUang += uang;
        }
        for (Integer uang : listUangLembaran){
            totalUang += uang;
        }
        return totalUang;
    }



}
