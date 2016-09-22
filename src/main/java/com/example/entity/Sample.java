package com.example.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zarra on 16/8/25.
 */
@Table(name = "t_sample")
@Entity
public class Sample {
    String id;

    String value;

    @Id
    @JacksonXmlProperty(localName = "iiid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
