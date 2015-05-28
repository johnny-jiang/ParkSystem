package main.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import main.basedata.TollboothDataBase;
import main.maintain.TollboothMangement;

import java.awt.*;

/**
 * @author jiang_yq
 * @Project: Parking
 * @ModuleID: <(模块)类编号，可以引用系统设计中的类编号>
 * @Comments: GUI of Employee Management
 * @JDKversionUsed: JDK1.8
 * @CreateDate: 2015-4-21 00:40:28
 * @ModifiedBy: jiang_yq
 * @ModifiedDate: 2015-4-21 00:40:32
 * @WhyAndWhatIsModified: change style , function didn't Implemented this time.
 * @version: 0.1 unedited!!!
 */
public class TollboothManagementFrame extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8446295736688722608L;

	public TollboothManagementFrame() {
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

		this.tManage = new TollboothMangement();
		initComponents();
	}

	public TollboothManagementFrame(TollboothMangement tm) {
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

		this.tManage = tm;
		initComponents();
	}

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
		jLabelTips = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new java.awt.GridBagLayout());

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
		gridBagConstraints.gridy = 0;
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
		gridBagConstraints.gridy = 0;
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
		gridBagConstraints.gridy = 0;
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
		gridBagConstraints.gridy = 0;
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
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
		getContentPane().add(jButtonExit, gridBagConstraints);

		jTableData.setModel(new DefaultTableModel(tManage.getCellData(),
				tManage.getColumnNames()) {
			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] { java.lang.Integer.class,
					java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { true, true, true };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
				// return true;
			}
		});

		jScrollPane2.setViewportView(jTableData);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 6;
		gridBagConstraints.gridheight = 30;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 0.8;
		gridBagConstraints.insets = new java.awt.Insets(0, 10, 2, 10);
		getContentPane().add(jScrollPane2, gridBagConstraints);

		jLabelTips
				.setText("<html>Trips: Press Edit Button after edit to update data."
						+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "Press Delete Button to delete the selected data. "
						+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "locality must be input.</html> ");
		jLabelTips.setFont(jLabelTips.getFont().deriveFont(
				jLabelTips.getFont().getSize() + 2f));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 62;
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
		this.setTitle("Tollbooth Mangement");
		pack();
	}

	private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.out.println("Button Add has been clicked!");
		for (int i = 0; i < this.jTableData.getSelectedRows().length; i++)
			System.out.println(this.jTableData.getSelectedRows()[i]
					+ " has been Selected!");
		DefaultTableModel tableModel = (DefaultTableModel) this.jTableData
				.getModel();
		tableModel.addRow(TollboothDataBase.getNewData());
	}

	private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.out.println("Button Save has been clicked!");
		DefaultTableModel tableModel = (DefaultTableModel) this.jTableData
				.getModel();
		int rowCount = tableModel.getRowCount();
		this.tManage.clearList();
		for (int i = 0; i < rowCount; i++) {
			if((Integer)tableModel.getValueAt(i, 0)==0)
				continue;
			TollboothDataBase tDat = new TollboothDataBase();
			tDat.setLocality((Integer)tableModel.getValueAt(i, 0));
			tDat.setStat((String)tableModel.getValueAt(i, 1));
			tDat.setMode((String)tableModel.getValueAt(i, 2));
			tManage.add(tDat);
		}
		this.tManage.saveTollboothDataToFile();
	}

	private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.out.println("Button Delete has been clicked!");
		DefaultTableModel tableModel = (DefaultTableModel) this.jTableData
				.getModel();
		while (this.jTableData.getSelectedRowCount() != 0) {
			tableModel.removeRow(this.jTableData.getSelectedRow());
		}
	}

	@SuppressWarnings("serial")
	private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.out.println("Button Refresh has been clicked!");
		jTableData.setModel(new DefaultTableModel(tManage.getCellData(),
				tManage.getColumnNames()) {
			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] { java.lang.Integer.class,
					java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { true, true, true };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
				// return true;
			}
		});

	}

	private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.out.println("Button Exit has been clicked!");
		tManage.saveTollboothDataToFile();
		this.dispose();
	}

	protected void finalize() {
		tManage.saveTollboothDataToFile();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */

	public static void main(String args[]) {
		/* Create and display the form */
		new TollboothManagementFrame().setVisible(true);
	}

	private JButton jButtonAdd;
	private JButton jButtonDelete;
	private JButton jButtonSave;
	private JButton jButtonExit;
	private JButton jButtonRefresh;
	private JScrollPane jScrollPane2;
	private JTable jTableData;
	private JLabel jLabelTips;
	private TollboothMangement tManage;
}
