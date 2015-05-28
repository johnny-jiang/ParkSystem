package main.maintain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.basedata.ParkSpaceDataBase;

/**
 * @author chuqi
 * @Project: Park
 * @ModuleID: <(模块)类编号,可以引用系统设计中的类编号>
 * @Comments: park space Management
 * @JDKversionUsed: JDK1.8
 * @CreateDate: 2015-04-19 16:45:10
 * @ModifiedBy: chuqi
 * @ModifiedDate: 2015-05-21 11:51:34
 * @WhyAndWhatIsModified: add more Comments
 * @version: 0.2
 */
public class ParkSpaceManagement {
	// List
	List<ParkSpaceDataBase> parkSpaceList;
	String filePath = "parkSpace.dat";
	int parked;

	/**
	 * @Description 无参构造函数,初始化parkSpaceList,并从文件中读取信息
	 */
	public ParkSpaceManagement() {
		this.parkSpaceList = new ArrayList<ParkSpaceDataBase>();
		this.getParkSpaceDataFromFile();
	}

	/**
	 * @Description 注销这个类的时候,调用保存函数,将数据保存到文件中.
	 */
	protected void finalize() {
		this.saveParkSpaceDataToFile();
	}

	/**
	 * @Description 从文件中读取数据.成功返回true,失败返回false
	 * @return boolean
	 */

	public boolean getParkSpaceDataFromFile() {
		/* if read data success return true, else return false. */
		// 从文件中读取数据到arkSpaceList中
		File pDatFile = new File(this.filePath);
		if (pDatFile.exists() == true) {
			this.parkSpaceList = new ArrayList<ParkSpaceDataBase>();
			FileReader reader;
			try {
				reader = new FileReader(this.filePath);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String line = null;
				ParkSpaceDataBase pDat = new ParkSpaceDataBase();
				this.parked = 0;
				parkSpaceList.clear();
				while ((line = bufferedReader.readLine()) != null) {
					// System.out.println(line);
					pDat = new ParkSpaceDataBase(line);
					// cDat.disp();
					if (pDat.getState() == true)
						this.parked++;
					parkSpaceList.add(pDat);
				}
				bufferedReader.close();
				System.out.println("Park Space Data Read Success!");
				return true;
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} else {
			System.out.println("Park Space Data File NOT Exists!");
			return false;
		}
		return false;
	}

	/**
	 * @Description 将数据保存到文数据文件中.若成功返回true,否则返回false.
	 * @return boolean
	 */

	public boolean saveParkSpaceDataToFile() {
		/* if save data success return true, else return false. */
		// 保存数据到ParkSpaceDataBase中
		File pDatFile = new File(this.filePath);
		if (pDatFile.exists() == true) {
			// if file exists , delete it!
			System.out.println("Park Space Data File Exists!");
			if (pDatFile.delete() == true)
				System.out.println("Park Space Data File Delete Success!");
			else {
				System.out.println("Park Space Data File Delete Fail!");
				return false;
			}
		}
		FileWriter Writer;
		try {
			Writer = new FileWriter(this.filePath, true);
			BufferedWriter bufferedWriter = new BufferedWriter(Writer);
			for (ParkSpaceDataBase pDat : this.parkSpaceList) {
				// cDat.disp();
				bufferedWriter.write(pDat.toString() + '\n');
			}
			bufferedWriter.close();
			System.out.println("Park Space Data Save Success!");
			return true;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @Description 添加新的停车位信息.若成功返回true,否则返回false.
	 * @param p
	 *            待添加的停车位信息
	 * @return boolean
	 */

	public boolean addParkSpace(ParkSpaceDataBase p) {
		if (this.parkSpaceList.add(p) == true)
			return true;
		else
			return false;
	}

	/**
	 * @Description 清空停车位信息
	 */

	public void clearList() {
		parkSpaceList.clear();
	}

	/**
	 * @Description 获得用于填充表格的数据
	 * @return Object[][]
	 * 
	 */

	public Object[][] getCellData() {
		List<Object[]> l = new ArrayList<Object[]>();
		for (ParkSpaceDataBase pDat : this.parkSpaceList) {
			l.add(pDat.getCellData());
		}
		return (Object[][]) l.toArray(new Object[0][]);
	}

	/**
	 * @Description 获得用于填充表格的表头数据
	 * @return String[]
	 * 
	 */
	public String[] getColumnNames() {
		return ParkSpaceDataBase.getColumnNames();
	}

	/**
	 * @Description 返回已停车的车位的数目
	 * @return int
	 * 
	 */
	public int getParkCount() {
		int count = 0;
		for (ParkSpaceDataBase pDat : this.parkSpaceList) {
			if (pDat.isParked())
				count++;
		}
		return count;
	}

	/**
	 * @Description 返回空停车位的数目
	 * @return int
	 * 
	 */
	public int getEmptyCount() {
		int count = 0;
		for (ParkSpaceDataBase pDat : this.parkSpaceList) {
			if (!pDat.isParked())
				count++;
		}
		return count;
	}

	/**
	 * @Description 停车进场,找到第一个空的停车位,停车,若成功找到并停车,则返回true,否则返回false
	 * @return boolean 停车是否成功
	 * 
	 */
	public boolean parkin() {
		for (ParkSpaceDataBase pDat : this.parkSpaceList) {
			if (!pDat.isParked()) {
				pDat.park();
				return true;
			}
		}
		return false;
	}

	/**
	 * @Description 汽车离开停车位,若成功找到一个已停车的停车位并离开,则返回true,否则返回false
	 * @return boolean 汽车离开是否成功
	 * 
	 */
	public boolean leaveout() {
		for (ParkSpaceDataBase pDat : parkSpaceList) {
			if (pDat.isParked()) {
				pDat.leave();
				return true;
			}
		}
		return false;
	}

}
