package aero.nettracer.kitems;

import aero.nettracer.kitems.delegate.KItemsApplicationDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@ComponentScan(basePackages = {"aero.nettracer.kitems"})
@SpringBootApplication
public class KitemsApplication {
	@Autowired
	KItemsApplicationDelegate kItemsApplicationDelegate;
	private static KItemsApplicationDelegate delegate;

	@PostConstruct
	private void initStaticDelegate () {
		delegate = this.kItemsApplicationDelegate;
	}

	public static void main(String[] args) {
		SpringApplication.run(KitemsApplication.class, args);

		if (args.length > 0) {
			delegate.processCommandLineArgs(args);
		} else {
			delegate.processApplicationProperties();
		}
	}
}