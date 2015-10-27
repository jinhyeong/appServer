package com.xrkj.app.webapp.common;

import static com.xrkj.app.Constants.REQUEST_MAPPING_AUTHORIZATION;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(REQUEST_MAPPING_AUTHORIZATION)
public class AuthorizationController {
	
	@SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);
	

}
