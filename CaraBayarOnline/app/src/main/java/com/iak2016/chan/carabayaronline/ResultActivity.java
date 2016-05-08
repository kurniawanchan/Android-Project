package com.iak2016.chan.carabayaronline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // initialize variable
        String howToPayContent = getResources().getString(R.string.method_na);
        int adminFee = 0;

        // get variable from intent
        String paymentMethod = getIntent().getStringExtra("paymentMethod");
        String paymentBank = getIntent().getStringExtra("paymentBank");
        String paymentMinimarket = getIntent().getStringExtra("paymentMinimarket");
        String ewalletProvider = getIntent().getStringExtra("ewalletProvider");
        String onlineShop = getIntent().getStringExtra("onlineShop");

        // Populate Payment Method
        TextView tvPaymentMethod = (TextView) findViewById(R.id.tv_payment_method);
        tvPaymentMethod.setText(paymentMethod + " : ");

        // Populate Payment Provider
        TextView tvPaymentProvider = (TextView) findViewById(R.id.tv_payment_provider);

        if (paymentBank != null) {
            tvPaymentProvider.setText(paymentBank);
        }
        if (paymentMinimarket != null) {
            tvPaymentProvider.setText(paymentMinimarket);
        }
        if (ewalletProvider != null) {
            tvPaymentProvider.setText(ewalletProvider);
        }

        // Populate Online Shop
        TextView tvOnlineShop = (TextView) findViewById(R.id.tv_online_shop);
        tvOnlineShop.setText(onlineShop);

        // Define Content
        //ImageView ivHowToPayContent = (ImageView) findViewById(R.id.iv_how_to_pay_content);

        // populate content
        // Internet Banking Payment Method
        if (paymentMethod.equalsIgnoreCase("e-banking") && onlineShop.equalsIgnoreCase("elevenia") && paymentBank.equalsIgnoreCase("bca")) {
            // set adminfee
            adminFee = 0;

            // populate content
            //ivHowToPayContent.setImageResource(R.drawable.ebanking_elevenia_bca);
            /*howToPayContent = "Minimum pembayaran menggunakan KlikBCA adalah Rp 10.000.\n" +
                    "Setelah Anda memilih KlikBCA di halaman Selesai Belanja, maka Anda akan dibawa ke layar login KlikBCA. \n" +
                    "Pastikan alamat domain yang tertulis di address bar browser adalah: https://ibank.klikbca.com/\n" +
                    "\n" +
                    "Cara membayar di elevenia dengan KlikBCA\n" +
                    "\n" +
                    "Masukkan User ID dan password\n" +
                    "Pilih menu \"Pembayaran e-Commerce\", klik kategori \"Marketplace\" dan pilih \"ELEVENIA\". Lalu klik \"Lanjutkan\"\n" +
                    "Periksa kembali pemesanan, klik \"Lanjutkan\"\n" +
                    "Masukkan respon dari token, klik \"Kirim\"\n" +
                    "Di halaman berikutnya, akan muncul pemberitahuan tentang transaksi yang berhasil\n" +
                    "Pembayaran kamu dengan KlikBCA sudah berhasil dan diverifikasi secara otomatis. Pesanan pun\n" +
                    "langsung diteruskan ke penjual.\n" +
                    "impan bukti pembayaran Anda jika terjadi kendala pada transaksi";*/
        } else if (paymentMethod.equalsIgnoreCase("e-banking") && onlineShop.equalsIgnoreCase("lazada") && paymentBank.equalsIgnoreCase("bca")) {
            adminFee = 0;
            howToPayContent = "Login pada aplikasi KlikBCA, masukkan user ID & PIN\n" +
                    "Pilih \"Transfer Dana\", kemudian pilih \"Transfer ke BCA Virtual Account\"\n" +
                    "Masukkan no. BCA Virtual Account (71000XXXXXXXX) & klik \"Lanjutkan\"\n" +
                    "Masukan nominal yang ditransfer, isi kolom \"Berita\" dengan nama Anda & klik \"Lanjut\"\n" +
                    "Pastikan data yang dimasukkan sudah benar, dan Input \"Respon KeyBCA\", lalu klik \"Kirim\"";
        } else if (paymentMethod.equalsIgnoreCase("e-banking") && onlineShop.equalsIgnoreCase("lazada") && paymentBank.equalsIgnoreCase("mandiri")) {
            adminFee = 0;
            howToPayContent = "Login ke Internet Banking Mandiri anda lalu pilih menu \"Bayar\" " +
                    "\nkemudian pilih \"Lainnya\"\n" +
                    "\nPilih \"Penyedia Jasa: MitraPay\"\n" +
                    "\nMasukkan no. pesanan #ordernumber# (Nomor pesanan akan berbeda setiap kali pesan) lalu tekan “Lanjutkan”\n" +
                    "\nPilih pembayaran yang akan diproses kemudian tekan “Lanjutkan”\n" +
                    "\nCek informasi yang tertera di layar lalu tekan “Lanjutkan”";
        } else if (paymentMethod.equalsIgnoreCase("e-banking") && onlineShop.equalsIgnoreCase("lazada") && paymentBank.equalsIgnoreCase("bni")) {
            adminFee = 0;
            howToPayContent = "Pilih “transfer dana” lalu pilih “antar rekening BNI”, tekan \"nomor rekening\" & masukan rek. BNI 0326996294\n" +
                    "\nSimpan ke Daftar Rekening lalu isi kolom jumlah sesuai dengan yang harus dibayarkan untuk pesanan anda\n" +
                    "\nIsi no pesanan pada kolom “berita” lalu tekan logo “kunci” & masukan kode BNI E-Secure lalu tekan “lanjut”\n" +
                    "\nCek kembali transaksi lalu masukan kode BNI E-Secure & tekan “lanjut”, simpan no ref untuk bukti transaksi\n" +
                    "\nTransaksi selesai Lakukan konfirmasi pembayaran pada tautan www.lazada.co.id/konfirmasi/";
        }

        // ATM payment method
        if (paymentMethod.equalsIgnoreCase("atm") && onlineShop.equalsIgnoreCase("Elevenia") && paymentBank.equalsIgnoreCase("bca")) {
            adminFee = 0;
            howToPayContent = "Pembayaran melalui ATM BCA dapat dilakukan dengan mengikuti petunjuk berikut:\n" +
                    "\n" +
                    "Minimum pembayaran adalah Rp 10.000\n" +
                    "Masukkan kartu ATM BCA pada mesin ATM BCA dan masukkan nomor PIN Anda\n" +
                    "Plih menu \"TRANSAKSI LAINNYA\"\n" +
                    "Pilih menu \"PEMBAYARAN\"\n" +
                    "Pilih menu \"LAYAR BERIKUT\"\n" +
                    "Pilih menu \"LAIN_LAIN\"\n" +
                    "Masukkan kode perusahaan elevenia yaitu \"710419\"\n" +
                    "Masukkan kode pembayaran elevenia\n" +
                    "Akan muncul data transaksi Anda, apabila sesuai maka pilih menu \"YA\"\n" +
                    "Transaksi selesai";
        } else if (paymentMethod.equalsIgnoreCase("atm") && onlineShop.equalsIgnoreCase("Elevenia") && paymentBank.equalsIgnoreCase("mandiri")) {
            adminFee = 0;
            howToPayContent = "Pembayaran melalui ATM Mandiri dapat dilakukan dengan mengikuti petunjuk berikut:\n" +
                    "\n" +
                    "Minimum pembayaran adalah Rp 10.000\n" +
                    "Masukkan kartu ATM Mandiri pada mesin ATM Mandiri dan masukan nomor PIN Anda\n" +
                    "Pilih menu \"PEMBAYARAN/PEMBELIAN\"\n" +
                    "Pilih menu \"MULTI PAYMENT\"\n" +
                    "Masukkan kode perusahaan elevenia yaitu \"71000\"\n" +
                    "Masukkan kode pembayaran dari Elevenia\n" +
                    "Pilih transaksi nomor 1 pada halaman konfirmasi, apabila sesuai maka pilih menu \"YA\"\n" +
                    "Transaksi selesai";
        } else if (paymentMethod.equalsIgnoreCase("atm") && onlineShop.equalsIgnoreCase("lazada") && paymentBank.equalsIgnoreCase("bca")) {
            adminFee = 0;
            howToPayContent = "Masukkan kartu ATM kemudian masukkan nomor PIN Anda\n" +
                    "Pilih \"Transaksi lainnya\", kemudian pilih \"Transfer\"\n" +
                    "Silahkan masukkan no. BCA Virtual Account (71000XXXXXXXX), lalu tekan \"Benar\"\n" +
                    "Masukkan jumlah yang transfer\n" +
                    "Periksa kembali data transaksi kemudian tekan \"Benar\"";
        } else if (paymentMethod.equalsIgnoreCase("atm") && onlineShop.equalsIgnoreCase("lazada") && paymentBank.equalsIgnoreCase("mandiri")) {
            adminFee = 0;
            howToPayContent = "Pada menu utama, pilih menu \"Bayar/Beli\"\n" +
                    "Pilih menu \"Multi Payment\" (Jika di layar belum tersedia, tekan menu \"Lainnya\")\n" +
                    "Masukkan nomor kode perusahaan/instansi (70009)\n" +
                    "Masukkan kode akun virtual 710 diikuti dengan nomor pesanan Anda (tanpa spasi), contoh 710312345678\n" +
                    "Periksa kembali nomor Virtual Account dan nominal pembayaran Anda pada halaman Konfirmasi Pembayaran";
        } else if (paymentMethod.equalsIgnoreCase("atm") && onlineShop.equalsIgnoreCase("lazada") && paymentBank.equalsIgnoreCase("bni")) {
            adminFee = 0;
            howToPayContent = "Pilih menu “transfer” lalu pilih menu “dari rekening tabungan” kemudian pilih menu “ke rekening BNI”\n" +
                    "Masukkan nomor rekening Lazada 0326996294 & jumlah pembayaran pesanan anda\n" +
                    "Periksa kembali transaksi anda lalu pilih “tekan jika benar”\n" +
                    "Transaksi selesai, lakukan konfirmasi pembayaran pada tautan www.lazada.co.id/konfirmasi/";
        }

        // KLIKPAY payment method
        if (paymentMethod.equalsIgnoreCase("klikpay") && onlineShop.equalsIgnoreCase("Elevenia") && paymentBank.equalsIgnoreCase("bca")) {
            adminFee = 0;
            howToPayContent = "Setelah Anda memilih BCA KlikPay di halaman Selesai Belanja, maka Anda akan dibawa ke layar login BCA KlikPay. Pastikan alamat domain yang tertulis di address bar browser adalah https://klikpay.klikbca.com.\n" +
                    "\n" +
                    "Lalu ikuti langkah berikut ini, sesuai dengan tampilan halaman yang muncul setelah Anda login:\n" +
                    "\n" +
                    "Minimum pembayaran menggunakan BCA KlikPay adalah Rp 10.000\n" +
                    "Bila Anda belum melakukan registrasi dan aktivasi sebelumnya, silakan baca petunjuknya di: www.klikbca.com/KlikPay/cara_registrasi.html.\n" +
                    "Setelah Anda memasukkan alamat email dan password, maka akan tampil informasi transaksi seperti nama merchant (elevenia.co.id), waktu transaksi, dan jumlah yang harus dibayar. Pilihlah jenis pembayaran KlikBCA untuk transaksi tersebut.\n" +
                    "Untuk otorisasi pembayaran dengan BCA KlikPay, tekan tombol \"kirim OTP\", dan Anda akan menerima kode OTP (One Time Password) yang dikirim melalui SMS ke handphone Anda. Masukkan kode OTP tersebut pada kolom yang tersedia.\n" +
                    "Apabila kode OTP yang Anda masukkan benar, transaksi pembayaran akan langsung diproses dan saldo rekening Anda (untuk jenis pembayaran KlikBCA) akan berkurang sejumlah nilai transaksi.\n" +
                    "Status keberhasilan transaksi Anda akan tampil pada layar transaksi dan Anda akan menerima email notifikasi.";
        } else if (paymentMethod.equalsIgnoreCase("klikpay") && onlineShop.equalsIgnoreCase("Elevenia") && paymentBank.equalsIgnoreCase("mandiri")) {
            adminFee = 0;
            howToPayContent = "Untuk dapat melakukan transaksi dengan mandiri clickpay sebelumnya Anda harus memperhatikan hal berikut :\n" +
                    "\n" +
                    "Harus memiliki User ID Mandiri Internet dan Token Mandiri\n" +
                    "Harus mengaktifasikan layanan mandiri clickpay pada Mandiri Internet di www.bankmandiri.co.id\n" +
                    "Cara membayar di elevenia dengan mandiri clickpay\n" +
                    "\n" +
                    "Minimum pembayaran menggunakan mandiri clickpay adalah Rp 10.000\n" +
                    "Aktifkan Token Mandiri Anda dengan menekan tombol \n" +
                    "Masukkan password Token Mandiri\n" +
                    "Tekan \"3\" ketika muncul pesan \"APPLI\"\n" +
                    "Masukkan \"Input ke-1\" yang tertera pada layar Anda dan tekan tombol selama 3 detik\n" +
                    "Masukkan \"Input ke-2\" yang tertera pada layar Anda dan tekan tombol selama 3 detik\n" +
                    "Masukkan \"Input ke-3\" yang tertera pada layar Anda dan tekan tombol selama 3 detik\n" +
                    "Masukkan angka yang tertera di layar Token Mandiri Anda pada kolom \"Token Response\"\"\n" +
                    "Untuk informasi lebih lanjut kunjungi www.bankmandiri.co.id atau mandiri call 14000";
        } else if (paymentMethod.equalsIgnoreCase("klikpay") && onlineShop.equalsIgnoreCase("lazada") && paymentBank.equalsIgnoreCase("mandiri")) {
            adminFee = 0;
            howToPayContent = "Pilih opsi pembayaran Mandiri Klikpay lalu Masukan no. kartu debit Bank\n" +
                    "Aktifkan token Mandiri dengan tekan \"alt\" lalu Masukan password token kemudian tekan \"3\" ketika muncul pesan \"APPLI\"\n" +
                    "Masukan \"Challenge Code 1\" (10 digit terakhir kartu ATM) dan tekan tombol selama 3 detik\n" +
                    "Masukan \"Challenge Code 2\" (nilai transaksi) dan tekan tombol selama 3 detik\n" +
                    "Masukan \"Challenge Code 3\" (nomor order) dan tekan tombol selama 3 detik\n" +
                    "Masukan angka yang tertera di layar token Mandiri di kolom \"Token Response\" lalu Klik Bayar/Performa Payment";
        }

        // MINIMARKET payment method
        if (paymentMethod.equalsIgnoreCase("minimarket") && onlineShop.equalsIgnoreCase("Elevenia") && paymentMinimarket.equalsIgnoreCase("indomaret")) {
            adminFee = 0;
            howToPayContent = "Cara membayar di elevenia menggunakan Indomaret:\n" +
                    "\n" +
                    "Beli produk dengan memilih metode pembayaran Indomaret pada checkout dan tekan \"Beli Sekarang\", lalu Anda akan mendapatkan nomor pemesanan yang dikirim melalui email\n" +
                    "Kunjungi gerai Indomaret terdekat\n" +
                    "Lakukan pembayaran di kasir dengan menunjukkan langsung kode pembayaran, lalu kasir memproses transaksi pembayaran dan harap untuk menyimpan bukti transaksi pembayaran\n" +
                    "Status pesanan Anda akan segera update secara otomatis menjadi \"Pembayaran Berhasil\" dan akan segera diproses oleh Seller\n" +
                    "Note :\n" +
                    "- Simpan bukti transaksi pembayaran\n" +
                    "- Maksimum pembayaran di Indomaret adalah Rp 5.000.000,- (total pembayaran setelah discount).";
        }

        // E-WALLET payment method
        if (paymentMethod.equalsIgnoreCase("e-wallet") && onlineShop.equalsIgnoreCase("Elevenia") && ewalletProvider.equalsIgnoreCase("xl tunai")) {
            adminFee = 0;
            howToPayContent = "Untuk dapat melakukan transaksi dengan XL Tunai sebelumnya Anda harus mengaktifasi layanan XL Tunai melalui ponsel Anda.\n" +
                    "\n" +
                    "Untuk informasi lebih lanjut kunjungi www.xl.co.id/id/layanan-lain/xl-tunai atau hubungi 021-57959817.\n" +
                    "\n" +
                    "Cara membayar di elevenia dengan XL Tunai:\n" +
                    "\n" +
                    "Tekan *123*120# dari ponsel Anda\n" +
                    "Pilih \"Belanja Online\"\n" +
                    "Masukkan Merchant ID 780764\n" +
                    "Masukkan 15 (lima belas) digit Order ID\n" +
                    "Konfirmasi pembayaran";
        } else if (paymentMethod.equalsIgnoreCase("e-wallet") && onlineShop.equalsIgnoreCase("Elevenia") && ewalletProvider.equalsIgnoreCase("indosat dompetku")) {
            adminFee = 0;
            howToPayContent = "Layanan inovatif yang memungkinkan pelanggan Indosat untuk melakukan berbagai transaksi finansial seperti pembelian di merchant, pembayaran tagihan, pengisian pulsa, P2P Transfer, pengiriman uang melalui Handphone dengan melakukan pendaftaran terlebih dahulu. Khusus layanan Transfer lintas operator juga dapat dilakukan oleh pengguna Non Indosat. Bisa diakses menggunakan ponsel jenis apapun, kapan saja dan dimana saja tanpa perlu membawa uang tunai. Info lebih lanjut silahkan buka di http://duniadigital.co.id/dompetku.php atau hub call center 100 (Mentari, IM3), 111 (Matrix).\n" +
                    "\n" +
                    "Pembayaran melalui Indosat Dompetku dapat dilakukan dengan mengikuti petunjuk berikut :\n" +
                    "\n" +
                    "Siapkan ponsel Anda, pastikan layar ponsel anda tidak dalam posisi terkunci dan sinyal aktif\n" +
                    "Masukan nomor ponsel Indosat Anda pada Form Pembayaran Indosat Dompetku\n" +
                    "Masukan PIN Dompetku pada layar konfirmasi yang muncul di ponsel Anda\n" +
                    "Jika pembayaran Berhasil Anda akan terima notifkasi SMS\n" +
                    "Kegagalan transaksi pembayaran bisa disebabkan oleh :\n" +
                    "\n" +
                    "Koneksi internet yang tidak stabil ketika proses verifikasi berjalan\n" +
                    "Pengguna menutup/me-refresh jendela transaksi\n" +
                    "PIN yang dimasukan Pengguna salah\n" +
                    "Akun Dompetku Pengguna tidak aktif/diblokir\n" +
                    "Saldo Dompetku Pengguna tidak mencukupi\n" +
                    "Transaksi Pengguna melebihi batas transaksi Dompetku per bulan yaitu Rp 20.000.000\n" +
                    "\n" +
                    "Apabila dalam waktu 10 detik PUSH USSD tidak muncul, pelanggan dapat mengirim SMS ke 789 dengan format : YES[spasi]PIN\n" +
                    "\n" +
                    "\n" +
                    "Simpan bukti transaksi pembayaran\n" +
                    "\n" +
                    "\n" +
                    "Info lebih lanjut silahkan buka di http://duniadigital.co.id/dompetku.php atau hubungi call center 100 (Mentari,IM3), 111 (Matrix)";
        }

        // Populate Admin Fee
        TextView tvAdminFee = (TextView) findViewById(R.id.tv_admin_fee);
        tvAdminFee.setText("Rp " + adminFee);

        // get total payment
        int totalPaymentVal = getIntent().getIntExtra("totalPaymentVal", 0);

        // count grandtotal
        int grandTotal = adminFee + totalPaymentVal;

        // Populate GrandTotal Payment
        //String grandtotal_val = NumberFormat.getCurrencyInstance().format(grandtotal);
        TextView tvPaymentTotal = (TextView) findViewById(R.id.tv_payment_total);
        tvPaymentTotal.setText("Rp " + grandTotal);
    }

    /**
     * click finish button go to main activity
     *
     * @param view
     */
    public void finish(View view) {
        // got to main activity
        Intent intentMainActivity = new Intent(this, MainActivity.class);

        // start intent
        startActivity(intentMainActivity);
    }
}
