package com.krokky.pro0512.reflectProgram;

public class Printer {

    private Ink ink;
    private Paper paper;

    public Printer() {
    }
    public Printer(Ink ink, Paper paper) {
        this.ink = ink;
        this.paper = paper;
    }

    public void Print(String s) {
        ink.color();
        paper.print(s);
    }
}
