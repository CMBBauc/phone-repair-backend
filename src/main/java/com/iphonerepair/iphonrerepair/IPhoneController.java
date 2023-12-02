package com.iphonerepair.iphonrerepair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IPhoneController {
    @Autowired
    IPhoneService iphoneservice;

    IPhoneRepository iphonerepository;

    @CrossOrigin
    @GetMapping("/api/iPhones")
    @ResponseBody
    public List<IPhoneItem> getiPhones() {
        return iphoneservice.getiPhones();
    }
    @CrossOrigin
    @GetMapping("/api/getLatestPhone")
    @ResponseBody
    public IPhoneItem getLatest(@RequestParam("latest") String latest) {
        return iphoneservice.getLatestPhone(latest);
    }
    @CrossOrigin
    @GetMapping("/api/getIPhoneById")
    @ResponseBody
    public IPhoneItem getIPhoneById(@RequestParam("id") String id) {
        return iphoneservice.getIPhoneById(id);
    }
    @CrossOrigin
    @PostMapping("/api/createIPhone")
    public IPhoneItem createIPhone(@RequestBody IPhoneItem iPhoneItem) {
        return iphoneservice.createIPhone(iPhoneItem);
    }


    @CrossOrigin
    @PutMapping("/api/updateLatest")
    public void updateLatest(@RequestParam String isTrue, @RequestParam String isFalse) {
        iphoneservice.updatePrevLatestTo(isTrue, isFalse);
    }
    @PutMapping("/api/updatePhone")
    public void updateFieldOnMultipleEntities(@RequestParam String oldFieldValue, @RequestParam String newFieldValue) {
        iphoneservice.updateFieldOnMultipleEntities(oldFieldValue, newFieldValue);
    }
    @CrossOrigin
    @DeleteMapping("api/deleteIPhone")
    public String deleteIPhone (@RequestParam("id") String id) {
         if(iphoneservice.deleteIPhone(id) == 1) {
             return "iPhone deleted successfully.";
         } else {
             return "iPhone did not delete.";
         }
    }
}

