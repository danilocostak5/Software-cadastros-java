package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import dao.*;
import auxiliares.*;
import net.java.dev.designgridlayout.DesignGridLayout;
import modelo.*;
import control.*;
import view.*;
import modelo.PalavraChave;

public class PalavraChaveView extends JFrame
{
	
	JButton salvar;
	public JTextInt id;
	public JTextField palavra;

	public PalavraChaveView(PalavraChaveTabela t) throws Exception
	{
		super("PalavraChave");
		inicio(new PalavraChave());
		salvar.addActionListener(new PalavraChaveControl(this, t));
	}

	public PalavraChaveView(Autocompletee t) throws Exception
	{
		super("PalavraChave");
		inicio(new PalavraChave());
		salvar.addActionListener(new PalavraChaveControl(this, t));
	}

	public PalavraChaveView(PalavraChaveTabela t, PalavraChave palavrachave)
			throws Exception
	{
		super("PalavraChave");
		inicio(palavrachave);
		salvar.addActionListener(new PalavraChaveControl(this, t, palavrachave));
	}

	
	public void inicio(PalavraChave palavrachave) throws Exception
	{
		salvar = new JButton("Salvar");
		id = new JTextInt(palavrachave.getId());
		id.setEditable(false);
		id.setEnabled(false);
		palavra = new JTextField(palavrachave.getPalavra() == null ? ""
				: palavrachave.getPalavra());

		JPanel pp = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(pp);
		layout.row().grid(new JLabel("ID:")).add(id);
		layout.row().grid(new JLabel("Palavra-chave:")).add(palavra);

		layout.row().grid().add(salvar, 1);
		getContentPane().add(new JScrollPane(pp));
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400, 150);
		setVisible(true);
	}
}
