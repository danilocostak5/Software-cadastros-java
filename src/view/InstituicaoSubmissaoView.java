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
import modelo.InstituicaoSubmissao;

public class InstituicaoSubmissaoView extends JFrame{
	public InstituicaoSubmissaoView( InstituicaoSubmissaoTabela t) throws Exception{
		super("InstituicaoSubmissao");
		inicio(new InstituicaoSubmissao());
		salvar.addActionListener(new InstituicaoSubmissaoControl(this,t));
	}
	public InstituicaoSubmissaoView( Autocompletee t) throws Exception{
		super("InstituicaoSubmissao");
		inicio(new InstituicaoSubmissao());
		salvar.addActionListener(new InstituicaoSubmissaoControl(this,t));
	}
	public InstituicaoSubmissaoView( InstituicaoSubmissaoTabela t,InstituicaoSubmissao instituicaosubmissao) throws Exception{
		super("InstituicaoSubmissao");
		inicio(instituicaosubmissao);
		salvar.addActionListener(new InstituicaoSubmissaoControl(this,t,instituicaosubmissao));
	}
	JButton salvar;
	public JTextInt id;
	public JTextField nome;
	public void inicio(InstituicaoSubmissao instituicaosubmissao) throws Exception{
		salvar = new JButton("Salvar");
		id = new JTextInt(instituicaosubmissao.getId());
		id.setEditable(false);
		id.setEnabled(false);
		nome = new JTextField(instituicaosubmissao.getNome()==null?"":instituicaosubmissao.getNome());

		JPanel pp = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(pp);
		layout.row().grid(new JLabel("ID:")).add(id);
		layout.row().grid(new JLabel("Nome:")).add(nome);

		layout.row().grid().add(salvar,1);
		getContentPane().add(new JScrollPane(pp));
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400, 200);
		setVisible(true);
	}}
