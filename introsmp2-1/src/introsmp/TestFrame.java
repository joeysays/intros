package introsmp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.concurrent.locks.ReentrantLock;
import java.awt.event.ActionEvent;

public class TestFrame extends JFrame {

	private JPanel contentPane;
	private Runner runner;
	private JLabel lblNewLabel;
	private int i=0;
	private JButton btnReset;
	private ReentrantLock lock = new ReentrantLock();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
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
	public void removeBlack () {
		lblNewLabel.setText("Thread 1: " + i);
	}
	
	public void removeWhite () {
		lblNewLabel.setText("Thread 2: " + i);
	}
	
	
	public TestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("Threading Test");
		

		
		JButton btnNewButton = new JButton("Activate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Thread t1 = new Thread() {
					
					public void run() {
						lock.lock();
						while (i <= 1000) {
							
							removeBlack();
							System.out.println("Thread 1:  " + i);
							i++;
							
							try {
//								Thread.sleep(1000);
								Thread.sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						lock.unlock();


					}
				};
				
				Thread t2 = new Thread() {
					
					public void run() {
						lock.lock();
						while (i <= 2000) {
							
							removeWhite();
							System.out.println("Thread 2: " + i);
							i++;
							
							try {
//								Thread.sleep(1000);
								Thread.sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						lock.unlock();

					}
				};
				
				t1.start();
				t2.start();
				

				
			}
			
		});
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = 0;
				lblNewLabel.setText("Threading Test");
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(56))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(160)
					.addComponent(lblNewLabel)
					.addContainerGap(168, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnReset))
					.addGap(36))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
