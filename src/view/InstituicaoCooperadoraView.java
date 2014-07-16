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
import modelo.InstituicaoCooperadora;

public class InstituicaoCooperadoraView extends JFrame
{
	JButton salvar;
	public JTextInt id;
	public JTextField nome;

	public InstituicaoCooperadoraView(InstituicaoCooperadoraTabela t)
			throws Exception
	{
		super("InstituicaoCooperadora");
		inicio(new InstituicaoCooperadora());
		salvar.addActionListener(new InstituicaoCooperadoraControl(this, t));
	}

	public InstituicaoCooperadoraView(Autocompletee t) throws Exception
	{
		super("InstituicaoCooperadora");
		inicio(new InstituicaoCooperadora());
		salvar.addActionListener(new InstituicaoCooperadoraControl(this, t));
	}

	public InstituicaoCooperadoraView(InstituicaoCooperadoraTabela t,
			InstituicaoCooperadora instituicaocooperadora) throws Exception
	{
		super("InstituicaoCooperadora");
		inicio(instituicaocooperadora);
		salvar.addActionListener(new InstituicaoCooperadoraControl(this, t,
				instituicaocooperadora));
	}
	
	public void inicio(InstituicaoCooperadora instituicaocooperadora)
			throws Exception
	{
		salvar = new JButton("Salvar");
		id = new JTextInt(instituicaocooperadora.getId());
		id.setEditable(false);
		id.setEnabled(false);
		nome = new JTextField(instituicaocooperadora.getNome() == null ? ""
				: instituicaocooperadora.getNome());

		JPanel pp = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(pp);
		layout.row().grid(new JLabel("ID:")).add(id);
		layout.row().grid(new JLabel("Nome:")).add(nome);

		layout.row().grid().add(salvar, 1);
		getContentPane().add(new JScrollPane(pp));
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400, 200);
		setVisible(true);
	}
}
