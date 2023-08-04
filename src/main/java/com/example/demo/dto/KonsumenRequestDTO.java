package com.example.demo.dto;

import lombok.Data;

@Data
public class KonsumenRequestDTO {
    private String nama;
    private String alamat;
    private String kota;
    private String provinsi;
    private String status;
}
