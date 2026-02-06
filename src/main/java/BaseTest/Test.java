package BaseTest;

public class Test {
	public static void main(String[] args) {
		
	
	String s = "my name is satya priya";
    String[] words = s.split(" ");
    String result = "";

    for (String word : words) {
        result += Character.toUpperCase(word.charAt(0))
                + word.substring(1) + " ";
    }

    System.out.println(result.trim());
}
}



