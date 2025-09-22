package core;

import java.util.List;
import java.util.ArrayList;

public class Terminal extends Facility {

    private Integer terminalNumber;
    private List<Gate> gates;

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

    public List<Gate> getGates() { return new ArrayList<>(gates); }
    public void setGates(List<Gate> gates) { this.gates = new ArrayList<>(gates); }
}
