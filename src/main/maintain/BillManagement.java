package main.maintain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import main.basedata.BillDataBase;

/**
 * @author chuqi
 * @Project Park
 * @ModuleID <(模块)类编号,可以引用系统设计中的类编号>
 * @Comments Bill Data management
 * @JDKversionUsed JDK1.8
 * @CreateDate 2015-05-05 23:10:21
 * @version 0.1
 */
public class BillManagement {
	List<BillDataBase> billList;
	List<BillDataBase> paidBillList;
	List<BillDataBase> closedBillList;
	double cash;
	String filePath = "bill.dat";
	int nextBillID;

	/**
	 * @Description 无参构造函数,初始化三个链表及nextBillID,并从文件中读取信息
	 */
	public BillManagement() {
		this.billList = new ArrayList<BillDataBase>();
		this.paidBillList = new ArrayList<BillDataBase>();
		this.closedBillList = new ArrayList<BillDataBase>();
		nextBillID = 0;
		this.getAllBillDataFromFile();
	}

	/**
	 * @Description 有参构造函数,设置filePath的值为file,初始化三个链表及nextBillID,并从文件中读取信息
	 * @param file
	 *            数据文件路径
	 */
	public BillManagement(String file) {
		filePath = file;
		this.billList = new ArrayList<BillDataBase>();
		this.paidBillList = new ArrayList<BillDataBase>();
		this.closedBillList = new ArrayList<BillDataBase>();
		nextBillID = 0;
		this.getAllBillDataFromFile();
	}

	/**
	 * @Description 注销这个类的时候,调用保存函数,将数据保存到文件中.
	 */
	protected void finalize() {
		this.saveAllBillDataToFile();
	}

