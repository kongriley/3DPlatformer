import java.util.ArrayList;

public class Object3d {
	ArrayList<Vec3> vecs = new ArrayList<Vec3>();
	
	Object3d(ArrayList<Vec3> vecs){
		this.vecs = vecs;
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
	
	public static void dilateArray(ArrayList<?> objs, Vec3 vec, float scale) {
		for (int i = 0; i < objs.size(); i++) {
			((Object3d) objs.get(i)).dilate(vec, scale);
		}
	}
	
	public static void translateArray(ArrayList<?> objs, Vec3 vec) {
		for (int i = 0; i < objs.size(); i++) {
			((Object3d) objs.get(i)).translate(vec);
		}
	}
	
	public static void rotateArray(ArrayList<?> objs, String axis, Vec3 point, float deg) {
		for (int i = 0; i < objs.size(); i++) {
			((Object3d) objs.get(i)).rotate(axis, point, deg);
		}
	}
}
