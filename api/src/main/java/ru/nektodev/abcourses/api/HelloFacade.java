package ru.nektodev.abcourses.api;

import com.googlecode.jsonrpc4j.JsonRpcService;

/**
 * @author Slava Tsykin ts.slawa@gmail.com
 */
@JsonRpcService("/hello")
public interface HelloFacade {
	String hello();
}
