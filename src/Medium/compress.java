package Medium;
//Problem-443
public class compress {
    public int compress(char[] chars) {
        if (chars.length == 0) return 0; // Edge case

        int index = 0; // Pointer to overwrite chars
        int i = 0; // Pointer to traverse chars

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count occurrences of currentChar
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // Store character
            chars[index++] = currentChar;

            // Store count if greater than 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}
