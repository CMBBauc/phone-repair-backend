package com.iphonerepair.iphonrerepair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPhoneService {

    @Autowired
    IPhoneRepository iphonerepository;

    public List<IPhoneItem> getiPhones() {return iphonerepository.findAll(); }

    public IPhoneItem createIPhone(IPhoneItem iPhoneItem) {
        iphonerepository.save(iPhoneItem);
        return iPhoneItem;
    }

    public void updatePrevLatestTo(String isTrue, String isFalse) {
        List<IPhoneItem> entities = iphonerepository.findByLatest(isTrue);

        for (IPhoneItem entity : entities) {
            entity.setLatest(isFalse);
        }

        iphonerepository.saveAll(entities);
    }
    public void updateFieldOnMultipleEntities(String oldFieldValue, String newFieldValue) {
        List<IPhoneItem> entities = iphonerepository.findByConfiguration(oldFieldValue);

        for (IPhoneItem entity : entities) {
            entity.setConfiguration(newFieldValue);
        }

        iphonerepository.saveAll(entities);
    }

    public IPhoneItem getIPhoneById(String id) {
        return iphonerepository.findById(id);
    }

    public IPhoneItem getLatestPhone(String latest) {
        return iphonerepository.findByTrueLatest(latest);
    }


    public int deleteIPhone(String id) {
        IPhoneItem iPhoneItem = iphonerepository.findById(id);

        if (iPhoneItem != null) {
            iphonerepository.delete(iPhoneItem);
            return 1;
        }
        return -1;
    }
}
