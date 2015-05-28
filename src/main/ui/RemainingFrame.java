package main.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import main.maintain.ParkSpaceManagement;

public class RemainingFrame extends javax.swing.JFrame {

	/**
	 * 
	 */

	private static final long serialVersionUID = -4936577584105419502L;
	class RefreshTask extends TimerTask {
		RemainingFrame r;

		public RefreshTask(RemainingFrame r) {
			this.r = r;
		}

		public void run() {
			r.refreshData();
		}
	}

	/**
	 * Creates new form RemainingFrame
	 */

	public void refreshData() {
		jTextParked.setText(String.valueOf(pSpaceManage.getParkCount()));
		jTextSpace.setText(String.valueOf(pSpaceManage.getEmptyCount()));
	}

	public RemainingFrame() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Metal".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(RemainingFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(RemainingFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(RemainingFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(RemainingFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		pSpaceManage = new ParkSpaceManagement();
		initComponents();
		t = new Timer();
		t.schedule(new RefreshTask(this), 500, 500);
	}

	public RemainingFrame(ParkSpaceManagement pSpaceManage) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Metal".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(RemainingFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(RemainingFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(RemainingFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(RemainingFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		this.pSpaceManage = pSpaceManage;
		initComponents();
		t = new Timer();
		t.schedule(new RefreshTask(this), 500, 500);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jLabelRemaining = new javax.swing.JLabel();
		jLabelparked = new javax.swing.JLabel();
		jLabelspace = new javax.swing.JLabel();
		jTextParked = new javax.swing.JTextField();
		jTextSpace = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new java.awt.GridBagLayout());

		jLabelRemaining.setFont(jLabelRemaining.getFont().deriveFont(
				jLabelRemaining.getFont().getSize() + 50f));
		jLabelRemaining.setText("Remaining");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 0.5;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jLabelRemaining, gridBagConstraints);

		jLabelparked.setFont(jLabelparked.getFont().deriveFont(
				jLabelparked.getFont().getSize() + 5f));
		jLabelparked.setText("Parked:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 30;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.4;
		gridBagConstraints.weighty = 0.25;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jLabelparked, gridBagConstraints);

		jLabelspace.setFont(jLabelspace.getFont().deriveFont(
				jLabelspace.getFont().getSize() + 5f));
		jLabelspace.setText("Space:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 30;
		gridBagConstraints.ipady = 6;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.4;
		gridBagConstraints.weighty = 0.25;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jLabelspace, gridBagConstraints);

		jTextParked.setEditable(false);
		jTextParked.setFont(jTextParked.getFont().deriveFont(
				jTextParked.getFont().getSize() + 5f));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 80;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.4;
		gridBagConstraints.weighty = 0.25;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jTextParked, gridBagConstraints);

		jTextSpace.setEditable(false);
		jTextSpace.setFont(jTextSpace.getFont().deriveFont(
				jTextSpace.getFont().getSize() + 5f));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 80;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.4;
		gridBagConstraints.weighty = 0.25;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jTextSpace, gridBagConstraints);
		
		refreshData();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		setSize(screenWidth / 6, screenHeight / 6);
		setLocationByPlatform(true);
		this.setTitle("Remaining");
		pack();
	}// </editor-fold>

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		// </editor-fold>
		ParkSpaceManagement pSpace = new ParkSpaceManagement();

		/* Create and display the form */
		new RemainingFrame(pSpace).setVisible(true);
//		try {
//			Thread.sleep(3000);
//			pSpace.parkAt(3);
//			Thread.sleep(3000);
//			pSpace.parkAt(2);
//			Thread.sleep(3000);
//			pSpace.leaveAt(3);
//			Thread.sleep(3000);
//			pSpace.leaveAt(2);
//		} catch (InterruptedException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
	}

	// Variables declaration - do not modify
	private javax.swing.JLabel jLabelRemaining;
	private javax.swing.JLabel jLabelparked;
	private javax.swing.JLabel jLabelspace;
	private javax.swing.JTextField jTextParked;
	private javax.swing.JTextField jTextSpace;
	private ParkSpaceManagement pSpaceManage;
	private Timer t;
	// End of variables declaration
}
