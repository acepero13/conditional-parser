package com.acepero13.research.conditionalparser;

import com.acepero13.research.conditionalparser.visitor.ParserBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String filename = args[0];

        File f = new File(filename);
        var conditions = ParserBuilder.of(new FileInputStream(f)).parse();
        System.out.println("conditions = " + conditions);
    }
}