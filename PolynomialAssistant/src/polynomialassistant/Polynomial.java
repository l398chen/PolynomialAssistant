package polynomialassistant;

public class Polynomial {
    int degree;
    int[] coefficients = new int[degree];
    
    public Polynomial(int d, int[] c) {
        degree = d;
        coefficients = c;
    }
    
    public Polynomial(String p) {
        int degIndex = p.indexOf("^");
        degree = Integer.parseInt(p.substring(degIndex, degIndex + 1));
        for (int i = 0; i < this.degree; i++) {
            int cIndex = p.indexOf("x");
            coefficients[i] = Integer.parseInt(p.substring(cIndex - 1, cIndex));
            p = p.substring(cIndex + 1);
        }
    }
    
    public void display() {
	String d = "", sign = "", e = "";
	int deg = this.degree;
        for (int i = 0; i < this.coefficients.length; i++) {
            if (coefficients[i] > 0 && deg - i != this.degree) {
                    sign = " + ";
            }
            else if (coefficients[i] < 0) {
                    sign = " - ";
            }
            
            if (deg - i == 1) {
                e = "x";
            }
            else if (deg - i > 0) {
                e = "x^" + (deg - i);
            }
            else {
                e = "";
            }
            
            if (coefficients[i] == 1 || coefficients[i] == -1) {
                    d += sign + e;
            }
            else if (coefficients[i] != 0) {
                    d += sign + Math.abs(coefficients[i]) + e;
            }
        }
        System.out.println(d);
    }
}
