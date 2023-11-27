package todo.p20231127;

import java.util.Scanner;

public class FriendApp {
	


	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		Friend[] friends = null;
		boolean run = true;
		int friendNum = 0;
		 
		
		while(run) {
			System.out.println("1.ģ����  2.�Է�  3.���  4.����  5.����");
			int menu = scn.nextInt();
			scn.nextLine();
			
			switch(menu) {
			case 1 : 
				System.out.print("ģ�� ��>> ");
				friendNum = Integer.parseInt(scn.nextLine());
				friends = new Friend[friendNum];
				break;
			case 2 :
				System.out.println("ģ������ �Է�>> ");
				for(int i = 0; i < friends.length; i++) {
					Friend friend = new Friend();
					System.out.print("- �̸�: ");
					friend.name = scn.nextLine();
					System.out.print("- ����ó: ");
					friend.tel = scn.nextLine();
					System.out.print("- ������: ");
					friend.blType = scn.nextLine();
					
					friends[i] = friend;			
				}//end for
				break;
			case 3 :
				System.out.println("��� ���>> ");
				for(Friend list : friends) {
					System.out.println("�̸�: " + list.name + " / ��ȭ��ȣ: " + list.tel + " / ������: " + list.blType);
				}
				break;
			case 4 :
				System.out.print("ģ���̸� �Է�>> ");
				String name = scn.nextLine();
				boolean exists = false;
				
				for(int i = 0; i < friends.length; i++) {
				
					if(name.equals(friends[i].name)) {
						System.out.print("������ ��ȭ��ȣ �Է�: ");
						friends[i].tel = scn.nextLine();
						exists = true;
					}
				}	
					if(!exists) {
						System.out.println("ã�� �̸��� �����ϴ�.");
					}
				break;
			
			case 5 :
				 System.out.println("�����մϴ�.");
				 run = false;
				
				
			}//end switch
			
			
		}
		
	}//end main
	
}//end class
