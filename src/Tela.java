import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Tela implements ListSelectionListener {
	
	JLabel label;
	JList<String> list;
	
	public Tela() {
	

		JFrame frame = new JFrame("Título");
		frame.setSize(400, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] redesSociais = {"Facebook" , "Instagram"};
		
		list  = new JList<String>(redesSociais); 
		
		//Método para selecionar apenas um dos ítens
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//Executando Ação para mostrar as imagens com ListSelectionListener
		list.addListSelectionListener(this);
		
		frame.add(list,BorderLayout.EAST);
		
		label = new JLabel();
		
		frame.add(label, BorderLayout.CENTER);
	
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {

				new Tela();
				
			}
		});
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		System.out.println("Teste");
		
		String img = list.getSelectedValue();
		label.setIcon(new ImageIcon("img/"+img.toLowerCase()+".png"));
	}

}
