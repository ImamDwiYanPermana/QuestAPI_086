package com.example.h12.service

import com.example.h12.data.Mahasiswa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

/**
 * Interface Retrofit untuk operasi CRUD pada entitas Mahasiswa.
 * Berkomunikasi dengan REST API menggunakan HTTP methods: GET, POST, PUT, DELETE.
 */

interface MahasiswaService {

    //Menambahkan header ke setiap permintaan HTTP
    @Headers(
        "Accept: application/json",//Menerima data dalam format JSON
        "Content-Type: application/json",// Mengirim data dalam format JSON
    )

    /**
     * Mendapatkan daftar semua Mahasiswa dari server.
     * Endpoint: bacamahasiswa.php
     * @return List<Mahasiswa> - daftar mahasiswa dalam format JSON.
     */
    @GET("bacamahasiswa.php")
    suspend fun getMahasiswa(): List<Mahasiswa>


    /**
     * Mendapatkan data Mahasiswa berdasarkan NIM.
     * Endpoint: baca1mahasiswa.php/{nim}
     * @param - NIM mahasiswa.
     * @return Mahasiswa - objek mahasiswa berdasarkan NIM.
     */
    @GET("baca1mahasiswa.php/{nim}")
    suspend fun getMahasiswaById(@Query("nim") nim:String): Mahasiswa


    /**
     * Menambahkan data Mahasiswa baru ke server.
     * Endpoint: insertmahasiswa.php
     * @param: mahasiswa:Mahasiswa - data mahasiswa yang akan ditambahkan.
     */
    @POST("insertmahasiswa.php")
    suspend fun insertMahasiswa(@Body mahasiswa: Mahasiswa)

    /**
     * Memperbarui data Mahasiswa berdasarkan NIM.
     * Endpoint: editmahasiswa.php/{nim}
     * @param:nim String - NIM mahasiswa.
     * @param:mahasiswa Mahasiswa - data mahasiswa yang diperbarui.
     */
    @PUT("editmahasiswa.php/{nim}")
    suspend fun updateMahasiswa(@Query("nim")nim: String, @Body mahasiswa: Mahasiswa)

    /**
     * Menghapus data Mahasiswa berdasarkan NIM.
     * Endpoint: deletemahasiswa.php/{nim}
     * @param nim String - NIM mahasiswa.
     * @return Response<Void> - respons HTTP dari server (berhasil/gagal).
     */

    @DELETE("deletemahasiswa.php/{nim}")
    suspend fun deleteMahasiswa(@Query("nim")nim: String): Response<Void>
}