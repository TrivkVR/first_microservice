package com.viki.serviceB.contoller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;


@RestController
public class ServiceBController {

	private final DiscoveryClient discoveryClient;
	private final RestClient restClient;
	
	public ServiceBController(DiscoveryClient discoveryClient, RestClient.Builder restClientBuilder) {
		// TODO Auto-generated constructor stub
		this.discoveryClient = discoveryClient;
		this.restClient = restClientBuilder.build();
	}
	
	@GetMapping("helloServer")
	public String helloFromServiceB() {
		ServiceInstance serviceInstance = discoveryClient.getInstances("serviceA").get(0);
		String serviceAResponse = restClient.get()
									.uri(serviceInstance.getUri() + "/helloWorld")
									.retrieve()
									.body(String.class);
		
		return serviceAResponse;
	}
}
