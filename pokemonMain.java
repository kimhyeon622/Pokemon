import java.util.Scanner;

public class pokemonMain {

	public static void main(String[] args) {

		pokemonSQL sql = new pokemonSQL();

		sql.connect();

		Scanner sc = new Scanner(System.in);

		Sleep t = new Sleep();	 		// ȭ�� �ܼ�â�� ����ϰ� �����ֱ����� ������ �ð��� ������ �ߴ�

		String skillname = null;	 // ��ų�̸�
		String name1 = null;		// �÷��̾� 1 ���ϸ��̸�
		String name2 = null;		// �÷��̾� 2 ���ϸ��̸�
		int pz = 3;					// �������
		int num1 = 1;				// �÷��̾� 1 ���ϸ󸶴� ���� ���� ��ȣ�� ����
		int num2 = 1;				// �÷��̾� 2 ���ϸ󸶴� ���� ���� ��ȣ�� ����
		int cnt1 = 1;				// �÷��̾� 1 ���� ���ϸ��� �����ϱ����� ����
		int cnt2 = 1;				// �÷��̾� 2 ���� ���ϸ��� �����ϱ����� ����
		int sat1 = 0;				 // ��ų������ ����
		int ch = 0;					 // ���ϸ��� ��ü�Ҷ� ���
		int ran = 0;				// �ʹݿ� �����Լ� �Ҷ� ���
		int hp1 = 30;				 // �÷��̾� 1 ���ϸ� HP�� ����
		int hp2 = 30;				// �÷��̾� 2 ���ϸ� HP�� ����
		int at1 = 0;				// �÷��̾� 1 ���ϸ� ���ݷ�
		int at2 = 0;				// �÷��̾� 2 ���ϸ� ���ݷ�
		int po1 = 10;				 // �Ϲ� ��ó�� ���� ����
		int po2 = 10;				 // ��� ��ó�� ���� ����
		int count1 = 0;				// �÷��̾� 1 ���� ���ϸ� ī��Ʈ�� ��
		int count2 = 0;				// �÷��̾� 2 ���� ���ϸ� ī��Ʈ�� ��
		String name = null;			// �������� �̸��� ������ ����
		boolean run = true;			// ���� ��ü �ݺ��� ����Ҷ�
		boolean de = true;			 // �׾����� �ڵ������� ���� ����
		boolean B = true;			// ���� ���ϸ� �����Ҷ� ����
		boolean cha = true;			// ���ϸ� ��ü�Ҷ� ���
		boolean p1 = true;			// �÷��̾� 1 ���ϸ� ������ ��� 
		boolean p2 = true;			// �÷��̾� 2 ���ϸ� ������ ��� 
		
		open();						// ���ϸ� �α� �ҷ�����
		System.out.println("\t1. �����ϱ�\t\t2. ����");
		sql.re1(); // �� ������ �÷��̾� 1 ������ ����
		sql.re2(); // �� ������ �÷��̾� 2 ������ ����
		int num = sc.nextInt();
		if (num == 1) {
			for (int i = 1; i <= 2; i++) {					// i=1 : �÷��̾� 1   // i=2 : �÷��̾� 2
				for (int j = 1; j <= 3; j++) {				// ���� 3���� ���ϸ�
					ran = (int) (Math.random() * 15) + 1;	 // 15������ ���� ���ϸ� 3������ �������� ������� �������(�ߺ�����)
					switch (ran) {
					case 1:
						name = "���̸�";
						break;
					case 2:
						name = "���α�";
						break;
					case 3:
						name = "�̻��ؾ�";
						break;
					case 4:
						name = "�Ҳɼ���";
						break;
					case 5:
						name = "�ص���";
						break;
					case 6:
						name = "��α�";
						break;
					case 7:
						name = "������";
						break;
					case 8:
						name = "������";
						break;
					case 9:
						name = "ġ�ڸ�Ÿ";
						break;
					case 10:
						name = "������";
						break;
					case 11:
						name = "��¯��";
						break;
					case 12:
						name = "��������";
						break;
					case 13:
						name = "�Ѳٸ�";
						break;
					case 14:
						name = "������";
						break;
					case 15:
						name = "�긮���";
						break;
					default:
						break;
					}
					if (i == 1) {			// �÷��̾�1 ���ϸ� ����
						num1 = cnt1;
						hp1 = sql.hp(name);
						at1 = sql.at(name);
						sql.player1(num1, name, hp1, at1);
						cnt1 += 1;
					} else if (i == 2) {	// �÷��̾�2 ���ϸ� ����
						num2 = cnt2;
						hp2 = sql.hp(name);
						at2 = sql.at(name);
						sql.player2(num2, name, hp2, at2);
						cnt2 += 1;
					}
				}
			}
			num1 = 1;	// ������ ����
			num2 = 1;	// �� ���
			while (run) {
				de = true;	 // �ڵ������� ���
				B = true;	 // ���� ������ ���ϸ� ���ý� ���
				cha = true;	 // ��ü�� ���
				name1 = sql.name1(num1);	// �÷��̾�1 �����ص� ���ϸ� �ҷ�����
				at1 = sql.at1(num1);
				hp1 = sql.hp1(num1);

				name2 = sql.name2(num2);	// �÷��̾�2 �����ص� ���ϸ� �ҷ�����
				at2 = sql.at2(num2);
				hp2 = sql.hp2(num2);
				while(p1) { 	// �÷��̾�1 ���ο� ���ϸ��� ������ ���
					clear();
					System.out.println("����������������������������������������������������������������");
					System.out.println("�� [�÷��̾�1] : ����!! " + name1);
					System.out.println("����������������������������������������������������������������");
					t.sleep(1500);
					p1 = false;
				}
				while(p2) {		// �÷��̾�2 ���ο� ���ϸ��� ������ ���
					clear();
					System.out.println("����������������������������������������������������������������");
					System.out.println("�� [�÷��̾�2] : ����!! " + name2);
					System.out.println("����������������������������������������������������������������");
					t.sleep(1500);
					p2 = false;
				}
				clear();
				System.out.println("����������������������������������������������������������������");	// P1 ���ϸ� ����â
				System.out.println("�� [�÷��̾�1]               ");
				System.out.println("�� name : " + name1 + "      ");
				System.out.println("�� hp   : " + hp1 + "/30     ");
				System.out.print("��");
				for (int i = 0; i < hp1; i++) {		 // �÷��̾�1 ���� �����ϰ��ִ� HP ǥ��
					System.out.print("��");
				}
				for (int i = 0; i < (30 - hp1); i++) {
					System.out.print("��");
				}
				System.out.println("");
				System.out.println("����������������������������������������������������������������");
				
				System.out.println("����������������������������������������������������������������");	// P2 ���ϸ� ����â
				System.out.println("�� [�÷��̾�2]               ");
				System.out.println("�� name : " + name2 + "      ");
				System.out.println("�� hp   : " + hp2 + "/30     ");
				System.out.print("��");
				for (int i = 0; i < hp2; i++) {		 // �÷��̾�2 ���� �����ϰ��ִ� HP ǥ��
					System.out.print("��");
				}
				for (int i = 0; i < (30 - hp2); i++) {
					System.out.print("��");
				}
				System.out.println("");
				System.out.println("����������������������������������������������������������������");
				System.out.println("");
				System.out.println("����������������������������������������������������������������");
				System.out.println("��    1. attack                 ��");
				System.out.println("��    2. skill                  ��");
				System.out.println("��    3. bag                    ��");		// ����â
				System.out.println("��    4. run                    ��");
				System.out.println("��    5. change                 ��");
				System.out.println("����������������������������������������������������������������");
				int c = sc.nextInt();
				switch (c) {
				
				case 1: //attack�� ���ý�
					clear();
					System.out.println("����������������������������������������������������������������");// ���� �Ϲ� ������ �ְ� ����
					System.out.println("��" + name1 + "�� attack");
					System.out.println("��" + at1 + "�� �����");
					hp2 = hp2 - at1;
					System.out.println("��[�÷��̾�2]" + name2 + "�� ���� hp : " + hp2);
					System.out.println("����������������������������������������������������������������");

					System.out.println("����������������������������������������������������������������");
					System.out.println("��" + name2 + "�� attack");
					System.out.println("��" + at2 + "�� �����");
					hp1 = hp1 - at2;
					System.out.println("��[�÷��̾�1]" + name1 + "�� ���� hp : " + hp1);
					System.out.println("����������������������������������������������������������������");
					t.sleep(3000);
					break;
				
				
				case 2: // skill�� ����������
					clear();
					sql.skillname(name1);	// ��ų�̸� ���
					skillname = sql.skill(name1);  // DB���� ��ų�̸��� �����´�
					int sk = sc.nextInt();
					switch (sk) {
					case 1:
						
						clear();
						sat1 = (int) (Math.random() * 50) + 1;	// ��ų������� 1~50���� ���� �����
						if (skillname.equals("�͵�") ) {			// ��ų�̸��� �͵��� ���
							pz = 0;								// �͵� 3�� ����
							sat1 = 10;							// ��ų ������� 10
						}	
						System.out.println("����������������������������������������������������������������");
						System.out.println("��" + name1 + "�� " + skillname);
						System.out.println("��" + sat1 + "�� �����");
						hp2 = hp2 - sat1;
						System.out.println("��" + name2 + "�� ���� hp : " + hp2);
						System.out.println("����������������������������������������������������������������");
						System.out.println("����������������������������������������������������������������");
						System.out.println("��" + name2 + "�� attack");
						System.out.println("��" + at2 + "�� �����");
						hp1 = hp1 - at2;
						System.out.println("��[�÷��̾�1]" + name1 + "�� ���� hp : " + hp1);
						System.out.println("����������������������������������������������������������������");
						t.sleep(3000);
						break;
					default:
						System.out.println("����������������������������������������������������������������");
						System.out.println("��        �������� �ʽ��ϴ�.        ��");
						System.out.println("����������������������������������������������������������������");
						t.sleep(1000);
						System.out.println("����������������������������������������������������������������");
						System.out.println("��" + name2 + "�� attack");
						System.out.println("��" + at2 + "�� �����");
						hp1 = hp1 - at2;
						System.out.println("��[�÷��̾�1]" + name1 + "�� ���� hp : " + hp1);
						System.out.println("����������������������������������������������������������������");
						t.sleep(3000);
						break;
					}

					break;
				
				
				
				case 3: // bag�� ���ý� 
					System.out.println("����������������������������������������������������������������");
					System.out.println("��  1. �Ϲݻ�ó��(+10) " + po1 + "��");
					System.out.println("��  2. ��޻�ó��(+30) " + po2 + "��");
					System.out.println("����������������������������������������������������������������");
					int bag = sc.nextInt();
					if (bag == 1) {		// �Ϲݻ�ó���� �����������
						if (po1 >= 1) {
							if (hp1 >= 30) {
								System.out.println("����������������������������������������������������������������");
								System.out.println("��        ����� �� �����ϴ�.       ��");
								System.out.println("����������������������������������������������������������������");
							} else if (hp1 < 30) {
								po1 = po1 - 1;		// ���� ������ �پ�� 
								hp1 = hp1 + 10;		// ȸ���� 10
								if (hp1 >= 30) {	// HP�� 30�� �Ѿ��� �ִ�ġ�� 30���� ����
									hp1 = 30;
								}
							}

						} else {
							System.out.println("����������������������������������������������������������������");
							System.out.println("��        ��ó���� �����ϴ�.        ��");
							System.out.println("����������������������������������������������������������������");
						}
						t.sleep(1000);
						System.out.println("����������������������������������������������������������������");		// ��ó������ ȸ��
						System.out.println("��"+name1 + "�� hp : " + hp1);
						System.out.println("����������������������������������������������������������������");
						t.sleep(1500);
						clear();
						System.out.println("����������������������������������������������������������������");		// ��ó ���� ������� ��� �����
						System.out.println("��" + name2 + "�� attack");
						System.out.println("��" + at2 + "�� �����");
						hp1 = hp1 - at2;
						System.out.println("��[�÷��̾�1]" + name1 + "�� ���� hp : " + hp1);
						System.out.println("����������������������������������������������������������������");
						t.sleep(3000);
						break;
						
					}else if (bag == 2) { // ��޻�ó���� �������� ���
						if (po2 >= 1) {
							if (hp1 >= 30) {
								System.out.println("����������������������������������������������������������������");
								System.out.println("��        ����� �� �����ϴ�.       ��");
								System.out.println("����������������������������������������������������������������");
							} else if (hp1 < 30) {
								po2 = po2 - 1;		// ���� ������ �پ�� 
								hp1 = hp1 + 30;		// ȸ���� 30
								if (hp1 >= 30) {	// HP�� 30�� �Ѿ��� �ִ�ġ�� 30���� ����
									hp1 = 30;
								}
							}

						} else {
							System.out.println("����������������������������������������������������������������");
							System.out.println("��        ��ó���� �����ϴ�.        ��");		// ��ó���� �������� ���� ��� ���
							System.out.println("����������������������������������������������������������������");
						}
						t.sleep(1000);
						System.out.println("����������������������������������������������������������������");		// ��ó������ ȸ��
						System.out.println("��"+name1 + "�� hp : " + hp1);
						System.out.println("����������������������������������������������������������������");
						t.sleep(1500);
						clear();
						System.out.println("����������������������������������������������������������������");		// ��ó ���� ������� ��� �����
						System.out.println("��" + name2 + "�� attack");
						System.out.println("��" + at2 + "�� �����");
						hp1 = hp1 - at2;
						System.out.println("��[�÷��̾�1]" + name1 + "�� ���� hp : " + hp1);
						System.out.println("����������������������������������������������������������������");
						t.sleep(3000);
						break;
					}else {
						clear();
						t.sleep(1000);
						System.out.println("����������������������������������������������������������������");
						System.out.println("��        �������� �ʽ��ϴ�.        ��"); // 1,2���� ���ڸ� �Է½� ���
						System.out.println("����������������������������������������������������������������");
						t.sleep(1000);
					}
					// ��ó ���� ������� ���� 1,2�� �ܿ� �������� ��� �����
					clear();
					System.out.println("����������������������������������������������������������������");
					System.out.println("��" + name2 + "�� attack");
					System.out.println("��" + at2 + "�� �����");
					hp1 = hp1 - at2;
					System.out.println("��[�÷��̾�1]" + name1 + "�� ���� hp : " + hp1);
					System.out.println("����������������������������������������������������������������");
					t.sleep(3000);
					break;
				
				
				case 4: // run
					int r = (int) (Math.random() * 2) + 1;		// 50����Ȯ���� ����
					if (r == 1) {
						t.sleep(1000);
						clear();
						System.out.println("����������������������������������������������������������������");	
						System.out.println("��           �����ƽ��ϴ�.         ��");		// 50����Ȯ���� ����
						System.out.println("����������������������������������������������������������������");
						run = false;
					} else {
						t.sleep(1000);
						clear();
						System.out.println("����������������������������������������������������������������");	
						System.out.println("��        �����������߽��ϴ�.         ");	// 50����Ȯ���� ����
						System.out.println("����������������������������������������������������������������");
						t.sleep(1000);
						System.out.println("");
						System.out.println("����������������������������������������������������������������");		// ���� ��
						System.out.println("��" + name2 + "�� attack");
						System.out.println("��" + at2 + "�� �����");
						hp1 = hp1 - at2;
						System.out.println("��[�÷��̾�1]" + name1 + "�� ���� hp : " + hp1);
						System.out.println("����������������������������������������������������������������");
						t.sleep(3000);
					}
					break;
					

				case 5:		// change
					while (cha) {
					clear();
					System.out.println("����������������������������������������������������������������");
					System.out.println("��  [��ü�� ���ϸ�]                 ");
					System.out.println("��  1." + sql.name1(1)            );
					System.out.println("��  2." + sql.name1(2)            );
					System.out.println("��  3." + sql.name1(3)            );
					System.out.println("����������������������������������������������������������������");
					
					ch = sc.nextInt();
					switch (ch) {
					case 1:
						sql.player1hp(num1, hp1);
						num1 = 1;
						name1 = sql.name1(num1);
						if (name1.equals("����")) {	// ���ϸ��� ���������ϋ� �缱��
							clear();
							t.sleep(1000);
							System.out.println("����������������������������������������������������������������");
							System.out.println("��          �����߽��ϴ�.          ��");// ���ϸ��� ���������ϋ� ���
							System.out.println("����������������������������������������������������������������");
							t.sleep(1000); 
						} else {
							at1 = sql.at1(num1);
							hp1 = sql.hp1(num1);
							cha = false;					  // ���ϸ��� �������°� �ƴҋ� ����
							p1 = true;
						}
						break;
					case 2:
						sql.player1hp(num1, hp1);
						num1 = 2;
						name1 = sql.name1(num1);
						if (name1.equals("����")) {
							clear();
							t.sleep(1000);
							System.out.println("����������������������������������������������������������������");
							System.out.println("��          �����߽��ϴ�.          ��");
							System.out.println("����������������������������������������������������������������");
							t.sleep(1000);
						} else {
							at1 = sql.at1(num1);
							hp1 = sql.hp1(num1);
							cha = false;
							p1 = true;
						}
						break;
					case 3:
						sql.player1hp(num1, hp1);
						num1 = 3;
						name1 = sql.name1(num1);
						if (name1.equals("����")) {
							clear();
							t.sleep(1000);
							System.out.println("����������������������������������������������������������������");
							System.out.println("��          �����߽��ϴ�.          ��");
							System.out.println("����������������������������������������������������������������");
							t.sleep(1000);
						} else {
							at1 = sql.at1(num1);
							hp1 = sql.hp1(num1);
							cha = false;
							p1 = true;
						}
						break;

					default:
						break;
					}
					} 
					// ��ü�� ���� ���� 
					System.out.println("����������������������������������������������������������������");
					System.out.println("��" + name2 + "�� attack");
					System.out.println("��" + at2 + "�� �����");
					hp1 = hp1 - at2;
					System.out.println("��[�÷��̾�1]" + name1 + "�� ���� hp : " + hp1);
					System.out.println("����������������������������������������������������������������");
					t.sleep(3000);
					break;
				default:
					clear();
					t.sleep(1000);
					System.out.println("����������������������������������������������������������������");
					System.out.println("��     �÷��̾�1�� ������Դϴ�.       ");
					System.out.println("����������������������������������������������������������������");
					t.sleep(1000);
					break;
				}

				
				sql.player1hp(hp1, num1);	// �ڽ��� ���ϸ� hp����
				sql.player2hp(hp2, num2);	// ������ ���ϸ� hp����
				// �ڽŰ� ������ ���ϸ��� ��� ����������
				  if (hp2 <= 0) {		// ���� ���ϸ��� ����������
					count1 += 1;
					num2 += 1;
					p2 = true;
				} 
				 if (hp1 <= 0) {		// �ڽ��� ���ϸ��� ���������� �̸��� ������ �ٲٰ� ��������
					 					// ���� �����Ҷ� �����̸� ��ü�� ���ϰ� ���� �ߴ�
					count2 += 1;		
					name1 = "����";
					sql.player1name(name1, num1);
					while(B) {
					System.out.println("����������������������������������������������������������������");
					System.out.println("��  [�������� ������ ���ϸ�]          ");
					System.out.println("��  1." + sql.name1(1)           );
					System.out.println("��  2." + sql.name1(2)           );
					System.out.println("��  3." + sql.name1(3)           );
					System.out.println("����������������������������������������������������������������");
					int nx = sc.nextInt();
					switch (nx) {
					case 1:
						sql.player1hp(num1, hp1);
						num1 = 1;
						name1 = sql.name1(num1);
						if (name1.equals("����")) {
							clear();
							t.sleep(1000);
							System.out.println("����������������������������������������������������������������");// �������� ��� �缱��
							System.out.println("��          �����߽��ϴ�.          ��");
							System.out.println("����������������������������������������������������������������");
							t.sleep(1000);
							break;
						} else {
							at1 = sql.at1(num1);
							hp1 = sql.hp1(num1);
							B = false;					// ������ �ƴ� ��� ����
							p1 = true;
						}
						break;
					case 2:
						sql.player1hp(num1, hp1);
						num1 = 2;
						name1 = sql.name1(num1);
						if (name1.equals("����")) {
							clear();
							t.sleep(1000);
							System.out.println("����������������������������������������������������������������");
							System.out.println("��          �����߽��ϴ�.          ��");
							System.out.println("����������������������������������������������������������������");
							t.sleep(1000);
							break;
						} else {
							at1 = sql.at1(num1);
							hp1 = sql.hp1(num1);
							B = false;
							p1 = true;
						}
						break;
					case 3:
						sql.player1hp(num1, hp1);
						num1 = 3;
						name1 = sql.name1(num1);
						if (name1.equals("����")) {
							clear();
							t.sleep(1000);
							System.out.println("����������������������������������������������������������������");
							System.out.println("��          �����߽��ϴ�.          ��");
							System.out.println("����������������������������������������������������������������");
							t.sleep(1000);
							break;
						} else {

							at1 = sql.at1(num1);
							hp1 = sql.hp1(num1);
							B = false;
							p1 = true;
						}
						break;

					default:
						break;
					}
				}
				}
				 if (pz < 3 ) { // ������� 2�����
						clear();
						t.sleep(1500);
						System.out.println(hp2%2);
						System.out.println(hp2/2);
						System.out.println("����������������������������������������������������������������");
						System.out.println("��" + name2 + "�� ��������� �Ծ���.");
						System.out.println("��  2�� �����");
						hp2 = hp2 - 2;
						System.out.println("��[�÷��̾�2]" + name2 + "�� ���� hp : " + hp2);
						System.out.println("����������������������������������������������������������������");
						pz += 1;
						t.sleep(1500);
					}
				
				
				// ���ϸ��� ����������� �������ϸ� �ڵ� ����
				while (de) {
					if (name1.equals("����")) {
						num1 += 1;
						if (num1 == 3) {
							num1 = 1;
							p1 = true;
						}
					} else {
						de = false;
						
					}
				}
				
				
				if(count1 >=3 && count2 >=3) {		//�ڽŰ� ������ ���ϸ� 3������ ���� ������ ���º�
					clear();
					draw();
					run = false;
				}else if (count1 >= 3) { 		//��� ���ϸ� 3������ ���� ������ �¸�
					clear();
					win();
					run = false;
				} else if (count2 >= 3) {	//�ڽ��� ���ϸ� 3������ ���� ������ �й�
					clear();
					lose();
					run = false;
				} 

			}
		} else if (num != 1) {	// ����ȭ�鿡�� 1���� �ƴѼ��ڸ� ������ ��������
			clear();
			t.sleep(1000);
			gameover();			// ���ӿ��� ���
		}

	}
	
