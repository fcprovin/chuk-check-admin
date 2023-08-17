package com.fcprovin.admin.web.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fcprovin.admin.api.vo.error.ApiError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class WebExceptionHandler {

    private final ObjectMapper mapper;

    @ExceptionHandler(WebClientResponseException.class)
    public ModelAndView apiException(WebClientResponseException e, HttpServletRequest request) throws JsonProcessingException {
        log.error("apiException {} / {} / {}", e.getStatusText(), e.getMessage(), e.getResponseBodyAsString());
        ApiError apiError = mapper.readValue(e.getResponseBodyAsString(), ApiError.class);

        return new ModelAndView("error/api")
                .addObject("error", apiError)
                .addObject("redirect", request.getRequestURI());
    }
}
