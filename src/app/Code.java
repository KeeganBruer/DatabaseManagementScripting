package app;

import java.util.ArrayList;

public class Code {
    private ArrayList<CodeLine> lines;
    public Code() {
        lines = new ArrayList<CodeLine>();
    }

    public void addLine(CodeLine line){
        lines.add(line);
    }
}