package com.vivek.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Component
@Slf4j
public class RequestLogger extends CommonsRequestLoggingFilter {

	protected RequestLogger() {
		this.setIncludeClientInfo(true);
		this.setIncludeQueryString(true);
		this.setIncludePayload(true);
		this.setMaxPayloadLength(64000);
	}
}
