//ȭ�� ���� ȿ���� �ֱ� ���� class
public class Sleep {
	protected int time=500;//ȭ�� ��ȯ �ӵ�
	
	public void setTime(int time) {
		this.time=time;
	}
	public void sleep(){
	    try {
	      Thread.sleep(time);
	    } catch (InterruptedException e) { }
	}
	public void sleep(int time){
	    try {
	      Thread.sleep(time);
	    } catch (InterruptedException e) { }
	}
}
