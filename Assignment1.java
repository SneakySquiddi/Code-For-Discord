import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] equation = new String[3];

        equation = readString();

        try {
            System.out.println(equation[0] + " " + equation[1] + " " + equation[2]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        }
        String answer = performOperation(equation);

        PrintAnswer(answer);
    }

    public static String[] readString() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the operation you would like the calculator to perform.");
        System.out.println("Example: 2 + 9, 193 - 58, etc.");
        String fullOperation = sc.nextLine();
        String[] equation = new String[3];
        equation = fullOperation.split(" ");

        return equation;
    }

    public static String performOperation(String[] operators) {
        double num1 = 0.0;
        String operator = "";
        double num2 = 0.0;
        try {
            num1 = Double.parseDouble(operators[0]);
            operator = operators[1];
            num2 = Double.parseDouble(operators[2]);
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
            System.exit(0);
        }
        if(operator.equals("+")) return "Your answer is: " + (String.format("%.3g%n", num1 + num2));
        else if(operator.equals("-")) return "Your answer is: " + (String.format("%.3g%n", num1 - num2));
        else if(operator.equals("*")) return "Your answer is: " + (String.format("%.3g%n", num1 * num2));
        else if(operator.equals("/")){
                if (num2 == 0){
                return "Error: Can not divide by zero.";
                }
            return "Your answer is: " + (String.format("%.3g%n", num1 / num2));
        }

        return "Error: Invalid function.";
    }

    public static void PrintAnswer(String result){
        String stringresult = result;

        System.out.println(stringresult);
    }

}
