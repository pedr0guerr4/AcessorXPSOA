package com.xpinc.assessor.clients;

import org.springframework.stereotype.Component;

@Component
public class QuotesClient {
	public String getSelic() {
		return "10.50";
	} // stub

	public String getIpca() {
		return "4.20";
	}

	public String getUsd() {
		return "5.35";
	}
}