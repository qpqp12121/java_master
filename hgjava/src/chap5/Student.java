package chap5;

public class Student {
	
	//���θ޼ҵ� ���� �����͸� ��� StudentApp2 30���� ����
	String name;
	int score;
	String gender; // ���� ����
}

/* StudentApp ���Ͽ���  
   Q. ��ȣ �����ϸ� ���� ��µǰ� �����
     < 1.�л��� 2.�����Է� 3.������ 4.�м�(�ְ�����, ���) 5.���� > ���α׷� ��������� 
      
      switch������ case4�� ���� if�� �ȿ��� ����, �̸� ���� �־� ȿ�������� �ʴ�. 
      => �׷��� class���� �����͸� �ְ� StudentApp2���� �۾� �ٽ� �� �� */

	
	//�Ʒ��� StudentApp case4 �ڵ� �Ϻ�(����)

	/*for(int i = 0; i < scores.length; i++) { 
	   sum += scores[i];
	   if(maxScore < scores[i]) {  //�̸�, ���� ���� �־� ȿ������ �ڵ� X 
	   maxScore = scores[i];   //�̸�,������ �ϳ��� ������ ��� ������ Ŭ���� ����ؾ� �ȴ� �׷��� Student���Ϸ� Ŭ���� ������ �ְ� App2���� �۾��� �� Ȯ���ϱ�!
	   maxName = names[i];
	  } */