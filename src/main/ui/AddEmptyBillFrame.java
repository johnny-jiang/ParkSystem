package main.ui;

import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import main.basedata.BillDataBase;
import main.maintain.BillManagement;
import main.maintain.ParkSpaceManagement;

/**
 * @author chuqi
 * @Project: Park
 * @ModuleID: <(模块)类编号,可以引用系统设计中的类编号>
 * @Comments: Frame of Add Empty Bill
 * @JDKversionUsed: JDK1.8
 * @CreateDate: 2015-04-19 16:45:10
 * @version: 0.2
 */
public class AddEmptyBillFrame extends JFrame {

	private static final long serialVersionUID = -1252410237560383062L;

	/**
	 * @Description 无参构造函数,设置风格,初始化bManage,pManage,绘制图形
	 */
	public AddEmptyBillFrame() {
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
		bManage = new BillManagement();
		pManage = new ParkSpaceManagement();
		initComponents();
	}

	/**
	 * @Description 无参构造函数,设置风格,使用bm和pm设置bManage,pManage,绘制图形
	 * @param bm
	 *            BillBanagement 账单管理类
	 * @param pm
	 *            ParkSpaceManagement 停车位管理
	 */
	public AddEmptyBillFrame(BillManagement bm, ParkSpaceManagement pm) {
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
		bManage = bm;
		pManage = pm;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jButtonExit = new JButton();
		jButtonAdd = new JButton();
		jLabelBIllID = new JLabel();
		jTextFieldBillID = new JTextField();
		jLabelEnter = new JLabel();
		jLabelState = new JLabel();
		jLabelLeave = new JLabel();
		jLabelCarLicense = new JLabel();
		jLabelOwnerID = new JLabel();
		jTextFieldState = new JTextField();
		jTextFieldEnter = new JTextField();
		jTextFieldLeave = new JTextField();
		jTextFieldCarLicense = new JTextField();
		jTextFieldOwnerID = new JTextField();
		jLabelTips = new JLabel();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new java.awt.GridBagLayout());

