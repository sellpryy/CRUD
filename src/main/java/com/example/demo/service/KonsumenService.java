package com.example.demo.service;

import com.example.demo.model.Konsumen;
import com.example.demo.repository.KonsumenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KonsumenService {
    @Autowired
    private KonsumenRepository konsumenRepository;
    //Create
    public Konsumen saveData(Konsumen konsumen){
        System.out.println("INI ADALAH NAMA:"+konsumen.getNama());
        konsumenRepository.save(konsumen);
        return konsumen;
    }
    //Read
    public List<Konsumen> getAllData(){
        return konsumenRepository.findAll();
    }

    //Findbyid
    public Optional<Konsumen> findById(Long idKonsumen) {
        System.out.println("ini update service");
        System.out.println(idKonsumen);
        Optional<Konsumen> konsumen = konsumenRepository.findById(idKonsumen);

        return konsumen;
    }

    // Update
    public static void updateKonsumen(Integer idKonsumen) {
        System.out.println("ini konsumen");
        System.out.println(idKonsumen);


    //Delete


}

    public void deleteData(Long id) {
        konsumenRepository.deleteById(id);
    }
}
