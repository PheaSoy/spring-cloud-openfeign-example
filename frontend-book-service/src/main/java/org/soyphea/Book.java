package org.soyphea;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class Book {

    String id;

    @NonNull
    String title;
    Date publishDate;
}
