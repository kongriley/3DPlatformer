import java.util.ArrayList;

public class Object3d {
	ArrayList<Vec3> vecs = new ArrayList<Vec3>();
	public Vec3 velocity = Vec3.ZERO;
	Object3d(){
	}
	
	Object3d(ArrayList vecs){
		this.vecs = vecs;
	}
	
	public void update(){
		translate(velocity);
	}
	
	public void addVelocity(Vec3 vec){
		velocity.translate(vec);
	}
	
	public void dilate(Vec3 vec, float scale) {
		for (int i = 0; i < vecs.size(); i++) {
			((Vec3) vecs.get(i)).dilate(vec, scale);
		}
	}
	public void translate(Vec3 vec) {
		for (int i = 0; i < vecs.size(); i++) {
			((Vec3) vecs.get(i)).translate(vec);
		}
	}
	public void rotate(String axis, Vec3 point, float deg) {
		for (int i = 0; i < vecs.size(); i++) {
			((Vec3) vecs.get(i)).rotate(axis, point, deg);
		}
	}
	public Vec3 get(int i){
		return (Vec3) vecs.get(i);
	}
	public int size(){
		return vecs.size();
	}
	
	public static void dilateArray(ArrayList<Object3d> objs, Vec3 vec, float scale) {
		for (int i = 0; i < objs.size(); i++) {
			((Object3d) objs.get(i)).dilate(vec, scale);
		}
	}
	
	public static void translateArray(ArrayList<Object3d> objs, Vec3 vec) {
		for (int i = 0; i < objs.size(); i++) {
			((Object3d) objs.get(i)).translate(vec);
		}
	}
	
	public static void rotateArray(ArrayList<Object3d> objs, String axis, Vec3 point, float deg) {
		for (int i = 0; i < objs.size(); i++) {
			((Object3d) objs.get(i)).rotate(axis, point, deg);
		}
	}
	
	public static void updateArray(ArrayList<Object3d> objs){
		for (int i = 0; i < objs.size(); i++) {
			((Object3d) objs.get(i)).update();
		}
	}
	
	public static void addVelocityArray(ArrayList<Object3d> objs, Vec3 vec){
		for (int i = 0; i < objs.size(); i++) {
			((Object3d) objs.get(i)).addVelocity(vec);
		}
	}
}
