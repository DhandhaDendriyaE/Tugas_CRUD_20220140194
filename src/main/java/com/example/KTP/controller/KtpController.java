package com.example.KTP.controller;

import com.example.KTP.model.Ktp;
import com.example.KTP.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ktp")
public class KtpController {
    @Autowired
    private KtpService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Ktp ktp) {
        try {
            return ResponseEntity.ok(service.saveKtp(ktp));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Ktp> getAll() {
        return service.getAllKtp();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getKtpById(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Ktp ktp) {
        try {
            return ResponseEntity.ok(service.updateKtp(id, ktp));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.deleteKtp(id);
            return ResponseEntity.ok("Data berhasil dihapus");
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
