import java.util.Scanner;

public class Geometry {
    static int areaCircleChoice = 1;
    static int circumferenceChoice = 2;
    static int areaRectangleChoice = 3;
    static int perimeteterRectangleChoice = 4;
    static int quitChoice = 5;

    public static void main(String[] args){
        int choice = 0;
        while(choice != quitChoice){
            String menu = displayMenu();
            System.out.println(menu);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the number of your choice.");
            String userInput = scanner.nextLine();
            choice = Integer.parseInt(userInput);

            if (choice == areaCircleChoice){
                System.out.println("Enter the circle's radius.");
                float radius = Float.parseFloat(scanner.nextLine());
                float area = Circle.area(radius);
                System.out.println("The area is " + Float.toString(area));
            } else if (choice == circumferenceChoice){
                System.out.println("Enter the circle's radius.");
                float radius = Float.parseFloat(scanner.nextLine());
                float circumference = Circle.circumference(radius);
                System.out.println("The circumference is " + Float.toString(circumference));
            } else if (choice == areaRectangleChoice){
                System.out.println("Enter the rectangle's width.");
                float width = Float.parseFloat(scanner.nextLine());
                System.out.println("Enter the rectangle's length.");
                float length = Float.parseFloat(scanner.nextLine());
                float area = Rectangle.area(width, length);
                System.out.println("The area is " + Float.toString(area));
            } else if (choice == perimeteterRectangleChoice){
                System.out.println("Enter the rectangle's width.");
                float width = Float.parseFloat(scanner.nextLine());
                System.out.println("Enter the rectangle's length.");
                float length = Float.parseFloat(scanner.nextLine());
                float perimeter = Rectangle.perimeter(width, length);
                System.out.println("The perimeter is " + Float.toString(perimeter));
            } else if (choice == quitChoice){
                System.out.println("Exiting the program...");
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    private static String displayMenu() {
        String menu = "Menu\n1) Area of a Circle\n2) Circumference of a circle\n3) Area of a rectangle\n4) Perimeter of a rectangle\n5) Quit";
        return menu;
    }
}
