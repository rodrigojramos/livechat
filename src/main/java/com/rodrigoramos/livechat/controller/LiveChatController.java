package com.rodrigoramos.livechat.controller;

import com.rodrigoramos.livechat.domain.ChatInput;
import com.rodrigoramos.livechat.domain.ChatOutput;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LiveChatController {

    @MessageMapping("/new-message")
    @SendTo("/topics/livechat")
    public ChatOutput newMessage(ChatInput input) {
        return new ChatOutput(HtmlUtils.htmlEscape(input.user() + ": " + input.message()));
    }
}
