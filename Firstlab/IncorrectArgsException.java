package Firstlab;

class IncorrectArgsException extends Exception {
    private int number;
    public int getNumber() {
        return number;
    }
    public IncorrectArgsException(String message, int num) {
        super(message);
        number=num;
    }
}
