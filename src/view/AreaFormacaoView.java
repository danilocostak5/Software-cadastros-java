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
import modelo.AreaFormacao;

public class AreaFormacaoView extends JFrame
{



	JButton salvar;
	public JTextInt id;
	public JTextField nome;

	public AreaFormacaoView(AreaFormacaoTabela t) throws Exception
	{
		super("AreaFormacao");
		inicio(new AreaFormacao());
		salvar.addActionListener(new AreaFormacaoControl(this, t));
	}

	public AreaFormacaoView(Autocompletee t) throws Exception
	{
		super("AreaFormacao");
		inicio(new AreaFormacao());
		salvar.addActionListener(new AreaFormacaoControl(this, t));
	}

	public AreaFormacaoView(AreaFormacaoTabela t, AreaFormacao areaformacao)
			throws Exception
	{
		super("AreaFormacao");
		inicio(areaformacao);
		salvar.addActionListener(new AreaFormacaoControl(this, t, areaformacao));
	}
	
	public void inicio(AreaFormacao areaformacao) throws Exception
	{
		salvar = new JButton("Salvar");
		id = new JTextInt(areaformacao.getId());
		id.setEditable(false);
		id.setEnabled(false);
		nome = new JTextField(areaformacao.getNome() == null ? ""
				: areaformacao.getNome());

		JPanel pp = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(pp);
		layout.row().grid(new JLabel("ID:")).add(id);
		layout.row().grid(new JLabel("Nome:")).add(nome);

		layout.row().grid().add(salvar, 1);
		getContentPane().add(new JScrollPane(pp));
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 150);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