	/**
	 * @Description 将数据保存到文数据文件中.若成功返回true,否则返回false.
	 * @return boolean
	 */
	public boolean saveAllBillDataToFile() {
		/* if save data success return true, else return false. */
		// 保存数据到ParkSpaceDataBase中
		File pDatFile = new File(this.filePath);
		if (pDatFile.exists() == true) {
			// if file exists , delete it!
			System.out.println("Bill Data File Exists!");
			if (pDatFile.delete() == true)
				System.out.println("Bill Data File Delete Success!");
			else {
				System.out.println("Bill Data File Delete Fail!");
				return false;
			}
		}
		FileWriter Writer;
		try {
			class SortByID implements Comparator<BillDataBase> {
				public int compare(BillDataBase o1, BillDataBase o2) {
					BillDataBase s1 = (BillDataBase) o1;
					BillDataBase s2 = (BillDataBase) o2;
					if (s1.getBillID() > s2.getBillID())
						return 1;
					return 0;
				}
			}
			Collections.sort(billList, new SortByID());
			Collections.sort(paidBillList, new SortByID());
			Collections.sort(closedBillList, new SortByID());
			Writer = new FileWriter(this.filePath, true);
			BufferedWriter bufferedWriter = new BufferedWriter(Writer);
			bufferedWriter.write(this.nextBillID + "," + this.cash + '\n');
			for (BillDataBase bDat : this.billList) {
				bufferedWriter.write(bDat.toString() + '\n');
			}
			for (BillDataBase bDat : this.paidBillList) {
				bufferedWriter.write(bDat.toString() + '\n');
			}
			for (BillDataBase bDat : this.closedBillList) {
				bufferedWriter.write(bDat.toString() + '\n');
			}
			bufferedWriter.close();
			System.out.println("Bill Data Save Success!");
			return true;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @Description 从文件中读取数据,分别放到三个表中.成功返回true,失败返回false
	 * @return boolean
	 */
	public boolean getAllBillDataFromFile() {
		/* if read data success return true, else return false. */
		// 从文件中读取数据
		File pDatFile = new File(this.filePath);
		if (pDatFile.exists() == true) {
			FileReader reader;
			try {
				reader = new FileReader(this.filePath);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String line = null;
				BillDataBase bDat = new BillDataBase();
				// System.out.print(line);
				if ((line = bufferedReader.readLine()) != null) {
					nextBillID = Integer.parseInt(line.split(",")[0]);
					cash = Double.parseDouble(line.split(",")[1]);
				}
				while ((line = bufferedReader.readLine()) != null) {
					bDat = new BillDataBase(line);
					this.addBill(bDat);
				}
				bufferedReader.close();
				System.out.println("Bill Data Read Success!");
				return true;
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} else {
			System.out.println("Bill Data File NOT Exists!");
			return false;
		}
		return false;
	}

	/**
	 * @Description 查找订单id等于billID的订单.成功返回此订单信息,失败返回null
	 * @param billID
	 *            所需查找的订单编号
	 * @return BillDataBase 返回找到的订单数据
	 */
	public BillDataBase getBillByBillID(int billID) {
		for (BillDataBase bDat : this.billList) {
			if (bDat.getBillID() == billID)
				return bDat;
		}
		for (BillDataBase bDat : this.paidBillList) {
			if (bDat.getBillID() == billID)
				return bDat;
		}
		return null;
	}

	/**
	 * @Description 查找车牌号等于License的订单.成功返回此订单信息,失败返回null
	 * @param License
	 *            所需查找的车牌号
	 * @return BillDataBase 返回找到的订单数据
	 */
	public BillDataBase getBillByLicense(String License) {
		for (BillDataBase bDat : this.paidBillList) {
			if (bDat.getCarLicense().equals(License))
				return bDat;
		}
		for (BillDataBase bDat : this.billList) {
			if (bDat.getCarLicense().equals(License))
				return bDat;
		}
		return null;
	}

	/**
	 * @Description 
	 *              查找订单id等于billID的订单,将此订单从billList表移到paidBillList表中.移动成功返回true,失败返回false
	 * @param billID
	 *            所需查找的订单编号
	 * @return boolean 移动结果
	 */

	public boolean moveFromListToPaidList(int billID) {
		for (int i = 0; i < billList.size(); i++) {
			if (billList.get(i).getBillID() == billID) {
				paidBillList.add(new BillDataBase(billList.get(i)));
				billList.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * @Description 
	 *              查找订单id等于billID的订单,将此订单从billList表移到paidList表中.移动成功返回true,失败返回false
	 * @param billID
	 *            所需查找的订单编号
	 * @return boolean 移动结果
	 */
	public boolean moveFromPaidListToCloseList(int billID) {
		for (int i = 0; i < paidBillList.size(); i++) {
			if (paidBillList.get(i).getBillID() == billID) {
				closedBillList.add(new BillDataBase(paidBillList.get(i)));
				paidBillList.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * @Description 将bDat的数据插入到表中.成功返回true,失败返回false
	 * @param bDat
	 *            BillDataBase 增加的订单的数据
	 * @return boolean 插入结果
	 */

	public boolean addBill(BillDataBase bDat) {
		if (bDat.getBillID() == 0) {
			bDat.setBillID(nextBillID);
			switch (bDat.getStat()) {
			case 0:
				if (billList.add(bDat)) {
					nextBillID++;
					return true;
				}
			case 1:
				if (paidBillList.add(bDat)) {
					nextBillID++;
					return true;
				}
			case 2:
				if (closedBillList.add(bDat)) {
					nextBillID++;
					return true;
				}
			}
		} else {
			switch (bDat.getStat()) {
			case 0:
				return billList.add(bDat);
			case 1:
				return paidBillList.add(bDat);
			case 2:
				return closedBillList.add(bDat);
			}

		}
		return false;
	}

	/**
	 * @Description 清空三个表中的所有数据
	 */

	public void clearList() {
		billList.clear();
		paidBillList.clear();
		closedBillList.clear();
	}

	/**
	 * @Description 获得用于填充表格的数据
	 * @return Object[][]
	 * 
	 */
	public Object[][] getCellData() {
		List<Object[]> l = new ArrayList<Object[]>();
		for (BillDataBase bDat : this.billList) {
			l.add(bDat.getCellData());
		}
		for (BillDataBase bDat : this.paidBillList) {
			l.add(bDat.getCellData());
		}
		for (BillDataBase bDat : this.closedBillList) {
			l.add(bDat.getCellData());
		}
		return (Object[][]) l.toArray(new Object[0][]);
	}

	/**
	 * @Description 返回月份等于month的所有订单信息,用于填充表格的格式
	 * @param month
	 *            筛选的月份信息
	 * @return Object[][]
	 * 
	 */
	public Object[][] getMonthCellData(String month) {
		List<Object[]> l = new ArrayList<Object[]>();
		for (BillDataBase bDat : this.billList) {
			if (bDat.checkMonth(month))
				l.add(bDat.getCellData());
		}
		for (BillDataBase bDat : this.paidBillList) {
			if (bDat.checkMonth(month))
				l.add(bDat.getCellData());
		}
		for (BillDataBase bDat : this.closedBillList) {
			if (bDat.checkMonth(month))
				l.add(bDat.getCellData());
		}
		return (Object[][]) l.toArray(new Object[0][]);
	}

	/**
	 * @Description 删除月份于month相同的所有数据
	 * @param month
	 *            筛选的月份信息
	 * 
	 */
	public void removeMonthData(String month) {
		System.out.println(billList.size());
		for (int i = 0; i < billList.size(); i++) {
			if (billList.get(i).checkMonth(month)) {
				billList.remove(i);
				i--;
			}
		}
		for (int i = 0; i < paidBillList.size(); i++) {
			if (paidBillList.get(i).checkMonth(month)) {
				paidBillList.remove(i);
				i--;
			}
		}
		for (int i = 0; i < closedBillList.size(); i++) {
			if (closedBillList.get(i).checkMonth(month)) {
				closedBillList.remove(i);
				i--;
			}
		}
	}

	/**
	 * @Description 获得用于填充表格的表头数据
	 * @return String[]
	 * 
	 */
	public String[] getColumnNames() {
		return BillDataBase.getColumnNames();
	}

	/**
	 * @Description 返回文件路径
	 * @return String
	 * 
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @Description 设置文件路径
	 * @param String
	 * 
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @Description 返回cash
	 * @return double 返回cash
	 * 
	 */
	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public void addCash(double a) {
		cash += a;
	}

	/**
	 * @Description 返回nextBillID
	 * @return int 返回nextBillID
	 * 
	 */
	public int getNextBillID() {
		return nextBillID;
	}

	public void setNextBillID(int nextBillID) {
		this.nextBillID = nextBillID;
	}

	/**
	 * @Description 返回ticket付款的订单的金额总数
	 * @return double 返回ticket付款的订单的金额总数
	 * 
	 */
	public double getTicketCount() {
		double count = 0;
		for (BillDataBase bDat : this.paidBillList) {
			if (bDat.getPayMode() == 0)
				count += bDat.getCount();
		}
		for (BillDataBase bDat : this.closedBillList) {
			if (bDat.getPayMode() == 0)
				count += bDat.getCount();
		}
		return count;
	}

	/**
	 * @Description 返回visa付款的订单的金额总数
	 * @return double 返回visa付款的订单的金额总数
	 * 
	 */
	public double getVisaCount() {
		double count = 0;
		for (BillDataBase bDat : this.paidBillList) {
			if (bDat.getPayMode() == 1)
				count += bDat.getCount();
		}
		for (BillDataBase bDat : this.closedBillList) {
			if (bDat.getPayMode() == 1)
				count += bDat.getCount();
		}
		return count;
	}

	/**
	 * @Description 返回cash付款的订单的金额总数
	 * @return double 返回cash付款的订单的金额总数
	 * 
	 */
	public double getCashCount() {
		double count = 0;
		for (BillDataBase bDat : this.paidBillList) {
			if (bDat.getPayMode() == 2)
				count += bDat.getCount();
		}
		for (BillDataBase bDat : this.closedBillList) {
			if (bDat.getPayMode() == 2)
				count += bDat.getCount();
		}
		return count;
	}
}
