package org.soyphea;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class Book implements Serializable {

    String id;
    @NonNull
    String title;
    Date publishDate;
}
