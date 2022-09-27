package com.example.sinaukoding.Controller;

import com.example.sinaukoding.Entity.dto.PembeliDTO;
import com.example.sinaukoding.Service.implemen.PembeliServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembeli")
public class PembeliController {
    @Autowired
    private PembeliServiceImpl Service;

    @GetMapping("/find-all")
    public ResponseEntity<?> findAllData(){
        return new ResponseEntity<>(Service.findAllData(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveData(@RequestBody PembeliDTO param){
        return new ResponseEntity<>(Service.save(param), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateData(@PathVariable Integer id_pembeli,
                                        @RequestBody PembeliDTO param){
       PembeliDTO data = Service.update(param, id_pembeli);

        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id_pembeli){
        return new ResponseEntity<>(Service.findById(id_pembeli), HttpStatus.OK);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<?> findById2(@RequestParam(name = "id_pembeli") Integer id_pembeli){
        return new ResponseEntity<>(Service.findById(id_pembeli), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteData(@PathVariable Integer id_pembeli) {
        if (Service.delete(id_pembeli)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}
