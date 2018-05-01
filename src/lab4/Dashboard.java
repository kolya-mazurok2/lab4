package lab4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Dashboard extends JFrame {
	private JList<String> list;
	private JTextField text = new JTextField();
	
	public Dashboard() {
		setLayout(new GridLayout());
		
		JPanel pnl1 = new JPanel();
		pnl1.setSize(new Dimension(200,200));
		pnl1.setLayout(null);
		
		pnl1.add(text);
		text.setBounds(5,5,190,25);
		
		JButton btnAdd = new JButton();
		pnl1.add(btnAdd);
		btnAdd.setText("Додати");
		btnAdd.setBounds(50, 35, 100, 25);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() != -1) {
					try {
						String part1 = "";
						String part2 = "";
						int index = list.getSelectedIndex();
						int listLength = (int) list.getModel().getSize();
						
						for(int i=0; i<listLength; i++) {
							if(i <= index)
								part1 = part1 + "," + list.getModel().getElementAt(i);
							else
								part2 = part2 + "," + list.getModel().getElementAt(i);
						}
						
						part1 = part1.substring(1);
						String result = "";
						result = part1 + "," + text.getText() + part2;
						String [] tempArr = result.split(",");
						DefaultListModel<String> newListModel = new DefaultListModel<>();
						
						for(int i=0; i<tempArr.length; i++)
							newListModel.addElement(tempArr[i]);
						
						list.setModel(newListModel);
	                }
	                catch(Exception exc) {
	                	System.out.println("Error: "+exc);
	                }
				}
				else
					JOptionPane.showMessageDialog(new JFrame(), "Виберіть елемент у списку!");
			}
		});
		
		JPanel pnl2 = new JPanel();
		pnl2.setSize(new Dimension(200,200));
		pnl2.setLayout(null);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(int i=0; i<15; i++)
			listModel.addElement("Test" + (int)Math.floor(Math.random()*10));
		
		list = new JList<>(listModel);
		JScrollPane listScrollPn = new JScrollPane(list);
		listScrollPn.setBounds(5,5,190,190);
		pnl2.add(listScrollPn);
		
		add(pnl1);
		add(pnl2);
		
		setTitle("Список");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(400,200));
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
        setVisible(true);
	}
}
