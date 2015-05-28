package main.business;

import main.basedata.ChargeDataBase;

/**
 * @author chuqi
 * @Project: Park
 * @ModuleID: <(模块)类编号,可以引用系统设计中的类编号>
 * @Comments: Management of charge
 * @JDKversionUsed: JDK1.8
 * @CreateDate: 2015-04-19 11:44:33
 * @ModifiedBy: jiang_yq
 * @ModifiedDate: 2015-04-19 11:44:37
 * @WhyAndWhatIsModified: add more Comments
 * @version: 0.1
 */
public class ChargeManagement {
	TimeSchedule tSchedule;
	ChargeSchedule publicChargeSchedule;

	/**
	 * @Description 无参数构造函数, 初始化tSchedule,publicChargeSchedule
	 */
	public ChargeManagement() {
		tSchedule = new TimeSchedule();
		publicChargeSchedule = new ChargeSchedule("publicCharge.dat");
	}

	/**
	 * @Description 保存所有数据到文件,若保存成功返回true,否则返回false
	 * @return boolean
	 */

	public boolean saveAllDataToFile() {
		if (this.tSchedule.saveTimeScheduleToFile()
				&& this.publicChargeSchedule.SaveChargeScheduleToFile())
			return true;
		else
			return false;
	}

	/**
	 * @Description 保存time数据到文件,若保存成功返回true,否则返回false
	 * @return boolean
	 */

	public boolean saveTimeDataToFile() {
		return this.tSchedule.saveTimeScheduleToFile();
	}

	/**
	 * @Description 保存收费标准数据到文件,若保存成功返回true,否则返回false
	 * @return boolean
	 */

	public boolean saveChargeDataToFile() {
		return this.publicChargeSchedule.SaveChargeScheduleToFile();
	}

	/**
	 * @Description 返回当前的开放时间数据
	 * @return TimeSchedule
	 */
	public TimeSchedule gettSchedule() {
		return tSchedule;
	}

	/**
	 * @Description 使用tSchedule设置当前的开放时间数据
	 * @param tSchedule
	 *            待设置的数据源
	 */

	public void settSchedule(TimeSchedule tSchedule) {
		this.tSchedule = tSchedule;
	}

	/**
	 * @Description 返回当前的收费标准数据
	 * @return ChargeSchedule
	 */
	public ChargeSchedule getPublicChargeSchedule() {
		return publicChargeSchedule;
	}

	/**
	 * @Description 使用publicChargeSchedule设置当前收费标准数据
	 * @param publicChargeSchedule
	 *            待设置的数据源
	 */

	public void setPublicChargeSchedule(ChargeSchedule publicChargeSchedule) {
		this.publicChargeSchedule = publicChargeSchedule;
	}

	/**
	 * @Description 清空开放日数据
	 */

	public void clearOpenDay() {
		tSchedule.clearOpenDay();
	}

	/**
	 * @Description 清空收费标准数据
	 */

	public void clearChargeDate() {
		publicChargeSchedule.clearChargeData();
	}

	/**
	 * @Description 增加开放日
	 * @param s
	 *            String ,日期数据,待添加到开放日中的日期
	 */

	public boolean addOpenDay(String s) {
		return tSchedule.addOpenDay(s);
	}

	/**
	 * @Description 获得用于填充表格的一列收费标准数据
	 * @return Object[]
	 * 
	 */
	public Object[][] getChargeCellData() {
		return publicChargeSchedule.getCellData();
	}

	/**
	 * @Description 获得用于填充表格的收费标准数据表头
	 * @return Object[]
	 * 
	 */
	public String[] getChargeColumnNames() {
		return ChargeSchedule.getColumnNames();
	}

	/**
	 * @Description 增加收费标准数据
	 * @param cDat
	 *            ChargeDataBase ,收费标准数据,待添加到收费标准表中的数据
	 */

	public boolean addChargeData(ChargeDataBase cDat) {
		return this.publicChargeSchedule.add(cDat);
	}

	/**
	 * @Description 返回星期的开放情况
	 * @return boolean[]
	 */

	public boolean[] getWeekData() {
		return tSchedule.getWeekDat();
	}

	/**
	 * @Description 获得用于填充表格的一列开放时间数据
	 * @return Object[]
	 * 
	 */
	public Object[][] getTimeCellData() {
		return tSchedule.getCellData();
	}

	/**
	 * @Description 获得用于填充表格的开放时间表头
	 * @return Object[]
	 * 
	 */

	public String[] getTimeColumnNames() {
		return TimeSchedule.getColumnNames();
	}

	/**
	 * @Description 检查今天是否对公众开放,若开放返回true,否则返回false
	 * @return boolean
	 * 
	 */
	public boolean checkTodayPublic() {
		return tSchedule.checkTodayOpen();
	}

	/**
	 * @Description 根据输入的时长,返回所需交的费用
	 * @return double
	 * @param duringTime
	 *            经过的时长
	 */

	public double getCharge(int duringTime) {
		return publicChargeSchedule.getCharge(duringTime);
	}

}
