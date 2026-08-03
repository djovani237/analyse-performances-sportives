package model;

public class AthleteCourse extends Athlete {
    public AthleteCourse(String nom) {
        super(nom, "Course");
    }

    @Override
    public double getMeilleurePerformance() {
        if (performances.isEmpty()) return 0.0;
        double min = performances.get(0);
        for (double p : performances) {
            if (p < min) min = p;
        }
        return min;
    }
}