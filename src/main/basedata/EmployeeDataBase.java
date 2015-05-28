package main.basedata;

/**
 * @author chuqi
 * @Project: Park
 * @ModuleID: <(模块)类编号,可以引用系统设计中的类编号>
 * @Comments: base class of employee
 * @JDKversionUsed: JDK1.8
 * @CreateDate: 2015-04-19 16:14:30
 * @ModifiedBy: jiang_yq
 * @ModifiedDate: 2015-04-19 16:14:34
 * @WhyAndWhatIsModified: add more Comments
 * @version: 0.1
 */
public class EmployeeDataBase {

	int ID;
	String name;
	double money;

	/**
	 * @Description 无参数构造函数, 初始化ID,name,fee
	 */
	public EmployeeDataBase() {
		this.ID = 0;
		this.name = "";
		this.money = 0;
	}

	/**
	 * @Description 使用字符串s初始化ID,name,fee的值
	 * @param s
	 *            格式: ID,name,fee eg:1,褚琪,0
	 */
	public EmployeeDataBase(String s) {
		this.set(s);
	}

	/**
	 * @Description 使用字符串s设置ID,name,fee的值
	 * @return boolean
	 * @param s
	 *            格式: ID,name,fee eg:1,褚琪,0
	 */
	public boolean set(String s) {
		if (s.split(",").length == 3) {
			this.ID = Integer.parseInt(s.split(",")[0]);
			this.name = s.split(",")[1];
			this.money = Double.parseDouble(s.split(",")[2]);
			return true;
		} else {
			System.out.println("Emploree Data Format Error!\n");
			return false;
		}
	}

	/**
	 *@Description 重写的同String()方法,按照从文件中读取的格式进行显示
	 * @return String
	 * 
	 */
	public String toString() {
		String s = this.ID + "," + this.name + "," + this.money;
		return s;
	}

	/**
	 *@Description 显示对象的内容,直接打印在命令行中
	 * 
	 */
	public void disp() {
		String s = "ID: " + this.ID + ", Name: " + this.name + ",Fee: " + ","
				+ this.money;
		System.out.println(s);
	}

	/**
	 *@Description 返回对象内的ID的值
	 * @return int
	 * 
	 */

	public int getID() {
		return ID;
	}

	/**
	 *@Description 使用iD设置对象内的iD的值
	 * 
	 * @param iD
	 *            int,员工编号
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 *@Description 返回对象内的name的值
	 * @return String
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 *@Description 使用name设置对象内的name的值
	 * 
	 * @param name
	 *            String,Employee's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *@Description 返回对象内的money的值
	 * @return double
	 * 
	 */
	public double getFee() {
		return money;
	}

	/**
	 *@Description 设置对象内的fee的值
	 * 
	 * @param fee
	 *            double,Employee's fee
	 */
	public void setFee(double fee) {
		this.money = fee;
	}

	/**
	 *@Description 获得用于填充表格的表头数据
	 * @return String[]
	 * 
	 */

	public static String[] getColumnNames() {
		String[] s = { "ID", "name", "money" };
		return s;
	}

	/**
	 *@Description 获得用于填充表格的一列数据
	 * @return Object[]
	 * 
	 */
	public Object[] getCellData() {
		Object[] s = { ID, name, money };
		return s;
	}

	/**
	 *@Description 获得用于填充表格的一列新数据
	 * @return Object[]
	 * 
	 */
	public static Object[] getNewData() {
		Object[] s = { 0, "", 0.0 };
		return s;
	}

}
