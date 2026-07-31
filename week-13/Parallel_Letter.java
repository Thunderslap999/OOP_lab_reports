import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;


class ParallelLetterFrequency {
    private final String[] texts;

    ParallelLetterFrequency(String[] texts) {
        this.texts = texts;
    }

    Map<Character, Integer> letterFrequencies() {
        return Arrays.stream(texts)
                .parallel()
                .flatMapToInt(CharSequence::chars)
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toConcurrentMap(
                        c -> c,
                        c -> 1,
                        Integer::sum
                ));
    }
}


public class Parallel_Letter {
    public static void main(String[] args) {
        String[] texts = {
            "Hello World!",
            "This is a concurrent test.",
            "Multithreading in Java is fun."
        };
        
        ParallelLetterFrequency counter = new ParallelLetterFrequency(texts);
        Map<Character, Integer> freq = counter.letterFrequencies();
        
        System.out.println("--- Parallel Letter Frequencies ---");
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}