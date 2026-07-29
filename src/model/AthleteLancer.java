package model;

public class AthleteLancer extends Athlete {
    public AthleteLancer(String nom) {
        super(nom, "Lancer");
    }

    @Override
    public double getMeilleurePerformance() {
        if (performances.isEmpty()) return 0.0;
        double max = performances.get(0);
        for (double p : performances) {
            if (p > max) max = p;
        }
        return max;
    }
}