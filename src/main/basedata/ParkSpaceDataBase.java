package main.basedata;

/**
 * @author chuqi
 * @Project: Parking
 * @ModuleID: <(模块)类编号,可以引用系统设计中的类编号>
 * @Comments: base class of park space data
 * @JDKversionUsed: JDK1.8
 * @CreateDate: 2015-04-19 11:44:33
 * @ModifiedBy: jiang_yq
 * @ModifiedDate: 2015-04-19 11:44:37
 * @WhyAndWhatIsModified: add more Comments
 * @version: 0.1
 */
public class ParkSpaceDataBase {

	// 停车位位置
	int local;
	int size;
	boolean state;
	String carLicense;

	/**
	 * @Description 无参数构造函数, 初始化local,size,state,carLicense
	 */
	public ParkSpaceDataBase() {
		this.state = false;
		this.size = 1;
		this.local = 0;
		carLicense = "";
	}

	/**
	 * @Description 使用字符串s初始化local,size,state,carLicense的值
	 * @param s
	 *            格式: local,size,state eg:1,1,false
	 */
	public ParkSpaceDataBase(String s) {
		this.set(s);
	}

	/**
	 * @Description 使用字符串s设置local,size,state的值
	 * @return boolean
	 * @param s
	 *            格式: local,size,state eg:1,1,false
	 */
	public boolean set(String s) {
		// 格式: local,size,state eg:1,1,false
		if (s.split(",").length == 4) {
			this.local = Integer.parseInt(s.split(",")[0]);
			this.size = Integer.parseInt(s.split(",")[1]);
			this.state = Boolean.parseBoolean(s.split(",")[2]);
			if (!s.split(",")[3].equals(" "))
				this.carLicense = s.split(",")[3];
			else
				this.carLicense = "";
			return true;
		} else {
			System.out.println("Park Space Data Format Error!\n");
			return false;
		}

	}

	/**
	 * @Description 显示对象的内容,直接打印在命令行中
	 * 
	 */

	public void disp() {
		/* just for test */
		System.out.println("Local : " + this.local + ", Size: " + this.size
				+ ", State: " + this.state);
	}

	/**
	 * @Description 如果state为false,即此停车位为空,则可以停车,更改state为true,返回true;否则返回false
	 * @return boolean
	 */
	public boolean park() {
		if (this.state == true) {
			System.out.println("Park Space at " + this.local
					+ " is already parked!");
			return false;
		} else {
			this.state = true;
			System.out.println("Park  at " + this.local + " Success!");
			return true;
		}
	}

	/**
	 * @Description 如果state为true,即此停车位不为空,则可以停车,更改state为false,返回true;否则返回false
	 * @return boolean
	 */
	public boolean leave() {
		if (this.state == true) {
			this.state = false;
			System.out.println("Leave  at " + this.local + " Success!");
			return true;
		} else {
			System.out.println("Park Space at " + this.local + " is empty!");
			return false;
		}
	}

	/**
	 * @Description 如果state为true,即此停车位不为空,返回true;否则返回false
	 * @return boolean
	 */
	public boolean isParked() {
		return state;
	}

	/**
	 * @Override
	 * @description 重写的同String()方法,按照从文件中读取的格式进行显示
	 */
	public String toString() {
		if (carLicense.equals(""))
			carLicense = " ";
		return this.local + "," + this.size + "," + this.state + ","
				+ this.carLicense;
	}

	/**
	 *@Description 返回对象内的local的值
	 * 
	 * @return int
	 * 
	 */
	public int getLocal() {
		return local;
	}

	/**
	 *@Description 使用local设置对象内的local的值
	 * 
	 * @param local
	 *            int ,所在位置,或编号
	 */
	public void setLocal(int local) {
		this.local = local;
	}

	/**
	 * @Description 返回对象内的size的值
	 * @unused
	 * @return int
	 * 
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @Description 使用size设置对象内的size的值
	 * @unused
	 * @param size
	 *            int ,停车位大小
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 *@Description 返回对象内的state的值
	 * 
	 * @return boolean
	 * 
	 */
	public boolean getState() {
		return state;
	}
	/**
	 * @Description 使用state设置对象内的state的值
	 * @unused
	 * @param state
	 *            boolean ,停车位状态
	 */
	public void setState(boolean state) {
		this.state = state;
	}
	/**
	 * @Description 使用String类型的state设置对象内的state的值
	 * @unused
	 * @param state
	 *            String ,停车位状态:parked/其他
	 */

	public void setState(String state) {
		this.state = state.toString().toLowerCase().equals("parked") ? true
				: false;
	}

	/**
	 *@Description 返回对象内的carLicense的值
	 * 
	 * @return String
	 * 
	 */
	public String getCarLicense() {
		return carLicense;
	}
	/**
	 * @Description 使用String类型的carLicense设置对象内的carLicense的值
	 * @unused
	 * @param carLicense
	 *            String ,停车的车牌照
	 */

	public void setCarLicense(String carLicense) {
		this.carLicense = carLicense;
	}

	/**
	 * @Description 获得用于填充表格的表头数据
	 * @return String[] 
	 * 
	 */
	public static String[] getColumnNames() {
		String[] s = { "local", "size", "state", "car licence" };
		return s;
	}

	/**
	 * @Description 获得用于填充表格的一列数据
	 * @return Object[] 
	 * 
	 */

	public Object[] getCellData() {
		Object[] s = { this.local, this.size,
				this.state == true ? "Parked" : "Empty",
				this.carLicense.equals(" ") ? "" : this.carLicense };
		return s;

	}

	/**
	 * @Description 获得用于填充表格的一列新数据
	 * @return Object[] 
	 * 
	 */
	public static Object[] getNewData() {
		Object[] s = { 0, 0, "Empty", "" };
		return s;
	}
}
