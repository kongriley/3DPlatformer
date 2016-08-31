import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class BoxCollider {
	Vec3 vec1;
	Vec3 vec2;
	Timer timer = new Timer();
	BoxCollider(Vec3 vec1, Vec3 vec2){
		this.vec1 = vec1;
		this.vec2 = vec2;
	}
	
	public boolean isTouching(BoxCollider b){
		Vec3 B1 = this.vec1;
		Vec3 B2 = this.vec2;
		
		Vec3 A1 = b.vec1;
		Vec3 A2 = b.vec2;
		
//		if (!(B1.x > A1.x+A2.x || B1.x+B2.x < A1.x ||
//		        B1.y > A1.y+A2.y || B1.y+B2.y < A1.y ||
//		        B1.z > A1.z+A2.z || B1.z+B2.z < A1.z)){
//			return true;
//		}
//		if (!(B1.x > A1.x+A2.x || B1.x+B2.x < A1.x ||
//		        B1.y > A1.y+A2.y || B1.y+B2.y < A1.y ||
//		        B1.z > A1.z+A2.z || B1.z+B2.z < A1.z)){
//			return false;
//		}
//		if(
//			(A1.x < B1.x && A2.x< B1.x)
//				){
//			
//		}
		int touching = 0;
		if((A1.x<B1.x && A2.x>B1.x) || (A1.x>B1.x && A2.x<B1.x)){
			//System.out.println("x");
			touching++;
		}
		if(((A1.y<B1.y && A2.y>B1.y) || (A1.y>B1.y && A2.y<B1.y))){
			//System.out.println("y");
			touching++;
		}
		if(((A1.z<B1.z && A2.z>B1.z) || (A1.z>B1.z && A2.z<B1.z))){
			touching++;
		}
		if(touching == 3){
			return true;
		}
		if (
				((((A1.x<B1.x && A2.x<B1.x) || (A1.x>B1.x && A2.x>B1.x))  &&  
				((A1.y<B1.y && A2.y<B1.y) || (A1.y>B1.y && A2.y>B1.y))) &&
				(A1.z<B1.z && A2.z<B1.z) || (A1.z>B1.z && A2.z>B1.z))
//				||
//				(((B1.x<A1.x && B2.x<A1.x) && (B1.x>A1.x && B2.x>A1.x))  &&  
//				((B1.y<A1.y && B2.y<A1.y) && (B1.y>A1.y && B2.y>A1.y)) &&
//				!((B1.z<A1.z && B2.z<A1.z) && (B1.z>A1.z && B2.z>A1.z)))
				){
//			return true;
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
				}else{
					timer.schedule(new setVals(), 40);
				}
			}else{
				timer.schedule(new setGrounded(), 10);
				System.out.println("afe");
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
