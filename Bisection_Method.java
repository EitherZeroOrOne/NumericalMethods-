
import java.math.*;
public class Bisection_Method {
	/**
	 * Setting the Math Context is setting the precision
	 * The Math Context can then be used as an argument
	 * for making Decimal Numbers
	 */
	MathContext mc = new MathContext(4);
	BigDecimal zero = new BigDecimal(0);
	BigDecimal a = new BigDecimal(1,mc);
	BigDecimal b = new BigDecimal(2,mc);
	BigDecimal c, u, v, w;
	public Bisection_Method(){
		c = a.add(b,mc).divide(new BigDecimal(2));
		u = new BigDecimal(Math.cos(a.doubleValue()) - Math.cos(3*a.doubleValue()),mc);
		v = new BigDecimal(Math.cos(b.doubleValue()) - Math.cos(3*b.doubleValue()),mc);
		if(u.multiply(v).signum() > 0){
			System.out.println("Need different Starting Points");
			System.exit(0);
		}
		System.out.println("f(x) = cos(x) - cos(3x)");
		String line = "";
		for(int i = 0; i < 50; i++){
			c = a.add(b,mc).divide(new BigDecimal(2));
			line = "a=" + a + " b=" + b + " c=" + c;
			u = new BigDecimal(Math.cos(a.doubleValue()) - Math.cos(3*a.doubleValue()),mc);
			v = new BigDecimal(Math.cos(b.doubleValue()) - Math.cos(3*b.doubleValue()),mc);
			w = new BigDecimal(Math.cos(c.doubleValue()) - Math.cos(3*c.doubleValue()),mc);
			line += " f(a)=" + u + " f(b)=" + v + " f(c)=" + w;
			System.out.println(line);
			if(!w.equals(zero)){
				if(u.multiply(w).signum() < 0) b = c;
				else if(v.multiply(w).signum() < 0) a = c;
				else{
					System.out.println("Something is Terribly wrong."); 
					break;
				}
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Bisection_Method();
	}

}
