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
import modelo.Curso;

public class CursoView extends JFrame{
	public CursoView( CursoTabela t) throws Exception{
		super("Curso");
		inicio(new Curso());
		salvar.addActionListener(new CursoControl(this,t));
	}
	public CursoView( Autocompletee t) throws Exception{
		super("Curso");
		inicio(new Curso());
		salvar.addActionListener(new CursoControl(this,t));
	}
	public CursoView( CursoTabela t,Curso curso) throws Exception{
		super("Curso");
		inicio(curso);
		salvar.addActionListener(new CursoControl(this,t,curso));
	}
	JButton salvar;
	public JTextInt id;
	public JTextField nome;
	public void inicio(Curso curso) throws Exception{
		salvar = new JButton("Salvar");
		id = new JTextInt(curso.getId());
		id.setEditable(false);
		id.setEnabled(false);
		nome = new JTextField(curso.getNome()==null?"":curso.getNome());

		JPanel pp = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(pp);
		layout.row().grid(new JLabel("ID:")).add(id);
		layout.row().grid(new JLabel("Nome:")).add(nome);

		layout.row().grid().add(salvar,1);
		getContentPane().add(new JScrollPane(pp));
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}}
