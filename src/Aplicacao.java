import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import control.PesquisaTabela;

public class Aplicacao
{
	public static void main(String[] args)
	{

		try
		{
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch (Exception e)
		{
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}

		JFrame tela = new JFrame("Sistema de Cadastro - Anuário de Pesquisas");
		// tela.setLayout(new FlowLayout());

		tela.setSize(800, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PesquisaTabela pt;

		try
		{
			pt = new PesquisaTabela();
			tela.add(new JScrollPane(pt.getView()));
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		tela.setVisible(true);
	}
}
