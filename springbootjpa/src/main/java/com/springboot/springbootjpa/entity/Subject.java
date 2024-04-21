package com.springboot.springbootjpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @SequenceGenerator(
            name = "subject_sequence",
            sequenceName = "subject_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_sequence"
    )
    private Long code;

    private String title;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "id"
    )
    private Teacher teacher;

    public Subject() {
    }

    public Subject(String title, Teacher teacher) {
        this.title = title;
        this.teacher = teacher;
    }

    @Override
    public String toString(){
        return "\nCode: "+code+"\n"+
                "Title: "+title+"\n"+
                "Teacher ID: "+teacher.getId();
    }

    public Long getCode() {
        return code;
    }
}
