package com.flm.Controller;

import org.jspecify.annotations.Nullable;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIController {
	
	@Autowired
	ChatClient chatClient;
	
	@Autowired
	ImageModel imageModel;
	
	@Autowired
	ImageResponse imageResponse;
	
	
	
	@GetMapping("/ai")
	public String askAI(@RequestParam(name="prompt") String prompt) {
		
		@Nullable
		String content = chatClient.prompt()
		.user(prompt)
		.call()
		.content();
		
		
		return content;
	}
	
	
	
	
	// this below code is outdated
//	public String generateImage(@RequestParam(name = "prompt") String prompt) {
//		
//		ImageResponse imgResponse = imageModel.call(new ImagePrompt(prompt));
//		return imgResponse
//				.getResult()
//				.getOutput()
//				.getUrl();
//		
//	
//	}
	
	
	
	@GetMapping("/image")
	public String generateImage(@RequestParam String prompt, Model model) {

	    OpenAiImageOptions openAiImageOptions = OpenAiImageOptions.builder()
	            .width(1024)
	            .height(1024)
	            .n(1)              // how many images that model wants to generate 
	            .model("gpt-image-1.5")
	            .quality("high")
	            .build();

	    ImageResponse imageResponse = imageModel.call(
	            new ImagePrompt(prompt, openAiImageOptions)
	    );

	    @Nullable
	    String imageBase64 = imageResponse.getResult()
	            .getOutput()
	            .getB64Json();

	    String imageUrl = "data:image/png;base64," + imageBase64;

	    model.addAttribute("imageUrl", imageUrl);

	    return "image";
	}

}
