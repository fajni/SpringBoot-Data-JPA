package com.springboot.springbootjpa.entity;

import com.springboot.springbootjpa.id.StudentId;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "student",
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email"
        )
)
public class Student {

    @EmbeddedId
    private StudentId studentId;

    @Column(nullable = false, name = "firstname")
    private String firstname;

    @Column(nullable = false, name = "lastname")
    private String lastname;

    @Column(nullable = false)
    private String email; // unique email for every Student (uniqueConstraints)

    @Column(
            name = "phone",
            nullable = true
    )
    private String phone_number;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "student_id", referencedColumnName = "student_id"),
            @JoinColumn(name = "admission_year", referencedColumnName = "admission_year")
    })
    private List<Enrollment> enrollments;

    public Student() {
    }

    public Student(StudentId id, String firstname, String lastname, String email, String phone_number) {
        super();
        this.studentId = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone_number = phone_number;
    }

    public Student(StudentId id, String firstname, String lastname, String email) {
        super();
        this.studentId = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Student(String firstname, String lastname, String email, String phone_number) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone_number = phone_number;
    }

    public Student(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nId: "+studentId.getId()+"\n"+
                "Admission Year: "+studentId.getAdmission_year()+"\n"+
                "Firstname: "+firstname+"\n"+
                "Lastname: "+lastname+"\n"+
                "Email: "+email+"\n"+
                "Phone: "+phone_number;
    }


    public StudentId getStudentId() {
        return studentId;
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

    public void setStudentId(StudentId studentId) {
        this.studentId = studentId;
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
