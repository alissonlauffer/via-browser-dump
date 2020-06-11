package mark.via.util;

final class QuitCockroachException extends RuntimeException {
    public QuitCockroachException(String str) {
        super(str);
    }
}
