package core;

public class Terminal extends Facility {

    private Integer terminalNumber;
    private Gate[] gates;

    public Terminal(String name, int capacity, int terminalNumber) {
        super(name, capacity);
        this.terminalNumber = terminalNumber;
    }

    public Integer getTerminalNumber() {
        return terminalNumber;
    }

    public void setTerminalNumber(Integer terminalNumber) {
        this.terminalNumber = terminalNumber;
    }

    public Gate[] getGates() {
        return gates;
    }

    public void setGates(Gate[] gates) {
        this.gates = gates;
    }
}
