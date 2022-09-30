package com.example.sinaukoding.Controller;

import com.example.sinaukoding.Entity.dto.PembayaranDTO;
import com.example.sinaukoding.Service.implemen.PembayaranServiceImpl;
import com.example.sinaukoding.common.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pembayaran")
public class PembayaranController {
    @Autowired
    private PembayaranServiceImpl Service;

    @GetMapping("/find-all")
    public Response findAllData(){
        List<PembayaranDTO> data= Service.findAllData();
        return new Response(data, "Get All data pembayaran",data.size(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveData(@RequestBody PembayaranDTO param){
        return new ResponseEntity<>(Service.save(param), HttpStatus.OK);
    }

    @PutMapping("/update/{id_pembayaran}")
    public ResponseEntity<?> updateData(@PathVariable Integer id_pembayaran,
                                        @RequestBody PembayaranDTO param){
        PembayaranDTO data = Service.update(param, id_pembayaran);

        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/find-by-id/{id_pembayaran}")
    public Response findById(@PathVariable Integer id_pembayaran){
        return new Response(Service.findById(id_pembayaran), "berhasil mengambil data",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id_pembayaran}")
    public ResponseEntity<?> deleteData(@PathVariable Integer id_pembayaran) {
        if (Service.delete(id_pembayaran)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

}
