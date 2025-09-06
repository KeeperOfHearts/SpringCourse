package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		return runner -> {
//			demoBeforeAdvice(theAccountDAO, theMembershipDAO);

//			demoTheAfterReturningAdvice(theAccountDAO);
			
			demoTheAfterThrowingAdvice(theAccountDAO);
		};
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		List<Account> accounts = null;
		try {
			boolean tripWire = true;

			accounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n=====> We caught the exception: " + e);
		}

		System.out.println("\nMain Program: AfterThrowingAdvice");

		System.out.println("\n=====>After found Accounts: " + accounts);
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		System.out.println("\nMain Program: AfterReturningDemoApp");
		System.out.println("=====> Calling findAccounts()");

		var accounts = theAccountDAO.findAccounts();

		System.out.println("\n=====>After found Accounts: " + accounts);
	}

	private void demoBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		theAccountDAO.addAccount(new Account("Kritik", "ultra"), true);

		theAccountDAO.doWork();

		theAccountDAO.setName("foorbar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		theMembershipDAO.addSillyMember();

	}



}
