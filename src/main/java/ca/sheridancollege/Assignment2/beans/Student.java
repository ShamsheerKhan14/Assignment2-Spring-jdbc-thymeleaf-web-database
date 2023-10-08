package ca.sheridancollege.Assignment2.beans;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String programName;
    private int programYear;
    private Boolean programCoop;
    private Boolean programInternship;

    public Student(int id, String firstName, String lastName, String programName, int programYear, Boolean programCoop, Boolean programInternship) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.programName = programName;
        this.programYear = programYear;
        this.programCoop = programCoop;
        this.programInternship = programInternship;
    }
    public Student() {
    }

}
