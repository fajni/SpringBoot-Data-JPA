package com.springboot.springbootjpa.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StudentId implements Serializable {

    @Column(name = "student_id")
    private Integer id;

    @Column(name = "admission_year")
    private Integer admission_year;

    public StudentId(Integer id, Integer admission_year) {
        this.id = id;
        this.admission_year = admission_year;
    }

    public StudentId() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getAdmission_year() {
        return admission_year;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAdmission_year(Integer admission_year) {
        this.admission_year = admission_year;
    }
}
