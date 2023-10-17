public class Complex {
    private double realPart;
    private double imaginaryPart;

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public void showData() {
        System.out.println(realPart + " + i" + imaginaryPart );
    }

    public float Modul() {
        return (float) Math.sqrt(realPart * realPart + imaginaryPart * imaginaryPart);
    }

    public static void main(String[] args) {
        Complex[] complexArray = new Complex[3];

        complexArray[0] = new Complex(1, 2);
        complexArray[1] = new Complex(2, 3);
        complexArray[2] = new Complex(3, 4);

        for (Complex complexNumber : complexArray) {
            complexNumber.showData();
        }

        double sumOfModulus = 0;

        for (Complex complexNumber : complexArray) {
            sumOfModulus += complexNumber.Modul();
        }

        System.out.println("Сумма модулей: " + sumOfModulus);
    }
}