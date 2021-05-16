public class ScoreboardField {
    private int value;
    private boolean alreadyUsed;

    public ScoreboardField() {
        value = 0;
        alreadyUsed = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isAlreadyUsed() {
        return alreadyUsed;
    }

    public void setAlreadyUsed(boolean alreadyUsed) {
        this.alreadyUsed = alreadyUsed;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
