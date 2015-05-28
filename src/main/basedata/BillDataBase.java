package main.basedata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chuqi
 * @Project Park
 * @ModuleID <(模块)类编号,可以引用系统设计中的类编号>
 * @Comments base class of Bill data
 * @JDKversionUsed JDK1.8
 * @CreateDate 2015-05-05 22:29:27
 * @version 0.1
 */
public class BillDataBase {
	private int billID;
	private int stat;
	// 0 normal,1 paid,2 closed
	private Date enterTime;
	private Date leaveTime;
	private String carLicense;
	private int ownerID;
	private int payMode;
	private double count;
	// 0 ticket,1 visa,2 cash
	public static SimpleDateFormat sdf = new SimpleDateFormat(
			"HH:mm:ss yyyy-MM-dd");
	public static SimpleDateFormat monthsdf = new SimpleDateFormat("yyyy-MM");
	// 格式化对象
	private static String[] stats = { "normal", "paid", "closed" };
	private static String[] payModes = { "ticket", "visa", "cash", "employee" };

	/**
	 * @Description : 无参数构造函数,
	 * 初始化billID,stat,enterTime,leaveTime,ownerID,carLicense,payMode,count
	 */
	public BillDataBase() {
		this.billID = 0;
		this.stat = 0;
		this.enterTime = new Date();
		this.leaveTime = new Date();
		this.ownerID = 0;
		this.carLicense = " ";
		this.payMode = 2;
		this.count = 0;
	}

	/**
	 * @Description 带参数构造函数,
	 * 初始化billID,stat,enterTime,leaveTime,ownerID,carLicense,payMode,count
	 * 
	 * @param s
	 *            String,格式: 60,0,23:01:52 2015-05-20,23:01:52
	 *            2015-05-20,test,1,3,0.0
	 */
	public BillDataBase(String s) {
		this.set(s);
	}

	/**
	 * @Description 带参数构造函数,复制bDat的值到新的对象中
	 * 
	 * @param bDat
	 *            BillDataBase,待复制值的对象
	 */
	public BillDataBase(BillDataBase bDat) {
		// TODO 自动生成的构造函数存根
		billID = bDat.billID;
		stat = bDat.stat;
		enterTime = bDat.enterTime;
		leaveTime = bDat.leaveTime;
		ownerID = bDat.ownerID;
		carLicense = bDat.carLicense;
		payMode = bDat.payMode;
		count = bDat.count;
	}

