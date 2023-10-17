public class Strings {

    public static void main(String[] args) {
        String inputText = "В предложении это это слово в. А в следующем следующем предложении - другое слово слово.";
        String editedText = removeDuplicateWords(inputText);
        System.out.println(editedText);
    }

    public static String removeDuplicateWords(String text) {
        StringBuilder result = new StringBuilder();
        String[] sentences = text.split("[.!?]");

        for (String sentence : sentences) {
            String[] words = sentence.split("\\s+");
            StringBuilder sentenceBuilder = new StringBuilder();

            for (String word : words) {
                if (!sentenceBuilder.toString().contains(word)) {
                    sentenceBuilder.append(word).append(" ");
                }
            }

            if (!sentenceBuilder.isEmpty()) {
                sentenceBuilder.deleteCharAt(sentenceBuilder.length() - 1);
                sentenceBuilder.append(". ");
                result.append(sentenceBuilder);
            }
        }

        return result.toString().trim();
    }

}
