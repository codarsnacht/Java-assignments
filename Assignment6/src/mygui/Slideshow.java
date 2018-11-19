package mygui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Slideshow extends JFrame implements ItemListener {
	private JPanel comboBoxPane;
	private JComboBox comboBox;
	private String[] comboBoxItem = {"Animals","Food", "Flowers"};
	private JPanel cards;
	private JButton change1;
	private JButton change2;
	private JButton change3;
	private JPanel buttonPanel;
	Timer tm;
	int a = 0;
	int b = 0;
	int c = 0;
	
	 String[] Flowers = {"flower1.jpg",
			"flower2.jpg",
			"flower3.jpg"};
	 String[] Food= {"food1.jpg" , 
			"food2.jpg" ,
			"food3.jpg" , };
	 String[] Animals= {"animal1.jpg" ,
			"animal2.jpg" , 
			"animal3.jpg" };

	private Color colours[] = { Color.black, Color.red, Color.yellow,  Color.green,
			Color.orange, Color.pink,Color.gray, Color.white , Color.blue, Color.cyan, Color.DARK_GRAY , Color.MAGENTA , Color.white };
	
	
	public void addComponent(Container pane) {
		comboBoxPane = new JPanel();
		comboBox = new JComboBox(comboBoxItem);
		comboBox.addItemListener(this);
		comboBoxPane.add(comboBox);
		
	
	
		// Animal card
		JPanel cards1 = new JPanel();
		JLabel pic1 = new JLabel();
		addImageToLabel(2, Animals, pic1);	
		Timer animalTimer = new Timer(1500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				addImageToLabel(a, Animals, pic1);
				++a;									//slideshow code
				if(a == Animals.length - 1) {
					a = 0;
				}
			}});
		//adds card 1 to main card
		cards1.add(pic1);
		animalTimer.start();
		
		// Food card
		JPanel cards2 = new JPanel();
		JLabel pic2 = new JLabel();
		addImageToLabel(2, Food, pic2);	
		Timer fT = new Timer(1500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {	//slideshow code
				addImageToLabel(b, Food, pic2);
				++b;
				if(b == Food.length - 1) {
					b = 0;	
				}
						
				}});
				//adds card 2 to main card
			cards2.add(pic2);
			fT.start();
			
		// Flower card
		JPanel cards3 = new JPanel();
		JLabel pic3 = new JLabel();
		addImageToLabel(2, Flowers, pic3);
		Timer flowerTimer = new Timer(1500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				addImageToLabel(c, Flowers, pic3);					//slideshow code
				++c;
				if (c == Flowers.length - 1) {
					c = 0;
				}

			}
		});
		//adds card 3 to main card
		cards3.add(pic3);
		flowerTimer.start();
		
		//buttons for bottom of the page
		change1 = new JButton( "Change Animal Colour");
		change2 = new JButton("Change Food Colour");
		change3 = new JButton("Change Flower Colour");
		
		//button 1
		change1.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						//changes background colour
						
						cards1.setBackground(colours[1]);
								
					//	cards2.setBackground(colours[2]);
								
				//		cards3.setBackground(	colours[3]);	
					}
				}
				);//closes actionListener call
		
		
		//button 2
		change2.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						//changes background colour
						
							//cards1.setBackground(colours[2]);
								
						cards2.setBackground(colours[4]);
								
						//	cards3.setBackground(colours[6]);
					}
				}	
				);//closes actionListener call
		
		//button 3
				change3.addActionListener(
						new ActionListener(){
							@Override
							public void actionPerformed(ActionEvent arg0) {
								//changes background colour
								
						//			cards1.setBackground(colours[6]);
										
					//		cards2.setBackground(colours[3]);
							
								cards3.setBackground(colours[6]);
								}
						}
						);//closes actionListener call
		
		
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,4));
		buttonPanel.add(change1);
		buttonPanel.add(change2);
		buttonPanel.add(change3);
		
		//adds buttons to bottom of the layout
		pane.add(buttonPanel , BorderLayout.SOUTH);
		pane.setVisible(true);
		
		cards = new JPanel(new CardLayout());
		cards.add(cards1, "Animals");
		cards.add(cards2, "Food");
		cards.add(cards3, "Flowers");
		cards.setBounds(30, 30, 750, 750);
		getContentPane().setBackground(Color.decode("#bdb67b"));
		pane.add(comboBoxPane, BorderLayout.PAGE_START);
		pane.add(cards, BorderLayout.CENTER);
	}
	
	public void addImageToLabel(int size, String[] list, JLabel label) {
		Icon icon = new ImageIcon(getClass().getResource(list[size]));
		label.setIcon(icon);
	}
			
	
	public static void addAndShow() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Slideshow slide = new Slideshow();
		slide.addComponent(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	

//main method , starts code
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				addAndShow();
			}});
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		CardLayout c1 = (CardLayout) cards.getLayout();
		c1.show(cards, (String) e.getItem());
		
	}
}

