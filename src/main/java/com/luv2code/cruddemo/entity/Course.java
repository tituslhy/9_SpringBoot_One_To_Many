package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * If we delete the course we want to delete all associated reviews
     */
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="course_id")
    private List<Review> reviews;

    public Course(String title) {
        this.title = title;
    }

    public void addReview(Review theReview){
        if (reviews == null){
            reviews = new ArrayList<>();
        }
        reviews.add(theReview);
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
