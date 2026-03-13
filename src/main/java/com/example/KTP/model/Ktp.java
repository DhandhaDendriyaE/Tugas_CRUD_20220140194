package com.example.KTP.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "KTP")
public class Ktp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nomorKtp;

    private String namaLengkap;
    private String alamat;
    private LocalDate tanggalLahir;
    private String jenisKelamin;

    // Getter dan Setter
}
