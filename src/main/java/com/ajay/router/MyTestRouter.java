package com.ajay.router;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
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

		// For Apache Camel Processor
//		from("{{my.loc.source}}").process(new Processor() {
//			@Override
//			public void process(Exchange exchange) throws Exception {
//				// 1. By using Exchange input Data
//				Message inMsg = exchange.getIn();
//				// 2. Read body(data) from Message obj
//				String body = inMsg.getBody(String.class);
//				// 3. conversion/logics (Processing code)
//				body = "Newly Modified Data " + body;
//				// 4. using Exchange obj set Message to Output
//				// Message outMsg = exchange.getOut();
//				Message outMsg = exchange.getMessage();
//				// 5. Set body to Out Message.
//				outMsg.setBody(body);
//			}
//		}).to("{{my.loc.dest}}");

		/* Lambda Expression    ---  Processor(I) is Functional Interface which is having only one abstract method.*/
		from("{{my.loc.source}}")
		.process(
				exchange -> {
			// 1. By using Exchange input Data
			Message inMsg = exchange.getIn();
			// 2. Read body(data) from Message obj
			String body = inMsg.getBody(String.class);
			// 3. conversion/logics (Processing code)
			body = "Newly Modified Data " + body;
			// 4. using Exchange obj set Message to Output
			// Message outMsg = exchange.getOut();
			Message outMsg = exchange.getMessage();
			// 5. Set body to Out Message.
			outMsg.setBody(body);
			}
		)
		.to("{{my.loc.dest}}");

	}
}
