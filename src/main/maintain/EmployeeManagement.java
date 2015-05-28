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

import main.basedata.EmployeeDataBase;

/**
 * @author chuqi
 * @Project: Park
 * @ModuleID: <(模块)类编号,可以引用系统设计中的类编号>
 * @Comments: Employee Management
 * @JDKversionUsed: JDK1.8
 * @CreateDate: 2015-04-19 16:45:10
 * @ModifiedBy: chuqi
 * @ModifiedDate: 2015-04-19 16:45:13
 * @WhyAndWhatIsModified: add more Comments
 * @version: 0.1
 */
public class EmployeeManagement {

	List<EmployeeDataBase> emploreeList;
	String filePath = "emploree.dat";
	int nextEmployeeID;

	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	// EmployeeManagement e = new EmployeeManagement();
	// EmployeeDataBase eDat = new EmployeeDataBase(
	// "3,褚琪,0");
	// eDat.disp();
	// e.emploreeList.add(eDat);
	// eDat = new
	// EmployeeDataBase("4,johnny,0");
	// eDat.disp();
	// e.emploreeList.add(eDat);
	// e.saveEmploreeDataToFile();
	// }

	/**
	 * @Description 无参构造函数,初始化emploreeList,nextEmployeeID,并从文件中读取信息
	 */
	public EmployeeManagement() {
		this.emploreeList = new ArrayList<EmployeeDataBase>();
		nextEmployeeID = 1;
		this.getEmploreeDataFromFile();
	}

	/**
	 * @Description 注销这个类的时候,调用保存函数,将数据保存到文件中.
	 */
	protected void finalize() {
		this.saveEmploreeDataToFile();
	}

	/**
	 * @Description 从文件中读取数据.成功返回true,失败返回false
	 * @return boolean
	 */
	public boolean getEmploreeDataFromFile() {
		/* if read data success return true, else return false. */
		// 从文件中读取数据到arkSpaceList中
		File pDatFile = new File(this.filePath);
		if (pDatFile.exists() == true) {
			this.emploreeList = new ArrayList<EmployeeDataBase>();
			FileReader reader;
			try {
				reader = new FileReader(this.filePath);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String line = null;
				EmployeeDataBase eDat = new EmployeeDataBase();
				// System.out.print(line);
				if ((line = bufferedReader.readLine()) != null)
					nextEmployeeID = Integer.parseInt(line.trim());
				while ((line = bufferedReader.readLine()) != null) {
					eDat = new EmployeeDataBase(line);
					emploreeList.add(eDat);
				}
				bufferedReader.close();
				System.out.println("Employee Data Read Success!");
				return true;
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} else {
			System.out.println("Employee Data File NOT Exists!");
			return false;
		}
		return false;
	}

	/**
	 * @Description 将数据保存到文数据文件中.若成功返回true,否则返回false.
	 * @return boolean
	 */
	
	public boolean saveEmploreeDataToFile() {
		/* if save data success return true, else return false. */
		// 保存数据到文件中
		File pDatFile = new File(this.filePath);
		if (pDatFile.exists() == true) {
			// if file exists , delete it!
			System.out.println("Employee Data File Exists!");
			if (pDatFile.delete() == true)
				System.out.println("Employee Data File Delete Success!");
			else {
				System.out.println("Employee Data File Delete Fail!");
				return false;
			}
		}
		FileWriter Writer;
		try {
			class SortByID implements Comparator<EmployeeDataBase> {
				public int compare(EmployeeDataBase o1, EmployeeDataBase o2) {
					EmployeeDataBase s1 = (EmployeeDataBase) o1;
					EmployeeDataBase s2 = (EmployeeDataBase) o2;
					if (s1.getID() > s2.getID())
						return 1;
					return 0;
				}
			}
			Collections.sort(emploreeList, new SortByID());
			Writer = new FileWriter(this.filePath, true);
			BufferedWriter bufferedWriter = new BufferedWriter(Writer);
			bufferedWriter.write(String.valueOf(this.nextEmployeeID) + '\n');
			for (EmployeeDataBase eDat : this.emploreeList) {
				// cDat.disp();
				bufferedWriter.write(eDat.toString() + '\n');
			}
			bufferedWriter.close();
			System.out.println("Employee Data Save Success!");
			return true;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @Description 添加一个新的员工,如果id设置为0,则分配给这个员工一个新id,即nextEmployeeID的值
	 * @param eDat
	 *            待添加的员工信息
	 * @return boolean 添加成功返回true,否则返回false
	 */
	public boolean addEmploree(EmployeeDataBase eDat) {
		if (eDat.getID() == 0) {
			eDat.setID(nextEmployeeID);
			if (emploreeList.add(eDat)) {
				nextEmployeeID++;
				return true;
			} else
				return false;
		} else {
			return emploreeList.add(eDat);
		}
	}

	/**
	 * @Description 通过员工的id,找到员工的信息,若成功找到返回员工的信息,否则返回null
	 * @param ID
	 *            员工的id
	 * @return EmployeeDataBase 找到的员工信息
	 */
	public EmployeeDataBase getEmployeeByID(int ID) {
		for (EmployeeDataBase eDat : emploreeList) {
			if (eDat.getID() == ID)
				return eDat;
		}
		return null;
	}

	/**
	 * @Description 获得用于填充表格的数据
	 * @return Object[][]
	 * 
	 */
	public Object[][] getCellData() {
		List<Object[]> l = new ArrayList<Object[]>();
		for (EmployeeDataBase eDat : this.emploreeList) {
			l.add(eDat.getCellData());
		}
		return (Object[][]) l.toArray(new Object[0][]);
	}

	/**
	 * @Description 获得用于填充表格的表头数据
	 * @return String[]
	 * 
	 */

	public String[] getColumnNames() {
		return EmployeeDataBase.getColumnNames();
	}

	/**
	 * @Description 清空员工信息
	 */
	public void clearList() {
		emploreeList.clear();
	}

	/**
	 * @Description 获得所有的员工数据表
	 * @return List<EmployeeDataBase>
	 * 
	 */
	public List<EmployeeDataBase> getEmploreeList() {
		return emploreeList;
	}

}
