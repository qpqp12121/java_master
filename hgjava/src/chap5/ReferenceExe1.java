package chap5;

//�������� ������ ������ ������ ����ڴ� ( -- �����͸� ���� �� ����(�� ���� ����� ������ �켱 �⺻Ÿ���̶� ���ϸ�
class Friend{  
	String name; //�ʵ�
	int age; //�ʵ�
	double height; //�ʵ�
	
}

public class ReferenceExe1 {
	public static void main(String[] args) {
		
		
		/**/
		// �⺻Ÿ��
		int a = 10;
		int b = a;
		
		a = 20; //�� �ٲ㼭 a �� �ٲ� (b�� �� �ٲ��)
		
		
		// ��������: ���� ���� ��� �� �ƴ�, ���� ���� �ּҸ� ��� �ִ� (��ǥ������ Ŭ����)
		Friend myFriend = new Friend(); // new => ��ü ����. //Ŭ������ �����������̶� Friend�� ����
		myFriend.name = "��ö��";
		myFriend.age = 20;
		myFriend.height = 178.3;
		
//		Friend ourFriend = myFriend; //myFriend�� ������ �ִ� �ּҰ��� ourFriend�� ���� ��
//		
//		myFriend.name = "ȫ�浿"; //myFriend�� �ִ� name �Ӽ��� �ٲ� - ����غ��� ourFriend�� ���� �ٲ���
//		                         //�Ȱ��� �������� �����ֱ� ������ //�ؿ� �⺻Ÿ���� a�� �ٲ㵵 b�� �� �ٲ��µ�
//		
//		System.out.println(ourFriend.name);
//		System.out.println(ourFriend.age);
//		System.out.println(ourFriend.height);
		
		
		
		Friend yourFriend = new Friend(); // new => ��ü ����. //Ŭ������ �����������̶� Friend�� ����
		yourFriend.name = "��ö��";
		yourFriend.age = 20;
		yourFriend.height = 178.3;
		
		//myFriend�� ���� ���� ���δ�. �׷��� myFriend�� yourFriend�� ���غ��Ҵ�
		// �ٵ� ���������� �ȿ� �ִ� ���� ���ϴ°� �ƴ� �ּҰ��� ���ؼ� �׻� false�� ����
		System.out.println(myFriend == yourFriend); 
		// = > ���� ���ϰ� ������ ���� .name, age, height �Ӽ����� ���ؾ� ��
		
		
		yourFriend = null;
		System.out.println(myFriend.name);
		try {       //10�忡�� ��� ����ó�� (���� �߻��ϸ� ���� �ߴ��ϴµ� catch���Ϸ��� ������ ����ϰ� ��� �����ض�
		System.out.println(yourFriend.name);
		} catch (Exception e) {
			System.out.println("null���� �����մϴ�.");
		}
		
		
		
		
		
//-----------------------------------------------------------------------		
		// ����Ÿ�� : �� ���� ��� �ִ� �ּҰ��� ������ �����ϴ� ��
		String name = "�ſ��"; //�ſ���̶�� ��ü�� �ּҰ� : 16������ 23db~
		String hobby = "����";
		
//		String name1 = name; //name1���� �ſ���̶�� �ּҰ� �־� ���󰡸� �ſ���̶�� �� �� �� ����
//		name1 = "����";
		
		String name1 = "�ſ��"; // new String("�ſ��")   //�񱳿����� == �� ���ϸ� true���� //**���ڿ���

		System.out.println("name: " + name);
		System.out.println("name1: " + name1);
		System.out.println(name.equals(name1)); // ���ڿ� �� ���� �� equals �޼ҵ� Ȱ��
	
		
		
		
		
		
	}//end main
}//end class
