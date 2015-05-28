package main.basedata;

import java.util.Date;

/**
 * @author chuqi
 * @Project Park
 * @ModuleID <(模块)类编号,可以引用系统设计中的类编号>
 * @Comments base class of Monthly deal
 * @JDKversionUsed JDK1.8
 * @CreateDate 2015-05-05 22:29:27
 * @version 0.1
 */
public class MonthDealDataBase {
	private int emploreeID;
	private String name;
	private int parkTimes;
	private boolean[] park;
	public static double perDay = 100;

	/**
	 *@Description : 无参数构造函数, 初始化emploreeID,name,parkTimes,park
	 */
	public MonthDealDataBase() {
		emploreeID = 0;
		name = "";
		parkTimes = 0;
		park = new boolean[31];
	}

	/**
	 * @Description :
	 *              根据输入的leaveTime,检查该员工在当天是否停过车,若未停过,这是当天的park值为true,并使parkTimes
	 *              +1
	 * 
	 * @param leaveTime
	 *            Date, 要检查的日期
	 * 
	 */

	@SuppressWarnings("deprecation")
	public void addParkTimes(Date leaveTime) {
		if (!park[leaveTime.getDate()]) {
			park[leaveTime.getDate()] = true;
			parkTimes++;
		}
	}

	/**
	 * @Description : 返回该员工本月需要交的停车费,计算方法为parkTimes * perDay
	 * @return double
	 */

	public double getCost() {
		return parkTimes * perDay;
	}

	/**
	 * @Description : 返回该员工的编号
	 * @return int
	 */

	public int getEmploreeID() {
		return emploreeID;
	}

	/**
	 * @Description : 返回设置该员工的编号
	 * @param emploreeID
	 *            int,员工编号
	 */

	public void setEmploreeID(int emploreeID) {
		this.emploreeID = emploreeID;
	}

	/**
	 * @Description : 返回该员工的name
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * @Description : 返回设置该员工的name
	 * @param name
	 *            String,员工名字
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @Description : 返回该员工的停车次数
	 * @return int
	 */
	public int getParkTimes() {
		return parkTimes;
	}

	/**
	 * @Description : 返回设置该员工的parkTimes
	 * @param parkTimes
	 *            int,停车次数
	 */

	public void setParkTimes(int parkTimes) {
		this.parkTimes = parkTimes;
	}

	/**
	 * @Description 获得用于填充表格的表头数据
	 * @return String[] 
	 * 
	 */
	public static String[] getColumnNames() {
		String[] s = { "emploree ID", "name", "park Times", "cost" };
		return s;
	}

	/**
	 * @Description 获得用于填充表格的一列数据
	 * @return Object[] 
	 * 
	 */
	public Object[] getCellData() {
		Object[] s = { emploreeID, name, parkTimes, getCost() };
		return s;
	}

	/**
	 * @Description 获得用于填充表格的一列新数据
	 * @return Object[] 
	 * 
	 */
	public static Object[] getNewCellData() {
		Object[] s = { 0, "", 0, 0 };
		return s;
	}

	/**
	 * @Description 显示对象的内容,直接打印在命令行中
	 * 
	 */
	public void disp() {
		System.out.println("ID:" + emploreeID + ", name: " + name
				+ ", parkTimes: " + parkTimes + ", cost: " + getCost());
	}

}