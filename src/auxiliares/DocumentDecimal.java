package auxiliares;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class DocumentDecimal extends PlainDocument
{
	public void insertString(int offs, String str,
			javax.swing.text.AttributeSet a) throws BadLocationException
	{
		String texto = getText(0, getLength());

		try
		{
			if (Character.isDigit(str.charAt(0)))
			{
				super.remove(0, getLength());
				texto = texto.replace(".", "");

				StringBuffer s = new StringBuffer(texto + str);
				if (s.length() > 0 && s.charAt(0) == '0')
					s.deleteCharAt(0);

				if (s.length() < 1)
					s.insert(0, "000");
				else if (s.length() < 2)
					s.insert(0, "00");
				else if (s.length() < 3)
					s.insert(0, "0");

				s.insert(s.length() - 2, ".");
				super.insertString(0, s.toString(), a);
			}

		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}

	public void remove(int offset, int length) throws BadLocationException
	{
		super.remove(offset, length);
		String texto = getText(0, getLength());
		texto = texto.replace(".", "");

		super.remove(0, getLength());

		insertString(0, texto, null);
	}
}