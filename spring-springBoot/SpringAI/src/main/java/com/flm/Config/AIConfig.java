package com.flm.Config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Configuration;

import com.openai.models.ChatModel;

@Configuration
public class AIConfig {

	
	ChatClient chatClient(org.springframework.ai.chat.model.ChatModel model) {
		return ChatClient.create(model);
	}
}
