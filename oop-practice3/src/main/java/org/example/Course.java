package org.example;

public class Course {
    private final String subject; // 과목
    private final int credit;     // 학점
    private final String grade;   // 성적 (A+, A, B+ ...)

    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    /**!!!!!!!!!!!!!!!!!!!!매우 중요!!!!!!!!!!!!!!!!!!!**/
    // getter 를 통해서 정보를 가져와 처리하는 방식이아닌
    // 정보를 가진 객체에게 처리를 요청한 후
    // 처리된 값을 가져오는 것이 바람직하다.
    /**!!!!!!!!!!!!!!!!!!!!매우 중요!!!!!!!!!!!!!!!!!!!**/
    public double multiplyCreditAndCourseGrade() {
        return credit * getGradeToNumber();
    }

    public int getCredit() {
        return credit;
    }

    public double getGradeToNumber() {
        double grade = 0;
        switch (this.grade) {
            case "A+":
                grade = 4.5;
                break;
            case "A":
                grade = 4.0;
                break;
            case "B+":
                grade = 3.5;
                break;
            case "B":
                grade = 3.0;
                break;
            case "C+":
                grade = 2.5;
                break;
            case "C":
                grade = 2.0;
                break;
        }
        return grade;
    }
}
