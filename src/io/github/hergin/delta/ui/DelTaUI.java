/*
 * Created by JFormDesigner on Mon Oct 19 17:28:54 CDT 2015
 */

package io.github.hergin.delta.ui;

import java.awt.*;

import javax.swing.*;


/**
 * @author Huseyin Ergin
 */
public class DelTaUI extends JPanel {

	public DelTaUI() {
		initComponents();
		comboBox1.addItem("Entity-Relationship Design Pattern");
		comboBox2.addItem("GrGen.NET");
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Huseyin Ergin
		//DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
		comboBox1 = new JComboBox();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		textField1 = new JTextField();
		label5 = new JLabel();
		textField2 = new JTextField();
		label6 = new JLabel();
		textField3 = new JTextField();
		label7 = new JLabel();
		textField4 = new JTextField();
		label8 = new JLabel();
		textField5 = new JTextField();
		label9 = new JLabel();
		textField6 = new JTextField();
		label10 = new JLabel();
		textField7 = new JTextField();
		label11 = new JLabel();
		textField8 = new JTextField();
		label12 = new JLabel();
		//separator1 = compFactory.createSeparator("");
		label1 = new JLabel();
		label13 = new JLabel();
		textField9 = new JTextField();
		label14 = new JLabel();
		textField10 = new JTextField();
		button1 = new JButton();
		comboBox2 = new JComboBox();
		label15 = new JLabel();
		button2 = new JButton();

		//======== this ========
		setLayout(null);
		add(comboBox1);
		comboBox1.setBounds(140, 60, 275, comboBox1.getPreferredSize().height);

		//---- label2 ----
		label2.setText("Selected design pattern");
		label2.setLabelFor(comboBox1);
		add(label2);
		label2.setBounds(new Rectangle(new Point(20, 65), label2.getPreferredSize()));

		//---- label3 ----
		label3.setText("Parameters");
		label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD));
		add(label3);
		label3.setBounds(new Rectangle(new Point(730, 70), label3.getPreferredSize()));

		//---- label4 ----
		label4.setText("src");
		add(label4);
		label4.setBounds(new Rectangle(new Point(665, 100), label4.getPreferredSize()));

		//---- textField1 ----
		textField1.setText("ClassDiagram");
		textField1.setForeground(Color.gray);
		add(textField1);
		textField1.setBounds(750, 95, 100, textField1.getPreferredSize().height);

		//---- label5 ----
		label5.setText("trgt");
		add(label5);
		label5.setBounds(665, 125, 30, 14);

		//---- textField2 ----
		textField2.setText("RelationalDB");
		textField2.setForeground(Color.gray);
		add(textField2);
		textField2.setBounds(750, 120, 100, 20);

		//---- label6 ----
		label6.setText("entityMapping");
		add(label6);
		label6.setBounds(new Rectangle(new Point(665, 150), label6.getPreferredSize()));

		//---- textField3 ----
		textField3.setText("class2table");
		textField3.setForeground(Color.gray);
		add(textField3);
		textField3.setBounds(750, 145, 100, textField3.getPreferredSize().height);

		//---- label7 ----
		label7.setText("relationMapping");
		add(label7);
		label7.setBounds(665, 175, 95, 14);

		//---- textField4 ----
		textField4.setText("attribute2column");
		textField4.setForeground(Color.gray);
		add(textField4);
		textField4.setBounds(750, 170, 100, 20);

		//---- label8 ----
		label8.setText("sEnt");
		add(label8);
		label8.setBounds(665, 200, 30, 14);

		//---- textField5 ----
		textField5.setText("Class");
		textField5.setForeground(Color.gray);
		add(textField5);
		textField5.setBounds(750, 195, 100, 20);

		//---- label9 ----
		label9.setText("tEnt");
		add(label9);
		label9.setBounds(665, 225, 68, 14);

		//---- textField6 ----
		textField6.setText("Table");
		textField6.setForeground(Color.gray);
		add(textField6);
		textField6.setBounds(750, 220, 100, 20);

		//---- label10 ----
		label10.setText("sEnt2");
		add(label10);
		label10.setBounds(665, 250, 30, 14);

		//---- textField7 ----
		textField7.setText("Attribute");
		textField7.setForeground(Color.gray);
		add(textField7);
		textField7.setBounds(750, 245, 100, 20);

		//---- label11 ----
		label11.setText("tEnt2");
		add(label11);
		label11.setBounds(665, 275, 68, 14);

		//---- textField8 ----
		textField8.setText("Column");
		textField8.setForeground(Color.gray);
		add(textField8);
		textField8.setBounds(750, 270, 100, 20);

		//---- label12 ----
		label12.setText("text");
		label12.setIcon(new ImageIcon(getClass().getResource("/io/github/hergin/delta/patterns/ER-Mapping.png")));
		add(label12);
		label12.setBounds(new Rectangle(new Point(30, 145), label12.getPreferredSize()));

		//---- separator1 ----
		//separator1.setFont(new Font("Tahoma", Font.BOLD, 17));
		//add(separator1);
		//separator1.setBounds(315, 30, 535, 15);

		//---- label1 ----
		label1.setText("Generate Models from Design Patterns");
		label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 4f));
		add(label1);
		label1.setBounds(new Rectangle(new Point(20, 20), label1.getPreferredSize()));

		//---- label13 ----
		label13.setText("rel1");
		add(label13);
		label13.setBounds(665, 300, 30, 14);

		//---- textField9 ----
		textField9.setText("attrs");
		textField9.setForeground(Color.gray);
		add(textField9);
		textField9.setBounds(750, 295, 100, 20);

		//---- label14 ----
		label14.setText("rel2");
		add(label14);
		label14.setBounds(665, 325, 68, 14);

		//---- textField10 ----
		textField10.setText("cols");
		textField10.setForeground(Color.gray);
		add(textField10);
		textField10.setBounds(750, 320, 100, 20);

		//---- button1 ----
		button1.setText("Generate Transformation Model");
		add(button1);
		button1.setBounds(new Rectangle(new Point(665, 385), button1.getPreferredSize()));
		add(comboBox2);
		comboBox2.setBounds(110, 385, 135, 20);

		//---- label15 ----
		label15.setText("Target language");
		label15.setLabelFor(comboBox2);
		add(label15);
		label15.setBounds(20, 390, 114, 14);

		//---- button2 ----
		button2.setText("Show Design Pattern Details");
		button2.setIcon(UIManager.getIcon("FileChooser.viewMenuIcon"));
		add(button2);
		button2.setBounds(424, 58, 190, 24);

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < getComponentCount(); i++) {
				Rectangle bounds = getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			setMinimumSize(preferredSize);
			setPreferredSize(preferredSize);
		}
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Huseyin Ergin
	private JComboBox comboBox1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JTextField textField1;
	private JLabel label5;
	private JTextField textField2;
	private JLabel label6;
	private JTextField textField3;
	private JLabel label7;
	private JTextField textField4;
	private JLabel label8;
	private JTextField textField5;
	private JLabel label9;
	private JTextField textField6;
	private JLabel label10;
	private JTextField textField7;
	private JLabel label11;
	private JTextField textField8;
	private JLabel label12;
	private JComponent separator1;
	private JLabel label1;
	private JLabel label13;
	private JTextField textField9;
	private JLabel label14;
	private JTextField textField10;
	private JButton button1;
	private JComboBox comboBox2;
	private JLabel label15;
	private JButton button2;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
