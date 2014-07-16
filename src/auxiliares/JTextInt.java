package auxiliares;

import javax.swing.JTextField;

public class JTextInt extends JTextField
{
	public JTextInt()
	{
		setDocument(new DocumentInt());
		setText("0");
	}

	public JTextInt(long id)
	{
		setDocument(new DocumentInt());
		setText(id + "");
	}

	public JTextInt(int id)
	{
		setDocument(new DocumentInt());
		setText(id + "");
	}

	public int getValor()
	{
		return Integer.parseInt(getText());
	}

	public void setText(long i)
	{
		setText(i + "");
	}
}
