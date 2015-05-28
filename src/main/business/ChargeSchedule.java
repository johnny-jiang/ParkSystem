package main.business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.basedata.ChargeDataBase;

/**
 * @author chuqi
 * @Project: Park
 * @ModuleID: <(模块)类编号,可以引用系统设计中的类编号>
 * @Comments: Management of Charge schedule
 * @JDKversionUsed: JDK1.8
 * @CreateDate: 2015-04-19 11:44:33
 * @ModifiedBy: jiang_yq
 * @ModifiedDate: 2015-04-19 11:44:37
 * @WhyAndWhatIsModified: add more Comments
 * @version: 0.1
 */

public class ChargeSchedule {

	List<ChargeDataBase> chargeList;
	String filePath;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		// ChargeSchedule cs = new ChargeSchedule("publicCharge.dat");
		// cs.GetChargeScheduleFromFile();
		// for (ChargeDataBase cDat : cs.getChargeList()) {
		// cDat.disp();
		// }
		// ChargeDataBase cDat = new ChargeDataBase("0,120,50");
		// cs.getChargeList().add(cDat);
		// cDat = new ChargeDataBase("120,240,100");
		// cs.getChargeList().add(cDat);
		// cDat = new ChargeDataBase("240,480,200");
		// cs.getChargeList().add(cDat);
		// cDat = new ChargeDataBase("480,720,300");
		// cs.getChargeList().add(cDat);
		// cDat = new ChargeDataBase("720,1440,500");
		// cs.getChargeList().add(cDat);
		// cs.SaveChargeScheduleToFile();
	}

	/**
	 * @Description 无参数构造函数, 初始化tSchedule,publicChargeSchedule
	 */
	public ChargeSchedule() {
		chargeList = new ArrayList<ChargeDataBase>();
		filePath = "charge.dat";
		GetChargeScheduleFromFile();
	}

	/**
	 * @Description 有参构造函数,使用字符串s初始化filePath的值,然后从文件中读取收费标准数据
	 * @param s
	 *            文件路径
	 */
	public ChargeSchedule(String s) {
		chargeList = new ArrayList<ChargeDataBase>();
		filePath = s;
		GetChargeScheduleFromFile();
	}

	/**
	 * @Description 从filePath路径中读取数据.若成功返回true,否则返回false
	 * @return boolean
	 */

	public boolean GetChargeScheduleFromFile() {
		/* if read data success return true, else return false. */
		// 从文件中读取数据到chargeList中
		File cDatFile = new File(filePath);
		if (cDatFile.exists() == true) {
			chargeList = new ArrayList<ChargeDataBase>();
			FileReader reader;
			try {
				reader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String line = null;
				ChargeDataBase cDat;
				while ((line = bufferedReader.readLine()) != null) {
					cDat = new ChargeDataBase(line);
					chargeList.add(cDat);
				}
				bufferedReader.close();
				System.out.println("Charge Schedule Data Read Success! File:"
						+ filePath + ".");

			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return true;
		} else {
			System.out.println("Charge Schedule Data File NOT Exists! File:"
					+ filePath + ".");
			return false;
		}
	}

	/**
	 * @Description 将数据保存到filePath中,若成功返回true,否则返回false
	 * @return boolean
	 */

	public boolean SaveChargeScheduleToFile() {
		/* if save data success return true, else return false. */
		// 保存chargeList数据到文件中
		File cDatFile = new File(filePath);
		if (cDatFile.exists() == true) {
			// if file exists , delete it!
			System.out.println("Charge Schedule Data File Exists!");
			if (cDatFile.delete() == true)
				System.out
						.println("Charge Schedule Data File Delete Success! File:"
								+ filePath + ".");
			else {
				System.out
						.println("Charge Schedule Data File Delete Fail! File:"
								+ filePath + ".");
				return false;
			}
		}
		FileWriter Writer;
		try {
			Writer = new FileWriter(filePath, true);
			BufferedWriter bufferedWriter = new BufferedWriter(Writer);
			for (ChargeDataBase cDat : this.chargeList) {
				bufferedWriter.write(cDat.toString() + '\n');
			}
			bufferedWriter.close();
			System.out.println("Charge Schedule Data Save Success! File:"
					+ filePath + ".");
			return true;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @Description 收费标准表
	 */
	public void clearChargeData() {
		chargeList.clear();
	}

	/**
	 * @Description 获得用于填充表格的数据
	 * @return Object[]
	 * 
	 */
	public Object[][] getCellData() {
		List<Object[]> l = new ArrayList<Object[]>();
		for (ChargeDataBase cDat : this.chargeList) {
			l.add(cDat.getCellData());
		}
		return (Object[][]) l.toArray(new Object[0][]);
	}

	/**
	 * @Description 获得用于填充表格的一列新数据
	 * @return Object[]
	 * 
	 */
	public static Object[] getNewData() {
		return ChargeDataBase.getNewData();
	}

	/**
	 * @Description 获得用于填充表格的表头数据
	 * @return String[]
	 * 
	 */
	public static String[] getColumnNames() {
		return ChargeDataBase.getColumnNames();
	}

	/**
	 * @Description 将aDat中的收费标准数据插入到表中,若成功给返回true,否则返回false
	 * @return boolean
	 * @param cDat
	 *            ChargeDataBase,收费标准
	 */
	public boolean add(ChargeDataBase cDat) {
		return this.chargeList.add(cDat);
	}
	/**
	 * @Description 获取收费数据表
	 * @return List<ChargeDataBase>
	 */

	public List<ChargeDataBase> getChargeList() {
		return chargeList;
	}

	/**
	 * @Description 使用新的收费表替换对象内的收费表
	 * @param chargeList
	 *            List<ChargeDataBase>,新的收费数据表
	 */
	public void setChargeList(List<ChargeDataBase> chargeList) {
		this.chargeList = chargeList;
	}
	/**
	 * @Description 返回数据文件路径
	 * @return String
	 */

	public String getFilePath() {
		return filePath;
	}

	/**
	 * @Description 使用新的收费表替换对象内的收费表
	 * @param chargeList
	 *            List<ChargeDataBase>,新的收费数据表
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @Description 根据输入的时间,返回所需交的停车费
	 * @return double
	 * @param duringTime
	 *            int,时间长度,单位为分钟
	 */
	public double getCharge(int duringTime) {
		for (ChargeDataBase cDat : chargeList) {
			if (cDat.getStart() < duringTime && cDat.getEnd() >= duringTime)
				return cDat.getCharge();
		}
		return 0;
	}
}
