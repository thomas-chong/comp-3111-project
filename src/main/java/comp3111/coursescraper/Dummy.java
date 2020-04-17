
package comp3111.coursescraper;

public class Dummy {
	
	public static int[] countAB(String input) {
    	int a = 0, b = 0;
    	for (int i = 0; i < input.length(); ++i) {
    		if (input.charAt(i) == 'A') {
    			++a;
    		} else if (input.charAt(i) == 'B') {
    			++b;
    		}
    	}
    	return new int[] {a, b};
    }
	
}
