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
import com.mvc.login_project.dao.impl.WorkerDaoImpl;
import com.mvc.login_project.dto.Owner;
import com.mvc.login_project.dto.Worker;

@Controller
public class WorkerController {

	@Autowired
	OwnerDaoImpl ownerDaoImpl;
	
	@Autowired
	WorkerDaoImpl workerDaoImpl;
	
	@RequestMapping("createWorker")
	public ModelAndView createWorker() {
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("workermodel",new Worker());
		mv.setViewName("createworker.jsp");
		return mv;
	}
	
	@RequestMapping("saveWorker")
	public ModelAndView saveWorker(@ModelAttribute Worker worker,HttpServletRequest req) {
		
		HttpSession session=req.getSession();
		int id=(int) session.getAttribute("Id");
		
		Owner owner=ownerDaoImpl.getOwnerById(id);
		
		worker.setOwner(owner);
		
		String message=ownerDaoImpl.saveWorker(worker);
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("result",message);
		mv.setViewName("ownermessage.jsp");
		return mv;
	}
	
	@RequestMapping("workerLogin")
	public void workerLogin(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		HttpSession httpSession=req.getSession();
		
		Worker worker=workerDaoImpl.findByEmailAndPassword(email, password);
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		if(worker!=null) {
			httpSession.setAttribute("worker", worker);
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("workerhome.jsp");
			dispatcher.forward(req, resp);
		}else {
			out.println("<center><h1> INVALID CREDENTIALS </h1></center>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("workerlogin.jsp");
			dispatcher.include(req, resp);
			
		}
		
	}
	
}
