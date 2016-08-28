import java.util.ArrayList;

public class RectPrism {
	RectPrism(Vec3 center, float x, float y, float z){
			ArrayList<Vec3> vecs = new ArrayList<Vec3>();
			float X = x/2;
			float Y = y/2;
			float Z = z/2;
			for(int i=-1; i<=1; i+=2){
				for(int j=-1; j<=1; j+=2){
					for(int k=-1; k<=1; k+=2){
						vecs.add(new Vec3(center.x+X*i, center.y+Y*j, center.z+Z*k));
					}
				}
			}
		}
}
