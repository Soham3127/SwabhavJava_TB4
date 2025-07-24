package com.aurionpro.comnpare;

import java.util.Comparator;

public class NameDescComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s2.getName().compareToIgnoreCase(s1.getName());
    }
}
