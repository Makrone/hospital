package by.hospital.constants;

public class Test {

	public static void main(String[] args) {
		String s = PropertyManager.getInstance().getProperty("test");
		System.out.println(s);

	}

}
