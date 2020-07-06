package org.soyphea;

import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.soyphea.exception.BookClientException;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class MyErrorDecoder implements ErrorDecoder {

//    final Decoder decoder;
//    final ErrorDecoder defaultDecoder = new ErrorDecoder.Default();
//
//    public MyErrorDecoder(Decoder decoder) {
//        this.decoder = decoder;
//    }

    @Override
    public Exception decode(String s, Response response) {
        log.error("s=>{},response=>{}",s,response);
        try {
           return new BookClientException();
        }catch (Exception exception){
            return exception;
        }

    }
}
