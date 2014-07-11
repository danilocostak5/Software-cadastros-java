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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JCheckBox;

import dao.*;
import auxiliares.*;
import net.java.dev.designgridlayout.DesignGridLayout;
import net.java.dev.designgridlayout.LabelAlignment;
import modelo.*;
import control.*;
import view.*;
import modelo.Pesquisa;

public class PesquisaView extends JFrame
{

	public PesquisaView(PesquisaTabela t) throws Exception
	{
		super("Pesquisa");
		inicio(new Pesquisa());
		salvar.addActionListener(new PesquisaControl(this, t));
	}

	public PesquisaView(Autocompletee t) throws Exception
	{
		super("Pesquisa");
		inicio(new Pesquisa());
		salvar.addActionListener(new PesquisaControl(this, t));
	}

	public PesquisaView(PesquisaTabela t, Pesquisa pesquisa) throws Exception
	{
		super("Pesquisa");
		inicio(pesquisa);
		salvar.addActionListener(new PesquisaControl(this, t, pesquisa));
	}

	JButton salvar;
	public JTextInt id;
	public JTextField titulo;
	public Autocompletee orientador;
	public Autocompletee pesquisador_responsavel;
	public ListaAutoComplete colaboradores;
	public JTextInt ano_submissao;
	public JTextInt tempo_duracao;
	public ListRadio tipo;
	public ListRadio qualificacao;
	public ListRadio impacto_pesquisa;
	public JCheckBox gerou_patente;
	public ListRadio status;
	public ListRadio resultado;
	public Autocompletee instituicao_submissao;
	public Autocompletee fonte_financiamento;
	public Autocompletee area_conhecimento_CNPq;
	public ListaAutoComplete palavras_chave;
	public ListaAutoComplete instituicoes_cooperadoras;
	public Autocompletee local;
	public JTextArea resumo;

