package edu.kirkwood.cis171;
import java.util.Scanner;

public class Assignment515 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        double[] Scores = new double[5];

        printHeader();

        for (int x = 0; x < 5; x++){
            Scores[x] = promptForAnswer();
        }

        for (int k = 0; k < 5; k++){
            printRow(k + 1, Scores[k], determineGrade(Scores[k]));
        }

        printFooter(calculateAverage(Scores), determineGrade(calculateAverage(Scores)));

    }

    public static void printHeader(){
        System.out.println("Score\t\tNumeric Grade\t\tLetter Grade");
        System.out.println("--------------------------------------");
    }
    public static void printRow(int num, double score, String letterGrade){
        System.out.println("Score " + num + ":\t" + score + "\t\t" + letterGrade);
    }
    public static void printFooter(double average, String letterGrade){
        System.out.println("--------------------------------------");
        System.out.println("Average score:\t" + average + "\t\t" + letterGrade);
    }

    public static double calculateAverage(double[] AllScores){

        int total = 0;
        for (int x = 0; x < 5; x++){
            total += AllScores[x];
        }

        return total / 5;
    }

    public static String determineGrade(double num){
        if (num >= 90) return "A";
        else if (num >= 80) return "B";
        else if (num >= 70) return "C";
        else if (num >= 60) return "D";
        else return "F";
    }

    public static double promptForAnswer(){
        System.out.println("Please enter score: ");
        String score = scanner.nextLine();
        double actualscore = Double.parseDouble(score);
        return actualscore;
    }
}
