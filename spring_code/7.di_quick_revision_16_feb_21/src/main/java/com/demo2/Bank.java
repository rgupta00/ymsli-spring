package com.demo2;

import java.util.*;

public class Bank {
	private String bankName;
	private List<String> branchNames;// KN, LN, PV
	private List<Account> accounts;

	// prop
	private Map<String, String> branchAndRank;

	// map : key -value
	private Map<String, Account> richDetails;

	public Map<String, Account> getRichDetails() {
		return richDetails;
	}

	public void setRichDetails(Map<String, Account> richDetails) {
		this.richDetails = richDetails;
	}

	public Map<String, String> getBranchAndRank() {
		return branchAndRank;
	}

	public void setBranchAndRank(Map<String, String> branchAndRank) {
		this.branchAndRank = branchAndRank;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public List<String> getBranchNames() {
		return branchNames;
	}

	public void setBranchNames(List<String> branchNames) {
		this.branchNames = branchNames;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void printBankDetails() {
		System.out.println("bankname: " + bankName);
		System.out.println("-----branches loc------------");
		branchNames.stream().forEach(bn -> System.out.println(bn));

		System.out.println("-----all customers------------");
		accounts.stream().forEach(acc -> System.out.println(acc));

		System.out.println("-----all branches with rank--------");
		branchAndRank.forEach((bn, rank) -> System.out.println(bn + " : " + rank));

		System.out.println("-------branch and richDetails---------");
		
		richDetails.forEach((bn, account)->System.out.println(bn+" : "+ account));
	}

}
