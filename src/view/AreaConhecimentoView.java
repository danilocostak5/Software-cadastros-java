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
import modelo.AreaConhecimento;

public class AreaConhecimentoView extends JFrame{
	
	public AreaConhecimentoView( AreaConhecimentoTabela t) throws Exception{
		super("AreaConhecimento");
		inicio(new AreaConhecimento());
		salvar.addActionListener(new AreaConhecimentoControl(this,t));
	}
	
	public AreaConhecimentoView( Autocompletee t) throws Exception{
		super("AreaConhecimento");
		inicio(new AreaConhecimento());
		salvar.addActionListener(new AreaConhecimentoControl(this,t));
	}
	
	public AreaConhecimentoView( AreaConhecimentoTabela t,AreaConhecimento areaconhecimento) throws Exception{
		super("AreaConhecimento");
		inicio(areaconhecimento);
		salvar.addActionListener(new AreaConhecimentoControl(this,t,areaconhecimento));
	}
	
	JButton salvar;
	public JTextInt id;
	public JTextField nome;
	public JTextField ciencia;
	public JTextField areaAvaliacao;
	
	public void inicio(AreaConhecimento areaconhecimento) throws Exception{
		salvar = new JButton("Salvar");
		id = new JTextInt(areaconhecimento.getId());
		id.setEditable(false);
		id.setEnabled(false);
		nome = new JTextField(areaconhecimento.getNome()==null?"":areaconhecimento.getNome());
		ciencia = new JTextField((areaconhecimento.getCiencia() == null)? "" : areaconhecimento.getCiencia());
		areaAvaliacao = new JTextField((areaconhecimento.getAreaAvaliacao() == null)? "" : areaconhecimento.getAreaAvaliacao());
		
		JPanel pp = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(pp);
		layout.row().grid(new JLabel("ID:")).add(id);
		layout.row().grid(new JLabel("Nome:")).add(nome);
		layout.row().grid(new JLabel("Ciência:")).add(ciencia);
		layout.row().grid(new JLabel("Área de Avaliação:")).add(areaAvaliacao);

		layout.row().grid().add(salvar,1);
		JScrollPane scroll = new JScrollPane(pp);
		scroll.setAutoscrolls(true);
		getContentPane().add(scroll);
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400, 200);
		setVisible(true);
	}}
