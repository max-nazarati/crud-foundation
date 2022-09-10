package maxnazarati.web.pattern.crud.example;

import maxnazarati.web.pattern.crud.foundation.Query;

import java.util.List;

public record UserQuery(List<Integer> ids) implements Query<Integer> {

}
