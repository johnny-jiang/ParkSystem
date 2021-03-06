/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.ui;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import main.basedata.BillDataBase;
import main.business.ChargeManagement;
import main.maintain.BillManagement;
import main.maintain.CarManagement;
import main.maintain.ParkSpaceManagement;

/**
 *
 * @author jiang_yq
 */
public class EntranceFrame extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6535598972575272955L;

	/**
	 * Creates new form EntranceJFrame
	 */

	class RefreshTask extends TimerTask {
		EntranceFrame e;

		public RefreshTask(EntranceFrame e) {
			this.e = e;
		}

		public void run() {
			e.checkPublic();
		}
	}

	public void checkPublic() {
		if (pSpaceManage.getEmptyCount() > 0)
			jTextFieldStat.setText("OPEN");
		else
			jTextFieldStat.setText("CLOSE");
		jButtonPublic.setEnabled(chargeManage.checkTodayPublic());
	}

	public EntranceFrame() {
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
		enteranceID = 0;
		pSpaceManage = new ParkSpaceManagement();
		bManage = new BillManagement();
		carManage = new CarManagement();
		chargeManage = new ChargeManagement();
		initComponents();
		t = new Timer();
		t.schedule(new RefreshTask(this), 500, 500);
	}

	public EntranceFrame(int eID, BillManagement bm, ParkSpaceManagement psm,
			CarManagement carm, ChargeManagement cm) {
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
		enteranceID = eID;
		pSpaceManage = psm;
		bManage = bm;
		carManage = carm;
		chargeManage = cm;
		initComponents();
		t = new Timer();
		t.schedule(new RefreshTask(this), 100, 100);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jLabelTips = new javax.swing.JLabel();
		jTextFieldLicense = new javax.swing.JTextField();
		jButtonPublic = new javax.swing.JButton();
		jButtonEmployee = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextAreaData = new javax.swing.JTextArea();
		jLabelStat = new javax.swing.JLabel();
		jTextFieldStat = new javax.swing.JTextField();
		jLabelID = new javax.swing.JLabel();
		jTextFieldEnteranceID = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new java.awt.GridBagLayout());

		jLabelTips.setText("Input car license or press public button.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		getContentPane().add(jLabelTips, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 175;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.4;
		gridBagConstraints.weighty = 0.2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		getContentPane().add(jTextFieldLicense, gridBagConstraints);

		jButtonPublic.setText("Public");
		jButtonPublic.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonPublicActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.6;
		gridBagConstraints.weighty = 0.4;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		getContentPane().add(jButtonPublic, gridBagConstraints);

		jButtonEmployee.setText("Employee");
		jButtonEmployee.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonEmployeeActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.4;
		gridBagConstraints.weighty = 0.2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		getContentPane().add(jButtonEmployee, gridBagConstraints);

		jTextAreaData.setColumns(20);
		jTextAreaData.setRows(5);
		jTextAreaData.setEditable(false);
		jScrollPane1.setViewportView(jTextAreaData);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.gridwidth = 4;
		gridBagConstraints.gridheight = 6;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 0.4;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		getContentPane().add(jScrollPane1, gridBagConstraints);

		jLabelStat.setFont(jLabelStat.getFont().deriveFont(
				jLabelStat.getFont().getSize() + 25f));
		jLabelStat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelStat.setText("Stat:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.weighty = 0.2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		getContentPane().add(jLabelStat, gridBagConstraints);

		jTextFieldStat.setEditable(false);
		jTextFieldStat.setFont(jTextFieldStat.getFont().deriveFont(
				jTextFieldStat.getFont().getSize() + 10f));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.7;
		gridBagConstraints.weighty = 0.2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		getContentPane().add(jTextFieldStat, gridBagConstraints);

		jLabelID.setFont(jLabelID.getFont().deriveFont(
				jLabelID.getFont().getSize() + 10f));
		jLabelID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelID.setText("Enterance ID:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.3;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		getContentPane().add(jLabelID, gridBagConstraints);

		jTextFieldEnteranceID.setEditable(false);
		jTextFieldEnteranceID.setText(String.valueOf(enteranceID));
		jTextFieldEnteranceID.setFont(jTextFieldEnteranceID.getFont()
				.deriveFont(jTextFieldEnteranceID.getFont().getSize() + 10f));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.7;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		getContentPane().add(jTextFieldEnteranceID, gridBagConstraints);

		this.setTitle("Enterance");
		pack();
	}// </editor-fold>

	private void jButtonPublicActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.out.println("Button Public has been clicked.");
		BillDataBase bDat = new BillDataBase();
		bDat.setEnterTime(new Date());
		if (bManage.addBill(bDat) && pSpaceManage.getEmptyCount() > 0) {
			pSpaceManage.parkin();
			jTextAreaData.append(bDat.getEnterMessage());
			JOptionPane.showMessageDialog(this,
					"Please enter. \nYour Bill ID is " + bDat.getBillID(),
					"Bill Add Success", JOptionPane.INFORMATION_MESSAGE);
			// bManage.saveAllBillDataToFile();
			// pSpaceManage.saveParkSpaceDataToFile();
		} else {
			JOptionPane.showMessageDialog(this, "add bill error!",
					"Bill Add Fail", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jButtonEmployeeActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.out.println("Button Employee has been clicked.");
		int ownerID = carManage.getOwnerIDByCarLisence(jTextFieldLicense
				.getText().trim());
		if (ownerID == -1) {
			JOptionPane.showMessageDialog(this, "wrong License!",
					"wrong License", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			System.out.println("ownerID: " + ownerID);
			BillDataBase bDat = new BillDataBase();
			bDat.setCarLicense(jTextFieldLicense.getText());
			bDat.setOwnerID(ownerID);
			bDat.setEnterTime(new Date());
			if (bManage.addBill(bDat) && pSpaceManage.getEmptyCount() > 0) {
				pSpaceManage.parkin();
				jTextAreaData.append(bDat.getEnterMessage());
				JOptionPane.showMessageDialog(this,
						"Please enter. \nYour Bill ID is " + bDat.getBillID(),
						"Bill Add Success", JOptionPane.INFORMATION_MESSAGE);
				// bManage.saveAllBillDataToFile();
				// pSpaceManage.saveParkSpaceDataToFile();
			} else {
				JOptionPane.showMessageDialog(this, "add bill error!",
						"Bill Add Fail", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		new EntranceFrame().setVisible(true);
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButtonEmployee;
	private javax.swing.JButton jButtonPublic;
	private javax.swing.JLabel jLabelTips;
	private javax.swing.JLabel jLabelID;
	private javax.swing.JLabel jLabelStat;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextAreaData;
	private javax.swing.JTextField jTextFieldEnteranceID;
	private javax.swing.JTextField jTextFieldLicense;
	private javax.swing.JTextField jTextFieldStat;
	private int enteranceID;
	private BillManagement bManage;
	private CarManagement carManage;
	private ParkSpaceManagement pSpaceManage;
	private ChargeManagement chargeManage;
	private Timer t;
	// End of variables declaration
}
