package org.soyphea.book;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Book {

    String id;

    @NonNull
    String title;
    Date publishDate;
}
