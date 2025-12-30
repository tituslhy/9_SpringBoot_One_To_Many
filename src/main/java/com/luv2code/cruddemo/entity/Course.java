package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="course")
@Getter
@Setter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    /**
     * Note: We don't want cascade type to be all.
     */
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="instructor_id")
    private Instructor instructor;

    public Course(String title) {
        this.title = title;
    }

    /**
     * Remember to not include the Instructor class or toString
     * will fail
     * @return String
     */
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