	public void inicio(Pesquisa pesquisa) throws Exception
	{
		salvar = new JButton("Salvar");
		id = new JTextInt(pesquisa.getId());
		id.setEditable(false);
		id.setEnabled(false);
		titulo = new JTextField(pesquisa.getTitulo() == null ? ""
				: pesquisa.getTitulo());
		Pesquisador xorientador = null;

		if (pesquisa.getOrientador() != null)
		{
			xorientador = (new PesquisadorMysql().listar(" WHERE id="
					+ pesquisa.getOrientador()).get(0));
		}

		orientador = new Autocompletee(new PesquisadorMysql().listar(""),
				xorientador);
		orientador.setToolTipText("Pesquisador orientador da pesquisa");

		Pesquisador xpesquisador_responsavel = null;

		if (pesquisa.getPesquisador_responsavel() != null)
		{
			xpesquisador_responsavel = (new PesquisadorMysql()
					.listar(" WHERE id="
							+ pesquisa.getPesquisador_responsavel()).get(0));
		}

		pesquisador_responsavel = new Autocompletee(
				new PesquisadorMysql().listar(""), xpesquisador_responsavel);
		JButton colab = new JButton("Novo");
		colaboradores = new ListaAutoComplete(
				new PesquisadorMysql().listar(""), pesquisa.getColaboradores(),colab);
		colab.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					new PesquisadorView(colaboradores.getAutocompletee());
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});
		ano_submissao = new JTextInt(pesquisa.getAno_submissao());
		tempo_duracao = new JTextInt(pesquisa.getTempo_duracao());
		tipo = new ListRadio("Pura-Básica,Aplicada".split(","),
				pesquisa.getTipo() == null ? "" : pesquisa.getTipo());
		qualificacao = new ListRadio(
				"Projeto,TCC,TCE,Monografia,Dissertação".split(","),
				pesquisa.getQualificacao() == null ? "" : pesquisa
						.getQualificacao());
		impacto_pesquisa = new ListRadio("Difusão,Adoção".split(","),
				pesquisa.getImpacto_pesquisa() == null ? ""
						: pesquisa.getImpacto_pesquisa());
		gerou_patente = new JCheckBox("Gerou Patente?",
				pesquisa.isGerou_patente());
		status = new ListRadio(
				"Concluída,Não concluída,Em andamento".split(","),
				pesquisa.getStatus() == null ? "" : pesquisa.getStatus());
		resultado = new ListRadio(
				"Artigo Publicado, Resumo-Expandido,Livro".split(","),
				pesquisa.getResultado() == null ? "" : pesquisa.getResultado());
		InstituicaoSubmissao xinstituicao_submissao = null;
		if (pesquisa.getInstituicao_submissao() != null)
			xinstituicao_submissao = (new InstituicaoSubmissaoMysql()
					.listar(" WHERE id=" + pesquisa.getInstituicao_submissao())
					.get(0));
		instituicao_submissao = new Autocompletee(
				new InstituicaoSubmissaoMysql().listar(""),
				xinstituicao_submissao);
		FonteFinanciamento xfonte_financiamento = null;
		if (pesquisa.getFonte_financiamento() != null)
			xfonte_financiamento = (new FonteFinanciamentoMysql()
					.listar(" WHERE id=" + pesquisa.getFonte_financiamento())
					.get(0));
		fonte_financiamento = new Autocompletee(
				new FonteFinanciamentoMysql().listar(""), xfonte_financiamento);
		AreaConhecimento xarea_conhecimento_CNPq = null;
		if (pesquisa.getArea_conhecimento_CNPq() != null)
			xarea_conhecimento_CNPq = (new AreaConhecimentoMysql()
					.listar(" WHERE id=" + pesquisa.getArea_conhecimento_CNPq())
					.get(0));
		area_conhecimento_CNPq = new Autocompletee(
				new AreaConhecimentoMysql().listar(""), xarea_conhecimento_CNPq);
		JButton palavrax = new JButton("Novo");
		
		palavras_chave = new ListaAutoComplete(
				new PalavraChaveMysql().listar(""),
				pesquisa.getPalavras_chave(),palavrax);
		palavrax.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					new PalavraChaveView(palavras_chave.getAutocompletee());
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		JButton instituicoes = new JButton("Novo");
		instituicoes_cooperadoras = new ListaAutoComplete(
				new InstituicaoCooperadoraMysql().listar(""),
				pesquisa.getInstituicoes_cooperadoras(),instituicoes);
		instituicoes.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					new InstituicaoCooperadoraView(instituicoes_cooperadoras.getAutocompletee());
				}
				catch (Exception e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		Local xlocal = null;
		if (pesquisa.getLocal() != null)
			xlocal = (new LocalMysql().listar(" WHERE id="
					+ pesquisa.getLocal()).get(0));
		local = new Autocompletee(new LocalMysql().listar(""), xlocal);
		resumo = new JTextArea(pesquisa.getResumo() == null ? "" : pesquisa
				.getResumo().toString());

		JPanel pp = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(pp);

		layout.labelAlignment(LabelAlignment.RIGHT);
		layout.row().grid(new JLabel("ID:")).add(id);
		layout.row().grid(new JLabel("Título:")).add(titulo);
		JButton dorientador = new JButton("Novo");
		dorientador.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					new PesquisadorView(orientador);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		layout.row().grid(new JLabel("Orientador:")).add(orientador)
				.add(dorientador);
		JButton dpesquisador_responsavel = new JButton("Novo");
		dpesquisador_responsavel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					new PesquisadorView(pesquisador_responsavel);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		layout.row().grid(new JLabel("Pesquisador responsável:"))
				.add(pesquisador_responsavel).add(dpesquisador_responsavel);
		layout.row().grid(new JLabel("Colaboradores:")).add(colaboradores);
		layout.row().grid(new JLabel("Ano de Submissão :")).add(ano_submissao)
				.add(gerou_patente).grid(new JLabel("Tempo de duração:"))
				.add(tempo_duracao);
		layout.row().grid(new JLabel("Tipo:")).add(tipo)
				.grid(new JLabel("Impacto da pesquisa:")).add(impacto_pesquisa);
		layout.row().grid(new JLabel("Qualificação:")).add(qualificacao);
		// layout.row().grid(new
		// JLabel("Impacto_pesquisa :")).add(impacto_pesquisa);
		// layout.row().grid(new JLabel("Gerou_patente :")).add(gerou_patente);
		layout.row().grid(new JLabel("Status:")).add(status);
		layout.row().grid(new JLabel("Resultado:")).add(resultado);
		JButton dinstituicao_submissao = new JButton("Novo");
		dinstituicao_submissao.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					new InstituicaoSubmissaoView(instituicao_submissao);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		layout.row().grid(new JLabel("Instituição de submissão :"))
				.add(instituicao_submissao).add(dinstituicao_submissao);
		JButton dfonte_financiamento = new JButton("Novo");
		dfonte_financiamento.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					new FonteFinanciamentoView(fonte_financiamento);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		layout.row().grid(new JLabel("Fonte de financiamento:"))
				.add(fonte_financiamento).add(dfonte_financiamento);
		JButton darea_conhecimento_CNPq = new JButton("Novo");
		darea_conhecimento_CNPq.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					new AreaConhecimentoView(area_conhecimento_CNPq);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		layout.row().grid(new JLabel("Área do conhecimento (CNPq):"))
				.add(area_conhecimento_CNPq).add(darea_conhecimento_CNPq);
		layout.row().grid(new JLabel("Palavras-chave:")).add(palavras_chave);
		layout.row().grid(new JLabel("Instituições cooperadoras:"))
				.add(instituicoes_cooperadoras);
		JButton dlocal = new JButton("Novo");
		dlocal.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					new LocalView(local);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		layout.row().grid(new JLabel("Local:")).add(local).add(dlocal);
		layout.row().grid(new JLabel("Resumo:")).add(resumo);

		layout.row().grid().add(salvar, 1);
		JScrollPane scroll = new JScrollPane(pp);
		scroll.setAutoscrolls(true);
		getContentPane().add(scroll);
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	/*
	 * public static void main(String[] args) throws Exception { new
	 * PesquisaView(new PesquisaTabela()); }
	 */
}