	/**
	 * @Description
	 * 使用字符串设置变量的billID,stat,enterTime,leaveTime,ownerID,carLicense,payMode
	 * ,count 值,若成功返回true,否则返回false
	 * @return boolean 
	 * 
	 * @param s
	 *            String ,格式: 60,0,23:01:52 2015-05-20,23:01:52
	 *            2015-05-20,test,1,3,0.0
	 */
	public boolean set(String s) {
		if (s.split(",").length == 8) {
			this.billID = Integer.parseInt(s.split(",")[0]);
			this.stat = Integer.parseInt(s.split(",")[1]);
			try {
				this.enterTime = sdf.parse(s.split(",")[2]);
				this.leaveTime = sdf.parse(s.split(",")[3]);
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			this.carLicense = s.split(",")[4];
			this.ownerID = Integer.parseInt(s.split(",")[5]);
			this.payMode = Integer.parseInt(s.split(",")[6]);
			this.count = Double.parseDouble(s.split(",")[7]);
			return true;
		} else
			return false;
	}

	/**
	 * @Description 返回对象内的billID的值
	 * @return int 
	 * 
	 */
	public int getBillID() {
		return billID;
	}

	/**
	 * @Description 使用billID设置对象内的billID的值
	 * 
	 * @param billID
	 *            int,待设置的订单号
	 */
	public void setBillID(int billID) {
		this.billID = billID;
	}

	/**
	 * @Description 返回对象内的enterTime的值
	 * @return Date
	 * 
	 */
	public Date getEnterTime() {
		return enterTime;
	}

	/**
	 * @Description 使用enterTime设置对象内的enterTime的值
	 * 
	 * @param enterTime
	 *            Date,待设置的时间
	 */
	public void setEnterTime(Date enterTime) {
		this.enterTime = enterTime;
	}

	/**
	 * Description 使用字符串设置变量的enterTime的值
	 * 
	 * @param enterTime
	 *            String,与sdf设置的格式匹配,即:HH:mm:ss yyyy-MM-dd
	 */
	public void setEnterTime(String enterTime) {
		try {
			this.enterTime = sdf.parse(enterTime);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	/**
	 * @Description 返回对象内的leaveTime的值
	 * @return Date
	 * 
	 */
	public Date getLeaveTime() {
		return leaveTime;
	}

	/**
	 * @Description 使用leaveTime设置变量的对象内的leaveTime的值
	 * 
	 * @param leaveTime
	 *            Date,待设置的时间
	 */
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

	/**
	 * @Description 使用字符串设置变量的leaveTime的值
	 * 
	 * @param leaveTime
	 *            String,与sdf设置的格式匹配,即:HH:mm:ss yyyy-MM-dd
	 */

	public void setLeaveTime(String leaveTime) {
		try {
			this.leaveTime = sdf.parse(leaveTime);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	/**
	 * @Description 返回对象内的ownerID的值
	 * @return int
	 * 
	 */
	public int getOwnerID() {
		return ownerID;
	}

	/**
	 * @Description 使用ownerID设置变量的对象内的ownerID的值
	 * 
	 * @param ownerID
	 *            int,待设置的时间
	 */
	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	/**
	 * @Description 返回对象内的stat的值
	 * @return int
	 * 
	 */
	public int getStat() {
		return stat;
	}

	/**
	 * @Description 使用stat设置变量的对象内的stat的值
	 * 
	 * @param stat
	 *            int,待设置的时间
	 */
	public void setStat(int stat) {
		this.stat = stat;
	}

	/**
	 * @Description 返回对象String类型的stat
	 * @return String
	 * 
	 */
	public String getStringStat() {
		return stats[stat];
	}

	/**
	 * @Description 使用字符串型的状态设置设置对象内的stat的值
	 * 
	 * @param stat
	 *            String,状态字符串
	 */
	public void setStat(String stat) {
		stat.toLowerCase();
		if (stat.equals(stats[0]))
			this.stat = 0;
		else if (stat.equals(stats[1]))
			this.stat = 1;
		else if (stat.equals(stats[2]))
			this.stat = 2;
	}

	/**
	 *@Description 返回对象内的carLicense的值
	 * @return String
	 * 
	 */
	public String getCarLicense() {
		return carLicense;
	}

	/**
	 * @Description 使用carLicense设置变量的对象内的carLicense的值
	 * 
	 * @param carLicense
	 *            String,待设置的时间
	 */
	public void setCarLicense(String carLicense) {
		this.carLicense = carLicense;
	}

	/**
	 * @Description 返回对象内的payMode的值
	 * @return int
	 * 
	 */
	public int getPayMode() {
		return payMode;
	}

	/**
	 * @Description 返回对象内的String类型的付款方式字符串
	 * @return String
	 * 
	 */

	public String getStringPaymode() {
		return payModes[payMode];
	}

	/**
	 * @Description 使用paymode设置变量的对象内的paymode的值
	 * 
	 * @param paymode
	 *            int,待设置的时间
	 */
	public void setPayMode(int paymode) {
		this.payMode = paymode;
	}

	/**
	 * @Description 使用字符串型的状态设置设置对象内的paymode的值
	 * 
	 * @param paymode
	 *            String,字符串型的付款方式
	 */
	public void setPayMode(String paymode) {
		paymode.trim().toLowerCase();
		if (paymode.trim().equals(payModes[3]))
			this.payMode = 3;
		else if (paymode.trim().equals(payModes[2]))
			this.payMode = 2;
		else if (paymode.trim().equals(payModes[1]))
			this.payMode = 1;
		else if (paymode.trim().equals(payModes[0]))
			this.payMode = 0;
	}

	/**
	 * @Description 返回对象内的getCount的值
	 * @return double
	 * 
	 */

	public double getCount() {
		return count;
	}

	/**
	 * @Description 使用count设置变量的对象内的count的值
	 * 
	 * @param count
	 *            double,待设置的时间
	 */
	public void setCount(double count) {
		this.count = count;
	}

	/**
	 * @Description 重写的同String()方法,按照从文件中读取的格式进行显示
	 * @return String
	 * 
	 */
	public String toString() {
		return billID + "," + stat + "," + sdf.format(enterTime) + ","
				+ sdf.format(leaveTime) + ","
				+ (carLicense.equals("") ? " " : carLicense) + "," + ownerID
				+ "," + payMode + "," + count;
	}

	/**
	 * @Description 显示对象的内容,直接打印在命令行中
	 * 
	 */
	public void disp() {
		/* just for test */
		System.out.println("billID: " + billID + ",state: " + stat
				+ ", enterTime: " + sdf.format(enterTime) + ", leaveTime: "
				+ sdf.format(leaveTime) + ", carLicense: " + carLicense
				+ ", ownerID: " + ownerID + ", paymode:" + payMode + ",count: "
				+ count);
	}

	/**
	 * @Description 获得用于填充表格的表头数据
	 * @return String[]
	 * 
	 */
	public static String[] getColumnNames() {
		String[] s = { "billID", "state", "enterTime", "leaveTime",
				"car license", "owner ID", "pay mode", "count" };
		return s;
	}

	/**
	 * @Description 获得用于填充表格的一列数据
	 * @return Object[]
	 * 
	 */
	public static Object[] getNewData() {
		Object[] s = { 0, stats[0], sdf.format(new Date()),
				sdf.format(new Date()), "", 0, payModes[2], 0.0 };
		return s;
	}

	/**
	 * @Description 获得用于填充表格的一列新数据
	 * @return Object[]
	 * 
	 */
	public Object[] getCellData() {
		Object[] s = { billID, this.getStringStat(), sdf.format(enterTime),
				sdf.format(leaveTime), carLicense, ownerID,
				this.getStringPaymode(), count };
		return s;
	}

	/**
	 * @Description 检查当前对象所在的月份是否与s相符,若符合返回true,否则返回false
	 * @return boolean
	 * 
	 * @param s
	 *            月份字符串,格式: 2015-05
	 * 
	 */
	public boolean checkMonth(String s) {
		if (monthsdf.format(this.leaveTime).equals(s))
			return true;
		else
			return false;
	}

	/**
	 * @Description 针对该订单,返回入口处显示的信息,一行。
	 * @return String
	 * 
	 */
	public String getEnterMessage() {
		return "Bill ID: "
				+ billID
				+ (ownerID != 0 ? (", Owner ID: " + ownerID) : "")
				+ (carLicense.equals(" ") ? "" : ", Car License: " + carLicense)
				+ ", Enter Time: " + sdf.format(enterTime) + "\n";
	}

	/**
	 * Description 针对该订单,返回出口处显示的信息,一行。
	 * @return String
	 * 
	 */
	public String getLeaveMessage() {
		return "Bill ID: "
				+ billID
				+ (ownerID != 0 ? (", Owner ID: " + ownerID) : "")
				+ (carLicense.equals(" ") ? "" : ", Car License: " + carLicense)
				+ ", Leave Time: " + sdf.format(leaveTime) + "\n";
	}

	/**
	 * Description 针对该订单,返回停车时长,leaveTime与enterTime之间所差的时间,以分为单位
	 * @return int
	 * 
	 */
	public int getDuringTime() {
		long t = leaveTime.getTime() - enterTime.getTime();
		return (int) t / 60000;
	}

	/**
	 * Description 针对该订单,检查是否为员工订单,若是返回true,否则返回false
	 * 
	 * @return boolean
	 * 
	 */
	public boolean isEmployee() {
		if (ownerID > 0)
			return true;
		else
			return false;
	}
}
