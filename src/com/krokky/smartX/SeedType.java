package com.krokky.smartX;

public class SeedType {
    private String seedless;
    private String seed;

    public SeedType(String seedless, String seed) {
        this.seedless = seedless;
        this.seed = seed;
    }

    public String getSeedless() {
        return seedless;
    }

    public void setSeedless(String seedless) {
        this.seedless = seedless;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    @Override
    public String toString() {
        return "SeedType{" +
                "seedless='" + seedless + '\'' +
                ", seed='" + seed + '\'' +
                '}';
    }
}
