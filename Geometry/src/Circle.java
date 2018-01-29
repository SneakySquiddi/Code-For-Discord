public class Circle {
    public static float area(float radius){
        return (float) (Math.PI * radius * Math.pow(radius, 2));
    }
    public static float circumference(float radius){
        return (float) (Math.PI * 2 * radius);
    }
}
