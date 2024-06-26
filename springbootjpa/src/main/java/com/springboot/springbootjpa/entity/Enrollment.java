package com.springboot.springbootjpa.entity;

import com.springboot.springbootjpa.id.EnrollmentId;
import com.springboot.springbootjpa.id.StudentId;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "enrollment")
public class Enrollment {

    @EmbeddedId
    private EnrollmentId enrollmentId;

    @Column(name = "date", nullable = false)
    private Date date_of_enrollment;

    /*
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "id", referencedColumnName = "student_id"),
            @JoinColumn(name = "admission_year", referencedColumnName = "admission_year"),
    })
    private Student student;
    */

    public Enrollment() {
    }

    public Enrollment(EnrollmentId enrollmentId, Date date_of_enrollment) {
        this.enrollmentId = enrollmentId;
        this.date_of_enrollment = date_of_enrollment;
    }
}
