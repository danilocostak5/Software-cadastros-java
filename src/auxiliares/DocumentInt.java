package auxiliares;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class DocumentInt extends PlainDocument {
	public void insertString(int offs, String str,
			javax.swing.text.AttributeSet a) throws BadLocationException {
		if (Character.isDigit(str.charAt(0))) {
			if(getText(0, getLength()).equals("0")) super.remove(0, 1);
			super.insertString(getLength(), str, a);
		}
	}
	public void remove(int offs, int len) throws BadLocationException {
		super.remove(offs, len);
		if (getLength()<1) super.insertString(0, "0", null);
	}
}