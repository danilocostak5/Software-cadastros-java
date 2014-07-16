package auxiliares;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.java.dev.designgridlayout.DesignGridLayout;

public class View extends JPanel
{
	private JTextField filtro, pesquisa;
	private JComboBox opcoes;
	private JCheckBox tipo;
	private JTable tabela;
	private JButton buscar, remover, adicionar, editar, imprimir, pesquisar;

	public View()
	{
		tipo = new JCheckBox("Exata", false);
		filtro = new JTextField();
		pesquisa = new JTextField();
		opcoes = new JComboBox<>();
		buscar = new JButton("Filtrar");
		pesquisar = new JButton("Pesquisar");

		remover = new JButton("Remover");
		adicionar = new JButton("Adicionar");
		editar = new JButton("Editar");
		imprimir = new JButton("Imprimir");
		tabela = new JTable();
		JScrollPane scroll = new JScrollPane(tabela,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.setRowHeight(tabela.getFont().getSize() + 10);

		DesignGridLayout layout = new DesignGridLayout(this);
		layout.row().grid(new JLabel("Pesquisar: ")).add(pesquisa, 2)
				.add(opcoes).add(tipo).add(pesquisar);
		layout.row().grid(new JLabel("Busca: ")).add(filtro, 2).add(buscar);
		layout.row().grid().add(scroll);
		layout.row().grid().add(adicionar, editar, remover, imprimir);
		setMinimumSize(getPreferredSize());
	}

	public JCheckBox getTipo()
	{
		return tipo;
	}

	public void setTipo(JCheckBox tipo)
	{
		this.tipo = tipo;
	}

	public JComboBox getOpcoes()
	{
		return opcoes;
	}

	public void setOpcoes(JComboBox opcoes)
	{
		this.opcoes = opcoes;
	}

	public JTextField getFiltro()
	{
		return filtro;
	}

	public void setFiltro(JTextField filtro)
	{
		this.filtro = filtro;
	}

	public JTextField getPesquisa()
	{
		return pesquisa;
	}

	public void setPesquisa(JTextField pesquisa)
	{
		this.pesquisa = pesquisa;
	}

	public JTable getTabela()
	{
		return tabela;
	}

	public void setTabela(JTable tabela)
	{
		this.tabela = tabela;
	}

	public JButton getBuscar()
	{
		return buscar;
	}

	public void setBuscar(JButton buscar)
	{
		this.buscar = buscar;
	}

	public JButton getRemover()
	{
		return remover;
	}

	public void setRemover(JButton remover)
	{
		this.remover = remover;
	}

	public JButton getAdicionar()
	{
		return adicionar;
	}

	public void setAdicionar(JButton adicionar)
	{
		this.adicionar = adicionar;
	}

	public JButton getEditar()
	{
		return editar;
	}

	public void setEditar(JButton editar)
	{
		this.editar = editar;
	}

	public JButton getImprimir()
	{
		return imprimir;
	}

	public void setImprimir(JButton imprimir)
	{
		this.imprimir = imprimir;
	}

	public JButton getPesquisar()
	{
		return pesquisar;
	}

	public void setPesquisar(JButton pesquisar)
	{
		this.pesquisar = pesquisar;
	}

}
