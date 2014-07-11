package auxiliares;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.combobox.ListComboBoxModel;

//jar swingx-all-1.6.4
public class Autocompletee extends JComboBox {
	private ArrayList nomes;

	public Autocompletee(ArrayList n, Object o) {
		setEditable(true);
		nomes = n;
		if (n != null) {
			AutoCompleteDecorator.decorate(this);
			setModel(new ListComboBoxModel(nomes));
			setSelectedIndex(-1);
			if (o != null)
				for (int i = 0; i < n.size(); i++) {
					if (n.get(i).toString().equals(o.toString())) {
						setSelectedIndex(i);
						break;
					}
				}
		}
	}

	public Autocompletee(ArrayList n) {
		setEditable(true);
		nomes = n;
		if (n != null) {
			AutoCompleteDecorator.decorate(this);
			setModel(new ListComboBoxModel(nomes));
			if(n.size()>0)setSelectedIndex(0);
		}
	}
	
	public void adicionar(Object o) {
		nomes.add(o);
		setModel(new ListComboBoxModel(nomes));
		setSelectedIndex(nomes.size()-1);
	}

	public Object getSelected() {
		return nomes.get(getSelectedIndex());
	}
}
