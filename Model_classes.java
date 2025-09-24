// com.ccrm.model.Student.java
package com.ccrm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Student extends Person {
    private final String studentId;
    private final List<Enrollment> enrollments = new ArrayList<>();

    public Student(String studentId, String name, String email) {
        super(name, email);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    // Nested class to represent a grade entry on the transcript
    public class Transcript {
        private final List<GradeEntry> gradeEntries = new ArrayList<>();

        public void addGradeEntry(String courseCode, double grade) {
            this.gradeEntries.add(new GradeEntry(courseCode, grade));
        }

        public double calculateGPA() {
            if (gradeEntries.isEmpty()) {
                return 0.0;
            }
            double totalPoints = gradeEntries.stream()
                .mapToDouble(GradeEntry::getGradePoints)
                .sum();
            return totalPoints / gradeEntries.size();
        }

        @Override
        public String toString() {
            StringBuilder transcript = new StringBuilder("--- Transcript for " + getName() + " ---\n");
            gradeEntries.forEach(entry -> transcript.append(entry).append("\n"));
            transcript.append("-----------------------------\n");
            transcript.append(String.format("GPA: %.2f", calculateGPA()));
            return transcript.toString();
        }

        private class GradeEntry {
            private final String courseCode;
            private final double grade;

            public GradeEntry(String courseCode, double grade) {
                this.courseCode = courseCode;
                this.grade = grade;
            }

            public double getGradePoints() {
                // Simplified conversion: 90-100 -> 4.0, 80-89 -> 3.0, etc.
                if (grade >= 90) return 4.0;
                if (grade >= 80) return 3.0;
                if (grade >= 70) return 2.0;
                return 0.0;
            }

            @Override
            public String toString() {
                return String.format("Course: %s, Grade: %.2f", courseCode, grade);
            }
        }
    }
}
