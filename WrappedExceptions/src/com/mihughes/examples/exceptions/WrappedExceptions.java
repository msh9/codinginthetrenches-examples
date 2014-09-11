package com.mihughes.examples.exceptions;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import com.mihughes.examples.exceptions.hierarchy.TopLevelException;

public class WrappedExceptions {
	
	private static final int ITERATIONS = 10000000;
	private static final String GOOGLE_SEARCH = "https://www.google.com/#q=hello+world";
	private static final int WEB_ITERATIONS = 12;
	private static final int WAIT_TIME = 5000;
	
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		SomeLowLevelClass llc = new SomeLowLevelClass();
		SomeMidLevelClass mlc = new SomeMidLevelClass(llc);
		TopLevelClass tlc = new TopLevelClass(mlc);
		
		long start = System.nanoTime();
		for (int i = 0; i < ITERATIONS; i++) {
			try {
				tlc.getSomeInterestingView(true, true, true);
			} catch (TopLevelException ex) {
				//failure
				//System.out.println(ex.toString());
			}
		}
		long end = System.nanoTime();
		
		System.out.printf("Nanoseconds per iterations for all thrown was %d\n", (end - start)/ITERATIONS);
		

		start = System.nanoTime();
		for (int i = 0; i < ITERATIONS; i++) {
			try {
				tlc.getSomeInterestingView(true, false, false);
			} catch (TopLevelException ex) {
				//failure
				//System.out.println(ex.toString());
			}
		}
		end = System.nanoTime();
		
		System.out.printf("Nanoseconds per iterations for just bottom thrown was %d\n", (end - start)/ITERATIONS);
		
		start = System.nanoTime();
		for (int i = 0; i < ITERATIONS; i++) {
			try {
				tlc.getSomeInterestingView(false, false, false);
			} catch (TopLevelException ex) {
				//failure
				//System.out.println(ex.toString());
			}
		}
		end = System.nanoTime();
		
		System.out.printf("Nanoseconds per iterations for nothing thrown was %d\n", (end - start)/ITERATIONS);
		
		URL google = new URI(GOOGLE_SEARCH).toURL();
		Object result = null;
		String contentType = "";
		start = System.nanoTime();
		for (int i = 0; i < WEB_ITERATIONS; i++) {
			URLConnection request = google.openConnection();
			try {
				request.connect();
				contentType = request.getContentType();
				result = request.getContent();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread.sleep(WAIT_TIME);
		}
		end = System.nanoTime();
		if (result != null) {
			System.out.printf("Content type Result from Google: %s\n", contentType);
		}
		
		System.out.printf("Nanoseconds per iterations for network connection was %d\n", (end - start - WEB_ITERATIONS * WAIT_TIME)/WEB_ITERATIONS);
	}

}
