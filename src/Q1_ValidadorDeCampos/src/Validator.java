public interface Validator {
    boolean validate(String value);
    String getType();
}