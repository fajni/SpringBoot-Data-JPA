package com.springboot.springbootjpa.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "teacher",
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email"
        )
)
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private int id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String email;

    @Column(
            name = "phone",
            columnDefinition = "varchar(255) default '/'" // default value
    )
    private String phone_number;

    @OneToOne(
            mappedBy = "teacher"
    )
    private Subject subject;

    public Teacher() {
    }

    public Teacher(int id, String firstname, String lastname, String email, String phone_number) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone_number = phone_number;
    }

    public Teacher(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Teacher(String firstname, String lastname, String email, String phone_number) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone_number = phone_number;
    }

    @Override
    public String toString(){
        return "\nId: "+id+"\n"+
                "Firstname: "+firstname+"\n"+
                "Lastname: "+lastname+"\n"+
                "Email: "+email+"\n"+
                "Phone number: "+phone_number+"\n"+
                "Subject: "+subject.getCode();
    }


    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
