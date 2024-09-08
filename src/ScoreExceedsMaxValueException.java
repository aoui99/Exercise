public class ScoreExceedsMaxValueException extends Exception {
    private int score;

    public ScoreExceedsMaxValueException(int score) {
        this.score = score;
    }


}
