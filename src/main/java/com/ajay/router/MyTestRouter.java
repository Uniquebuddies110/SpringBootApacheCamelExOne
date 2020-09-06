package com.ajay.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyTestRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		System.out.println("MyTestRouter.configure()-- started");

		/*
		 * // 1st EIP Pattern ( from("file:sourceLoc").to("file:destLoc"); )
		 * from("file:C:\\Users\\ajay\\Desktop\\Imp Java Practice In Lockdown\\JAVA NOTES\\Spring Boot Notes\\SourceLoc"
		 * )
		 * .to("file:C:\\Users\\ajay\\Desktop\\Imp Java Practice In Lockdown\\JAVA NOTES\\Spring Boot Notes\\DestinationLoc"
		 * );
		 */

		/*
		 * // 2nd EIP Pattern ( from("file:sourceLoc?noop=true").to("file:destLoc"); )
		 * from("file:C:\\Users\\ajay\\Desktop\\Imp Java Practice In Lockdown\\JAVA NOTES\\Spring Boot Notes\\SourceLoc?noop=true"
		 * )
		 * .to("file:C:\\Users\\ajay\\Desktop\\Imp Java Practice In Lockdown\\JAVA NOTES\\Spring Boot Notes\\DestinationLoc"
		 * );
		 */

		/*
		 * // 3rd EIP Pattern ( from("{{srclocation}}").to("{{destlocation}}"); )
		 * from("{{my.loc.source}}") .to("{{my.loc.dest}}");
		 */

		System.out.println("MyTestRouter.configure()-- ends");
	}
}
