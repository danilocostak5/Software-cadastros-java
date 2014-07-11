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
import modelo.FonteFinanciamento;

public class FonteFinanciamentoView extends JFrame{
	public FonteFinanciamentoView( FonteFinanciamentoTabela t) throws Exception{
		super("FonteFinanciamento");
		inicio(new FonteFinanciamento());
		salvar.addActionListener(new FonteFinanciamentoControl(this,t));
	}
	public FonteFinanciamentoView( Autocompletee t) throws Exception{
		super("FonteFinanciamento");
		inicio(new FonteFinanciamento());
		salvar.addActionListener(new FonteFinanciamentoControl(this,t));
	}
	public FonteFinanciamentoView( FonteFinanciamentoTabela t,FonteFinanciamento fontefinanciamento) throws Exception{
		super("FonteFinanciamento");
		inicio(fontefinanciamento);
		salvar.addActionListener(new FonteFinanciamentoControl(this,t,fontefinanciamento));
	}
	JButton salvar;
	public JTextInt id;
	public JTextField nome;
	public void inicio(FonteFinanciamento fontefinanciamento) throws Exception{
		salvar = new JButton("Salvar");
		id = new JTextInt(fontefinanciamento.getId());
		id.setEditable(false);
		id.setEnabled(false);
		nome = new JTextField(fontefinanciamento.getNome()==null?"":fontefinanciamento.getNome());

		JPanel pp = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(pp);
		layout.row().grid(new JLabel("ID:")).add(id);
		layout.row().grid(new JLabel("Nome:")).add(nome);

		layout.row().grid().add(salvar,1);
		getContentPane().add(new JScrollPane(pp));
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400, 150);
		setVisible(true);
	}}
