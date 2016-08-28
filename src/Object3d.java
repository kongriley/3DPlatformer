import java.util.ArrayList;

public class Object3d {
	ArrayList vecs = new ArrayList<Vec3>();
	
	public void dilateArray(Vec3 vec, float scale) {
		for (int i = 0; i < vecs.size(); i++) {
			((Vec3) vecs.get(i)).dilate(vec, scale);
		}
	}
	public void translateArray(Vec3 vec) {
		for (int i = 0; i < vecs.size(); i++) {
			((Vec3) vecs.get(i)).translate(vec);
		}
	}
	public void rotateArray(String axis, Vec3 point, float deg) {
		for (int i = 0; i < vecs.size(); i++) {
			((Vec3) vecs.get(i)).rotate(axis, point, deg);
		}
	}
}
