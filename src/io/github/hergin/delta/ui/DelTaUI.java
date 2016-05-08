package io.github.hergin.delta.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.core.WorkflowEngine;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;

import io.github.hergin.delta.model.Param;
import io.github.hergin.delta.patterns.DesignPattern;

/**
 * @author Huseyin Ergin
 */
public class DelTaUI extends JPanel {

	private static final long serialVersionUID = 1L;
	List<DesignPattern> patterns;
	List<JComponent> existingParams;

	public DelTaUI(List<DesignPattern> patterns) {
		this.patterns = patterns;
		existingParams = new ArrayList<>();
		initComponents();

		for (DesignPattern designPattern : patterns) {
			dpListComboBox.addItem(designPattern.getName());
		}
		langsComboBox.addItem("GrGen.NET");

		initParamsAndLabels();
	}

	private void initParamsAndLabels() {

		for (JComponent jComponent : existingParams) {
			remove(jComponent);
		}

		dpImage.setIcon(
				new ImageIcon(getClass().getResource(patterns.get(dpListComboBox.getSelectedIndex()).getPath())));
		dpImage.setBounds(new Rectangle(new Point(30, 145), dpImage.getPreferredSize()));

		int startingX = 650, startingY = 100, stepY = 25, currentX = startingX, currentY = startingY;
		for (Param p : patterns.get(dpListComboBox.getSelectedIndex()).getParams()) {
			JLabel tempLabel = new JLabel();
			tempLabel.setText(p.getKey());
			add(tempLabel);
			tempLabel.setBounds(new Rectangle(new Point(currentX, currentY), tempLabel.getPreferredSize()));
			JTextField tempTextField = new JTextField();
			tempTextField.setText(p.getValue());
			add(tempTextField);
			tempTextField.setBounds(currentX + 100, currentY - 5, 100, tempTextField.getPreferredSize().height);
			tempTextField.addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {
				}

				@Override
				public void keyReleased(KeyEvent e) {
					patterns.get(dpListComboBox.getSelectedIndex()).updateParam(p.getKey(),
							((JTextField) e.getSource()).getText());
				}

				@Override
				public void keyPressed(KeyEvent e) {
				}
			});
			currentY += stepY;
			existingParams.add(tempLabel);
			existingParams.add(tempTextField);
		}
		repaint();
	}

	public void createDynamicExtFile() {
		File f = new File(URI.createFileURI("src/template/grgenDynamic.ext").toString());
		try {
			BufferedWriter writer = Files.newBufferedWriter(f.toPath());
			writer.write("import delta;\n\n");
			writer.write("String getName(String s):\n");
			writer.write("\tswitch(s) {\n");
			for (Param p : patterns.get(dpListComboBox.getSelectedIndex()).getParams()) {
				writer.write("\t\tcase '" + p.getKey() + "':'" + (p.getValue().isEmpty() ? p.getKey() : p.getValue())
						+ "'\n");
			}
			writer.write("\t\tcase 'designPatternName': '"
					+ patterns.get(dpListComboBox.getSelectedIndex()).getName().replace(' ', '_') + "'\n");
			writer.write("\t\tdefault: s\n");
			writer.write("\t};\n\n");
			writer.write("String getDPName():\n");
			writer.write("\tgetName('designPatternName');");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initComponents() {
		dpListComboBox = new JComboBox<String>();
		dpListLabel = new JLabel();
		paramsLabel = new JLabel();
		dpImage = new JLabel();
		appLabel = new JLabel();
		generateButton = new JButton();
		langsComboBox = new JComboBox<String>();
		targetLangLabel = new JLabel();
		showDetailButton = new JButton();

		setLayout(null);
		add(dpListComboBox);
		dpListComboBox.setBounds(140, 60, 275, dpListComboBox.getPreferredSize().height);
		dpListComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				initParamsAndLabels();
			}
		});

		dpListLabel.setText("Selected design pattern");
		dpListLabel.setLabelFor(dpListComboBox);
		add(dpListLabel);
		dpListLabel.setBounds(new Rectangle(new Point(20, 65), dpListLabel.getPreferredSize()));

		paramsLabel.setText("Parameters");
		paramsLabel.setFont(paramsLabel.getFont().deriveFont(paramsLabel.getFont().getStyle() | Font.BOLD));
		add(paramsLabel);
		paramsLabel.setBounds(new Rectangle(new Point(730, 70), paramsLabel.getPreferredSize()));

		dpImage.setText("text");
		add(dpImage);

		appLabel.setText("Generate Models from Design Patterns");
		appLabel.setFont(appLabel.getFont().deriveFont(appLabel.getFont().getStyle() | Font.BOLD,
				appLabel.getFont().getSize() + 4f));
		add(appLabel);
		appLabel.setBounds(new Rectangle(new Point(20, 20), appLabel.getPreferredSize()));

		generateButton.setText("Generate Transformation Model");
		add(generateButton);
		generateButton.setBounds(new Rectangle(new Point(665, 385), generateButton.getPreferredSize()));
		add(langsComboBox);
		langsComboBox.setBounds(110, 385, 135, 20);

		generateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (patterns.get(dpListComboBox.getSelectedIndex()).getXmiName() == null) {
					JOptionPane.showMessageDialog(null,
							"This design pattern doesn't have an XMI model. Please create it first!", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fc.setDialogTitle(
						"Choose a folder for generated codes. Most possibly your transformation project folder.");
				int result = fc.showSaveDialog(DelTaUI.this);

				createDynamicExtFile();

				if (result == JFileChooser.APPROVE_OPTION) {
					WorkflowEngine engine = new WorkflowEngine();

					HashMap<String, String> params = new HashMap<String, String>();
					params.put("pattern", patterns.get(dpListComboBox.getSelectedIndex()).getXmiName());
					params.put("src-gen", fc.getSelectedFile().getAbsolutePath());

					engine.run(URI.createFileURI("src/workflow/generateGrgen.mwe").toFileString(),
							new NullProgressMonitor(), params, new HashMap<String, Object>());
				}
			}
		});

		targetLangLabel.setText("Target language");
		targetLangLabel.setLabelFor(langsComboBox);
		add(targetLangLabel);
		targetLangLabel.setBounds(20, 390, 114, 14);

		showDetailButton.setText("Show Design Pattern Details");
		showDetailButton.setIcon(UIManager.getIcon("FileChooser.viewMenuIcon"));
		add(showDetailButton);
		showDetailButton.setBounds(424, 58, 190, 24);
		showDetailButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, patterns.get(dpListComboBox.getSelectedIndex()).getDetails(),
						patterns.get(dpListComboBox.getSelectedIndex()).getName() + " information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for (int i = 0; i < getComponentCount(); i++) {
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
	}

	private JComboBox<String> dpListComboBox;
	private JLabel dpListLabel;
	private JLabel paramsLabel;
	private JLabel dpImage;
	private JLabel appLabel;
	private JButton generateButton;
	private JComboBox<String> langsComboBox;
	private JLabel targetLangLabel;
	private JButton showDetailButton;
}
