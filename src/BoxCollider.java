import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class BoxCollider {
	Vec3 vec1;
	Vec3 vec2;
	static Timer timer = new Timer();
	BoxCollider(Vec3 vec1, Vec3 vec2){
		this.vec1 = vec1;
		this.vec2 = vec2;
	}
	
	public boolean isTouching(BoxCollider b){
		Vec3 B1 = this.vec1;
		Vec3 B2 = this.vec2;
		
		Vec3 A1 = b.vec1;
		Vec3 A2 = b.vec2;
		
		if(((A1.x<B1.x && A2.x>B1.x) || (A1.x>B1.x && A2.x<B1.x)) &&
			((A1.y<B1.y && A2.y>B1.y) || (A1.y>B1.y && A2.y<B1.y)) &&
			((A1.z<B1.z && A2.z>B1.z) || (A1.z>B1.z && A2.z<B1.z))){
			return true;
		}
		return false;
	}
	
	public void isTouchingArrayGrav(ArrayList objs){
		BoxCollider[] array = new BoxCollider[objs.size()];
		for(int i=0; i<objs.size(); i++){
			array[i] = ((Object3d)objs.get(i)).boxCollider;
		}
		for(BoxCollider b:array){
			if(isTouching(b)){
				if(!Draw.jump){
					Object3d.setVelocityArrayY(objs, 0);
					Draw.grounded = true;
//					Draw.toggled = true;
//					Draw.toggled = false;
				}else{
					timer.schedule(new setVals(), 40);
				}
			}else{
				timer.schedule(new setGrounded(), 10);
			}
		}
	}
	class setGrounded extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(!Draw.jump){
				timer.schedule(new setVals(), 0);
			}
		}
	}
	class setVals extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Draw.jump = false;
			Draw.grounded = false;
		}
	}
}
