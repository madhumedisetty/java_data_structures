import java.util.*;

public class ReversingAString {

    public void usingSplit(String str) {
        // Split the string into words
        String[] words = str.split(" ");
        
        // Create a stack to hold the words
        Stack<String> stack = new Stack<>();
        
        // Push all words onto the stack
        for (String word : words) {
            stack.push(word);
        }
        
        // Pop words from the stack to reverse the order
        StringBuilder reversedString = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
            // Append a space after each word except the last one
            if (!stack.isEmpty()) {
                reversedString.append(" ");
            }
        }
        
        // Print the reversed string
        System.out.println("Reversed sentence using split:");
        System.out.println(reversedString.toString());
    }

    public void withoutUsingSplit(String str) {
        // Create a stack to hold the words
        Stack<String> stack = new Stack<>();
        StringBuilder word = new StringBuilder();
        
        // Iterate through the string character by character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // If the character is a space, push the word to the stack
            if (ch == ' ') {
                if (word.length() > 0) {
                    stack.push(word.toString());
                    word.setLength(0); // Clear the StringBuilder for the next word
                }
            } else {
                word.append(ch); // Build the current word
            }
        }
        
        // Push the last word if there is one
        if (word.length() > 0) {
            stack.push(word.toString());
        }
        
        // Pop words from the stack to reverse the order
        StringBuilder reversedString = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
            // Append a space after each word except the last one
            if (!stack.isEmpty()) {
                reversedString.append(" ");
            }
        }
        
        // Print the reversed string
        System.out.println("Reversed sentence without using split:");
        System.out.println(reversedString.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String str = sc.nextLine();
        
        ReversingAString reverser = new ReversingAString();
        reverser.usingSplit(str);
        reverser.withoutUsingSplit(str);
        
        sc.close();
    }
}
