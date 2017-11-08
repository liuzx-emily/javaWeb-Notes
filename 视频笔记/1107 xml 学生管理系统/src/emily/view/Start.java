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
			System.out.println("-----ѧ������ϵͳ-----");
			System.out.println("-----��1��     ���     -----");
			System.out.println("-----��2��     ����     -----");
			System.out.println("-----��3��     ɾ��     -----");
			System.out.println("-----��4���˳�ϵͳ-----");
			System.out.print("-----��ѡ��-----");
			doWhat = Integer.parseInt(sc.next());
			switch (doWhat) {
			case 1:
				// ���
				service.add();
				break;
			case 2:
				// ����
				service.query();
				break;
			case 3:
				// ɾ��
				service.remove();
				break;
			case 4:
				// �˳�ϵͳ
				quit = true;
				break;
			default:
				System.out.println("��Ч����");
				break;
			}
		}

		System.out.println("----------�˳�----------");
	}

}
