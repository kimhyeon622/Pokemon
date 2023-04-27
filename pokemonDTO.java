public class pokemonDTO {

	private String name;
	private int hp;
	private String skill;
	private int attack;
	private String name1;
	private int hp1;
	private int num1;
	private int at1;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public int getHp1() {
		return hp1;
	}
	public void setHp1(int hp1) {
		this.hp1 = hp1;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getAt1() {
		return at1;
	}
	public void setAt1(int at1) {
		this.at1 = at1;
	}
	
	@Override
	public String toString() {
		return "pokemonDTO [name=" + name + ", hp=" + hp + ", skill=" + skill + ", attack=" + attack + ", name1="
				+ name1 + ", hp1=" + hp1 + ", num1=" + num1 + ", at1=" + at1 + "]";
	}
	
	
	
	
	
	
}