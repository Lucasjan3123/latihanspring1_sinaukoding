package com.example.Sinaukoding.Controller;

import com.example.Sinaukoding.Entity.dto.PembeliDTO;
import com.example.Sinaukoding.Service.implemen.PembeliServiceImpl;
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

    @PutMapping("/update/{id_pembeli}")
    public ResponseEntity<?> updateData(@PathVariable Integer id_pembeli,
                                        @RequestBody PembeliDTO param){
       PembeliDTO data = Service.update(param, id_pembeli);

        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/find-by-id/{id_pembeli}")
    public ResponseEntity<?> findById(@PathVariable Integer id_pembeli){
        return new ResponseEntity<>(Service.findById(id_pembeli), HttpStatus.OK);
    }

    

    @DeleteMapping("/delete/{id_pembeli}")
    public ResponseEntity<?> deleteData(@PathVariable Integer id_pembeli) {
        if (Service.delete(id_pembeli)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}
