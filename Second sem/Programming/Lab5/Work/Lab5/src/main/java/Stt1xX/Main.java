package Stt1xX;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;

class Main{
    public static void main(String[] args){
        Deque<Movie> movies = new ArrayDeque<>();
        try {
            PrintWriter fileOutput = new PrintWriter("XML.txt");
            fileOutput.flush();
            fileOutput.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}