import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel columnHeader;
	private JPanel drawingPanel;
	private JTextField requestsField;
	private JLabel seekTimeNum;
	private JRadioButton rdbtnLeft;
	private JRadioButton rdbtnRight;
	private JPanel SequencePanel;
	private ButtonGroup group;
	private boolean headPresent;
	ArrayList<Integer> requests = new ArrayList<Integer>();
	ArrayList<Integer> sortedRequests = new ArrayList<Integer>();
	ArrayList<Integer> xAxis = new ArrayList<Integer>();
	ArrayList<Integer> sequence = new ArrayList<Integer>();
	ArrayList<Integer> sequenceIndex = new ArrayList<Integer>();
	int scheduler, head = -1, headIndex, direction = -1;
	private JTextField headField;
	private Ellipse2D.Double circle;

   public void draw(Graphics2D g2) {
    	  setBackground(Color.WHITE);
    	  setForeground(Color.BLACK);
    	  g2.setColor(Color.BLUE);
    	  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    	  int yAxis = 20, lastVal = 0;
    	  if (direction == 1) { //right
    		  lastVal = sortedRequests.size() - 1;
    	  } else if (direction == 2) { //left
    		  lastVal = 0;
    	  }
    	  if (xAxis.size() > 0) {
    		  for (int i = 0; i < sequenceIndex.size(); i++) {
    			  circle = new Ellipse2D.Double(xAxis.get(sequenceIndex.get(i)+1),yAxis,8,8);
       			  g2.draw(circle);
    			  g2.fill(circle);

 				  if (direction == 2 && sortedRequests.get(0) == sequence.get(i)) {
					  if (scheduler == 2) {
						  drawExtraNode(g2, i, yAxis, 0, sequenceIndex.get(i+1)+1);
						  yAxis+=40;
					  } else if (scheduler == 3) {
						  drawExtraNode(g2, i, yAxis, 0, xAxis.size()-1);
						  yAxis+=20;
						  drawExtraNode(g2, i, yAxis, xAxis.size()-1, sequenceIndex.get(i+1)+1);
						  yAxis+=40;
					  } else {
	        			  if (i != sequenceIndex.size() - 1) {
	        				  g2.drawLine(xAxis.get(sequenceIndex.get(i)+1), yAxis+2, xAxis.get(sequenceIndex.get(i+1)+1), yAxis+22);
	        			  }
	        			  yAxis+=20;
					  }
				  } else if (direction == 1 && sortedRequests.get(sortedRequests.size() - 1) - 80 == sequence.get(i) - 80){
					  if (scheduler == 2) {
						  drawExtraNode(g2, i, yAxis, xAxis.size()-1, sequenceIndex.get(i+1)+1);
						  yAxis+=40;
					  } else if (scheduler == 3) {
						  drawExtraNode(g2, i, yAxis, xAxis.size()-1, 0);
						  yAxis+=20;
						  drawExtraNode(g2, i, yAxis, 0, sequenceIndex.get(i+1)+1);
						  yAxis+=40;
					  } else {
	        			  if (i != sequenceIndex.size() - 1) {
	        				  g2.drawLine(xAxis.get(sequenceIndex.get(i)+1), yAxis+2, xAxis.get(sequenceIndex.get(i+1)+1), yAxis+22);
	        			  }
	        			  yAxis+=20;
					  }
				  } else {
        			  if (i != sequenceIndex.size() - 1) {
        				  g2.drawLine(xAxis.get(sequenceIndex.get(i)+1), yAxis+2, xAxis.get(sequenceIndex.get(i+1)+1), yAxis+22);
        			  }
        			  yAxis+=20;
				  }
    		  }
    	  }
   }	
   
   public void drawExtraNode(Graphics2D g2, int i, int yAxis, int location, int nextLocation) {
	      if (location != xAxis.size() - 1 && direction == 2) {
	    	  g2.drawLine(xAxis.get(sequenceIndex.get(i)+1), yAxis+2, xAxis.get(location), yAxis+22);
	      }
	      if (location != 0  && direction == 1) {
	    	  g2.drawLine(xAxis.get(sequenceIndex.get(i)+1), yAxis+2, xAxis.get(location), yAxis+22);
	      }
		  yAxis+=20;
		  circle = new Ellipse2D.Double(xAxis.get(location),yAxis,8,8);
		  g2.draw(circle);
		  g2.fill(circle);
		  if (i != sequenceIndex.size() - 1) {
			  g2.drawLine(xAxis.get(location), yAxis+2, xAxis.get(nextLocation), yAxis+22);
		  }
		  yAxis+=20;
   }
   
    public void drawSequence(Graphics2D g2) {
    	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    	g2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
    	for (int i = 0; i < sequence.size(); i++) {
    		if (!headPresent && i == 0) {
    			continue;
    		}
    		g2.drawString("" + sequence.get(i), 58, 45 * (i + 1));
    	}
    }
   
   public void getSequenceIndex() {
	   for (int i = 0; i < sequence.size(); i++) {
		   for (int j = 0; j < sortedRequests.size(); j++) {
			   if (sequence.get(i) - 80 == sortedRequests.get(j) - 80) {
				   sequenceIndex.add(j);
			   }
		   }
		   if (sortedRequests.get(i) == head) {
			   headIndex = i;
		   }
		   
	   }
	   if (!headPresent) {
		   sequenceIndex.add(0, headIndex);
		   sequence.add(0, head);
	   }
   }

	/**
	 * Create the frame.
	 */
	public GUI() {
		
		setTitle("Disk Scheduling Algorithms");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 521);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		requestsField = new JTextField();
		requestsField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		requestsField.setBounds(227, 335, 272, 27);
		contentPane.add(requestsField);
		requestsField.setColumns(10);
		
		JLabel lblRequests = new JLabel("Enter the  I/O requests:");
		lblRequests.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblRequests.setBounds(25, 332, 242, 32);
		contentPane.add(lblRequests);
		
		JLabel lblChooseAlgo = new JLabel("Select the Scheduler you want to use:");
		lblChooseAlgo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblChooseAlgo.setBounds(25, 289, 242, 32);
		contentPane.add(lblChooseAlgo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"First Come First Served", "Shortest-Seek-Time-First", "SCAN", "C-SCAN", "LOOK", "C-LOOK", "New Optimized Algorithm"}));
		comboBox.setBounds(307, 295, 192, 20);
		contentPane.add(comboBox);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requests.clear();
				sortedRequests.clear();
				xAxis.clear();
				sequence.clear();
				sequenceIndex.clear();
				headPresent = false;
				direction = -1;
			
				head = Integer.parseInt(headField.getText());
				int req;
				String [] str = requestsField.getText().split(" ");
				for (int i = 0; i < str.length; i++) {
					req = Integer.parseInt(str[i]);
					requests.add(req);
					sortedRequests.add(req);
					if (head == req) {
						headPresent = true;
					}
				}
				if (!headPresent) {
					sortedRequests.add(head);
				}
				Collections.sort(sortedRequests);

				scheduler = comboBox.getSelectedIndex();
				if (rdbtnRight.isSelected()) {
					direction = 1;
				}
				if (rdbtnLeft.isSelected()) {
					direction = 2;
				}
				
				switch(scheduler) {
					case 0:
						seekTimeNum.setText("" + FCFS.calculateTotalSeekTime(requests, head));
						sequence = requests;
						break;
					case 1:
						seekTimeNum.setText("" + SSTF.calculateTotalSeekTime(requests, head));
						sequence = SSTF.getSequence();
						break;
					case 2: 
						seekTimeNum.setText("" + Scan.calculateTotalSeekTime(requests, head, direction));
						sequence = Scan.getSequence();
						break;
					case 3: {
						seekTimeNum.setText("" + CScan.calculateTotalSeekTime(requests, head, direction));
						sequence = CScan.getSequence();
						int index = sequence.indexOf(199);
						sequence.remove(index);
						index = sequence.indexOf(0);
						sequence.remove(index);
						break;
					}
					case 4:
						seekTimeNum.setText("" + Look.calculateTotalSeekTime(requests, head, direction));
						sequence = Look.getSequence();
						break;
					case 5: 
						seekTimeNum.setText("" + CLook.calculateTotalSeekTime(requests, head, direction));
						sequence = CLook.getSequence();
						break;
					case 6: 
						seekTimeNum.setText("" + Optimized.calculateTotalSeekTime(requests, head));
						sequence = Optimized.getSequence();
						break;
				}
				getSequenceIndex();
				group.clearSelection();
				contentPane.repaint();
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSubmit.setBounds(227, 432, 89, 32);
		contentPane.add(btnSubmit);
	
		
		SequencePanel = new JPanel() {
			
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
	        	  Graphics2D g2d=(Graphics2D)g;
	        	  drawSequence(g2d);
		    }
		};
		SequencePanel.setBackground(SystemColor.menu);
		SequencePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		SequencePanel.setBounds(526, 0, 155, 483);
		contentPane.add(SequencePanel);
		SequencePanel.setLayout(null);
		
		JLabel lblSequence = new JLabel("Sequence");
		lblSequence.setForeground(new Color(153, 102, 204));
		lblSequence.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblSequence.setBounds(37, 23, 92, 27);
		SequencePanel.add(lblSequence);
		
	    JLabel[] corners = new JLabel[4];
	    for (int i = 0; i < 4; i++) {
	      corners[i] = new JLabel();
	      corners[i].setBackground(Color.white);
	      corners[i].setOpaque(true);
	    }
	    
	    columnHeader = new JLabel() {

	        public void paintComponent(Graphics g) {
	          Graphics2D g2 = (Graphics2D) g;
	          super.paintComponent(g);
	          Rectangle r = g.getClipBounds();
	          int j = 0;
	          for (int i = 20 - (r.x % 50); i < r.width; i += 40) {
	            if (j < sortedRequests.size()) {
	            	xAxis.add(r.x + i);
	            	g.drawLine(r.x + i, 0, r.x + i, 3);
	            	if (i == 20) {
	            		g.drawString("" + (0), r.x + i - 5, 16);
	            		j = -1;
	            	} else {
	            		g.drawString("" + (sortedRequests.get(j)), r.x + i - 5, 16);
	            	}
	            	j++;
	            }
	            if (j == sortedRequests.size() && j != 0 && i != xAxis.get(xAxis.size()-1)) {
	            	xAxis.add(r.x + i);
	            	g.drawLine(r.x + i, 0, r.x + i, 3);
	            	g.drawString("" + (199), r.x + i - 5, 16);
	            	break;
	            }
	          }
	        }

	        public Dimension getPreferredSize() {
	          return new Dimension((int) 25, 25);
	        }
	      };
	    columnHeader.setBackground(Color.white);
	    columnHeader.setOpaque(true);
		scrollPane = new JScrollPane();
	    scrollPane.setColumnHeaderView(columnHeader);
	    scrollPane.setCorner(JScrollPane.LOWER_LEFT_CORNER, corners[0]);
	    scrollPane.setCorner(JScrollPane.LOWER_RIGHT_CORNER, corners[1]);
	    scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, corners[2]);
	    scrollPane.setCorner(JScrollPane.UPPER_RIGHT_CORNER, corners[3]);
		scrollPane.setBounds(10, 29, 500, 189);
		contentPane.add(scrollPane);
		
		drawingPanel = new JPanel() {
			
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
	        	  Graphics2D g2d=(Graphics2D)g;
	        	  draw(g2d);
		    }
		};
		drawingPanel.setPreferredSize(new Dimension(400, 700));
		drawingPanel.revalidate();
		scrollPane.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
		scrollPane.setViewportView(drawingPanel);
		
		JLabel lblTotalSeekTime = new JLabel("Total Seek Time:");
		lblTotalSeekTime.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotalSeekTime.setBounds(165, 229, 131, 20);
		contentPane.add(lblTotalSeekTime);
		
		seekTimeNum = new JLabel("0");
		seekTimeNum.setFont(new Font("Times New Roman", Font.BOLD, 15));
		seekTimeNum.setBounds(295, 232, 46, 14);
		contentPane.add(seekTimeNum);
		
		JLabel lblHead = new JLabel("Enter the initial head position:");
		lblHead.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblHead.setBounds(25, 375, 199, 32);
		contentPane.add(lblHead);
		
		headField = new JTextField();
		headField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		headField.setColumns(10);
		headField.setBounds(227, 378, 64, 27);
		contentPane.add(headField);
		
		JLabel lblDirection = new JLabel("Direction:");
		lblDirection.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblDirection.setBounds(323, 375, 81, 32);
		contentPane.add(lblDirection);
		
		rdbtnLeft = new JRadioButton("Left");
		rdbtnLeft.setBackground(new Color(204, 204, 255));
		rdbtnLeft.setFont(new Font("Times New Roman", Font.BOLD, 14));
		rdbtnLeft.setBounds(398, 380, 52, 23);
		contentPane.add(rdbtnLeft);
		
		rdbtnRight = new JRadioButton("Right");
		rdbtnRight.setFont(new Font("Times New Roman", Font.BOLD, 14));
		rdbtnRight.setBackground(new Color(204, 204, 255));
		rdbtnRight.setBounds(452, 380, 59, 23);
		contentPane.add(rdbtnRight);
		
		group = new ButtonGroup();
		group.add(rdbtnLeft);
		group.add(rdbtnRight);
		
		scrollPane.repaint();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
