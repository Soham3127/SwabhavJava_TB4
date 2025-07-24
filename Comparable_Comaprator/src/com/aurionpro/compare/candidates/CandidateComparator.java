package com.aurionpro.compare.candidates;
import java.util.Comparator;

public class CandidateComparator implements Comparator<Candidate> {
    @Override
    public int compare(Candidate c1, Candidate c2) {
        int nameCompare = c1.getName().compareToIgnoreCase(c2.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }
        return Integer.compare(c1.getAge(), c2.getAge());
    }
}

