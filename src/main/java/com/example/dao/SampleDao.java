package com.example.dao;

import com.example.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zarra on 16/8/25.
 */
public interface SampleDao extends JpaRepository<Sample,String> {
}
