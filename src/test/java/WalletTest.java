import org.example.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
public class WalletTest {
        @Test
        public void testSetOwner() {
            Wallet wallet = new Wallet("Bika");
            wallet.setOwner("Ambon");
            Assertions.assertEquals("Ambon", wallet.getOwner());
            Assertions.assertFalse(wallet.getOwner().contains("Bika"));
        }

    @Test
    public void testTambahKartu() {
        Wallet wallet = new Wallet("Bika");
        wallet.tambahKartu("Credit Card");

        ArrayList<String> listKartu = wallet.getListKartu();
        Assertions.assertNotNull(listKartu);
        Assertions.assertEquals(1, listKartu.size());
        Assertions.assertEquals("Credit Card", listKartu.get(0));
    }

    @Test
    public void testAmbilKartu() {
        Wallet wallet = new Wallet("Bika");
        wallet.tambahKartu("Credit Card");
        wallet.tambahKartu("Debit Card");

        String kartuYangDiambil = wallet.ambilKartu("Credit Card");
        Assertions.assertNotNull(kartuYangDiambil);
        Assertions.assertEquals("Credit Card", kartuYangDiambil);
        Assertions.assertFalse(wallet.getListKartu().contains("Credit Card"));

        String kartuYangTidakAda = wallet.ambilKartu("Membership Card");
        Assertions.assertNull(kartuYangTidakAda);
    }
    @Test
    public void testTambahUangRupiah() {
        Wallet wallet = new Wallet("Bika");

        wallet.tambahUangRupiah(1500);
        Assertions.assertEquals(1, wallet.getListUangLembaran().size());
        Assertions.assertEquals(1500, wallet.getListUangLembaran().get(0));
        Assertions.assertTrue(wallet.getListUangKoin().isEmpty());

        wallet.tambahUangRupiah(500);
        Assertions.assertEquals(1, wallet.getListUangLembaran().size());
        Assertions.assertEquals(500, wallet.getListUangKoin().get(0));
    }
    @Test
    public void testAmbilUang() {
        Wallet wallet = new Wallet("Bika");
        wallet.tambahUangRupiah(1000);
        wallet.tambahUangRupiah(500);
        Assertions.assertTrue(wallet.getListUangKoin().contains(500));
        Assertions.assertTrue(wallet.getListUangLembaran().contains(1000));

        int uangYangDiambil = wallet.ambilUang(1000);
        Assertions.assertEquals(1000, uangYangDiambil);
        Assertions.assertEquals(0, wallet.getListUangLembaran().size());
        Assertions.assertTrue(wallet.getListUangLembaran().isEmpty());

        uangYangDiambil = wallet.ambilUang(500);
        Assertions.assertEquals(500, uangYangDiambil);
        Assertions.assertTrue(wallet.getListUangKoin().isEmpty());

        uangYangDiambil = wallet.ambilUang(2000);
        Assertions.assertEquals(0, uangYangDiambil);
    }
    @Test
    public void testTampilkanUang() {
        Wallet wallet = new Wallet("Bika");

        wallet.tambahUangRupiah(500); // Koin
        wallet.tambahUangRupiah(1000); // Uang Kertas
        wallet.tambahUangRupiah(2000); // Uang Kertas

        Assertions.assertEquals(3500, wallet.tampilkanUang());
    }

}
