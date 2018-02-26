package com.val.vk.exceptions;

import java.io.IOException;

public class ProtocolIsNotHTTPSException extends IOException{
    public ProtocolIsNotHTTPSException(String s){
        super(s);
    }
}
