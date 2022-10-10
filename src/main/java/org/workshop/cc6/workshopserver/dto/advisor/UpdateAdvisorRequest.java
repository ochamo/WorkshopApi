package org.workshop.cc6.workshopserver.dto.advisor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAdvisorRequest {
    private Integer advisorId;
    private Integer advisorLocation;
    private Integer userId;
    private String advisorName;
    private String advisorLastName;
    private String advisorDpi;
    private String advisorPhoneNumber;
    private String advisorAddress;
    private Date advisorHiringDate;
    private Byte deleted;
}