	public static void clear() {	// �ǳʶٱ� ���� �ܼ�â����
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	public static void gameover() { // ������ ���������� ȭ�鿡 ���
	System.out.println("     �����������     �����������     ������           ������     �����������     �����������     ���        ���     �����������     �����������   ");
	System.out.println("     ���             ���      ���     ��������       ��������     �����������     �����������     ���        ���     �����������     �����������   ");
	System.out.println("     ���             ���      ���     ����  ����     ����  ����     ���             ���      ���      ���      ���      ���             ���      ���   ");
	System.out.println("     ���             ���      ���     ���    ����   ����    ���     ���             ���      ���      ���      ���      ���             ���      ���   ");
	System.out.println("     ���             ���      ���     ���     ���� ����     ���     ���             ���      ���       ���    ���       ���             ���      ���   ");
	System.out.println("     ���   ������     �����������     ���      ������      ���     �����������     ���      ���       ���    ���       �����������     �����������   ");
	System.out.println("     ���      ���     ���      ���     ���       ����       ���     ���             ���      ���        ���  ���        ���             ���  ���       ");
	System.out.println("     ���      ���     ���      ���     ���        ��        ���     ���             ���      ���        ���  ���        ���             ���   ���      ");
	System.out.println("     ���      ���     ���      ���     ���                 ���     ���             ���      ���         �����         ���             ���    ���     ");
	System.out.println("     ���      ���     ���      ���     ���                 ���     �����������     �����������          ���          �����������     ���     ���    ");
	System.out.println("     �����������     ���      ���     ���                 ���     �����������     �����������          ���          �����������     ���      ���   ");
	}
	
	
	
	
	
	public static void open() {
		Sleep t = new Sleep();
		clear();
		System.out.println("     �����������           ");
		System.out.println("     �����������           ");
		System.out.println("     ���      ���            ");
		System.out.println("     ���      ���                 ");
		System.out.println("     �����������            ");
		System.out.println("     �����������                     ");
		System.out.println("     ���                  ");
		System.out.println("     ���                      ");
		System.out.println("     ���                     ");
		System.out.println("     ���                          ");
		System.out.println("     ���                     ");
		System.out.println("");
		t.sleep(1000);
		clear();
		System.out.println("     �����������     �����������               ");
		System.out.println("     �����������     �����������             ");
		System.out.println("     ���      ���     ���      ���            ");
		System.out.println("     ���      ���     ���      ���                     ");
		System.out.println("     �����������     ���      ���             ");
		System.out.println("     �����������     ���      ���                   ");
		System.out.println("     ���             ���      ���             ");
		System.out.println("     ���             ���      ���             ");
		System.out.println("     ���             ���      ���            ");
		System.out.println("     ���             �����������                  ");
		System.out.println("     ���             �����������              ");
		System.out.println("");
		t.sleep(1000);
		clear();
		System.out.println("     �����������     �����������     ���       ���             ");
		System.out.println("     �����������     �����������     ���      ���             ");
		System.out.println("     ���      ���     ���      ���     ���     ���               ");
		System.out.println("     ���      ���     ���      ���     ���    ���                     ");
		System.out.println("     �����������     ���      ���     ���   ���                 ");
		System.out.println("     �����������     ���      ���     ��� ���                           ");
		System.out.println("     ���             ���      ���     ���   ���                 ");
		System.out.println("     ���             ���      ���     ���    ���                    ");
		System.out.println("     ���             ���      ���     ���     ���                  ");
		System.out.println("     ���             �����������     ���      ���                     ");
		System.out.println("     ���             �����������     ���       ���               ");
		System.out.println("");
		t.sleep(1000);
		clear();
		System.out.println("     �����������     �����������     ���       ���     �����������            ");
		System.out.println("     �����������     �����������     ���      ���      �����������          ");
		System.out.println("     ���      ���     ���      ���     ���     ���       ���                     ");
		System.out.println("     ���      ���     ���      ���     ���    ���        ���                            ");
		System.out.println("     �����������     ���      ���     ���   ���         ���                  ");
		System.out.println("     �����������     ���      ���     ��� ���           �����������                    ");
		System.out.println("     ���             ���      ���     ���   ���         ���                     ");
		System.out.println("     ���             ���      ���     ���    ���        ���                      ");
		System.out.println("     ���             ���      ���     ���     ���       ���                     ");
		System.out.println("     ���             �����������     ���      ���      �����������                   ");
		System.out.println("     ���             �����������     ���       ���     �����������              ");
		System.out.println("");
		t.sleep(1000);
		clear();
		System.out.println("     �����������     �����������     ���       ���     �����������      ������         ������               ");
		System.out.println("     �����������     �����������     ���      ���      �����������     ��������       ��������              ");
		System.out.println("     ���      ���     ���      ���     ���     ���       ���             ����  ����     ����  ����              ");
		System.out.println("     ���      ���     ���      ���     ���    ���        ���             ���    ����   ����    ���                   ");
		System.out.println("     �����������     ���      ���     ���   ���         ���             ���     ���� ����     ���             ");
		System.out.println("     �����������     ���      ���     ��� ���           �����������     ���      ������      ���                      ");
		System.out.println("     ���             ���      ���     ���   ���         ���             ���       ����       ���             ");
		System.out.println("     ���             ���      ���     ���    ���        ���             ���        ��        ���           ");
		System.out.println("     ���             ���      ���     ���     ���       ���             ���                 ���               ");
		System.out.println("     ���             �����������     ���      ���      �����������     ���                 ���                    ");
		System.out.println("     ���             �����������     ���       ���     �����������     ���                 ���               ");
		System.out.println("");
		t.sleep(1000);
		clear();
		System.out.println("     �����������     �����������     ���       ���     �����������      ������         ������      �����������             ");
		System.out.println("     �����������     �����������     ���      ���      �����������     ��������       ��������     �����������              ");
		System.out.println("     ���      ���     ���      ���     ���     ���       ���             ����  ����     ����  ����     ���      ���               ");
		System.out.println("     ���      ���     ���      ���     ���    ���        ���             ���    ����   ����    ���     ���      ���                        ");
		System.out.println("     �����������     ���      ���     ���   ���         ���             ���     ���� ����     ���     ���      ���                 ");
		System.out.println("     �����������     ���      ���     ��� ���           �����������     ���      ������      ���     ���      ���               ");
		System.out.println("     ���             ���      ���     ���   ���         ���             ���       ����       ���     ���      ���               ");
		System.out.println("     ���             ���      ���     ���    ���        ���             ���        ��        ���     ���      ���                 ");
		System.out.println("     ���             ���      ���     ���     ���       ���             ���                 ���     ���      ���                  ");
		System.out.println("     ���             �����������     ���      ���      �����������     ���                 ���     �����������                     ");
		System.out.println("     ���             �����������     ���       ���     �����������     ���                 ���     �����������                ");
		System.out.println("");
		t.sleep(1000);
		clear();
		System.out.println("     �����������     �����������     ���       ���     �����������      ������         ������      �����������      �����          ���            ");
		System.out.println("     �����������     �����������     ���      ���      �����������     ��������       ��������     �����������      ��� ���         ���           ");
		System.out.println("     ���      ���     ���      ���     ���     ���       ���             ����  ����     ����  ����     ���      ���      ���  ���        ���            ");
		System.out.println("     ���      ���     ���      ���     ���    ���        ���             ���    ����   ����    ���     ���      ���      ���   ���       ���                  ");
		System.out.println("     �����������     ���      ���     ���   ���         ���             ���     ���� ����     ���     ���      ���      ���    ���      ���            ");
		System.out.println("     �����������     ���      ���     ��� ���           �����������     ���      ������      ���     ���      ���      ���     ���     ���                   ");
		System.out.println("     ���             ���      ���     ���   ���         ���             ���       ����       ���     ���      ���      ���      ���    ���            ");
		System.out.println("     ���             ���      ���     ���    ���        ���             ���        ��        ���     ���      ���      ���       ���   ���            ");
		System.out.println("     ���             ���      ���     ���     ���       ���             ���                 ���     ���      ���      ���        ���  ���             ");
		System.out.println("     ���             �����������     ���      ���      �����������     ���                 ���     �����������      ���         ��� ���                 ");
		System.out.println("     ���             �����������     ���       ���     �����������     ���                 ���     �����������      ���          �����             ");
		System.out.println("");
		t.sleep(1000);
	}
	
	public static void win() {		// �¸��� ����� �޼ҵ�
	clear();
	System.out.println("         ���         �������  ���      ");
	System.out.println("       ���  ���           ���  ���      ");
	System.out.println("      ���    ���          ���  ���      ");
	System.out.println("     ���      ���         ���  ���      ");
	System.out.println("                        ���  ���      ");
	System.out.println("     �����������     �������  ���      ");
	System.out.println("                    ���      ���      ");
	System.out.println("       �������       ���      ���      ");
	System.out.println("      ����  ����      ���      ���      ");
	System.out.println("     ����    ����     ���      ���      ");
	System.out.println("      ����  ����      ���      ���      ");
	System.out.println("       �������       �������  ���      ");
	}
	
	public static void lose() {		// �й�� ����� �޼ҵ�
		clear();
	System.out.println("     �������� ��  ��    ���   ���  ��  ��    ");
	System.out.println("     �������� ��  ��    ���   ���  ��  ��    ");
	System.out.println("      ��   ��  ��  ��    ���   ���  ��  ��    ");
	System.out.println("      ��   ��  ��  ��    ���   ���  ��  ��    ");
	System.out.println("      ��   ��  ��  ��    ���   ���  ��  ��    ");
	System.out.println("      ��   ��  �����    ��������  �����    ");
	System.out.println("      ��   ��  �����    ��������  �����    ");
	System.out.println("      ��   ��  ��  ��    ���   ���  ��  ��    ");
	System.out.println("      ��   ��  ��  ��    ���   ���  ��  ��    ");
	System.out.println("      ��   ��  ��  ��    ���   ���  ��  ��    ");
	System.out.println("     �������� ��  ��    ��������  ��  ��    ");
	System.out.println("     �������� ��  ��    ��������  ��  ��    ");
	}
	
	public static void draw() {		// ���ºν� ����� �޼ҵ�
		clear();
	System.out.println("     �����������         ���         ���      ���   ");
	System.out.println("     ���      ���       ���  ���       ���      ���   ");
	System.out.println("     ���      ���      ���    ���      �����������   ");
	System.out.println("     ���      ���     ���      ���     ���      ���   ");
	System.out.println("     �����������                    �����������   ");
	System.out.println("                    �����������                  ");
	System.out.println("     �����������                    �����������   ");
	System.out.println("         ���           �������           ���       ");
	System.out.println("         ���          ����  ����          ���       ");
	System.out.println("         ���         ����    ����         ���       ");
	System.out.println("         ���          ����  ����          ���       ");
	System.out.println("         ���           �������           ���       ");
	}
}
