package com.example.KTP.repository;

import com.example.KTP.model.Ktp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KtpRepository extends JpaRepository<Ktp, Long> {
    Optional<Ktp> findByNomorKtp(String nomorKtp);
}