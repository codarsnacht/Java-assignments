import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Jama.Matrix;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;
import java.awt.event.ActionEvent;

import java.math.*;

public class Classafier extends JFrame {

	private static final long serialVersionUID = -2072408454979685333L;
	private JPanel contentPane;
	LinkedList<Owl> ll = new LinkedList<Owl>();	
	final LinkedList<Owl> trainingLL = new LinkedList<Owl>();
	LinkedList<Owl> holdoutSetLL = new LinkedList<Owl>();
	int count;
	//new class for computing the calculations
	logisticRegressionCalculate lrc = new logisticRegressionCalculate();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Classafier frame = new Classafier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Classafier() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 346);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			
				
		JLabel barnOwlLabel = new JLabel("Barn Owl #");
		barnOwlLabel.setBounds(10, 163, 133, 14);
		contentPane.add(barnOwlLabel);
		
		JLabel snowyOwlLabel = new JLabel("Snowy Owl #");
		snowyOwlLabel.setBounds(10, 199, 133, 14);
		contentPane.add(snowyOwlLabel);
		
		JLabel earedOwlLabel = new JLabel("Long-Eared Owl #");
		earedOwlLabel.setBounds(10, 235, 133, 14);
		contentPane.add(earedOwlLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(208, 11, 265, 188);
		contentPane.add(panel);
		
		JLabel lblActual = new JLabel("Actual");
		lblActual.setBounds(364, 210, 46, 14);
		contentPane.add(lblActual);
		
		JLabel lblPredicted = new JLabel("Predicted");
		lblPredicted.setBounds(241, 257, 71, 14);
		contentPane.add(lblPredicted);
		
		JLabel lblNewLabel = new JLabel("TP");
		lblNewLabel.setBounds(330, 235, 56, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FP");
		lblNewLabel_1.setBounds(412, 235, 61, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("FN");
		lblNewLabel_2.setBounds(330, 271, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblTn = new JLabel("TN");
		lblTn.setBounds(412, 271, 46, 14);
		contentPane.add(lblTn);
		
		JLabel totalCasesLabel = new JLabel("Total Cases: ");
		totalCasesLabel.setBounds(10, 271, 113, 14);
		contentPane.add(totalCasesLabel);
		
		Vector vec= new Vector(6);
		vec.add(4);
		vec.add(4);
		vec.add(4);
		vec.add(4);
		vec.add(4);
		vec.add(4);
		vec.add(4);
		
		System.out.println("Capacity is " + vec.capacity());
		
		JButton btnClassify = new JButton("Classify");
		btnClassify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				trainingLL.clear();
				holdoutSetLL.clear();
				
				int train = (int) (count * 0.67);
				System.out.println("train is: " + train + ", holdout is " + (count - train));
				
				// Random (shuffle) the Linkedlist containing all Owl Objects
				Collections.shuffle(ll);
				
				for(int i = 0; i < train; i++) {
					trainingLL.add(ll.get(i));
				}
				
				for(int i = train; i < count; i++) {
					holdoutSetLL.add(ll.get(i));
				}
				
				System.out.println("Shuffled: Body Length of Owl Indexed 2 is: " + ll.get(2).getBodyLength());
				System.out.println("trainingLL size is " + trainingLL.size());
				System.out.println("holdoutSetLL size is " + holdoutSetLL.size());
			}
		});
		btnClassify.setBounds(10, 66, 89, 23);
		contentPane.add(btnClassify);
		
		
		
		JButton btnLoadFile = new JButton("Load File");
		btnLoadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				count = 0;
				Owl owl;
				String csvFile = "C:\\Test\\owls.csv";
		        BufferedReader br = null;
		        String line = "";
		        String cvsSplitBy = ",";
		        int barnOwls = 0, snowOwls = 0, lEaredOwls = 0;
		        
				try {
					br = new BufferedReader(new FileReader(csvFile));
					while ((line = br.readLine()) != null) {

						// comma deliminator
						String[] owlCase = line.split(cvsSplitBy);

						owl = new Owl(Double.parseDouble(owlCase[0]), Double.parseDouble(owlCase[1]),
								Double.parseDouble(owlCase[2]), Double.parseDouble(owlCase[3]), owlCase[4]);
						ll.add(owl);
						count++;
						
						 switch (owlCase[4]) {
				         case "BarnOwl":
				        	 barnOwls ++;
				             break;
				         case "SnowyOwl":
				        	 snowOwls ++;
				             break;
				         case "LongEaredOwl":
				        	 lEaredOwls ++;
				             break;
				         default:
				             throw new IllegalArgumentException("Invalid Owl: " + owlCase[4]);
						}

						//System.out.println("Body-Length = " + owl.getBodyLength() + ", Type = " + owl.getType()
						//		+ ", size is " + ll.size());
						
					}
					
					barnOwlLabel.setText("Barn Owls # " + barnOwls);
					snowyOwlLabel.setText("Snowy Owls # " + snowOwls);
					earedOwlLabel.setText("Long-eared Owls # " + lEaredOwls);	
					totalCasesLabel.setText("Total Cases: " + count);
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnLoadFile.setBounds(10, 21, 89, 23);
		contentPane.add(btnLoadFile);
		
	}
	
	
}
