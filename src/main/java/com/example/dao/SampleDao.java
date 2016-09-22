package com.example.dao;

import com.example.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by zarra on 16/8/25.
 */
public interface SampleDao extends JpaRepository<Sample,String> {
    @Query("select s from Sample s where s.id = ?1 ")
    Sample findById(String id);
}
