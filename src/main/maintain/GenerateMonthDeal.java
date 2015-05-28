package main.maintain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.basedata.BillDataBase;
import main.basedata.EmployeeDataBase;
import main.basedata.MonthDealDataBase;

/**
 * @author chuqi
 * @Project: Park
 * @ModuleID: <(模块)类编号,可以引用系统设计中的类编号>
 * @Comments: Month deal generate
 * @JDKversionUsed: JDK1.8
 * @CreateDate: 2015-04-19 16:45:10
 * @ModifiedBy: jiang_yq
 * @ModifiedDate: 2015-05-21 11:32:14
 * @WhyAndWhatIsModified: add more Comments
 * @version: 0.2
 */
public class GenerateMonthDeal {

	List<MonthDealDataBase> monthDealList;
	List<BillDataBase> billList;
	List<EmployeeDataBase> emploreeList;
	String billFilePath;
	String month;
	double perCost = 100;

	/**
	 * @Description 
	 *              有参构造函数,设置month、billFilePath值,初始化emploreeList,billList,monthDealList
	 *              ,并从文件中读取信息,读取完成后调用生成账单方法生成账单
	 */
	public GenerateMonthDeal(String month) {
		emploreeList = new EmployeeManagement().getEmploreeList();
		this.month = month;
		this.billFilePath = month + ".dat";
		billList = new ArrayList<BillDataBase>();
		monthDealList = new ArrayList<MonthDealDataBase>();
		getAllBillDataFromFile();
		generateDeal();
	}

	/**
	 * @Description 生成月账单,读各个表进行匹配统计
	 */
	public void generateDeal() {
		for (EmployeeDataBase eDat : emploreeList) {
			MonthDealDataBase mDat = new MonthDealDataBase();
			mDat.setEmploreeID(eDat.getID());
			mDat.setName(eDat.getName());
			monthDealList.add(mDat);
		}
		for (BillDataBase bDat : billList) {
			for (MonthDealDataBase mDat : monthDealList) {
				if (mDat.getEmploreeID() == bDat.getOwnerID()) {
					mDat.addParkTimes(bDat.getLeaveTime());
					break;
				}
			}
		}
	}

	/**
	 * @Description 获得用于填充表格的表头数据
	 * @return String[]
	 * 
	 */

	public String[] getColumnNames() {
		return MonthDealDataBase.getColumnNames();
	}

	/**
	 * @Description 获得用于填充表格的数据
	 * @return Object[][]
	 * 
	 */
	public Object[][] getCellData() {
		List<Object[]> l = new ArrayList<Object[]>();
		for (MonthDealDataBase mDat : monthDealList) {
			l.add(mDat.getCellData());
		}
		return (Object[][]) l.toArray(new Object[0][]);
	}

	/**
	 * @Description 将月账单信息打印在命令行中
	 * 
	 */

	public void showAllDeal() {
		System.out.println("All Deal Data: Month at " + month);
		for (MonthDealDataBase mDat : monthDealList) {
			mDat.disp();
		}
		System.out.println("All Deal Data over.");
	}

	/**
	 * @Description 从文件中读取数据bill数据.成功返回true,失败返回false
	 * @return boolean
	 */
	public boolean getAllBillDataFromFile() {
		/* if read data success return true, else return false. */
		// 从文件中读取数据
		File pDatFile = new File(this.billFilePath);
		if (pDatFile.exists() == true) {
			FileReader reader;
			try {
				reader = new FileReader(this.billFilePath);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String line = null;
				BillDataBase bDat = new BillDataBase();
				// System.out.print(line);
				if ((line = bufferedReader.readLine()) != null) {
					;
				}
				while ((line = bufferedReader.readLine()) != null) {
					bDat = new BillDataBase(line);
					billList.add(bDat);
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

}
