package auxiliares;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

public class ListRadio extends JPanel
{
	ArrayList<JRadioButton> lista = new ArrayList<JRadioButton>();
	ButtonGroup bg = new ButtonGroup();

	public ListRadio(String[] list, String selecionado)
	{
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBorder(new EmptyBorder(-10, 0, 0, 0));
		boolean primeiro = true;
		for (String nome : list)
		{
			boolean marcado = false;
			if (primeiro)
			{
				primeiro = false;
				marcado = true;
			}
			if (selecionado != null && nome.equals(selecionado))
				marcado = true;

			lista.add(new JRadioButton(nome, marcado));
			bg.add(lista.get(lista.size() - 1));
			add(lista.get(lista.size() - 1));
		}
	}

	public String getText()
	{
		for (JRadioButton c : lista)
		{
			if (c.isSelected())
				return c.getText();
		}
		return "";
	}
}
