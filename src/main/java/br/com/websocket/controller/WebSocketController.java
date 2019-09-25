package br.com.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.websocket.model.Notifications;

@RestController
@CrossOrigin
@RequestMapping(value = "/webscoket")
public class WebSocketController {

	@Autowired
	private SimpMessagingTemplate template;

	private Notifications notifications = new Notifications(0);

	@GetMapping("/notify")
	public String getNotification() {
		notifications.increment();
		template.convertAndSend("/topic/notification", notifications);
		return "Notifications successfully sent to Angular !";
	}

	@GetMapping("/notify2")
	public String getNotificationOther() {
		notifications.increment();
		template.convertAndSend("/topic/teste2", notifications);
		return "Notifications successfully sent to Angular !";
	}

}
