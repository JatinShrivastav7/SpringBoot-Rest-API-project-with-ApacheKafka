package com.example.kafkaDemo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaDemo.constant.ApplicationConstant;
import com.example.kafkaDemo.dto.Employee;


@RestController
@RequestMapping("/produce")
public class KafkaProducer  {


	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@PostMapping("/message")
	public String sendMessage(@RequestBody Employee details) {

		try {

			kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, details);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "json message sent successfully";
	}

}