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
import main.basedata.TollboothDataBase;

/**
 * @author chuqi
 * @Project: Park
 * @ModuleID: <(模块)类编号,可以引用系统设计中的类编号>
 * @Comments: Tollbooth Management
 * @JDKversionUsed: JDK1.8
 * @CreateDate: 2015-04-19 16:45:10
 * @ModifiedBy: chuqi
 * @ModifiedDate: 2015-05-21 11:52:25
 * @WhyAndWhatIsModified: add more Comments
 * @version: 0.2
 */

public class TollboothMangement {
	List<TollboothDataBase> toolboothList;
	int availableCount;
	String filePath = "tollbooth.dat";

	/**
	 * @Description 无参构造函数,初始化toolboothList,availableCount,并从文件中读取信息
	 */
	public TollboothMangement() {
		toolboothList = new ArrayList<TollboothDataBase>();
		availableCount = 0;
		this.getTollboothDataFromFile();
	}

	/**
	 * @Description 注销这个类的时候,调用保存函数,将数据保存到文件中.
	 */
	protected void finalize() {
		this.saveTollboothDataToFile();
	}

	/**
	 * @Description 从文件中读取数据.成功返回true,失败返回false
	 * @return boolean
	 */

	public boolean getTollboothDataFromFile() {
		/* if read data success return true, else return false. */
		// 从文件中读取数据到toolboothList中
		File pDatFile = new File(this.filePath);
		if (pDatFile.exists() == true) {
			toolboothList = new ArrayList<TollboothDataBase>();
			FileReader reader;
			try {
				reader = new FileReader(this.filePath);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String line = null;
				TollboothDataBase tDat = new TollboothDataBase();
				while ((line = bufferedReader.readLine()) != null) {
					tDat = new TollboothDataBase(line);
					if (tDat.getStat() == 1) {
						this.availableCount++;
					}
					toolboothList.add(tDat);
				}
				bufferedReader.close();
				System.out.println("Tollbooth Data Read Success!");
				return true;
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} else {
			System.out.println("Tollbooth Data File NOT Exists!");
			return false;
		}
		return false;
	}

	/**
	 * @Description 将数据保存到文数据文件中.若成功返回true,否则返回false.
	 * @return boolean
	 */
	public boolean saveTollboothDataToFile() {
		/* if save data success return true, else return false. */
		// 保存数据到toolboothList中
		File pDatFile = new File(this.filePath);
		if (pDatFile.exists() == true) {
			// if file exists , delete it!
			System.out.println("Tollbooth Data File Exists!");
			if (pDatFile.delete() == true)
				System.out.println("Tollbooth Data File Delete Success!");
			else {
				System.out.println("Tollbooth Data File Delete Fail!");
				return false;
			}
		}
		FileWriter Writer;
		try {
			Writer = new FileWriter(this.filePath, true);
			BufferedWriter bufferedWriter = new BufferedWriter(Writer);
			for (TollboothDataBase tDat : this.toolboothList) {
				// cDat.disp();
				bufferedWriter.write(tDat.toString() + '\n');
			}
			bufferedWriter.close();
			System.out.println("Tollbooth Data Save Success!");
			return true;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @Description 添加新的收费亭信息.若成功返回true,否则返回false.
	 * @param tDat
	 *            待添加的收费亭信息
	 * @return boolean
	 */
	public boolean add(TollboothDataBase tDat) {
		if (toolboothList.add(tDat) == true) {
			availableCount++;
			return true;
		}
		return false;
	}

	/**
	 * @Description 获得用于填充表格的数据
	 * @return Object[][]
	 * 
	 */
	public Object[][] getCellData() {
		List<Object[]> l = new ArrayList<Object[]>();
		for (TollboothDataBase tDat : this.toolboothList) {
			l.add(tDat.getCellData());
		}
		return (Object[][]) l.toArray(new Object[0][]);
	}

	/**
	 * @Description 获得用于填充表格的表头数据
	 * @return String[]
	 * 
	 */
	public String[] getColumnNames() {
		return TollboothDataBase.getColumnNames();
	}

	/**
	 * @Description 获得用于填充表格一行的新数据
	 * @return Object[][]
	 * 
	 */
	public Object[] getNewCellData() {
		return TollboothDataBase.getNewData();
	}

	/**
	 * @Description 清空数据
	 * 
	 */

	public void clearList() {
		this.toolboothList.clear();
	}

	/**
	 * @Description 获得所有的员工数据表
	 * @return List<TollboothDataBase>
	 * 
	 */
	public List<TollboothDataBase> getToolboothList() {
		return toolboothList;
	}

}
