package main.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main.basedata.BillDataBase;
import main.maintain.BillManagement;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author jiang_yq
 * @Project: Parking
 * @ModuleID: <(模块)类编号，可以引用系统设计中的类编号>
 * @Comments: GUI of Employee Management
 * @JDKversionUsed: JDK1.8
 * @CreateDate: 2015-4-21 00:40:28
 * @ModifiedBy: jiang_yq
 * @ModifiedDate: 2015-4-21 00:40:32
 * @WhyAndWhatIsModified: change style
 * @version: 0.1
 */
public class BillManagementFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = -4565944048500683295L;

	/**
	 * @Description 无参构造函数,设置风格,初始化bManage,绘制图形
	 */

	public BillManagementFrame() {
		/* Set the Metal look and feel */
		try {
			for (UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels()) {
				if ("Metal".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		this.bManage = new BillManagement();
		initComponents();
	}

	/**
	 * @Description 无参构造函数,设置风格,使用bm设置bManage,绘制图形
	 * @param bm
	 *            BillBanagement 账单管理类
	 */
	public BillManagementFrame(BillManagement bm) {
		/* Set the Metal look and feel */
		try {
			for (UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels()) {
				if ("Metal".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		this.bManage = bm;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	@SuppressWarnings("serial")
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jButtonAdd = new JButton();
		jButtonSave = new JButton();
		jButtonDelete = new JButton();
		jScrollPane2 = new JScrollPane();
		jTableData = new JTable();
		jButtonRefresh = new JButton();
		jButtonExit = new JButton();
		jLabelTips = new JLabel();
		jLabelMonth = new JLabel();
		jComboBoxMonth = new JComboBox();
		jButtonLoad = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new java.awt.GridBagLayout());

		jLabelMonth.setText("Month:");
		jLabelMonth.setHorizontalAlignment(JLabel.CENTER);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.3;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jLabelMonth, gridBagConstraints);

		jButtonLoad.setText("Load");
		jButtonLoad.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonLoadActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 5;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.4;
		gridBagConstraints.weighty = 0.2;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jButtonLoad, gridBagConstraints);

		String[] month = new String[12];
		month[0] = "unsaved";
		Date date = new Date();// 当前日期
		Calendar calendar = Calendar.getInstance();// 日历对象
		calendar.setTime(date);// 设置当前日期
		for (int i = 1; i < 12; i++) {
			calendar.add(Calendar.MONTH, -1);// 月份减一
			month[i] = sdf.format(calendar.getTime());
		}
		jComboBoxMonth.setModel(new javax.swing.DefaultComboBoxModel(month));
		jComboBoxMonth.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBoxMonthActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 0.3;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jComboBoxMonth, gridBagConstraints);

		jButtonAdd.setText("Add new");
		jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonAddActionPerformed(evt);
			}
		});
		jButtonAdd.setFont(jButtonAdd.getFont().deriveFont(
				jButtonAdd.getFont().getSize() + 2f));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jButtonAdd, gridBagConstraints);

		jButtonSave.setText("Save");
		jButtonSave.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSaveActionPerformed(evt);
			}
		});
		jButtonSave.setFont(jButtonSave.getFont().deriveFont(
				jButtonSave.getFont().getSize() + 2f));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jButtonSave, gridBagConstraints);

		jButtonDelete.setText("Delete");
		jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonDeleteActionPerformed(evt);
			}
		});
		jButtonDelete.setFont(jButtonDelete.getFont().deriveFont(
				jButtonDelete.getFont().getSize() + 2f));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jButtonDelete, gridBagConstraints);

		jButtonRefresh.setText("Refresh");
		jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonRefreshActionPerformed(evt);
			}
		});
		jButtonRefresh.setFont(jButtonRefresh.getFont().deriveFont(
				jButtonRefresh.getFont().getSize() + 2f));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jButtonRefresh, gridBagConstraints);

		jButtonExit.setText("Exit");
		jButtonExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonExitActionPerformed(evt);
			}
		});
		jButtonExit.setFont(jButtonExit.getFont().deriveFont(
				jButtonExit.getFont().getSize() + 2f));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 5;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jButtonExit, gridBagConstraints);

		jTableData.setModel(new DefaultTableModel(bManage.getCellData(),
				bManage.getColumnNames()) {
			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] { java.lang.Integer.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.Integer.class, java.lang.String.class,
					java.lang.Double.class };
			boolean[] canEdit = new boolean[] { false, true, true, true, true,
					true, true, true };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		jScrollPane2.setViewportView(jTableData);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 6;
		gridBagConstraints.gridheight = 30;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 0.8;
		gridBagConstraints.insets = new java.awt.Insets(0, 10, 2, 10);
		getContentPane().add(jScrollPane2, gridBagConstraints);

		jLabelTips
				.setText("<html>&nbsp;Trips: Press Edit Button after edit to update data."
						+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "Press Delete Button to delete the selected data. "
						+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "Stat contains :normal, paid, closed."
						+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "No stat and enter time, No data Save.</html> ");
		jLabelTips.setFont(jLabelTips.getFont().deriveFont(
				jLabelTips.getFont().getSize() + 2f));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 63;
		gridBagConstraints.gridwidth = 6;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
		getContentPane().add(jLabelTips, gridBagConstraints);

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		setSize(screenWidth / 8, screenHeight / 4);
		setLocationByPlatform(true);
		this.setTitle("Bill Mangement");
		pack();
	}

	/**
	 * @Description the response function of add button
	 */
	private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.out.println("Button Add has been clicked!");
		DefaultTableModel tableModel = (DefaultTableModel) this.jTableData
				.getModel();
		tableModel.addRow(BillDataBase.getNewData());
	}

	/**
	 * @Description the response function of save button
	 */
	private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.out.println("Button Save has been clicked!");
		if (jComboBoxMonth.getSelectedIndex() == 0) {
			DefaultTableModel tableModel = (DefaultTableModel) this.jTableData
					.getModel();
			int rowCount = tableModel.getRowCount();
			this.bManage.clearList();
			for (int i = 0; i < rowCount; i++) {
				BillDataBase bDat = new BillDataBase();
				bDat.setBillID((Integer) tableModel.getValueAt(i, 0));
				bDat.setStat((String) tableModel.getValueAt(i, 1));
				bDat.setEnterTime((String) tableModel.getValueAt(i, 2));
				bDat.setLeaveTime((String) tableModel.getValueAt(i, 3));
				bDat.setCarLicense((String) tableModel.getValueAt(i, 4));
				bDat.setOwnerID((Integer) tableModel.getValueAt(i, 5));
				bDat.setPayMode((String) tableModel.getValueAt(i, 6));
				bDat.setCount((Double) tableModel.getValueAt(i, 7));
				bManage.addBill(bDat);
			}
			this.bManage.saveAllBillDataToFile();
		} else {
			bManage.removeMonthData(jComboBoxMonth.getSelectedItem().toString());
			DefaultTableModel tableModel = (DefaultTableModel) this.jTableData
					.getModel();
			int rowCount = tableModel.getRowCount();
			monthBillManage.setFilePath(jComboBoxMonth.getSelectedItem()
					.toString() + ".dat");
			this.monthBillManage.clearList();
			for (int i = 0; i < rowCount; i++) {
				BillDataBase bDat = new BillDataBase();
				bDat.setBillID((Integer) tableModel.getValueAt(i, 0));
				bDat.setStat((String) tableModel.getValueAt(i, 1));
				bDat.setEnterTime((String) tableModel.getValueAt(i, 2));
				bDat.setLeaveTime((String) tableModel.getValueAt(i, 3));
				bDat.setCarLicense((String) tableModel.getValueAt(i, 4));
				bDat.setOwnerID((Integer) tableModel.getValueAt(i, 5));
				bDat.setPayMode((String) tableModel.getValueAt(i, 6));
				bDat.setCount((Double) tableModel.getValueAt(i, 7));
				System.out.println(monthBillManage.addBill(bDat));
			}
			this.monthBillManage.saveAllBillDataToFile();
		}
	}

	/**
	 * @Description the response function of delete button
	 */
	private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.out.println("Button Delete has been clicked!");
		DefaultTableModel tableModel = (DefaultTableModel) this.jTableData
				.getModel();
		while (this.jTableData.getSelectedRowCount() != 0) {
			tableModel.removeRow(this.jTableData.getSelectedRow());
		}
	}

	/**
	 * @Description the response function of exrefresh  button
	 */
	private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.out.println("Button Refresh has been clicked!");
		if (jComboBoxMonth.getSelectedIndex() == 0) {
			DefaultTableModel tableModel = (DefaultTableModel) this.jTableData
					.getModel();
			tableModel.setNumRows(0);
			for (Object[] p : bManage.getCellData()) {
				tableModel.addRow(p);
			}
		} else {
			List<Object[]> l = new ArrayList<Object[]>();
			Object[][] mD = monthBillManage.getCellData();
			Object[][] bD = bManage.getMonthCellData(jComboBoxMonth
					.getSelectedItem().toString());
			for (Object[] a : mD) {
				l.add(a);
			}

			for (Object[] a : bD) {
				l.add(a);
			}
			DefaultTableModel tableModel = (DefaultTableModel) this.jTableData
					.getModel();
			tableModel.setNumRows(0);
			for (Object[] p : l) {
				tableModel.addRow(p);
			}
		}
	}

	/**
	 * @Description the response function of exit button
	 */
	private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.out.println("Button Exit has been clicked!");
		bManage.saveAllBillDataToFile();
		if (monthBillManage != null)
			monthBillManage.saveAllBillDataToFile();
		this.dispose();
	}

	/**
	 * @Description the response function of month combo box
	 */
	private void jComboBoxMonthActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.out.println("Combo Box Month has been select!");
		if (jComboBoxMonth.getSelectedIndex() == 0) {
			System.out.println("unsaved data.");
			monthBillManage = null;
		} else {
			System.out.println(jComboBoxMonth.getSelectedItem());
			monthBillManage = new BillManagement(
					jComboBoxMonth.getSelectedItem() + ".dat");
		}
	}

	/**
	 * @Description the response function of load button
	 */
	private void jButtonLoadActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.out.println("Button Load has been clicked!");
		jButtonRefreshActionPerformed(evt);
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
		new BillManagementFrame().setVisible(true);
	}

	private JButton jButtonAdd;
	private JButton jButtonDelete;
	private JButton jButtonSave;
	private JButton jButtonExit;
	private JButton jButtonRefresh;
	private JScrollPane jScrollPane2;
	private JTable jTableData;
	private JLabel jLabelTips;
	private JComboBox jComboBoxMonth;
	private JLabel jLabelMonth;
	private javax.swing.JButton jButtonLoad;
	private SimpleDateFormat sdf = BillDataBase.monthsdf;// 格式化对象
	private BillManagement bManage;
	private BillManagement monthBillManage;
}
