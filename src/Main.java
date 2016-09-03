import java.io.*;

public class Main {
	static Draw d;
	public static void main(String[] args) {
		d = new Draw();
	}
	static void save(){
		try{
			FileOutputStream fs = new FileOutputStream("game.txt");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(d);
			d.objects.get(0).get(0).print();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	static void load(){
		try{
			d.frame.setVisible(false);
			d.frame.dispose();
			d.objects.get(0).get(0).print();
			FileInputStream fs = new FileInputStream("game.txt");
			ObjectInputStream os = new ObjectInputStream(fs);
			Draw draw = (Draw)os.readObject();
			d = draw;
			d.load();
			os.close();
			draw.objects.get(0).get(0).print();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
//"X: 325.0 Y: -6289.2095 Z: 2981.6646";
