package com.mvc.login_project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.login_project.dao.impl.OwnerDaoImpl;
import com.mvc.login_project.dto.Owner;

@Controller
public class OwnerController {

	@Autowired
	OwnerDaoImpl ownerDaoImpl;
	
	@RequestMapping("createOwner")
	public ModelAndView createOwner() {
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("ownermodel",new Owner());
		mv.setViewName("createowner.jsp");
		return mv;
	}
	
	@RequestMapping("saveOwner")
	public ModelAndView saveOwner(@ModelAttribute Owner owner) {
		
		String message=ownerDaoImpl.saveOwner(owner);
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("result",message);
		mv.setViewName("ownermessage.jsp");
		return mv;
	}
	
	@RequestMapping("ownerLogin")
	public void ownerLogin(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		HttpSession httpSession=req.getSession();
		
		Owner owner=ownerDaoImpl.findByEmailAndPassword(email, password);
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		if(owner!=null) {
			httpSession.setAttribute("Id", owner.getId());
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("ownerhome.jsp");
			dispatcher.forward(req, resp);
		}else {
			out.println("<center><h1> INVALID CREDENTIALS </h1></center>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("ownerlogin.jsp");
			dispatcher.include(req, resp);
			
		}
		
	}
	
}
