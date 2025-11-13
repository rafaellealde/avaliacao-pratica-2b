/**
 * DESIGN PATTERN: Command (extensão do Handler)
 * REQUISITO: "capacidade de rollback"
 * Define um contrato para validadores que fazem alterações
 * e podem precisar revertê-las.
 */
public interface IReversibleValidator extends IValidator {
    void rollback(ValidationContext context);
}