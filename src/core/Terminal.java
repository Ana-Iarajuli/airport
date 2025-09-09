package core;

public class Terminal extends Facility {

    public int terminalNumber;
    private Gate[] gates;

    public Terminal(String name, int capacity, int terminalNumber) {
        super(name, capacity);
        this.terminalNumber = terminalNumber;
    }

    public int getTerminalNumber() {
        return terminalNumber;
    }

    public void setTerminalNumber(int terminalNumber) {
        this.terminalNumber = terminalNumber;
    }

    public Gate[] getGates() {
        return gates;
    }

    public void setGates(Gate[] gates) {
        this.gates = gates;
    }
}
