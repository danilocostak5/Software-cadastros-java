package auxiliares;

import java.text.DecimalFormat;

import javax.swing.JTextField;

public class JTextDec extends JTextField {
	public JTextDec() {
		setDocument(new DocumentDecimal());
		setText("000");
	}
	
	public void setText(double d) {
		super.setText(new DecimalFormat("0.00").format(d).replace(",",""));
	}
	public JTextDec(double d) {
		setDocument(new DocumentDecimal());
		setText(new DecimalFormat("0.00").format(d).replace(",",""));
	}
	public JTextDec(float d) {
		setDocument(new DocumentDecimal());
		setText(new DecimalFormat("0.00").format(d).replace(",",""));
	}

	public float getValor() {
		return Float.parseFloat(getText());
	}
	
	/*public static void main(String[] args) {
		JTextDec x = new JTextDec(2.2);
		new Fr(x);
		System.out.println(x.getText());
	}*/
}
