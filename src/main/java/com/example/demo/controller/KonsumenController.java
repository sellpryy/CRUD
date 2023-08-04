package com.example.demo.controller;

import com.example.demo.dto.KonsumenRequestDTO;
import com.example.demo.dto.PayloadDTO;
import com.example.demo.model.Konsumen;
import com.example.demo.service.KonsumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/konsumen")
@ResponseBody
public class KonsumenController {

    @Autowired
    private KonsumenService konsumenService;
    @PostMapping("/save") //Create
    public Konsumen saveKonsumen(@RequestBody  KonsumenRequestDTO konsumenRequestDTO) {
       Konsumen konsumen = new Konsumen();
       konsumen.setNama(konsumenRequestDTO.getNama());
       konsumen.setAlamat(konsumenRequestDTO.getAlamat());
       konsumen.setKota(konsumenRequestDTO.getKota());
       konsumen.setProvinsi(konsumenRequestDTO.getProvinsi());
       konsumen.setStatus(konsumenRequestDTO.getStatus());

       konsumenService.saveData(konsumen);


        return konsumen;
    }


    @GetMapping("/api/konsumen") //Read
    public List<Konsumen> getALlKonsumen() {
        return konsumenService.getAllData();
    }
    @GetMapping("/findbyid")
    public Optional<Konsumen> findById(@RequestParam("id_konsumen")  Long id_konsumen) {
       return konsumenService.findById(id_konsumen);
    }
    @GetMapping("/update")
    public void updateKonsumen(@RequestParam("id_konsumen") Integer id_konsumen) {
        KonsumenService.updateKonsumen(id_konsumen);
    }
    @DeleteMapping("/delete/{id}")
    public PayloadDTO deleteKonsumen(@PathVariable("id") Long id) {
        Optional<Konsumen> optionalKonsumen = konsumenService.findById(id);
        PayloadDTO payloadDTO = new PayloadDTO();
        if (!optionalKonsumen.isPresent()) {
            payloadDTO.setMessage("Data gak ada");
        }
        konsumenService.deleteData(id);
       payloadDTO.setMessage("data berhasil di apus"+id);
        return payloadDTO;
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Konsumen> updateKonsumen(@PathVariable("id") Long id,
                                                   @RequestBody KonsumenRequestDTO konsumenRequestDTO) {
        Optional<Konsumen> optionalKonsumen = konsumenService.findById(id);
        if (!optionalKonsumen.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Konsumen konsumen = optionalKonsumen.get();
        konsumen.setNama(konsumenRequestDTO.getNama());
        konsumen.setAlamat(konsumenRequestDTO.getAlamat());
        konsumen.setKota(konsumenRequestDTO.getKota());
        konsumen.setProvinsi(konsumenRequestDTO.getProvinsi());
        konsumen.setStatus(konsumenRequestDTO.getStatus());

        Konsumen updatedKonsumen = konsumenService.saveData(konsumen);
        return ResponseEntity.ok(updatedKonsumen);
    }




}
