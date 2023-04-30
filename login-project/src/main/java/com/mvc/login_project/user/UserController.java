package com.mvc.login_project.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	UserDaoImpl dao;
	
	@RequestMapping("createUser")
	public ModelAndView createUser() {
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("userModel",new UserModel());
		mv.setViewName("createuser.jsp");
		
		return mv;
	}
	
	@RequestMapping("saveUser")
	public ModelAndView saveUser(@ModelAttribute UserModel userModel) {
		
		String result=dao.saveUser(userModel);
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("message",result);
		mv.setViewName("message.jsp");
		return mv;
	}
	
	@RequestMapping("users")
	public ModelAndView getAllUsers() {
		
		ArrayList<UserModel> users=dao.getAllUsers();
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("allusers",users);
		mv.setViewName("displayusers.jsp");
		return mv;
	}
	
	@RequestMapping("delete")
	public ModelAndView deleteUser(@RequestParam String emailId) {
		
		String result=dao.delete(emailId);
		
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("message",result);
		mv.setViewName("message.jsp");
		return mv;
	}
	
	@RequestMapping("edit")
	public ModelAndView editUser(@RequestParam String emailId) {
		
		UserModel existingUser=dao.getUser(emailId);
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("userModel",existingUser);
		mv.setViewName("edit.jsp");
		return mv;
	}
	
	@RequestMapping("updateUser")
	public ModelAndView updateUser(@ModelAttribute UserModel userModel) {
		
		String result=dao.updateUser(userModel);
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("message",result);
		mv.setViewName("message.jsp");
		return mv;
	}
	
	@RequestMapping("login")
	public void login(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		
		HttpSession session=req.getSession();
		session.setAttribute("email", email);
		session.setAttribute("password", pass);
		
		PrintWriter out=resp.getWriter();
		//setting content type
		resp.setContentType("text/html");
		
		boolean condition=dao.findByEmailAndPassword(email, pass);
		
		if(condition) {
			
			out.println("<center><h1> Welcome to HOME PAGE </h1></center>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("userhome.jsp");
			dispatcher.include(req, resp);
			
		}else {
			out.println("<center><h1> INVALID CREDENTIALS </h1></center>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
	}
	
	@RequestMapping("/logout")
	public void logout(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		
		HttpSession session=req.getSession();
		session.removeAttribute("email");
		session.removeAttribute("password");
		session.invalidate();
		
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-control", "no-store");
		resp.setHeader("Expires", "0");
		resp.setDateHeader("Expires", -1);
		
		resp.sendRedirect("login.jsp");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
