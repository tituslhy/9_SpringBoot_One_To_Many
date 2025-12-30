package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save (Instructor theInstructor);

    Instructor findInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorById(int theId);

    /**
     * This method removes both the instructor detail AND the instructor
     * if cascade type is set to ALL in InstructorDetail
     * @param theId
     */
    void deleteInstructorDetailById(int theId);
}
