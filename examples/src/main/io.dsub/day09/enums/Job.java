package io.dsub.day09.enums;

public enum Job {
    STUDENT("Jack"), MARKETING("Orlando"), DEVELOPER("Jeff"), CHIEF("Cathy"), CHIEF_EXECUTIVE_OFFICER("Elon"); // Enumeration Constant

    private final String name;

    Job(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Job nextJob() {
        for (int i = 0; i < Job.values().length; i++) {
            if (this == Job.values()[i]) {
                if (i == Job.values().length - 1)
                    return Job.values()[0];
                return Job.values()[i + 1];
            }
        }
        return null;
    }
}
