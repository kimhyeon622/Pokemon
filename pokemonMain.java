import java.util.Scanner;

public class pokemonMain {

	public static void main(String[] args) {

		pokemonSQL sql = new pokemonSQL();

		sql.connect();

		Scanner sc = new Scanner(System.in);

		Sleep t = new Sleep();	 		// 화면 콘솔창을 깔끔하게 보여주기위해 나오는 시간을 설정을 했다

		String skillname = null;	 // 스킬이름
		String name1 = null;		// 플레이어 1 포켓몬이름
		String name2 = null;		// 플레이어 2 포켓몬이름
		int pz = 3;					// 독대미지
		int num1 = 1;				// 플레이어 1 포켓몬마다 각자 고유 번호를 설정
		int num2 = 1;				// 플레이어 2 포켓몬마다 각자 고유 번호를 설정
		int cnt1 = 1;				// 플레이어 1 랜덤 포켓몬을 저장하기위해 설정
		int cnt2 = 1;				// 플레이어 2 랜덤 포켓몬을 저장하기위해 설정
		int sat1 = 0;				 // 스킬데미지 저장
		int ch = 0;					 // 포켓몬을 교체할때 사용
		int ran = 0;				// 초반에 랜덤함수 할때 사용
		int hp1 = 30;				 // 플레이어 1 포켓몬 HP피 설정
		int hp2 = 30;				// 플레이어 2 포켓몬 HP피 설정
		int at1 = 0;				// 플레이어 1 포켓몬 공격력
		int at2 = 0;				// 플레이어 2 포켓몬 공격력
		int po1 = 10;				 // 일반 상처약 갯수 설정
		int po2 = 10;				 // 고급 상처약 갯수 설정
		int count1 = 0;				// 플레이어 1 죽은 포켓몬 카운트를 셈
		int count2 = 0;				// 플레이어 2 죽은 포켓몬 카운트를 셈
		String name = null;			// 랜덤으로 이름을 뽑을때 저장
		boolean run = true;			// 게임 전체 반복문 사용할때
		boolean de = true;			 // 죽었을때 자동출전을 위해 만듬
		boolean B = true;			// 다음 포켓몬 출전할때 선택
		boolean cha = true;			// 포켓몬 교체할때 사용
		boolean p1 = true;			// 플레이어 1 포켓몬 출전시 사용 
		boolean p2 = true;			// 플레이어 2 포켓몬 출전시 사용 
		
		open();						// 포켓몬 로그 불러오기
		System.out.println("\t1. 시작하기\t\t2. 종료");
		sql.re1(); // 전 게임의 플레이어 1 대이터 삭제
		sql.re2(); // 전 게임의 플레이어 2 대이터 삭제
		int num = sc.nextInt();
		if (num == 1) {
			for (int i = 1; i <= 2; i++) {					// i=1 : 플레이어 1   // i=2 : 플레이어 2
				for (int j = 1; j <= 3; j++) {				// 각각 3마리 포켓몬
					ran = (int) (Math.random() * 15) + 1;	 // 15마리중 각각 포켓몬 3마리씩 랜덤으로 골라지게 만들었다(중복가능)
					switch (ran) {
					case 1:
						name = "파이리";
						break;
					case 2:
						name = "꼬부기";
						break;
					case 3:
						name = "이상해씨";
						break;
					case 4:
						name = "불꽃숭이";
						break;
					case 5:
						name = "팽도리";
						break;
					case 6:
						name = "모부기";
						break;
					case 7:
						name = "브케인";
						break;
					case 8:
						name = "리아코";
						break;
					case 9:
						name = "치코리타";
						break;
					case 10:
						name = "아차모";
						break;
					case 11:
						name = "물짱이";
						break;
					case 12:
						name = "나무지기";
						break;
					case 13:
						name = "뚜꾸리";
						break;
					case 14:
						name = "수댕이";
						break;
					case 15:
						name = "쥬리비안";
						break;
					default:
						break;
					}
					if (i == 1) {			// 플레이어1 포켓몬 저장
						num1 = cnt1;
						hp1 = sql.hp(name);
						at1 = sql.at(name);
						sql.player1(num1, name, hp1, at1);
						cnt1 += 1;
					} else if (i == 2) {	// 플레이어2 포켓몬 저장
						num2 = cnt2;
						hp2 = sql.hp(name);
						at2 = sql.at(name);
						sql.player2(num2, name, hp2, at2);
						cnt2 += 1;
					}
				}
			}
			num1 = 1;	// 재사용을 위한
			num2 = 1;	// 값 사용
			while (run) {
				de = true;	 // 자동출전시 사용
				B = true;	 // 다음 출전한 포켓몬 선택시 사용
				cha = true;	 // 교체시 사용
				name1 = sql.name1(num1);	// 플레이어1 저장해둔 포켓몬 불러오기
				at1 = sql.at1(num1);
				hp1 = sql.hp1(num1);

				name2 = sql.name2(num2);	// 플레이어2 저장해둔 포켓몬 불러오기
				at2 = sql.at2(num2);
				hp2 = sql.hp2(num2);
				while(p1) { 	// 플레이어1 새로운 포켓몬이 나오면 출력
					clear();
					System.out.println("┌──────────────────────────────┐");
					System.out.println("│ [플레이어1] : 가랏!! " + name1);
					System.out.println("└──────────────────────────────┘");
					t.sleep(1500);
					p1 = false;
				}
				while(p2) {		// 플레이어2 새로운 포켓몬이 나오면 출력
					clear();
					System.out.println("┌──────────────────────────────┐");
					System.out.println("│ [플레이어2] : 가랏!! " + name2);
					System.out.println("└──────────────────────────────┘");
					t.sleep(1500);
					p2 = false;
				}
				clear();
				System.out.println("┌──────────────────────────────┐");	// P1 포켓몬 상태창
				System.out.println("│ [플레이어1]               ");
				System.out.println("│ name : " + name1 + "      ");
				System.out.println("│ hp   : " + hp1 + "/30     ");
				System.out.print("│");
				for (int i = 0; i < hp1; i++) {		 // 플레이어1 현재 보유하고있는 HP 표시
					System.out.print("■");
				}
				for (int i = 0; i < (30 - hp1); i++) {
					System.out.print("□");
				}
				System.out.println("");
				System.out.println("└──────────────────────────────┘");
				
				System.out.println("┌──────────────────────────────┐");	// P2 포켓몬 상태창
				System.out.println("│ [플레이어2]               ");
				System.out.println("│ name : " + name2 + "      ");
				System.out.println("│ hp   : " + hp2 + "/30     ");
				System.out.print("│");
				for (int i = 0; i < hp2; i++) {		 // 플레이어2 현재 보유하고있는 HP 표시
					System.out.print("■");
				}
				for (int i = 0; i < (30 - hp2); i++) {
					System.out.print("□");
				}
				System.out.println("");
				System.out.println("└──────────────────────────────┘");
				System.out.println("");
				System.out.println("┌──────────────────────────────┐");
				System.out.println("│    1. attack                 │");
				System.out.println("│    2. skill                  │");
				System.out.println("│    3. bag                    │");		// 선택창
				System.out.println("│    4. run                    │");
				System.out.println("│    5. change                 │");
				System.out.println("└──────────────────────────────┘");
				int c = sc.nextInt();
				switch (c) {
				
				case 1: //attack을 선택시
					clear();
					System.out.println("┌──────────────────────────────┐");// 서로 일반 공격을 주고 받음
					System.out.println("│" + name1 + "의 attack");
					System.out.println("│" + at1 + "의 대미지");
					hp2 = hp2 - at1;
					System.out.println("│[플레이어2]" + name2 + "의 남은 hp : " + hp2);
					System.out.println("└──────────────────────────────┘");

					System.out.println("┌──────────────────────────────┐");
					System.out.println("│" + name2 + "의 attack");
					System.out.println("│" + at2 + "의 대미지");
					hp1 = hp1 - at2;
					System.out.println("│[플레이어1]" + name1 + "의 남은 hp : " + hp1);
					System.out.println("└──────────────────────────────┘");
					t.sleep(3000);
					break;
				
				
				case 2: // skill를 선택했을떄
					clear();
					sql.skillname(name1);	// 스킬이름 출력
					skillname = sql.skill(name1);  // DB에서 스킬이름을 가져온다
					int sk = sc.nextInt();
					switch (sk) {
					case 1:
						
						clear();
						sat1 = (int) (Math.random() * 50) + 1;	// 스킬대미지는 1~50까지 랜덤 대미지
						if (skillname.equals("맹독") ) {			// 스킬이름이 맹독일 경우
							pz = 0;								// 맹독 3턴 시작
							sat1 = 10;							// 스킬 대미지는 10
						}	
						System.out.println("┌──────────────────────────────┐");
						System.out.println("│" + name1 + "의 " + skillname);
						System.out.println("│" + sat1 + "의 대미지");
						hp2 = hp2 - sat1;
						System.out.println("│" + name2 + "의 남은 hp : " + hp2);
						System.out.println("└──────────────────────────────┘");
						System.out.println("┌──────────────────────────────┐");
						System.out.println("│" + name2 + "의 attack");
						System.out.println("│" + at2 + "의 대미지");
						hp1 = hp1 - at2;
						System.out.println("│[플레이어1]" + name1 + "의 남은 hp : " + hp1);
						System.out.println("└──────────────────────────────┘");
						t.sleep(3000);
						break;
					default:
						System.out.println("┌──────────────────────────────┐");
						System.out.println("│        존재하지 않습니다.        │");
						System.out.println("└──────────────────────────────┘");
						t.sleep(1000);
						System.out.println("┌──────────────────────────────┐");
						System.out.println("│" + name2 + "의 attack");
						System.out.println("│" + at2 + "의 대미지");
						hp1 = hp1 - at2;
						System.out.println("│[플레이어1]" + name1 + "의 남은 hp : " + hp1);
						System.out.println("└──────────────────────────────┘");
						t.sleep(3000);
						break;
					}

					break;
				
				
				
				case 3: // bag을 선택시 
					System.out.println("┌──────────────────────────────┐");
					System.out.println("│  1. 일반상처약(+10) " + po1 + "개");
					System.out.println("│  2. 고급상처약(+30) " + po2 + "개");
					System.out.println("└──────────────────────────────┘");
					int bag = sc.nextInt();
					if (bag == 1) {		// 일반상처약을 선택했을경우
						if (po1 >= 1) {
							if (hp1 >= 30) {
								System.out.println("┌──────────────────────────────┐");
								System.out.println("│        사용할 수 없습니다.       │");
								System.out.println("└──────────────────────────────┘");
							} else if (hp1 < 30) {
								po1 = po1 - 1;		// 사용시 갯수가 줄어듬 
								hp1 = hp1 + 10;		// 회복량 10
								if (hp1 >= 30) {	// HP가 30이 넘어갈경우 최대치인 30으로 설정
									hp1 = 30;
								}
							}

						} else {
							System.out.println("┌──────────────────────────────┐");
							System.out.println("│        상처약이 없습니다.        │");
							System.out.println("└──────────────────────────────┘");
						}
						t.sleep(1000);
						System.out.println("┌──────────────────────────────┐");		// 상처약으로 회복
						System.out.println("│"+name1 + "의 hp : " + hp1);
						System.out.println("└──────────────────────────────┘");
						t.sleep(1500);
						clear();
						System.out.println("┌──────────────────────────────┐");		// 상처 약을 사용했을 경우 상대턴
						System.out.println("│" + name2 + "의 attack");
						System.out.println("│" + at2 + "의 대미지");
						hp1 = hp1 - at2;
						System.out.println("│[플레이어1]" + name1 + "의 남은 hp : " + hp1);
						System.out.println("└──────────────────────────────┘");
						t.sleep(3000);
						break;
						
					}else if (bag == 2) { // 고급상처약을 선택했을 경우
						if (po2 >= 1) {
							if (hp1 >= 30) {
								System.out.println("┌──────────────────────────────┐");
								System.out.println("│        사용할 수 없습니다.       │");
								System.out.println("└──────────────────────────────┘");
							} else if (hp1 < 30) {
								po2 = po2 - 1;		// 사용시 갯수가 줄어듬 
								hp1 = hp1 + 30;		// 회복량 30
								if (hp1 >= 30) {	// HP가 30이 넘어갈경우 최대치인 30으로 설정
									hp1 = 30;
								}
							}

						} else {
							System.out.println("┌──────────────────────────────┐");
							System.out.println("│        상처약이 없습니다.        │");		// 상처약의 보유량이 없을 경우 출력
							System.out.println("└──────────────────────────────┘");
						}
						t.sleep(1000);
						System.out.println("┌──────────────────────────────┐");		// 상처약으로 회복
						System.out.println("│"+name1 + "의 hp : " + hp1);
						System.out.println("└──────────────────────────────┘");
						t.sleep(1500);
						clear();
						System.out.println("┌──────────────────────────────┐");		// 상처 약을 사용했을 경우 상대턴
						System.out.println("│" + name2 + "의 attack");
						System.out.println("│" + at2 + "의 대미지");
						hp1 = hp1 - at2;
						System.out.println("│[플레이어1]" + name1 + "의 남은 hp : " + hp1);
						System.out.println("└──────────────────────────────┘");
						t.sleep(3000);
						break;
					}else {
						clear();
						t.sleep(1000);
						System.out.println("┌──────────────────────────────┐");
						System.out.println("│        존재하지 않습니다.        │"); // 1,2외의 숫자를 입력시 출력
						System.out.println("└──────────────────────────────┘");
						t.sleep(1000);
					}
					// 상처 약을 사용했을 경우와 1,2번 외에 선택했을 경우 상대턴
					clear();
					System.out.println("┌──────────────────────────────┐");
					System.out.println("│" + name2 + "의 attack");
					System.out.println("│" + at2 + "의 대미지");
					hp1 = hp1 - at2;
					System.out.println("│[플레이어1]" + name1 + "의 남은 hp : " + hp1);
					System.out.println("└──────────────────────────────┘");
					t.sleep(3000);
					break;
				
				
				case 4: // run
					int r = (int) (Math.random() * 2) + 1;		// 50프로확률로 도망
					if (r == 1) {
						t.sleep(1000);
						clear();
						System.out.println("┌──────────────────────────────┐");	
						System.out.println("│           도망쳤습니다.         │");		// 50프로확률로 성공
						System.out.println("└──────────────────────────────┘");
						run = false;
					} else {
						t.sleep(1000);
						clear();
						System.out.println("┌──────────────────────────────┐");	
						System.out.println("│        도망에실패했습니다.         ");	// 50프로확률로 실패
						System.out.println("└──────────────────────────────┘");
						t.sleep(1000);
						System.out.println("");
						System.out.println("┌──────────────────────────────┐");		// 상대방 턴
						System.out.println("│" + name2 + "의 attack");
						System.out.println("│" + at2 + "의 대미지");
						hp1 = hp1 - at2;
						System.out.println("│[플레이어1]" + name1 + "의 남은 hp : " + hp1);
						System.out.println("└──────────────────────────────┘");
						t.sleep(3000);
					}
					break;
					

				case 5:		// change
					while (cha) {
					clear();
					System.out.println("┌──────────────────────────────┐");
					System.out.println("│  [교체할 포켓몬]                 ");
					System.out.println("│  1." + sql.name1(1)            );
					System.out.println("│  2." + sql.name1(2)            );
					System.out.println("│  3." + sql.name1(3)            );
					System.out.println("└──────────────────────────────┘");
					
					ch = sc.nextInt();
					switch (ch) {
					case 1:
						sql.player1hp(num1, hp1);
						num1 = 1;
						name1 = sql.name1(num1);
						if (name1.equals("기절")) {	// 포켓몬이 기절상태일떄 재선택
							clear();
							t.sleep(1000);
							System.out.println("┌──────────────────────────────┐");
							System.out.println("│          기절했습니다.          │");// 포켓몬이 기절상태일떄 출력
							System.out.println("└──────────────────────────────┘");
							t.sleep(1000); 
						} else {
							at1 = sql.at1(num1);
							hp1 = sql.hp1(num1);
							cha = false;					  // 포켓몬이 기절상태가 아닐떄 선택
							p1 = true;
						}
						break;
					case 2:
						sql.player1hp(num1, hp1);
						num1 = 2;
						name1 = sql.name1(num1);
						if (name1.equals("기절")) {
							clear();
							t.sleep(1000);
							System.out.println("┌──────────────────────────────┐");
							System.out.println("│          기절했습니다.          │");
							System.out.println("└──────────────────────────────┘");
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
						if (name1.equals("기절")) {
							clear();
							t.sleep(1000);
							System.out.println("┌──────────────────────────────┐");
							System.out.println("│          기절했습니다.          │");
							System.out.println("└──────────────────────────────┘");
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
					// 교체시 상대방 공격 
					System.out.println("┌──────────────────────────────┐");
					System.out.println("│" + name2 + "의 attack");
					System.out.println("│" + at2 + "의 대미지");
					hp1 = hp1 - at2;
					System.out.println("│[플레이어1]" + name1 + "의 남은 hp : " + hp1);
					System.out.println("└──────────────────────────────┘");
					t.sleep(3000);
					break;
				default:
					clear();
					t.sleep(1000);
					System.out.println("┌──────────────────────────────┐");
					System.out.println("│     플레이어1은 고민중입니다.       ");
					System.out.println("└──────────────────────────────┘");
					t.sleep(1000);
					break;
				}

				
				sql.player1hp(hp1, num1);	// 자신의 포켓몬 hp저장
				sql.player2hp(hp2, num2);	// 상대방의 포켓몬 hp저장
				// 자신과 상대방의 포켓몬이 모두 기절했을떄
				  if (hp2 <= 0) {		// 상대방 포켓몬이 기절했을떄
					count1 += 1;
					num2 += 1;
					p2 = true;
				} 
				 if (hp1 <= 0) {		// 자신의 포켓몬이 기절했을떄 이름을 기절로 바꾸고 저장을함
					 					// 다음 출전할때 기절이면 교체을 못하게 설정 했다
					count2 += 1;		
					name1 = "기절";
					sql.player1name(name1, num1);
					while(B) {
					System.out.println("┌──────────────────────────────┐");
					System.out.println("│  [다음으로 출전할 포켓몬]          ");
					System.out.println("│  1." + sql.name1(1)           );
					System.out.println("│  2." + sql.name1(2)           );
					System.out.println("│  3." + sql.name1(3)           );
					System.out.println("└──────────────────────────────┘");
					int nx = sc.nextInt();
					switch (nx) {
					case 1:
						sql.player1hp(num1, hp1);
						num1 = 1;
						name1 = sql.name1(num1);
						if (name1.equals("기절")) {
							clear();
							t.sleep(1000);
							System.out.println("┌──────────────────────────────┐");// 기절했을 경우 재선택
							System.out.println("│          기절했습니다.          │");
							System.out.println("└──────────────────────────────┘");
							t.sleep(1000);
							break;
						} else {
							at1 = sql.at1(num1);
							hp1 = sql.hp1(num1);
							B = false;					// 기절이 아닐 경우 선택
							p1 = true;
						}
						break;
					case 2:
						sql.player1hp(num1, hp1);
						num1 = 2;
						name1 = sql.name1(num1);
						if (name1.equals("기절")) {
							clear();
							t.sleep(1000);
							System.out.println("┌──────────────────────────────┐");
							System.out.println("│          기절했습니다.          │");
							System.out.println("└──────────────────────────────┘");
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
						if (name1.equals("기절")) {
							clear();
							t.sleep(1000);
							System.out.println("┌──────────────────────────────┐");
							System.out.println("│          기절했습니다.          │");
							System.out.println("└──────────────────────────────┘");
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
				 if (pz < 3 ) { // 독대미지 2대미지
						clear();
						t.sleep(1500);
						System.out.println(hp2%2);
						System.out.println(hp2/2);
						System.out.println("┌──────────────────────────────┐");
						System.out.println("│" + name2 + "은 독대미지를 입었다.");
						System.out.println("│  2의 대미지");
						hp2 = hp2 - 2;
						System.out.println("│[플레이어2]" + name2 + "의 남은 hp : " + hp2);
						System.out.println("└──────────────────────────────┘");
						pz += 1;
						t.sleep(1500);
					}
				
				
				// 포켓몬이 기절했을경우 다음포켓몬 자동 출전
				while (de) {
					if (name1.equals("기절")) {
						num1 += 1;
						if (num1 == 3) {
							num1 = 1;
							p1 = true;
						}
					} else {
						de = false;
						
					}
				}
				
				
				if(count1 >=3 && count2 >=3) {		//자신과 상대방의 포켓몬 3마리가 전부 기절시 무승부
					clear();
					draw();
					run = false;
				}else if (count1 >= 3) { 		//상대 포켓몬 3마리가 전부 기절시 승리
					clear();
					win();
					run = false;
				} else if (count2 >= 3) {	//자신의 포켓몬 3마리가 전부 기절시 패배
					clear();
					lose();
					run = false;
				} 

			}
		} else if (num != 1) {	// 시작화면에서 1번이 아닌숫자를 누르면 게임종료
			clear();
			t.sleep(1000);
			gameover();			// 게임오버 출력
		}

	}
	
	public static void clear() {	// 건너뛰기 같은 콘솔창정리
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
	
	public static void gameover() { // 게임을 종료했을떄 화면에 출력
	System.out.println("     ■■■■■■■■■■     ■■■■■■■■■■     ■■■■■           ■■■■■     ■■■■■■■■■■     ■■■■■■■■■■     ■■        ■■     ■■■■■■■■■■     ■■■■■■■■■■   ");
	System.out.println("     ■■             ■■      ■■     ■■■■■■■       ■■■■■■■     ■■■■■■■■■■     ■■■■■■■■■■     ■■        ■■     ■■■■■■■■■■     ■■■■■■■■■■   ");
	System.out.println("     ■■             ■■      ■■     ■■■  ■■■     ■■■  ■■■     ■■             ■■      ■■      ■■      ■■      ■■             ■■      ■■   ");
	System.out.println("     ■■             ■■      ■■     ■■    ■■■   ■■■    ■■     ■■             ■■      ■■      ■■      ■■      ■■             ■■      ■■   ");
	System.out.println("     ■■             ■■      ■■     ■■     ■■■ ■■■     ■■     ■■             ■■      ■■       ■■    ■■       ■■             ■■      ■■   ");
	System.out.println("     ■■   ■■■■■     ■■■■■■■■■■     ■■      ■■■■■      ■■     ■■■■■■■■■■     ■■      ■■       ■■    ■■       ■■■■■■■■■■     ■■■■■■■■■■   ");
	System.out.println("     ■■      ■■     ■■      ■■     ■■       ■■■       ■■     ■■             ■■      ■■        ■■  ■■        ■■             ■■  ■■       ");
	System.out.println("     ■■      ■■     ■■      ■■     ■■        ■        ■■     ■■             ■■      ■■        ■■  ■■        ■■             ■■   ■■      ");
	System.out.println("     ■■      ■■     ■■      ■■     ■■                 ■■     ■■             ■■      ■■         ■■■■         ■■             ■■    ■■     ");
	System.out.println("     ■■      ■■     ■■      ■■     ■■                 ■■     ■■■■■■■■■■     ■■■■■■■■■■          ■■          ■■■■■■■■■■     ■■     ■■    ");
	System.out.println("     ■■■■■■■■■■     ■■      ■■     ■■                 ■■     ■■■■■■■■■■     ■■■■■■■■■■          ■■          ■■■■■■■■■■     ■■      ■■   ");
	}
	
	
	
	
	
	public static void open() {
		Sleep t = new Sleep();
		clear();
		System.out.println("     ■■■■■■■■■■           ");
		System.out.println("     ■■■■■■■■■■           ");
		System.out.println("     ■■      ■■            ");
		System.out.println("     ■■      ■■                 ");
		System.out.println("     ■■■■■■■■■■            ");
		System.out.println("     ■■■■■■■■■■                     ");
		System.out.println("     ■■                  ");
		System.out.println("     ■■                      ");
		System.out.println("     ■■                     ");
		System.out.println("     ■■                          ");
		System.out.println("     ■■                     ");
		System.out.println("");
		t.sleep(1000);
		clear();
		System.out.println("     ■■■■■■■■■■     ■■■■■■■■■■               ");
		System.out.println("     ■■■■■■■■■■     ■■■■■■■■■■             ");
		System.out.println("     ■■      ■■     ■■      ■■            ");
		System.out.println("     ■■      ■■     ■■      ■■                     ");
		System.out.println("     ■■■■■■■■■■     ■■      ■■             ");
		System.out.println("     ■■■■■■■■■■     ■■      ■■                   ");
		System.out.println("     ■■             ■■      ■■             ");
		System.out.println("     ■■             ■■      ■■             ");
		System.out.println("     ■■             ■■      ■■            ");
		System.out.println("     ■■             ■■■■■■■■■■                  ");
		System.out.println("     ■■             ■■■■■■■■■■              ");
		System.out.println("");
		t.sleep(1000);
		clear();
		System.out.println("     ■■■■■■■■■■     ■■■■■■■■■■     ■■       ■■             ");
		System.out.println("     ■■■■■■■■■■     ■■■■■■■■■■     ■■      ■■             ");
		System.out.println("     ■■      ■■     ■■      ■■     ■■     ■■               ");
		System.out.println("     ■■      ■■     ■■      ■■     ■■    ■■                     ");
		System.out.println("     ■■■■■■■■■■     ■■      ■■     ■■   ■■                 ");
		System.out.println("     ■■■■■■■■■■     ■■      ■■     ■■ ■■                           ");
		System.out.println("     ■■             ■■      ■■     ■■   ■■                 ");
		System.out.println("     ■■             ■■      ■■     ■■    ■■                    ");
		System.out.println("     ■■             ■■      ■■     ■■     ■■                  ");
		System.out.println("     ■■             ■■■■■■■■■■     ■■      ■■                     ");
		System.out.println("     ■■             ■■■■■■■■■■     ■■       ■■               ");
		System.out.println("");
		t.sleep(1000);
		clear();
		System.out.println("     ■■■■■■■■■■     ■■■■■■■■■■     ■■       ■■     ■■■■■■■■■■            ");
		System.out.println("     ■■■■■■■■■■     ■■■■■■■■■■     ■■      ■■      ■■■■■■■■■■          ");
		System.out.println("     ■■      ■■     ■■      ■■     ■■     ■■       ■■                     ");
		System.out.println("     ■■      ■■     ■■      ■■     ■■    ■■        ■■                            ");
		System.out.println("     ■■■■■■■■■■     ■■      ■■     ■■   ■■         ■■                  ");
		System.out.println("     ■■■■■■■■■■     ■■      ■■     ■■ ■■           ■■■■■■■■■■                    ");
		System.out.println("     ■■             ■■      ■■     ■■   ■■         ■■                     ");
		System.out.println("     ■■             ■■      ■■     ■■    ■■        ■■                      ");
		System.out.println("     ■■             ■■      ■■     ■■     ■■       ■■                     ");
		System.out.println("     ■■             ■■■■■■■■■■     ■■      ■■      ■■■■■■■■■■                   ");
		System.out.println("     ■■             ■■■■■■■■■■     ■■       ■■     ■■■■■■■■■■              ");
		System.out.println("");
		t.sleep(1000);
		clear();
		System.out.println("     ■■■■■■■■■■     ■■■■■■■■■■     ■■       ■■     ■■■■■■■■■■      ■■■■■         ■■■■■               ");
		System.out.println("     ■■■■■■■■■■     ■■■■■■■■■■     ■■      ■■      ■■■■■■■■■■     ■■■■■■■       ■■■■■■■              ");
		System.out.println("     ■■      ■■     ■■      ■■     ■■     ■■       ■■             ■■■  ■■■     ■■■  ■■■              ");
		System.out.println("     ■■      ■■     ■■      ■■     ■■    ■■        ■■             ■■    ■■■   ■■■    ■■                   ");
		System.out.println("     ■■■■■■■■■■     ■■      ■■     ■■   ■■         ■■             ■■     ■■■ ■■■     ■■             ");
		System.out.println("     ■■■■■■■■■■     ■■      ■■     ■■ ■■           ■■■■■■■■■■     ■■      ■■■■■      ■■                      ");
		System.out.println("     ■■             ■■      ■■     ■■   ■■         ■■             ■■       ■■■       ■■             ");
		System.out.println("     ■■             ■■      ■■     ■■    ■■        ■■             ■■        ■        ■■           ");
		System.out.println("     ■■             ■■      ■■     ■■     ■■       ■■             ■■                 ■■               ");
		System.out.println("     ■■             ■■■■■■■■■■     ■■      ■■      ■■■■■■■■■■     ■■                 ■■                    ");
		System.out.println("     ■■             ■■■■■■■■■■     ■■       ■■     ■■■■■■■■■■     ■■                 ■■               ");
		System.out.println("");
		t.sleep(1000);
		clear();
		System.out.println("     ■■■■■■■■■■     ■■■■■■■■■■     ■■       ■■     ■■■■■■■■■■      ■■■■■         ■■■■■      ■■■■■■■■■■             ");
		System.out.println("     ■■■■■■■■■■     ■■■■■■■■■■     ■■      ■■      ■■■■■■■■■■     ■■■■■■■       ■■■■■■■     ■■■■■■■■■■              ");
		System.out.println("     ■■      ■■     ■■      ■■     ■■     ■■       ■■             ■■■  ■■■     ■■■  ■■■     ■■      ■■               ");
		System.out.println("     ■■      ■■     ■■      ■■     ■■    ■■        ■■             ■■    ■■■   ■■■    ■■     ■■      ■■                        ");
		System.out.println("     ■■■■■■■■■■     ■■      ■■     ■■   ■■         ■■             ■■     ■■■ ■■■     ■■     ■■      ■■                 ");
		System.out.println("     ■■■■■■■■■■     ■■      ■■     ■■ ■■           ■■■■■■■■■■     ■■      ■■■■■      ■■     ■■      ■■               ");
		System.out.println("     ■■             ■■      ■■     ■■   ■■         ■■             ■■       ■■■       ■■     ■■      ■■               ");
		System.out.println("     ■■             ■■      ■■     ■■    ■■        ■■             ■■        ■        ■■     ■■      ■■                 ");
		System.out.println("     ■■             ■■      ■■     ■■     ■■       ■■             ■■                 ■■     ■■      ■■                  ");
		System.out.println("     ■■             ■■■■■■■■■■     ■■      ■■      ■■■■■■■■■■     ■■                 ■■     ■■■■■■■■■■                     ");
		System.out.println("     ■■             ■■■■■■■■■■     ■■       ■■     ■■■■■■■■■■     ■■                 ■■     ■■■■■■■■■■                ");
		System.out.println("");
		t.sleep(1000);
		clear();
		System.out.println("     ■■■■■■■■■■     ■■■■■■■■■■     ■■       ■■     ■■■■■■■■■■      ■■■■■         ■■■■■      ■■■■■■■■■■      ■■■■          ■■            ");
		System.out.println("     ■■■■■■■■■■     ■■■■■■■■■■     ■■      ■■      ■■■■■■■■■■     ■■■■■■■       ■■■■■■■     ■■■■■■■■■■      ■■ ■■         ■■           ");
		System.out.println("     ■■      ■■     ■■      ■■     ■■     ■■       ■■             ■■■  ■■■     ■■■  ■■■     ■■      ■■      ■■  ■■        ■■            ");
		System.out.println("     ■■      ■■     ■■      ■■     ■■    ■■        ■■             ■■    ■■■   ■■■    ■■     ■■      ■■      ■■   ■■       ■■                  ");
		System.out.println("     ■■■■■■■■■■     ■■      ■■     ■■   ■■         ■■             ■■     ■■■ ■■■     ■■     ■■      ■■      ■■    ■■      ■■            ");
		System.out.println("     ■■■■■■■■■■     ■■      ■■     ■■ ■■           ■■■■■■■■■■     ■■      ■■■■■      ■■     ■■      ■■      ■■     ■■     ■■                   ");
		System.out.println("     ■■             ■■      ■■     ■■   ■■         ■■             ■■       ■■■       ■■     ■■      ■■      ■■      ■■    ■■            ");
		System.out.println("     ■■             ■■      ■■     ■■    ■■        ■■             ■■        ■        ■■     ■■      ■■      ■■       ■■   ■■            ");
		System.out.println("     ■■             ■■      ■■     ■■     ■■       ■■             ■■                 ■■     ■■      ■■      ■■        ■■  ■■             ");
		System.out.println("     ■■             ■■■■■■■■■■     ■■      ■■      ■■■■■■■■■■     ■■                 ■■     ■■■■■■■■■■      ■■         ■■ ■■                 ");
		System.out.println("     ■■             ■■■■■■■■■■     ■■       ■■     ■■■■■■■■■■     ■■                 ■■     ■■■■■■■■■■      ■■          ■■■■             ");
		System.out.println("");
		t.sleep(1000);
	}
	
	public static void win() {		// 승리시 출력할 메소드
	clear();
	System.out.println("         ■■         ■■■■■■  ■■      ");
	System.out.println("       ■■  ■■           ■■  ■■      ");
	System.out.println("      ■■    ■■          ■■  ■■      ");
	System.out.println("     ■■      ■■         ■■  ■■      ");
	System.out.println("                        ■■  ■■      ");
	System.out.println("     ■■■■■■■■■■     ■■■■■■  ■■      ");
	System.out.println("                    ■■      ■■      ");
	System.out.println("       ■■■■■■       ■■      ■■      ");
	System.out.println("      ■■■  ■■■      ■■      ■■      ");
	System.out.println("     ■■■    ■■■     ■■      ■■      ");
	System.out.println("      ■■■  ■■■      ■■      ■■      ");
	System.out.println("       ■■■■■■       ■■■■■■  ■■      ");
	}
	
	public static void lose() {		// 패배시 출력할 메소드
		clear();
	System.out.println("     ■■■■■■■ ■  ■    ■■   ■■  ■  ■    ");
	System.out.println("     ■■■■■■■ ■  ■    ■■   ■■  ■  ■    ");
	System.out.println("      ■   ■  ■  ■    ■■   ■■  ■  ■    ");
	System.out.println("      ■   ■  ■  ■    ■■   ■■  ■  ■    ");
	System.out.println("      ■   ■  ■  ■    ■■   ■■  ■  ■    ");
	System.out.println("      ■   ■  ■■■■    ■■■■■■■  ■■■■    ");
	System.out.println("      ■   ■  ■■■■    ■■■■■■■  ■■■■    ");
	System.out.println("      ■   ■  ■  ■    ■■   ■■  ■  ■    ");
	System.out.println("      ■   ■  ■  ■    ■■   ■■  ■  ■    ");
	System.out.println("      ■   ■  ■  ■    ■■   ■■  ■  ■    ");
	System.out.println("     ■■■■■■■ ■  ■    ■■■■■■■  ■  ■    ");
	System.out.println("     ■■■■■■■ ■  ■    ■■■■■■■  ■  ■    ");
	}
	
	public static void draw() {		// 무승부시 출력할 메소드
		clear();
	System.out.println("     ■■■■■■■■■■         ■■         ■■      ■■   ");
	System.out.println("     ■■      ■■       ■■  ■■       ■■      ■■   ");
	System.out.println("     ■■      ■■      ■■    ■■      ■■■■■■■■■■   ");
	System.out.println("     ■■      ■■     ■■      ■■     ■■      ■■   ");
	System.out.println("     ■■■■■■■■■■                    ■■■■■■■■■■   ");
	System.out.println("                    ■■■■■■■■■■                  ");
	System.out.println("     ■■■■■■■■■■                    ■■■■■■■■■■   ");
	System.out.println("         ■■           ■■■■■■           ■■       ");
	System.out.println("         ■■          ■■■  ■■■          ■■       ");
	System.out.println("         ■■         ■■■    ■■■         ■■       ");
	System.out.println("         ■■          ■■■  ■■■          ■■       ");
	System.out.println("         ■■           ■■■■■■           ■■       ");
	}
}
