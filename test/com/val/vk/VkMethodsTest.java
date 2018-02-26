package com.val.vk;

import com.val.vk.exceptions.SendMessageErrorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class VkMethodsTest {

    private VkMethods methods;
    private int id = 204437607;

    @BeforeEach
    void setUp() {
        methods = new VkMethods(
                "fab62099e0c37da9e4d265129ef7d98735ee8982e96ad4b2c30447c148d36d888fc248b4979df4735b724",
                "204437607");
    }

    //getUsers(int[] uIds)
    @Test
    void getUsersWithValidIdReturnsUserList() {
        int actual = methods.getUsers(new int[]{204437607}).response[0].id;
        int expected = 204437607;

        assertEquals(expected, actual);
    }

    @Test
    void getUsersWithInvalidIdReturnsEmptyUserListWithEmptyResponse(){
        assertEquals(0, methods.getUsers(new int[]{0}).response.length);
    }
    //END_OF getUsers(int[] uIds)

    //getMessageHistory(int offset, int count, int uId)
    @Test
    void getMessageHistory_AllOkThenReturnsValidMessageList() throws IOException{
        MessageList actual = methods.getMessageHistory(0, 3,id);
        assertEquals(3, actual.items.length);
    }

    @Test
    void getMessageHistory_WrongUIdParamThenReturnsEmptyMessageList() throws IOException{
        MessageList actual = methods.getMessageHistory(0, 1, 0);
        assertEquals(0, actual.items.length);
    }

    @Test
    void geMessageHistory_ToBigCountParamThenFixItToMaxAllowedAndReturnsValidMessageList() throws IOException{
        MessageList actual = methods.getMessageHistory(0, 201,id);
        assertTrue(actual.items.length > 0);
    }
    //END_OF getMessageHistory(int offset, int count, int uId)

    //getDialogs(int count)
    @Test
    void getDialogs_CountIsToBigOrToSmallThenFixItToMaxOrMinAllowedAndReturnsDialogArray(){
        Dialog[] dialogs = methods.getDialogs(-1);
        assertEquals(1, dialogs.length);

        dialogs = methods.getDialogs(201);
        int length = dialogs.length;
        assertTrue(length > 0 && length < 201);
    }

    @Test
    void getDialogs_OkThenReturnsDialogsArray(){
        Dialog[] d = methods.getDialogs(5);
        assertEquals(5, d.length);
    }
    //END_OF getDialogs(int count)

    //sendMessage(int toId, String message)
    @Test
    void sendMessage_NonexistentToIdThenThrowsSendMessageErrorException(){
        assertThrows(SendMessageErrorException.class,
                ()->{methods.sendMessage(0, "test");});
    }

    @Test
    void sendMessage_OkThenMessageWellDelivered()
            throws SendMessageErrorException, IOException, InterruptedException {
        String expected = "abcdefg";
        Thread.sleep(3000); //vk API timeout
        methods.sendMessage(id, expected);
        String actual = methods.getMessageHistory(0, 1, id).items[0].body;

        assertEquals(expected, actual);
    }
    //END_OF sendMessage(int toId, String message)
}