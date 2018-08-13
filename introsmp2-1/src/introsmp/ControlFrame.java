package introsmp;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ControlFrame extends JFrame {

	private JPanel contentPane;
	private JTable trainsTable;
	private JTable stationsTable;
	private StatusColumnCellRenderer cellRenderer;
	private JScrollPane pane;
	private DefaultTableModel stationmodel;
	private DefaultTableModel trainmodel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlFrame frame = new ControlFrame();
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
	
	public void setFreeStation (int row, int col) {
		stationmodel.setValueAt("Free", row, col);
		stationsTable.setModel(stationmodel);
	}
	
	public void lockStation (int row, int col) {
		stationmodel.setValueAt("Locked", row, col);
		stationsTable.setModel(stationmodel);
	}
	
	public void updateTrain (int trainNo, int row, int col, int val) {
		trainmodel.setValueAt(val, row, col);
		trainsTable.setModel(trainmodel);
	}
	
	
	public ControlFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cellRenderer = new StatusColumnCellRenderer();
		
		
		trainsTable = new JTable();
		trainsTable.setRowSelectionAllowed(false);
		stationsTable = new JTable();
		stationsTable.setRowSelectionAllowed(false);
		
		
		
		
		
		
		trainsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		stationsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		
		stationmodel = new DefaultTableModel(8,4);
		for (int i=0;i<stationmodel.getColumnCount();i++) {
			for (int j=0;j<stationmodel.getRowCount();j++) {
				if (i == 0)
					stationmodel.setValueAt("Station " + j, j, i);
				if (i == 3)
					stationmodel.setValueAt(0, j, i);
				else if (i > 0 && i < 3)
					stationmodel.setValueAt("Free", j, i);
			}
		}
		
		trainmodel = new DefaultTableModel(16,4);
		for (int i=0;i<trainmodel.getColumnCount();i++) {
			for (int j=0;j<trainmodel.getRowCount();j++)
				if (i == 0) 
					trainmodel.setValueAt("Train " + j, j, i);
				else
					trainmodel.setValueAt(0, j, i);
		}
		//this.intializeTables(stationmodel);
		//this.intializeTables(trainmodel);
		trainsTable.setRowHeight(20);
		stationsTable.setRowHeight(20);
		
		trainsTable.setModel(trainmodel);
		stationsTable.setModel(stationmodel);
		
		
		for (int i=1;i<3;i++)
		stationsTable.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);

		JLabel lblStations = new JLabel("Stations");
		
		JLabel lblTrains = new JLabel("Trains");
		
		JLabel lblStation = new JLabel("Station");
		
		JLabel lblTlock = new JLabel("T-Lock");
		
		JLabel lblPlock = new JLabel("P-Lock");
		
		JLabel lblSeats = new JLabel("Taken");
		
		JLabel lblAvailable = new JLabel("Available");
		
		JLabel lblWaiting = new JLabel("Waiting");
		
		JLabel lblTrainNumber = new JLabel("Train Number");
		
		JLabel lblStationNumber = new JLabel("Station Number");
		
		JButton locksButton = new JButton("Locks");
		
		JButton semaphoresButton = new JButton("Semaphores");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblStationNumber)
							.addGap(18)
							.addComponent(lblTlock, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(lblPlock, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(lblWaiting)
							.addGap(36))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblStations)
							.addContainerGap(285, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(stationsTable, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(trainsTable, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblTrainNumber)
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
							.addComponent(lblStation)
							.addGap(39)
							.addComponent(lblAvailable)
							.addGap(41)
							.addComponent(lblSeats)
							.addGap(40))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblTrains)
							.addContainerGap(295, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(locksButton)
							.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
							.addComponent(semaphoresButton)
							.addGap(50))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addComponent(lblTrains)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSeats)
						.addComponent(lblAvailable)
						.addComponent(lblStation)
						.addComponent(lblTrainNumber))
					.addGap(6)
					.addComponent(trainsTable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addComponent(lblStations)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStationNumber)
						.addComponent(lblTlock)
						.addComponent(lblPlock)
						.addComponent(lblWaiting))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(stationsTable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(locksButton)
						.addComponent(semaphoresButton))
					.addGap(9))
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
}
