package main.business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author chuqi
 * @Project: Park
 * @ModuleID: <(模块)类编号,可以引用系统设计中的类编号>
 * @Comments: Management of time schedule
 * @JDKversionUsed: JDK1.8
 * @CreateDate: 2015-04-19 11:44:33
 * @ModifiedBy: jiang_yq
 * @ModifiedDate: 2015-04-19 11:44:37
 * @WhyAndWhatIsModified: add more Comments
 * @version: 0.1
 */
public class TimeSchedule {
	private boolean[] dayStat;
	private Set<String> openDaySet;
	private String filePath;
	public static SimpleDateFormat sdf;
	private boolean listedDayOpen = true;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		// Date tDat = new Date();
		// TimeSchedule ct = new TimeSchedule();
		// ct.getTimeScheduleFromFile();
		// ct.openDaySet.add(TimeSchedule.sdf.format(tDat));
		// ct.saveTimeScheduleToFile();
		// for (String s : ct.openDaySet) {
		// System.out.println(s);
		// }
	}

	/**
	 * @Description 无参构造函数,初始化filePath,openDaySet,sdf,dayStat的值,并从文件中读取数据
	 */
	public TimeSchedule() {
		filePath = "time.dat";
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		openDaySet = new TreeSet<String>();
		dayStat = new boolean[7];
		getTimeScheduleFromFile();
	}

	/**
	 * @Description 有参构造函数,使用字符串s初始化filePath的值
	 *              初始化filePath,openDaySet,sdf,dayStat的值,并从文件中读取数据
	 * @param s
	 *            String,文件路径
	 */
	public TimeSchedule(String s) {
		this.filePath = s;
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		openDaySet = new TreeSet<String>();
		dayStat = new boolean[7];
		getTimeScheduleFromFile();
	}

	/**
	 * @Description 清空开放日
	 */
	public void clearOpenDay() {
		openDaySet.clear();
	}

	/**
	 * @Description 将日期s增加到开放日集合中,若成功返回true,否则返回false
	 * @param s
	 *            String 日期,格式与sdf所定义的相同
	 * @return boolean
	 */

	public boolean addOpenDay(String s) {
		if (s.length() == 10)
			return openDaySet.add(s);
		else
			return false;
	}

	/**
	 * @Description 将日期d增加到开放日集合中,若成功返回true,否则返回false
	 * @param d
	 *            Date 日期
	 * @return boolean
	 */

	public boolean addOpenDay(Date d) {
		return openDaySet.add(sdf.format(d));
	}

	/**
	 * @return filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath
	 *            要设置的 filePath
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @Description 从filePath路径中读取数据.若成功返回true,否则返回false
	 * @return boolean
	 */
	public boolean getTimeScheduleFromFile() {
		/* if read data success return true, else return false. */
		// 从文件中读取数据到openDaySet中
		File cDatFile = new File(filePath);
		if (cDatFile.exists() == true) {
			openDaySet = new TreeSet<String>();
			FileReader reader;
			try {
				reader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String line = null;
				@SuppressWarnings("unused")
				Date cDat = new Date();
				line = bufferedReader.readLine();
				for (int i = 0; i < 7; i++) {
					this.dayStat[i] = Boolean.parseBoolean(line.split(",")[i]);
				}
				while ((line = bufferedReader.readLine()) != null) {
					openDaySet.add(line);
				}
				bufferedReader.close();
				System.out.println("Time Data Read Success!");
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return true;
		} else {
			System.out.println("Time Data File NOT Exists!");
			return false;
		}
	}

	/**
	 * @Description 将数据保存到filePath中,若成功返回true,否则返回false
	 * @return boolean
	 */
	public boolean saveTimeScheduleToFile() {
		/* if save data success return true, else return false. */
		// 保存数据到gDay中
		File cDatFile = new File(filePath);
		if (cDatFile.exists() == true) {
			// if file exists , delete it!
			System.out.println("Time Data File Exists!");
			if (cDatFile.delete() == true)
				System.out.println("Time Data File Delete Success!");
			else {
				System.out.println("Time Data File Delete Fail!");
				return false;
			}
		}
		FileWriter Writer;
		try {
			Writer = new FileWriter(filePath, true);
			BufferedWriter bufferedWriter = new BufferedWriter(Writer);
			String s = String.valueOf(this.dayStat[0]) + ','
					+ String.valueOf(this.dayStat[1]) + ','
					+ String.valueOf(this.dayStat[2]) + ','
					+ String.valueOf(this.dayStat[3]) + ','
					+ String.valueOf(this.dayStat[4]) + ','
					+ String.valueOf(this.dayStat[5]) + ','
					+ String.valueOf(this.dayStat[6]) + '\n';
			bufferedWriter.write(s);
			for (String str : this.openDaySet) {
				bufferedWriter.write(str + '\n');
			}
			bufferedWriter.close();
			System.out.println("Time Data Save Success!");
			return true;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
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
		for (String cDat : this.openDaySet) {
			l.add(new Object[] { cDat.toString() });
		}
		return (Object[][]) l.toArray(new Object[0][]);
	}

	/**
	 * @Description 获得用于填充表格的表头数据
	 * @return String[]
	 * 
	 */
	public static String[] getColumnNames() {
		String[] s = { "Date" };
		return s;
	}

	/**
	 * @Description 获得用于填充表格的一列新数据
	 * @return Object[]
	 * 
	 */
	public static Object[] getNewData() {
		Object[] s = { sdf.format(new Date()) };
		return s;
	}

	/**
	 * @Description 返回一周的开放状态
	 * @return boolean[] dayStat
	 */
	public boolean[] getWeekDat() {
		return dayStat;
	}

	/**
	 * @Description 检查今天是否对公众开放,若开放返回true,否则返回false
	 * @return boolean
	 * 
	 */
	@SuppressWarnings("deprecation")
	public boolean checkTodayOpen() {
		Date tDat = new Date();
		String today = sdf.format(tDat);
		for (String s : openDaySet) {
			if (s.equals(today))
				return listedDayOpen;
		}
		// System.out.println(tDat.getDay());
		if (dayStat[tDat.getDay() % 7])
			return true;
		else
			return false;
	}
}
