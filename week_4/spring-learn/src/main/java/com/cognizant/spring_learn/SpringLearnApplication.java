package com.cognizant.spring_learn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void displayDate() throws ParseException{
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		LOGGER.info("START");
		SimpleDateFormat date = context.getBean("dateFormat", SimpleDateFormat.class);
		
		
		Date d = date.parse("31/12/2024");
		LOGGER.debug(d.toString());
		// System.out.println(d);	
		LOGGER.info("END");	
	}
	public static void displayCountry() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString());
    }

	public static void newdisplayCountry() {
		LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
		Country country2 = context.getBean("country", Country.class);
		// System.out.println(country==country2);
		LOGGER.info("END");
    }

	public static void displayCountries() {
		LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countryList = context.getBean("countryList", List.class);
        LOGGER.debug("Country List: {}", countryList);
		LOGGER.info("END");
    }
	public static void main(String[] args) throws ParseException{
		SpringApplication.run(SpringLearnApplication.class, args);
		
		displayDate();
		LOGGER.info("START");
		displayCountry();
		LOGGER.info("END");
		newdisplayCountry();

		displayCountries();
	}

}
