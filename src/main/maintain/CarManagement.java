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

import main.basedata.CarDataBase;

/**
 * @author chuqi
 * @Project Park
 * @ModuleID <(模块)类编号,可以引用系统设计中的类编号>
 * @Comments Car Data management
 * @JDKversionUsed JDK1.8
 * @CreateDate 2015-04-19 11:59:33
 * @ModifiedBy jiang_yq
 * @ModifiedDate 2015-04-19 11:44:37
 * @WhyAndWhatIsModified add more Comments
 * @version 0.1
 */
public class CarManagement {
	// List
	List<CarDataBase> carList;
	String filePath = "car.dat";

	/**
	 * @Description 无参构造函数,初始化carList,并从文件中读取信息
	 */
	public CarManagement() {
		this.carList = new ArrayList<CarDataBase>();
		this.getCarDataFromFile();
	}

	/**
	 * @Description 注销这个类的时候,调用保存函数,将数据保存到文件中.
	 */
	protected void finalize() {
		this.saveCarDataToFile();
	}

	/**
	 * @Description 从文件中读取数据.成功返回true,失败返回false
	 * @return boolean
	 */
	public boolean getCarDataFromFile() {
		/* if read data success return true, else return false. */
		// 从文件中读取数据到carList中
		File cDatFile = new File(filePath);
		if (cDatFile.exists() == true) {
			this.carList = new ArrayList<CarDataBase>();
			FileReader reader;
			try {
				reader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String line = null;
				CarDataBase cDat = new CarDataBase();
				while ((line = bufferedReader.readLine()) != null) {
					// System.out.println(line);
					cDat = new CarDataBase(line);
					// cDat.disp();
					carList.add(cDat);
				}
				bufferedReader.close();
				System.out.println("Car Data Read Success!");
				return true;
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} else {
			System.out.println("Car Data File NOT Exists!");
			return false;
		}
		return false;
	}

	/**
	 * @Description 将数据保存到文数据文件中.若成功返回true,否则返回false.
	 * @return boolean
	 */
	public boolean saveCarDataToFile() {
		/* if save data success return true, else return false. */
		// 保存所有的carData到文件
		File cDatFile = new File(filePath);
		if (cDatFile.exists() == true) {
			// if file exists , delete it!
			System.out.println("Car Data File Exists!");
			if (cDatFile.delete() == true)
				System.out.println("Car Data File Delete Success!");
			else {
				System.out.println("Car Data File Delete Fail!");
				return false;
			}
		}
		FileWriter Writer;
		try {
			Writer = new FileWriter(filePath, true);
			BufferedWriter bufferedWriter = new BufferedWriter(Writer);
			for (CarDataBase cDat : this.carList) {
				// cDat.disp();
				bufferedWriter.write(cDat.toString() + '\n');
			}
			bufferedWriter.close();
			System.out.println("Car Data Save Success!");
			return true;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @Description 通过ownerID查找汽车信息.成功返回此汽车信息,失败返回null
	 * @param id
	 *            所有者编号
	 * @return CarDataBase 返回找到的汽车数据
	 */
	public CarDataBase getCarByOwnerID(int id) {
		for (CarDataBase cDat : this.carList) {
			if (cDat.getOwnerID() == id)
				return cDat;
		}
		System.out.println("Car Data Not Found! ID: " + id + "\n");
		return null;
	}

	/**
	 * @Description 添加一条汽车信息.成功返回true,失败返回false
	 * @param cDat
	 *            待添加的起车信息
	 * @return boolean 返回找到的汽车数据
	 */
	public boolean addCar(CarDataBase cDat) {
		return carList.add(cDat);
	}

	/**
	 * @Description 返回汽车信息表
	 * @return List<CarDataBase> 汽车信息表
	 */
	public List<CarDataBase> getCarList() {
		return carList;
	}

	/**
	 * @Description 设置汽车信息表
	 * @param carList
	 *            汽车信息表
	 */
	public void setCarList(List<CarDataBase> carList) {
		this.carList = carList;
	}

	/**
	 * @Description 清空汽车信息
	 */
	public void clearList() {
		carList.clear();
	}

	/**
	 * @Description 获得用于填充表格的数据
	 * @return Object[][]
	 * 
	 */
	public Object[][] getCellData() {
		List<Object[]> l = new ArrayList<Object[]>();
		for (CarDataBase cDat : this.carList) {
			l.add(cDat.getCellData());
		}
		return (Object[][]) l.toArray(new Object[0][]);
	}

	/**
	 * @Description 获得用于填充表格的表头数据
	 * @return String[]
	 * 
	 */
	public String[] getColumnNames() {
		return CarDataBase.getColumnNames();
	}

	/**
	 * @Description 通过汽车牌照carLicense查找所有者的id
	 * @param carLicense 起车的拍照
	 * @return int 所有者的id
	 */
	public int getOwnerIDByCarLisence(String carLicense) {
		for (CarDataBase cDat : carList) {
			if (cDat.checkLicense(carLicense))
				return cDat.getOwnerID();
		}
		return -1;
	}

}
