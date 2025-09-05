package core;

public class Terminal {

    private int terminalNumber;
    private Gate[] gates;

    public Terminal(int terminalNumber) {
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
