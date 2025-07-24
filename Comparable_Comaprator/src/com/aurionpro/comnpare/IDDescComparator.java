package com.aurionpro.comnpare;
import java.util.Comparator;

public class IDDescComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s2.getId(), s1.getId());
    }
}