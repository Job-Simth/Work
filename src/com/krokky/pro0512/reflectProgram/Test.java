package com.krokky.pro0512.reflectProgram;

public class Test {
    public static void main(String[] args) {
        Ink color = new ColorInk();
        Ink gray = new GrayInk();

        Paper a4 = new A4TextPaper();
        Paper a6 = new A6TextPaper();

        Printer printer =new Printer(gray,a4);
        printer.Print("zdsrafxcdvegdtcyvhgbvnvjfuvhvytifjvngmhkbjfhgtvh");
    }
}
