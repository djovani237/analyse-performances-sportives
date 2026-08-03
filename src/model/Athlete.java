package model;

import java.util.ArrayList;
import exception.DonneesInvalidesException;
import java.util.List;

public abstract class Athlete implements PerformanceEvaluable, Comparable<Athlete> {

    private String nom;

    private String discipline;

    protected List<Double> performances;

    public Athlete(String nom, String discipline) {

        this.nom = nom;

        this.discipline = discipline;

        this.performances = new ArrayList<>();

    }

    public void ajouterPerformance(double perf) throws DonneesInvalidesException {

        if (perf <= 0) {

            throw new DonneesInvalidesException("La performance doit être strictement positive (" + perf + " reçue pour " + nom + ").");

        }

        performances.add(perf);

    }

    public String getNom() { return nom; }

    public String getDiscipline() { return discipline; }

    public List<Double> getPerformances() { return performances; }

    @Override

    public double getMoyennePerformances() {

        if (performances.isEmpty()) return 0.0;

        double somme = 0;

        for (double p : performances) {

            somme += p;

        }

        return somme / performances.size();

    }

    @Override

    public int compareTo(Athlete autre) {

        return Double.compare(autre.getMeilleurePerformance(), this.getMeilleurePerformance());

    }

}

