package io.micronaut.data.jdbc.oraclexe.etag;

import io.micronaut.data.annotation.*;
import io.micronaut.data.annotation.sql.GeneratedEtag;
import io.micronaut.data.annotation.sql.ETagValue;
import io.micronaut.data.annotation.sql.Etaggable;

@Etaggable
@MappedEntity("etag_book")
public record ETagBook(
    @Id
    @GeneratedValue
    @ETagValue
    Long id,
    @ETagValue
    String title,

    @Relation(Relation.Kind.EMBEDDED)
    BookDetails bookDetails,

    @GeneratedEtag
    String etag) {

    @Embeddable
    public record BookDetails(
        @ETagValue
        int pages,
        int chapters
    ) {
    }
}
