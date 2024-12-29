package com.example.h12.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Mahasiswa (
    val nim: String,
    val nama: String,
    val alamat: String,

    @SerialName("jenis_kelamin")
    val jenisKelamin: String,

    val kelas: String,
    val angkatan: String
)