package main.basedata;

/**
 * @author chuqi
 * @Project: Park
 * @ModuleID: <(模块)类编号，可以引用系统设计中的类编号>
 * @Comments: base class of charge
 * @JDKversionUsed: JDK1.8
 * @CreateDate: 2015-04-19 16:14:30
 * @ModifiedBy: jiang_yq
 * @ModifiedDate: 2015-04-19 16:14:34
 * @WhyAndWhatIsModified: add more Comments
 * @version: 0.1
 */
public class ChargeDataBase {
	// 时间以分为单位，金额以便士为单位，所有输入的小时数*60保存，金额数*100保存。
	int start;
	int end;
	double charge;

	/**
	 * @Description 带参数构造函数, 使用字符串s初始化start,end,charge
	 * 
	 * @param s
	 *            String,格式: 0,120,50.0
	 */
	public ChargeDataBase(String s) {
		this.set(s);
	}

	/**
	 * @Description : 无参数构造函数, 初始化start,end,charge
	 */
	public ChargeDataBase() {
		start = 0;
		end = 0;
		charge = 0;
	}

	/**
	 * @Description 使用字符串s初始化start,end,charge
	 * 
	 * @return boolean
	 * @param s
	 *            String,格式: 0,120,50.0
	 */
	public boolean set(String s) {
		if (s.split(",").length == 3) {
			start = Integer.parseInt(s.split(",")[0]);
			end = Integer.parseInt(s.split(",")[1]);
			charge = Double.parseDouble(s.split(",")[2]);
		}
		return false;
	}

	/**
	 * @Description 返回对象内的start的值
	 * @return int
	 * 
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @Description 使用start设置对象内的start的值
	 * 
	 * @param start
	 *            int,起始时长，单位为分
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @Description 使用字符串型的时间设置对象内的start的值
	 * 
	 * @param start
	 *            String,起始时长，格式: "1 hours"
	 */
	public void setStart(String start) {
		this.start = (int) (Double.parseDouble(start.split("h")[0].trim()) * 60);
	}

	/**
	 * @Description 返回对象内的end的值
	 * @return int
	 * 
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * @Description 使用end设置对象内的end的值
	 * 
	 * @param end
	 *            int,起始时长，单位为分
	 */
	public void setEnd(int end) {
		this.end = end;
	}

	/**
	 * @Description 使用字符串型的时间设置对象内的end的值
	 * 
	 * @param end
	 *            String,起始时长，格式: "1 hours"
	 */
	public void setEnd(String end) {
		this.end = (int) (Double.parseDouble(end.split("h")[0].trim()) * 60);
	}

	/**
	 * @Description 返回对象内的charge的值
	 * @return double
	 * 
	 */
	public double getCharge() {
		return charge;
	}

	/**
	 * @Description 使用charge设置对象内的charge的值
	 * 
	 * @param charge
	 *            double,收费金额，以便士为单位
	 */
	public void setCharge(double charge) {
		this.charge = charge;
	}

	/**
	 * @Description 使用字符串型的金额设置对象内的charge的值
	 * 
	 * @param charge
	 *            String,收费金额，格式: "£ 1"
	 */
	public void setCharge(String charge) {
		this.charge = (Double.parseDouble(charge.split("£")[1].trim()) * 100);
	}

	/**
	 * @Description 重写的同String()方法,按照从文件中读取的格式进行显示
	 * @return String
	 * 
	 */
	public String toString() {
		return start + "," + end + "," + charge;
	}

	/**
	 * @Description 获得用于填充表格的表头数据
	 * @return String[]
	 * 
	 */
	public static String[] getColumnNames() {
		String[] s = { "from", "to", "charge" };
		return s;
	}

	/**
	 * @Description 获得用于填充表格的一列数据
	 * @return Object[]
	 * 
	 */
	public Object[] getCellData() {
		Object[] s = { start / 60 + " hour(s)", end / 60 + " hour(s)",
				"£ " + charge / 100 };
		return s;
	}

	/**
	 * @Description 获得用于填充表格的一列新数据
	 * @return Object[]
	 * 
	 */
	public static Object[] getNewData() {
		Object[] s = { 0 + " hour(s)", 0 + " hour(s)", "£ " + 0 };
		return s;
	}

	/**
	 * @Description 显示对象的内容,直接打印在命令行中
	 * 
	 */
	public void disp() {
		System.out.println("from: " + start + " to: " + end + " charge: "
				+ charge + ".");
	}
}