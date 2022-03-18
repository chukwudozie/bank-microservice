package com.emeka.loan.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


@Configuration
@ConfigurationProperties(prefix = "loan")
@Getter @Setter @ToString
public class LoanServiceConfig implements Serializable {
    private String msg;
    private String buildVersion;
    private Map<String,String > mailDetails;
    private List<String> activeBranches;
}
