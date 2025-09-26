package core;

public enum SecurityLevel {

    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private final int priority;

    SecurityLevel(int priority) {
        this.priority = priority;
    }

    public int getPriority() { return priority; }

    public String policy() { return "Standard"; }

    public boolean Supervisor() { return priority >= 3; }
}

