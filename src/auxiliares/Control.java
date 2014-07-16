package auxiliares;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public abstract class Control implements ActionListener
{
	protected View view;

	public View getView()
	{
		return view;
	}

	public void setView(View view)
	{
		this.view = view;
	}

	public Control()
	{
		view = new View();
		view.getBuscar().addActionListener(this);
		view.getAdicionar().addActionListener(this);
		view.getEditar().addActionListener(this);
		view.getRemover().addActionListener(this);
		view.getImprimir().addActionListener(this);
		view.getPesquisar().addActionListener(this);
	}

	// public abstract void preencherTabela();

	public abstract void adicionar();

	public abstract boolean remover(int i);

	public abstract void editar(int i);

	public abstract void pesquisar(String x) throws Exception;

	public void actionPerformed(ActionEvent evt)
	{
		try
		{
			if (evt.getSource().equals(view.getPesquisar()))
			{
				if (view.getPesquisa().getText().isEmpty())
					pesquisar("");
				else
				{
					String conteudo = view.getPesquisa().getText();
					String pesquisa = " WHERE "
							+ view.getOpcoes().getSelectedItem().toString()
							+ " ";
					if (conteudo.contains("/"))
					{
						System.out.println("contem");
						String data[] = conteudo.split("/");
						if (data.length == 3)
							conteudo = data[2] + "-" + data[1] + "-" + data[0];
						else
							conteudo = data[1] + "-" + data[0];
					}

					if (view.getTipo().isSelected())
						pesquisa = pesquisa + "= '" + conteudo + "'";
					else
						pesquisa = pesquisa + "LIKE '%" + conteudo + "%'";

					pesquisar(pesquisa);
				}
			}

			else if (evt.getSource().equals(view.getBuscar()))
			{
				TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(view
						.getTabela().getModel());
				view.getTabela().setRowSorter(sorter);
				sorter.setRowFilter(RowFilter.regexFilter(view.getFiltro()
						.getText()));
			}

			else if (evt.getSource().equals(view.getAdicionar()))
			{
				adicionar();
			}
			else if (evt.getSource().equals(view.getImprimir()))
			{
				view.getTabela().print();
			}

			else if (!(view.getTabela().getSelectedRow() < 0))
			{
				int i = view.getTabela().convertRowIndexToModel(
						view.getTabela().getSelectedRow());
				if (evt.getSource().equals(view.getRemover()))
				{
					if (JOptionPane.showConfirmDialog(null,
							"Deseja mesmo remover o item selecionado?",
							"Remover Item", 0) == 0)
					{
						String aux = "Não";
						if (remover(i))
						{
							((DefaultTableModel) view.getTabela().getModel())
									.removeRow(i);
							aux = "";
						}
						JOptionPane.showMessageDialog(null, "O produto " + aux
								+ " foi removido com sucesso",
								"Remoção de Produto", 1);
					}
				}
				else if (evt.getSource().equals(view.getEditar()))
				{
					editar(i);
				}
			}
			else
				JOptionPane.showMessageDialog(null,
						"Nenhum item da tabela foi selecionado",
						"Remoção de Produto", 0);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
