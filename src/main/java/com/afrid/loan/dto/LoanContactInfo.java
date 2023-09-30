package com.afrid.loan.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "loan")
public record LoanContactInfo(String name, List<String> contact) {
}
