package main.basedata;

/**
 * @author chuqi
 * @Project: Park
 * @ModuleID: <(模块)类编号,可以引用系统设计中的类编号>
 * @Comments: base class of car
 * @JDKversionUsed: JDK1.8
 * @CreateDate: 2015-04-19 16:14:30
 * @ModifiedBy: jiang_yq
 * @ModifiedDate: 2015-04-19 16:14:34
 * @WhyAndWhatIsModified: add more Comments
 * @version: 1.0
 */
public class CarDataBase {
	String name;
	String license;
	int ownerID;

	/**
	 * @Description : 无参数构造函数, 初始化name,license,ownerID
	 */
	public CarDataBase() {
		this.name = "";
		this.license = "";
		this.ownerID = 0;
	}

	/**
	 * @Description : 带参数构造函数, 初始化name,license,ownerID
	 * 
	 * @param s
	 *            :格式:ownerID,name,license eg:1,A's car,fs23452
	 */
	public CarDataBase(String s) {
		this.set(s);
	}

	/**
	 * @Description 使用字符串s设置name,license,ownerID的值
	 * @return boolean
	 * 
	 * @param s
	 *            格式:ownerID,name,license eg:1,A's car,fs23452
	 */
	public boolean set(String s) {
		// 格式:ownerID,name,license eg:1,A's car,fs23452
		if (s.split(",").length == 3) {
			this.ownerID = Integer.parseInt(s.split(",")[0]);
			this.name = s.split(",")[1];
			this.license = s.split(",")[2];
			return true;
		} else {
			System.out.println("Car Data Format Error!\n");
			return false;
		}
	}

	/**
	 * @Description 重写的同String()方法,按照从文件中读取的格式进行显示
	 * @return String
	 * 
	 */
	public String toString() {
		return this.ownerID + "," + this.name + "," + this.license;
	}

	/**
	 * @Description : 显示 name,license,ownerID的值
	 */
	public void disp() {
		/* just for test */
		System.out.println("Owner ID: " + this.ownerID + ", Car Name: "
				+ this.name + ", License: " + this.license);
	}

	/**
	 * @Description 检查 自身的carLicense是否与输入的carLicense相符,返回true,否则返回false
	 * @return boolean
	 * 
	 * @param carLicense
	 *            待匹配的车牌号字符串
	 * 
	 */
	public boolean checkLicense(String carLicense) {
		return license.equals(carLicense);
	}

	/**
	 * @Description 返回对象内的name的值
	 * @return String
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * @Description 使用name设置对象内的name的值
	 * 
	 * @param name
	 *            String,车的名字
	 */
	public void setName(String name) {
		if (name.equals(""))
			this.name = " ";
		else
			this.name = name;
	}

	/**
	 * @Description 返回对象内的license的值
	 * @return String
	 * 
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * @Description 使用license设置对象内的license的值
	 * 
	 * @param license
	 *            String,车牌号
	 */
	public void setLicense(String license) {
		this.license = license;
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
	 * @Description 使用ownerID设置对象内的ownerID的值
	 * 
	 * @param ownerID
	 *            int,所有者的编号
	 */
	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	/**
	 * @Description : 返回用于填充表格的表头信息
	 * @return String[]
	 * 
	 */
	public static String[] getColumnNames() {
		String[] s = { "ownerID", "license", "name" };
		return s;
	}

	/**
	 * @Description : 返回用于填充表格的数据
	 * @return Object[]
	 * 
	 */
	public Object[] getCellData() {
		Object[] s = { this.ownerID, this.license,
				this.name.equals(" ") ? "" : this.name };
		return s;
	}

	/**
	 * @Description : 返回用于填充表格的中新的一列数据
	 * @return Object[]
	 * 
	 */
	public static Object[] getNewData() {
		Object[] s = { 0, "", "" };
		return s;
	}
}