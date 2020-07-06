package org.soyphea;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.soyphea.exception.BookClientException;
import org.soyphea.exception.BookServerException;

@Slf4j
public class MyErrorDecoder implements ErrorDecoder {

    final ErrorDecoder defaultDecoder = new ErrorDecoder.Default();
    final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Exception decode(String s, Response response) {
        log.error("Status=>{}, reason=>{}",response.status(),response.reason());
        if (response.status() >= 400 && response.status() <= 499) {
            return new BookClientException(
                    response.status(),
                    response.body().toString()
            );
        }
        if (response.status() >= 500 && response.status() <= 599) {
            return new BookServerException(
                    response.status(),
                    response.reason()
            );
        }

        return new Exception("Genernal Error!");
    }
}
