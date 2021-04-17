package unit_two;

import java.util.concurrent.TimeUnit;

public class SimpleRandomSentences {
	
	// Arrays with rules words to use to create sentences
	static final String[] conjunction = {"and", "or", "but", "because"};
	static final String[] proper_noun = {"Fred", "Jane", "Richard Nixon", "Miss America"};
	static final String[] common_noun = {"man", "woman", "fish", "elephant", "unicorn"};   
	static final String[] determiner = {"a", "the", "every", "some"};
	static final String[] adjective = {"big", "tiny", "pretty", "bald"};
	static final String[] intransitive_verb = {"runs", "jumps", "talks", "sleeps"};
	static final String[] transitive_verb = {"loves", "hates", "sees", "knows", "looks", "for", "finds"};

	public static void main(String[] args) throws InterruptedException {
		
		// Create sentences every 2 seconds using recursive function call
		while (true) {
			createSentence();
			System.out.println(".\n");
			TimeUnit.SECONDS.sleep(2);
		}
	}
	
	// Recursive method to create sentence that calls createNounPhrase and createVerbPhrase recursively
	static void createSentence() {
		createNounPhrase();
		createVerbPhrase();
		if (Math.random() > 0.70) {
			System.out.print(" " + randomItem(conjunction));
			createSentence();
		}
	}
	
	// Create noun_phrase rule
	static void createNounPhrase() {
		if (Math.random() > 0.70) {
			System.out.print(" " + randomItem(proper_noun));
		}
        else if (Math.random() > 0.70) {
        		System.out.print(" " + randomItem(determiner));
        		System.out.print(" " + randomItem(adjective)+".");
        		System.out.print(" " + randomItem(common_noun));
        		System.out.print(" who" );
        		createVerbPhrase();
        }
	}
	
	// Create verb_phrase rule and call createSentence recursively
	static void createVerbPhrase() {
		if (Math.random() > 0.70) {
			System.out.print(" " + randomItem(intransitive_verb));
		} else if (Math.random() > 0.70) {
			System.out.print(" " + randomItem(transitive_verb));
			createNounPhrase();
		} else if (Math.random() > 0.70) {
			System.out.print(" is " + randomItem(adjective));
		}
		else {
			System.out.print(" believes that");
			createSentence();
		}
	}
	
	// Pick random item from an array of string
	static String randomItem(String[] listOfStrings){
		return listOfStrings[(int)(Math.random() * listOfStrings.length)];
	}
}















