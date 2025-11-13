/**
 * DESIGN PATTERN: Chain of Responsibility (Handler)
 */
public interface IValidator {
    void setNext(IValidator nextValidator);
    void validate(ValidationContext context);
}