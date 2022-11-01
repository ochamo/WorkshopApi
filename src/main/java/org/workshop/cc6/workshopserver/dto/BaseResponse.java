package org.workshop.cc6.workshopserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private String code;
    private String message;
    public BaseResponse(String code) {
        this(code, "");
    }

    public BaseResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse() {
        this.code = "";
        this.message = "";
    }


}
