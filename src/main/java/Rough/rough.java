package Rough;

public class rough {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str="testcase,,,,pass";
		
		System.out.println(str.length() - str.replace(",", "").length());
	}

}
