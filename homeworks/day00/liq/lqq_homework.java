package com.BestTest.BestTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class lqq_homework {
	public static Object obj = new Object();
	public static Map<Integer, String> weeks = new HashMap<Integer, String>();
	public static String mon = "一";
	public static String tue = "二";
	public static String sun = "日";
	public static String fri = "五";
	public static String sta = "六";
	public static String thr = "四";
	public static String wed = "三";
	public static List<Thread> TQueue = new ArrayList<Thread>();

	public static void main(String[] args) {
		// 第一题 星期转换
		// InitWeeks();
		// System.out.println(WeekTrans(1));
		// System.out.println(WeekTrans(12));
		// System.out.println(WeekTrans(""));
		// System.out.println(WeekTrans("二"));
		// System.out.println(WeekTrans("8"));
		// System.out.println(WeekTrans("……%"));

		// 第二题 控制台处理
		// control();

		// 第三題 大寫並翻轉
		// verser("lqq%lqq");

		// 第四题随机ID生成器
		// 添加线程队列
		// for (int i = 0; i < 10; i++) {
		// TQueue.add(new Thread(new Runnable() {
		// public void run() {
		// System.out.println(getRandom());
		// }
		// }));
		// }
		//
		// for (int i = 0; i < 10; i++) {
		// TQueue.get(i).start();
		// }

		// 第五题分组和遍历
		// getGroupAndList();

		// 第六题文件解析

		// 第七题文件复制
		// getCP("D:\\login.txt", "D:\\login2.txt");

		// 第八题文件读取&数据库落库

		// 第九题生成死锁
		// getBlock();

		// 第十题网络
		// getSocket();

		// 第十一题算法
		// getpair("(|)");

		// 第十二题 二分法查找数组元素，只是单纯查找 不考虑排序
		// int[] nums = { 1, 2, 4, 5, 44, 3, 45, 6, 7, 8, 9 };
		// getNumByTwo(nums, 0, nums.length - 1, 8);

		// 第十三题 找到出现次数最多的单词
		// String words = " fds djif fds sd fds ji hu lopq lqq";
		// getWord(words);

		// 第十四题斐波那契数列
		// int deep = 10;
		// System.out.println(getFeiBo(deep));

		// 第十五题读取日志，输出关键字

		// 第十六题3个线程输出ali ali,本题思路主要是采用等待通信机制，但是只会用同步块，不太会用lock，
		GetAutomicValue();

		// 第十七梯没有思路

		// 第十八题 十亿条淘宝记录，如何找到出现最多的前十
		// 基本思路是利用hashmap来存储出现的记录和次数,然后遍历map获取前10记录
		// 假设每条记录1kb，10e条为1TB。内存不够，得用类似于分布式处理系统分块计算，
		// 老师 这个题难度太大 我写不出来

		// 第十九题也不会

		// 第二十题反转long
		// getVerLon(12345689l);

		// 第二十一题
		// getSimNums(12.75);

	}

	private static void GetAutomicValue() {
		Thread t1 = new Thread(new getAutomic("a", 2));
		Thread t2 = new Thread(new getAutomic("l", 3));
		Thread t3 = new Thread(new getAutomic("i", 3));
		t1.start();
		t2.start();
		t3.start();
	}

	public static class getAutomic implements Runnable {
		private int counts;
		private String value;
		private static volatile String words = "";// 只要是线程安全的并发容器都可以
		private static ReentrantLock a = new ReentrantLock();
		private static Condition ac = a.newCondition();

		public getAutomic(String value, int count) {
			this.counts = count;
			this.value = value;
		}

		public void run() {
			while (counts > 0) {
				synchronized (getAutomic.class) {
					if ("a".equals(this.value)) {
						while (!(words.equals("") || words.equals(null)
								|| words.toCharArray()[words.length() - 1] == 'i')) {
							try {
								getAutomic.class.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						words = words + this.value;
						getAutomic.class.notifyAll();
					}

					if ("l".equals(this.value)) {
						while (!words.equals(null) && !words.equals("")
								&& !(words.toCharArray()[words.length() - 1] == 'a')) {
							try {
								getAutomic.class.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

						words = words + this.value;
						getAutomic.class.notifyAll();
					}

					if ("i".equals(this.value)) {
						while (!words.equals(null) && !words.equals("")
								&& !(words.toCharArray()[words.length() - 1] == 'l')) {
							try {
								getAutomic.class.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
						words = words + this.value;
						getAutomic.class.notifyAll();
					}
					this.counts = this.counts - 1;
					System.out.println(words);
				}
			}
		}

	}

	private static void getSimNums(Double d) {
		// double类型不能直接比较大小
		String ints = d.toString().split("\\.")[0];
		Double left = Math.abs(d - new Double(ints + ".49"));
		Double right = Math.abs(d - new Double(ints + ".99"));
		if (left - right > 0) {
			System.out.println(new Double(ints + ".99"));
		} else {
			System.out.println(new Double(ints + ".49"));
		}

	}

	private static void getVerLon(Long l) {
		String vers = "";
		char[] chars = l.toString().toCharArray();
		for (int i = chars.length - 1; i >= 0; i--) {
			vers = vers + chars[i];
		}

		System.out.println(new Long(vers));

	}

	private static int getFeiBo(int deep) {

		if (deep <= 0)
			return 0;
		if (deep == 1 || deep == 2)
			return 1;
		return getFeiBo(deep - 1) + getFeiBo(deep - 2);

	}

	private static void getWord(String words) {
		String[] wordsList = words.split(" ");
		String maxWord = null;
		int Biggest = 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < wordsList.length; i++) {
			if (map.containsKey(wordsList[i])) {
				map.put(wordsList[i], map.get(wordsList[i]) + 1);
			} else {
				map.put(wordsList[i], 1);
			}
		}

		Set<String> keys = map.keySet();
		for (String key : keys) {
			if (map.get(key) >= Biggest) {
				Biggest = map.get(key);
				maxWord = key;
			}
		}

		System.out.println("出现次数最多的单词为" + maxWord);

	}

	public static void getNumByTwo(int[] nums, int start, int end, int target) {

		// { 1, 2, 4, 5, 44, 3, 45, 6, 7, 8, 9 };
		// System.out.println(start + ":" + end);
		if (nums[(end + start) / 2] != target) {
			if ((end + start) / 2 >= start && (end + start) / 2 <= end) {
				getNumByTwo(nums, start, (end + start) / 2 - 1, target);
				getNumByTwo(nums, (end + start) / 2 + 1, end, target);
			} else {
				return;
			}
		} else {
			System.out.println("目标值" + target + "的index为:" + (end + start) / 2);
			return;
		}

	}

	public static void getSocket() {
		Thread server = new Thread(new socketServer(7777));
		server.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread client = new Thread(new socketClient());
		client.start();
	}

	// 单线程服务器
	public static class socketServer implements Runnable {
		private static volatile ServerSocket so;

		public socketServer(int port) {
			if (so == null) {
				synchronized (socketServer.class) {
					if (so == null) {
						try {
							so = new ServerSocket(port);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

		public void run() {

			System.out.println("服务端开启" + so.getLocalPort());
			Socket server = null;
			BufferedReader br = null;
			PrintWriter pw = null;
			while (true) {
				try {

					server = so.accept();
					pw = new PrintWriter(server.getOutputStream());
					br = new BufferedReader(new InputStreamReader(server.getInputStream()));
					while (true) {
						String line = br.readLine();
						if (line != null) {
							System.out.println("服务器接收客户端信息：" + line);
							pw.println("hi");
							pw.flush();
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						br.close();
						pw.close();
						server.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static class socketClient implements Runnable {
		private Socket client;
		private int port = 7777;

		public void run() {
			BufferedReader br = null;
			PrintWriter pw = null;
			try {
				client = new Socket("localhost", port);
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				pw = new PrintWriter(client.getOutputStream());
				System.out.println("客户端发送消息");
				pw.println("hello");
				pw.flush();
				while (true) {
					String line = br.readLine();
					if (line != null) {
						System.out.println("客户端接收到服务端信息：" + line);
					}
				}

			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					client.close();
					br.close();
					pw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void getCP(String oldPath, String newPath) {
		// 操作系统判断
		String separator = System.getProperty("file.separator");

		// 文件存在判断
		File oldfile = new File(oldPath);
		File newfile = new File(newPath);
		if (oldfile.exists()) {
			if (newfile.exists()) {
				System.out.println("新文件已存在，无法覆盖");
				return;
			}
		} else {
			System.out.println("原始文件不存在");
			return;
		}
		// 创建文件

		// 判断文件类型：图片还是文字
		String[] paths = oldPath.split("\\.");
		if (paths[paths.length - 1].toLowerCase().equals("txt")) {
			FileReader fi = null;
			BufferedReader bi = null;
			FileWriter fo = null;
			BufferedWriter bo = null;
			String sb = null;
			try {
				fi = new FileReader(oldfile);
				bi = new BufferedReader(fi);
				fo = new FileWriter(newfile);
				bo = new BufferedWriter(fo);
				sb = bi.readLine();
				while (sb != null) {
					bo.write(sb + "\r\n");
					sb = bi.readLine();
				}
				bo.flush();
				System.out.println("TXT复制完成");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					bi.close();
					bo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else if (paths[paths.length - 1].toLowerCase().equals("png")) {
			System.out.println("waiting");
			return;
		}

	}

	public static void getpair(String words) {

		if (words == "" || words == null) {
			System.out.println("字符串输入为空");
			return;
		}
		if (words.length() % 2 != 0) {
			System.out.println("不符合成对出现");
			return;
		}
		char[] chars = words.toCharArray();
		for (int i = 0; i < chars.length / 2; i++) {
			if ('{' == chars[i] && chars[chars.length - 1 - i] == '}') {
				continue;
			} else if ('[' == chars[i] && chars[chars.length - 1 - i] == ']') {
				continue;
			} else if ('(' == chars[i] && chars[chars.length - 1 - i] == ')') {
				continue;
			}
			System.out.println("不符合成对出现");
		}
		System.out.println("符合成对出现");
	}

	public static String pairs(String words, int deep) {

		return "不符合成对出现";
	}

	public static void getGroupAndList() {
		List<User> users = new ArrayList<User>();
		Map<String, List<User>> BySchool = new HashMap<String, List<User>>();

		// init users
		for (int i = 0; i < 10; i++) {
			if (i < 3) {
				users.add(new User("lqq" + i, 18, "lqq_school"));
			} else if (i >= 3 && i < 8) {
				users.add(new User("lqq" + i, 18, "uncle_school"));
			} else {
				users.add(new User("lqq" + i, 18, "big_school"));
			}
		}

		// list interator && group by school
		for (User u : users) {
			if (!BySchool.containsKey(u.getSchool())) {
				BySchool.put(u.getSchool(), new ArrayList<User>());
			}
			BySchool.get(u.school).add(u);
		}

		// map interator
		Iterator MapKey = BySchool.keySet().iterator();
		while (MapKey.hasNext()) {
			String school = MapKey.next().toString();
			List user = BySchool.get(school);
			String useing = "";
			Iterator useKey = user.iterator();
			while (useKey.hasNext()) {
				useing += ((User) useKey.next()).getUserName() + "_use,";
			}
			System.out.println(school + ":" + useing);
		}

	}

	public static String WeekTrans(Object obj) {
		if (obj instanceof Integer) {
			Integer in = (Integer) obj;
			if (weeks.containsKey(in)) {
				return "星期" + weeks.get(in);
			}
		} else if (obj instanceof String) {
			String ss = (String) obj;
			if (weeks.containsValue(ss)) {
				return "星期" + getKey(ss);
			}
		}
		return "输入不符合规定";
	}

	// 控制台
	public static void control() {
		Scanner put = new Scanner(System.in);
		StringBuilder ss;
		String words = "";
		try {
			while (true) {
				System.out.println("请输入指令");
				ss = new StringBuilder();
				if (put.hasNextLine()) {
					words = put.nextLine().trim();
					if (words == null || "".equals(words)) {
						System.out.println("输入不能为空，请重新输入");
						continue;
					}
					if ("exit".equals(words.toLowerCase()) || "-1".equals(words.toLowerCase())) {
						System.out.println("退出系统");
						break;
					}
					if (words.length() > 32) {
						System.out.println("输入不能超过32位，请重新输入");
						continue;
					}
					if (words.length() == 1 && (int) words.charAt(0) <= 57 && 49 <= (int) words.charAt(0)) {
						System.out.println("hello" + words);
						continue;
					}
					for (int l = 0; l < words.length(); l++) {
						if (l == words.length() - 1) {
							ss.append(words.toCharArray()[l]);
						} else {
							ss.append(words.toCharArray()[l] + " ");
						}
					}
					System.out.println(ss);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			put.close();
		}
	}

	// 翻轉
	public static void verser(String words) {
		char[] chars = words.toUpperCase().toCharArray();
		StringBuilder ss = new StringBuilder();
		for (int i = chars.length - 1; i >= 0; i--) {
			ss.append(chars[i]);
		}
		System.out.println(ss);
	}

	// 获得随机数
	public static String getRandom() {
		String prefix = "230_";
		String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		ThreadLocalRandom ran = ThreadLocalRandom.current();// 虽然util.random和math.random都是线程安全，但因为竞争唯一种子资源导致性能下降
		String word = "";
		int last = 0;

		for (int i = 0; i < 10; i++) {
			int nums = ran.nextInt(10);
			if (i == 9) {
				last = nums;
			}
			word += nums;
		}

		if (last % 2 == 0) {
			return prefix + date + word + "1100";
		} else {
			return prefix + date + word + "2200";
		}

	}

	// 获得死锁
	public static void getBlock() {
		Lock1 lock1 = new Lock1();
		Lock2 lock2 = new Lock2();
		Thread t1 = new Thread(lock1);
		Thread t2 = new Thread(lock2);
		t1.start();
		t2.start();
	}

	// 填充week hashmap
	public static void InitWeeks() {
		weeks.put(1, mon);
		weeks.put(2, tue);
		weeks.put(3, wed);
		weeks.put(4, thr);
		weeks.put(5, fri);
		weeks.put(6, sta);
		weeks.put(7, sun);
	}

	// 遍历map
	public static int getKey(String value) {
		Iterator i = weeks.keySet().iterator();

		while (i.hasNext()) {
			Integer key = (Integer) i.next();
			if ((String) weeks.get(key) == value) {
				return key;
			}
		}
		return -1;
	}

	public static class Lock1 implements Runnable {

		public void run() {
			while (true) {
				synchronized (obj) {
					synchronized (lqq_homework.class) {
						System.out.println(getRandom());
					}
				}
			}

		}

	}

	public static class Lock2 implements Runnable {

		public void run() {
			while (true) {
				synchronized (lqq_homework.class) {
					synchronized (obj) {
						System.out.println(getRandom());
					}
				}
			}

		}

	}

	public static class User {
		private String userName;

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getSchool() {
			return school;
		}

		public void setSchool(String school) {
			this.school = school;
		}

		private int age;
		private String school;

		public User(String userName, int age, String school) {
			this.userName = userName;
			this.age = age;
			this.school = school;
		}
	}

}
