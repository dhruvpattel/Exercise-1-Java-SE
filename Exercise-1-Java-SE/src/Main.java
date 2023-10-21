import java.util.Scanner;
class Coordinate{
    double x,y;

    public Coordinate(double x,double y){
        this.x=x;
        this.y=y;
    }
    public double distance(Coordinate other){
        return Math.sqrt(Math.pow(this.x-other.x,2)+Math.pow(this.y-other.y,2));
    }
}
class Triangle {
    Coordinate c1,c2,c3;

    public Triangle(Coordinate c1,Coordinate c2,Coordinate c3) {
        this.c1=c1;
        this.c2=c2;
        this.c3=c3;
    }
    public double perimeter() {
        double s1=c1.distance(c2);
        double s2=c2.distance(c3);
        double s3=c3.distance(c1);
        return s1+s2+s3;
    }
    public boolean isIsosceles() {
        double s1=c1.distance(c2);
        double s2=c2.distance(c3);
        double s3=c3.distance(c1);
        return s1==s2||s2==s3||s3==s1;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Coordinate[] points=new Coordinate[3];
        for (int i=0;i< 3;i++){
            System.out.println("Construction of a new point");
            System.out.print("Please enter x: ");
            double x = sc.nextDouble();
            System.out.print("Please enter y: ");
            double y = sc.nextDouble();
            points[i] = new Coordinate(x, y);
        }
        Triangle triangle=new Triangle(points[0],points[1],points[2]);
        double perimeter=triangle.perimeter();
        boolean isIsosceles=triangle.isIsosceles();

        System.out.println("Perimeter:"+perimeter);
        if (isIsosceles){
            System.out.println("The triangle is isosceles");
        }
        sc.close();
    }
}
