package com.example.sinaukoding.Controller;

import com.example.sinaukoding.Entity.dto.BarangDTO;
import com.example.sinaukoding.Entity.dto.PembayaranDTO;
import com.example.sinaukoding.Service.implemen.BarangServiceImpl;
import com.example.sinaukoding.common.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/barangs")

public class BarangController {
    @Autowired
    private BarangServiceImpl Service;

    @GetMapping("/find-all")
    public Response findAllData(){
        List<BarangDTO> data= Service.findAllData();
        return new Response(data, "Get All data pembayaran",data.size(),HttpStatus.OK);

    }

    @PostMapping( "/create")
    public ResponseEntity<?> saveData(@RequestBody BarangDTO param){
        return new ResponseEntity<>(Service.save(param), HttpStatus.OK);

    }

    @PutMapping("/update/{id_barang}")
    public ResponseEntity<?> updateData(@PathVariable Integer id_barang,
                                        @RequestBody BarangDTO param){
        BarangDTO data = Service.update(param, id_barang);

        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/find-by-id/{id_barang}")
    public Response findById(@PathVariable Integer id_barang){
        return new Response(Service.findById(id_barang), "berhasil mengambil data",HttpStatus.OK);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<?> findById2(@RequestParam(name = "id_barang") Integer id_barang){
        return new ResponseEntity<>(Service.findById(id_barang), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id_barang}")
    public Response deleteData(@PathVariable Integer id_barang) {
        if (Service.delete(id_barang)) {
            return new Response( "data berhasil dihapus",HttpStatus.OK);
        } else {
            return new Response(  "data berhasil dihapus",HttpStatus.BAD_REQUEST);
        }
    }
   }
