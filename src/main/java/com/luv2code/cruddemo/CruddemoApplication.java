package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    /**
     * Shorthand command line interface runner
     * @param appDAO
     * @return
     */
    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO){
        return runner -> {
//            createInstructor(appDAO);
//            findInstructor(appDAO);
//            deleteInstructor(appDAO);
//            findInstructorDetail(appDAO);
            deleteInstructorDetail(appDAO);
        };
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 4;
        System.out.println("Deleting instructor detail id: " + theId);
        appDAO.deleteInstructorDetailById(theId);
        System.out.println("Done");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int theId = 1;
        InstructorDetail detail = appDAO.findInstructorDetailById(theId);
        System.out.println(detail);
        System.out.println(detail.getInstructor());
        System.out.println("Done");
    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 2;
        System.out.println("Deleting instructor: " +  theId);
        appDAO.deleteInstructorById(theId);
        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding the instructor of id:  " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("Instructor: " + tempInstructor);
        System.out.println("Instructor details: " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {

//        // Create the instructor
//        Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//
//        // Create the instructor detail
//        InstructorDetail tempInstructorDetail = new InstructorDetail(
//                "http://www.luv2code.com/youtube",
//                "Luv 2 code!!!"
//        );

        // Create the instructor
        Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhuy@luv2code.com");

        // Create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "http://www.luv2code.com/youtube",
                "Guitar"
        );

        // Associate the objects - you need to set the instruction detail in your instructor
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // Save the instructor. Note this will also save the details object
        // because of CascadeType.ALL
        System.out.println("Saving instructor: " + tempInstructor);

        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

}
