package com.walt.Text4ShellExample.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.text.StringSubstitutor;
import org.apache.commons.text.lookup.DefaultStringLookup;
import org.apache.commons.text.lookup.StringLookup;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("text4shell")
public class Text4ShellController {
	
	@RequestMapping(value = "/example1", method = RequestMethod.GET)
	@ResponseBody
	public String example1(@RequestParam(defaultValue="Please pass in a search parameter") String search) {
		StringSubstitutor interpolator = StringSubstitutor.createInterpolator();
		// String pocstring = "${script:javascript:java.lang.Runtime.getRuntime().exec('touch /tmp/foo')}";
    String result = ""; 
    try{
			result = interpolator.replace(search);
		} catch(Exception e) {
      System.out.println("====================");
      System.out.println("Error Processing replace : ");
			System.out.println(e);
      System.out.println("====================");
		}
		return "You passed in : " + search+" </br> the result was : "+result;
	}

	@RequestMapping(value = "/example2", method = RequestMethod.GET)
	@ResponseBody
	public String example2(@RequestParam(defaultValue="Please pass in a search parameter") String search) {
		StringSubstitutor interpolator = StringSubstitutor.createInterpolator();
    interpolator.setEnableSubstitutionInVariables(true);
		// String pocstring = "${script:javascript:java.lang.Runtime.getRuntime().exec('touch /tmp/foo')}";
    String result = ""; 
    try{
			result = interpolator.replace(search);
		} catch(Exception e) {
      System.out.println("====================");
      System.out.println("Error Processing replace : ");
			System.out.println(e);
      System.out.println("====================");
		}
		return "You passed in : " + search+" </br> the result was : "+result;
	}
	
  @RequestMapping(value = "/example3", method = RequestMethod.GET)
	@ResponseBody
	public String example3(@RequestParam(defaultValue="Please pass in a search parameter") String search) {
    Map<String, StringLookup> myMap = new HashMap<>();
    myMap.put(DefaultStringLookup.DATE.getKey(), DefaultStringLookup.DATE.getStringLookup());
    myMap.put(DefaultStringLookup.BASE64_DECODER.getKey(), DefaultStringLookup.BASE64_DECODER.getStringLookup());
    myMap.put(DefaultStringLookup.BASE64_ENCODER.getKey(), DefaultStringLookup.BASE64_ENCODER.getStringLookup());

		StringSubstitutor interpolator = new StringSubstitutor(myMap);
		// String pocstring = "${script:javascript:java.lang.Runtime.getRuntime().exec('touch /tmp/foo')}";
    String result = ""; 
    try{
			result = interpolator.replace(search);
		} catch(Exception e) {
      System.out.println("====================");
      System.out.println("Error Processing replace : ");
			System.out.println(e);
      System.out.println("====================");
		}
		return "You passed in : " + search+" </br> the result was : "+result;
	}
}