		jButtonExit.setFont(jButtonExit.getFont().deriveFont(
				jButtonExit.getFont().getSize() + 5f));
		jButtonExit.setText("Exit");
		jButtonExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonExitActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jButtonExit, gridBagConstraints);

		jButtonAdd.setFont(jButtonAdd.getFont().deriveFont(
				jButtonAdd.getFont().getSize() + 5f));
		jButtonAdd.setText("ADD");
		jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonAddActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.3;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jButtonAdd, gridBagConstraints);

		jLabelBIllID.setFont(jLabelBIllID.getFont().deriveFont(
				jLabelBIllID.getFont().getSize() + 5f));
		jLabelBIllID.setText("Bill ID:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jLabelBIllID, gridBagConstraints);

		jTextFieldBillID.setEditable(false);
		jTextFieldBillID.setFont(jTextFieldBillID.getFont().deriveFont(
				jTextFieldBillID.getFont().getSize() + 5f));
		jTextFieldBillID.setText("0");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 70;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jTextFieldBillID, gridBagConstraints);

		jLabelEnter.setFont(jLabelEnter.getFont().deriveFont(
				jLabelEnter.getFont().getSize() + 5f));
		jLabelEnter.setText("Enter Time:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jLabelEnter, gridBagConstraints);

		jLabelState.setFont(jLabelState.getFont().deriveFont(
				jLabelState.getFont().getSize() + 5f));
		jLabelState.setText("State:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jLabelState, gridBagConstraints);

		jLabelLeave.setFont(jLabelLeave.getFont().deriveFont(
				jLabelLeave.getFont().getSize() + 5f));
		jLabelLeave.setText("Leave Time:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jLabelLeave, gridBagConstraints);

		jLabelCarLicense.setFont(jLabelCarLicense.getFont().deriveFont(
				jLabelCarLicense.getFont().getSize() + 5f));
		jLabelCarLicense.setText("Car License:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jLabelCarLicense, gridBagConstraints);

		jLabelOwnerID.setFont(jLabelOwnerID.getFont().deriveFont(
				jLabelOwnerID.getFont().getSize() + 5f));
		jLabelOwnerID.setText("Owner ID:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jLabelOwnerID, gridBagConstraints);

		jTextFieldState.setEditable(false);
		jTextFieldState.setFont(jTextFieldState.getFont().deriveFont(
				jTextFieldState.getFont().getSize() + 5f));
		jTextFieldState.setText("normal");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 70;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jTextFieldState, gridBagConstraints);

		jTextFieldEnter.setText(BillDataBase.sdf.format(new Date()));
		jTextFieldEnter.setFont(jTextFieldEnter.getFont().deriveFont(
				jTextFieldEnter.getFont().getSize() + 5f));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 70;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jTextFieldEnter, gridBagConstraints);

		jTextFieldLeave.setText(BillDataBase.sdf.format(new Date()));
		jTextFieldLeave.setFont(jTextFieldLeave.getFont().deriveFont(
				jTextFieldLeave.getFont().getSize() + 5f));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 70;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jTextFieldLeave, gridBagConstraints);

		jTextFieldCarLicense.setFont(jTextFieldCarLicense.getFont().deriveFont(
				jTextFieldCarLicense.getFont().getSize() + 5f));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 70;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jTextFieldCarLicense, gridBagConstraints);

		jTextFieldOwnerID.setFont(jTextFieldOwnerID.getFont().deriveFont(
				jTextFieldOwnerID.getFont().getSize() + 5f));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.ipadx = 70;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jTextFieldOwnerID, gridBagConstraints);

		jLabelTips.setFont(jLabelTips.getFont().deriveFont(
				jLabelTips.getFont().getSize() + 5f));
		jLabelTips.setText("Time format: HH:mm:ss yyyy-MM-dd");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jLabelTips, gridBagConstraints);

		this.setTitle("Add new Bill");
		pack();
	}// </editor-fold>

	/**
	 * @Description the response function of add button
	 */
	private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.out.println("Add Exit has been clicked!");
		if (jTextFieldEnter.getText().length() != 19) {
			JOptionPane.showMessageDialog(this, "wrong enter time",
					"wrong data", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (jTextFieldLeave.getText().length() != 19) {
			JOptionPane.showMessageDialog(this, "wrong leave time",
					"wrong data", JOptionPane.ERROR_MESSAGE);
			return;
		}
		BillDataBase bDat = new BillDataBase();
		bDat.setStat("normal");
		bDat.setEnterTime(jTextFieldEnter.getText());
		bDat.setLeaveTime(jTextFieldLeave.getText());
		bDat.setCarLicense(jTextFieldCarLicense.getText());
		if (jTextFieldOwnerID.getText().equals(""))
			bDat.setOwnerID(0);
		else
			bDat.setOwnerID(Integer.parseInt(jTextFieldOwnerID.getText()));
		bManage.addBill(bDat);
		jTextFieldBillID.setText(String.valueOf(bDat.getBillID()));
		// 下面这行 添加新的订单后,剩余停车位减一
		pManage.parkin();
		JOptionPane.showMessageDialog(this,
				"New Bill ID is " + bDat.getBillID(), "Empty Bill",
				JOptionPane.OK_OPTION);
	}

	/**
	 * @Description the response function of exit button
	 */
	private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.out.println("Button Exit has been clicked!");
		bManage.saveAllBillDataToFile();
		this.dispose();
	}

	/**
	 * @Description 注销这个类的时候,调用保存函数,将数据保存到文件中.
	 */
	protected void finalize() {
		bManage.saveAllBillDataToFile();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AddEmptyBillFrame().setVisible(true);
			}
		});
	}

	// Variables declaration 
	private JButton jButtonAdd;
	private JButton jButtonExit;
	private JLabel jLabelBIllID;
	private JLabel jLabelCarLicense;
	private JLabel jLabelEnter;
	private JLabel jLabelLeave;
	private JLabel jLabelOwnerID;
	private JLabel jLabelState;
	private JLabel jLabelTips;
	private JTextField jTextFieldBillID;
	private JTextField jTextFieldCarLicense;
	private JTextField jTextFieldEnter;
	private JTextField jTextFieldLeave;
	private JTextField jTextFieldOwnerID;
	private JTextField jTextFieldState;
	private BillManagement bManage;
	private ParkSpaceManagement pManage;
	// End of variables declaration
}
