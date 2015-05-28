package main.basedata;

/**
 * @author chuqi
 * @Project: Park
 * @ModuleID: <(模块)类编号,可以引用系统设计中的类编号>
 * @Comments: base class of park space data
 * @JDKversionUsed: JDK1.8
 * @CreateDate: 2015-04-19 11:44:33
 * @ModifiedBy: jiang_yq
 * @ModifiedDate: 2015-04-19 11:44:37
 * @WhyAndWhatIsModified: add more Comments
 * @version: 0.1
 */
public class TollboothDataBase {
	private int locality;
	// 0 close 1 open
	private int stat;
	// 0 不找零 1找零
	private int mode;
	private static String[] stats = { "closed", "open" };
	private static String[] modes = { "no charge", "charge" };

	/**
	 * @Description 无参数构造函数, 初始化locality,stat,mode
	 */
	public TollboothDataBase() {
		this.locality = 0;
		this.stat = 0;
		this.mode = 0;
	}

	/**
	 * @Description 使用字符串s初始化locality,stat,mode的值
	 * @param s
	 *            格式: locality,stat,mode eg:1,1,charge
	 */
	public TollboothDataBase(String s) {
		this.set(s);
	}

	/**
	 * @Description 使用字符串s设置locality,stat,mode的值
	 * @param s
	 *            格式: locality,stat,mode eg:1,1,charge
	 */
	public boolean set(String s) {
		if (s.split(",").length == 3) {
			this.locality = Integer.parseInt(s.split(",")[0]);
			this.stat = Integer.parseInt(s.split(",")[1]);
			this.mode = Integer.parseInt(s.split(",")[2]);
		}
		return false;
	}

	/**
	 * @Description 重写的同String()方法,按照从文件中读取的格式进行显示
	 * 
	 */
	public String toString() {
		return this.locality + "," + this.stat + "," + this.mode;
	}

	/**
	 * @Description 获得对象的位置locality
	 * @return int
	 */
	public int getLocality() {
		return locality;
	}

	/**
	 * @Description 使用locality设置对象内的locality的值
	 * 
	 * @param locality
	 *            int ,所在位置,或编号
	 */
	public void setLocality(int locality) {
		this.locality = locality;
	}

	/**
	 * @Description 获得对象的状态stat
	 * @return int
	 */
	public int getStat() {
		return stat;
	}

	/**
	 * @Description 使用stat设置对象内的stat的值
	 * 
	 * @param stat
	 *            int ,状态
	 */
	public void setStat(int stat) {
		this.stat = stat;
	}

	/**
	 * @Description 使用字符串型的stat设置对象内的stat的值
	 * 
	 * @param stat
	 *            String ,状态
	 */

	public void setStat(String stat) {
		if (stat.trim().toLowerCase().equals(stats[1]))
			this.stat = 1;
		else
			this.stat = 0;
	}

	/**
	 * @Description 获得对象的是否找零状态mode
	 * @return int
	 */
	public int getMode() {
		return mode;
	}

	/**
	 * @Description 使用mode设置对象内的mode的值
	 * 
	 * @param mode
	 *            int ,状态
	 */

	public void setMode(int mode) {
		this.mode = mode;
	}

	/**
	 * @Description 使用字符串型的mode设置对象内的mode的值
	 * 
	 * @param mode
	 *            String ,状态
	 */

	public void setMode(String mode) {
		if (mode.trim().toLowerCase().equals(modes[1]))
			this.mode = 1;
		else
			this.mode = 0;
	}

	/**
	 * @Description 显示对象的内容,直接打印在命令行中
	 * 
	 */
	public void disp() {
		System.out.println("locality:" + locality + " stat:" + stat + " mode:"
				+ mode);
	}

	/**
	 * @Description 获得用于填充表格的表头数据
	 * @return String[] 
	 * 
	 */
	public static String[] getColumnNames() {
		String[] s = { "locality", "static", "mode" };
		return s;
	}

	/**
	 * @Description 获得用于填充表格的一列数据
	 * @return Object[] 
	 * 
	 */
	public Object[] getCellData() {
		Object[] s = { this.locality, stats[stat], modes[mode] };
		return s;
	}

	/**
	 * @Description 获得用于填充表格的一列新数据
	 * @return Object[] 
	 * 
	 */
	public static Object[] getNewData() {
		Object[] s = { 0, "closed", "no charge" };
		return s;
	}
}
