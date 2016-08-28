import java.util.ArrayList;

public class BoxCollider {
	Vec3 vec1;
	Vec3 vec2;

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
		if (!(B1.x > A1.x+A2.x || B1.x+B2.x < A1.x ||
		        B1.y < A1.y+A2.y || B1.y+B2.y > A1.y ||
		        B1.z > A1.z+A2.z || B1.z+B2.z < A1.z)){
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
				Object3d.setVelocityArray(objs, Vec3.ZERO);
			}
		}
	}
}
