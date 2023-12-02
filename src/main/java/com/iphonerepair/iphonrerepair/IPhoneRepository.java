package com.iphonerepair.iphonrerepair;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IPhoneRepository extends MongoRepository<IPhoneItem, Long> {
    IPhoneItem findById(String id);

    @Query("{ 'latest' : 'true'}")
    IPhoneItem findByTrueLatest(String latest);

    List<IPhoneItem> findByConfiguration(String configuration);
    @Query("{'configuration': ?0}")
    void updateFieldOnMultipleEntities(String newFieldValue);
    List<IPhoneItem> findByLatest(String latest);
    @Query("{'latest': ?0}")
    void updatePrevLatest(String isFalse);






}
