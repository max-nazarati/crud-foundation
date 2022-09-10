package maxnazarati.web.pattern.crud.foundation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class CrudServiceTest<ID, M extends Model<ID>, Q extends Query<ID>> {
    protected final CrudService<ID, M, Q> underTest;

    protected CrudServiceTest(CrudService<ID, M, Q> underTest) {
        this.underTest = underTest;
    }

    @Test
    void create() {
        // GIVEN
        var model = getModel();

        // WHEN
        var result = underTest.create(model);

        // THEN
        assertThat(result).usingRecursiveComparison().isEqualTo(getExpectedModel());

    }

    @Test
    void get() {
        // GIVEN
        var savedModel = underTest.create(getModel());

        // WHEN
        var retrievedModel = underTest.get(savedModel.getId());

        // THEN
        assertThat(retrievedModel).isEqualTo(savedModel);
    }

    protected abstract M getModel();

    protected abstract M getExpectedModel();

}