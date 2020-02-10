package com.dreamlight.saku.api;

import com.dreamlight.saku.Login;
import com.dreamlight.saku.model.AbsenKelas.AbsenKelasList;
import com.dreamlight.saku.model.AbsenKelas.AbsenSimpanDataModel;
import com.dreamlight.saku.model.AbsenKelas.SimpanAbsenModel;
import com.dreamlight.saku.model.DaftarSiswa.DaftarSiswaListModel;
import com.dreamlight.saku.model.DaftarSiswa.DaftarSiswaModel;
import com.dreamlight.saku.model.Jadwal.JadwalListModel;
import com.dreamlight.saku.model.JadwalSekarang.ListJadwalSekarangModel;
import com.dreamlight.saku.model.kodePPModel;
import com.dreamlight.saku.model.loginModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @FormUrlEncoded
    @POST("LoginGuru.php?fx=login")
    Call<loginModel> login (
        @Field("nik") String nik,
        @Field("pass") String pass,
        @Field("kode_pp") String kode_pp
            );

    @FormUrlEncoded
    @POST("Login.php?fx=getDaftarPP")
    Call<kodePPModel> getPP (
        @Field("nis") String nik
    );


    @GET("Guru.php?fx=getJadwalSekarang")
    Call<ListJadwalSekarangModel> getJadwalSekarang (
        @Query("kode_pp") String kode_pp,
        @Query("kode_ta") String kode_ta,
        @Query("nik") String nik,
        @Query("kode_hari") String kode_hari,
        @Query("kode_lokasi") String kode_lokasi
    );

    @GET("Guru.php?fx=getJadwal")
    Call<JadwalListModel> getJadwalHari(
      @Query("kode_pp") String kode_pp,
      @Query("kode_lokasi") String kode_lokasi,
      @Query("kode_ta") String kode_ta,
      @Query("nik") String nik
    );

    @GET("Guru.php?fx=getDaftarSiswa")
    Call<DaftarSiswaListModel> getDaftarSiswa(
            @Query("kode_pp") String kode_pp,
            @Query("kode_lokasi") String kode_lokasi,
            @Query("kode_kelas") String kode_kelas
    );

    @GET("Guru.php?fx=getAbsenTotal")
    Call<AbsenKelasList> getAbsenKelas(
            @Query("kode_pp") String kode_pp,
            @Query("kode_lokasi") String kode_lokasi,
            @Query("kode_ta") String kode_ta,
            @Query("nik") String nik,
            @Query("kode_hari") String kode_hari,
            @Query("jam") String jam,
            @Query("tanggal") String tanggal
    );


    @POST("Guru.php?fx=insertAbsen")
    Call<SimpanAbsenModel> simpanAbsen(
            @Body AbsenSimpanDataModel absen
            );
}
