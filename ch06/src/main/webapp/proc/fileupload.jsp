<%@page import="org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletDiskFileUpload"%>
<%@page import="org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 수신 데이터 처리
	
	/*
		- 일반 Form이 아닌 파일 전송폼(multipart/form-date)으로 전송되는 데이터는 request
		  객체 수신 안됨
		- 파일 전송폼으로 전송되는 데이터 수신(파일포함)은 라이브러리(commons-fileupload)로 수신
	*/
	
	String title = request.getParameter("title");
	String name = request.getParameter("name");

	System.out.println("title : " + title + ", name : " + name);
	
	// 파일업로드 디렉터리 경로 생성
	String path = application.getRealPath("/files");
	
	// 파일 업로드 처리 객체 생성
	//DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
	//JakartaServletFileUpload<?,?> upload = new ..
%>