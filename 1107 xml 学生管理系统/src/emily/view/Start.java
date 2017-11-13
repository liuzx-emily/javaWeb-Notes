package emily.view;

import java.util.Scanner;

import emily.service.StudentService;
import emily.serviceImpl.StudentServiceImpl;

public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		studentSystem();
	}


	/**
	 * 
	 */
	private static void studentSystem() {
		Scanner sc = new Scanner(System.in);
		StudentService service = new StudentServiceImpl();
		Integer doWhat;
		Boolean quit = false;

		while (quit == false) {
			System.out.println("-----学生管理系统-----");
			System.out.println("-----【1】     添加     -----");
			System.out.println("-----【2】     查找     -----");
			System.out.println("-----【3】     删除     -----");
			System.out.println("-----【4】退出系统-----");
			System.out.print("-----请选择：-----");
			doWhat = Integer.parseInt(sc.next());
			switch (doWhat) {
			case 1:
				// 添加
				service.add();
				break;
			case 2:
				// 查找
				service.query();
				break;
			case 3:
				// 删除
				service.remove();
				break;
			case 4:
				// 退出系统
				quit = true;
				break;
			default:
				System.out.println("无效输入");
				break;
			}
		}

		System.out.println("----------退出----------");
	}

}
