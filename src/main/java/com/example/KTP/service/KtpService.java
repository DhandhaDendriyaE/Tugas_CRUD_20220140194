package com.example.KTP.service;

import com.example.KTP.model.Ktp;
import com.example.KTP.repository.KtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KtpService {
    @Autowired
    private KtpRepository repository;

    public Ktp saveKtp(Ktp ktp) {
        if(repository.findByNomorKtp(ktp.getNomorKtp()).isPresent()) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }
        return repository.save(ktp);
    }

    public List<Ktp> getAllKtp() {
        return repository.findAll();
    }

    public Ktp getKtpById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan dengan ID: " + id));
    }

    public Ktp updateKtp(Long id, Ktp detailKtp) {
        Ktp ktp = getKtpById(id);
        ktp.setNamaLengkap(detailKtp.getNamaLengkap());
        ktp.setAlamat(detailKtp.getAlamat());
        ktp.setTanggalLahir(detailKtp.getTanggalLahir());
        ktp.setJenisKelamin(detailKtp.getJenisKelamin());
        return repository.save(ktp);
    }

    public void deleteKtp(Long id) {
        Ktp ktp = getKtpById(id);
        repository.delete(ktp);
    }
}