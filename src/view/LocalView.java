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
import modelo.Local;

public class LocalView extends JFrame{
	public LocalView( LocalTabela t) throws Exception{
		super("Local");
		inicio(new Local());
		salvar.addActionListener(new LocalControl(this,t));
	}
	public LocalView( Autocompletee t) throws Exception{
		super("Local");
		inicio(new Local());
		salvar.addActionListener(new LocalControl(this,t));
	}
	public LocalView( LocalTabela t,Local local) throws Exception{
		super("Local");
		inicio(local);
		salvar.addActionListener(new LocalControl(this,t,local));
	}
	JButton salvar;
	public JTextInt id;
	public JTextField cidade;
	public JTextField estado;
	public JTextField descricao;
	public void inicio(Local local) throws Exception{
		salvar = new JButton("Salvar");
		id = new JTextInt(local.getId());
		id.setEditable(false);
		id.setEnabled(false);
		cidade = new JTextField(local.getCidade()==null?"":local.getCidade());
		estado = new JTextField(local.getEstado()==null?"":local.getEstado());
		descricao = new JTextField(local.getDescricao()==null?"":local.getDescricao());

		JPanel pp = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(pp);
		layout.row().grid(new JLabel("ID:")).add(id);
		layout.row().grid(new JLabel("Cidade:")).add(cidade);
		layout.row().grid(new JLabel("Estado:")).add(estado);
		layout.row().grid(new JLabel("Descrição:")).add(descricao);

		layout.row().grid().add(salvar,1);
		getContentPane().add(new JScrollPane(pp));
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}}
