/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gybran.nilai.vo;

/**
 *
 * @author Gybran
 */
public class Matkul {
    private Long id;
    private String kode;
    private String nama;
    private Integer sks;

    public Matkul() {
    }

    public Matkul(Long id, String kode, String nama, Integer sks) {
        this.id = id;
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getSks() {
        return sks;
    }

    public void setSks(Integer sks) {
        this.sks = sks;
    }

    @Override
    public String toString() {
        return "Matkul{" + "id=" + id + ", kode=" + kode + ", nama=" + nama + ", sks=" + sks + '}';
    }

    

    
}
