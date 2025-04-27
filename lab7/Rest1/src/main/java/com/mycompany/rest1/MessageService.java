/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rest1;

/**
 *
 * @author michal
 */
import java.util.ArrayList;
import java.util.List;

public class MessageService {

    public List<Message> getAllMessages() {
        List<Message> list = new ArrayList<>();
        list.add(new Message(1L, "Pierwsza wiadomość"));
        list.add(new Message(2L, "Druga wiadomość"));
        list.add(new Message(3L, "Trzecia wiadomość"));
        return list;
    }
}
