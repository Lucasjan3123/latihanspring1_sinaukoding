package com.example.sinaukoding.Controller;

import com.example.sinaukoding.Entity.dto.TransaksiDTO;
import com.example.sinaukoding.Service.implemen.TransaksiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaksi")
public class TransaksiController {
    @Autowired
    private TransaksiServiceImpl Service;

    @GetMapping("/find-all")
    public ResponseEntity<?> findAllData(){
        return new ResponseEntity<>(Service.findAllData(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveData(@RequestBody TransaksiDTO param){
        return new ResponseEntity<>(Service.save(param), HttpStatus.OK);
    }

    @PutMapping("/update/{id_pembeli}")
    public ResponseEntity<?> updateData(@PathVariable Integer id_transaksi,
                                        @RequestBody TransaksiDTO param){
        TransaksiDTO data = Service.update(param, id_transaksi);

        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/find-by-id/{id_transaksi}")
    public ResponseEntity<?> findById(@PathVariable Integer id_transaksi){
        return new ResponseEntity<>(Service.findById(id_transaksi ), HttpStatus.OK);
    }



    @DeleteMapping("/delete/{id_transaksi}")
    public ResponseEntity<?> deleteData(@PathVariable Integer id_transaksi) {
        if (Service.delete(id_transaksi)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}
