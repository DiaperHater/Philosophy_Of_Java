package com.val.vk;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import com.val.vk.exceptions.ProtocolIsNotHTTPSException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GetTest {

    //get(String address)
    @Test
    void ifBadAddressThenThrowsEception(){
        assertThrows(MalformedURLException.class, ()->{Get.get("baduri");});
        assertThrows(MalformedURLException.class, ()->{Get.get("google.com");});
        assertThrows(MalformedURLException.class, ()->{Get.get("bad://google.com");});
    }

    @Test
    void protocolIsNotHTTPSThenException(){
        assertThrows(ProtocolIsNotHTTPSException.class,
                ()->{Get.get("http://google.com");});
    }

    @Test
    void ifConnectionFailedThenThrowsException(){
        assertThrows(UnknownHostException.class, ()->{Get.get("https://unexistentpage-blah.com");});
    }

    @Test
    void allOkThenReturnPage() throws IOException {
        String actual = Get.get("https://google.com");
        assertTrue( !actual.isEmpty() );
    }
    //END of get(String address)

}