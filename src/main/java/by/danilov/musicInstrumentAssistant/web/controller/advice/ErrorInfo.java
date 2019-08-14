package by.danilov.musicInstrumentAssistant.web.controller.advice;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
class ErrorInfo {

    private String message;

    private Integer code;

    private String url;

}
