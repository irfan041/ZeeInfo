package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.command.LoginCommand;
import com.demo.dao.UserDAO;
import com.demo.model.Student;
import com.demo.services.LoginServices;

@Controller
public class UserController {

	@Autowired
	UserDAO userDao;
	@Autowired
	LoginServices loginservice;

	@RequestMapping("/")
	public String prepaarePage() {
		return "NewFile";
	}

	@RequestMapping("/register/form1")
	public String registerPage(Model m) {
		Student student = new Student();
		m.addAttribute("cmd", student);
		return "Register";
	}

	@RequestMapping(value = { "/register/save" }, method = RequestMethod.POST)
	public String registerSave(@ModelAttribute("cmd") Student student,
			RedirectAttributes redirectattibutes) {

		/*
		 * if (student.getStudentId() != null) {
		 * 
		 * userDao.update(student); }
		 */

		userDao.save(student);

		redirectattibutes
				.addFlashAttribute("msg", "User Register SuccessFully");
		return "redirect:/userList";
	}

	@RequestMapping(value = { "/register/update" }, method = RequestMethod.POST)
	public String registerUpdate(@ModelAttribute("cmd") Student student,
			RedirectAttributes redirectattibutes) {
		userDao.update(student);
		redirectattibutes.addFlashAttribute("msg", "User Updated SuccessFully");
		return "redirect:/userList";
	}

	@RequestMapping("/userList")
	public String userList(Model m) {
		List<Student> studentList = userDao.findAll();

		m.addAttribute("studentList", studentList);
		return "userList";
	}

	@RequestMapping("/userList1")
	public String userList2(Model m) {
		// List<Student> studentList = userDao.findAll();

		// m.addAttribute("studentList", studentList);
		return "userList1";
	}

	@RequestMapping("/userListJSON")
	@ResponseBody
	public List<Student> userList1(Model m) {
		System.out.println("userListJSON Controller");
		List<Student> studentList = userDao.findAll();

		m.addAttribute("studentList", studentList);
		return userDao.findAll();
	}

	@RequestMapping("/login/form")
	public String loginPage(Model m) {
		Student student = new Student();
		m.addAttribute("cmd", student);
		return "Login";
	}

	@RequestMapping(value = { "/login/fetch" }, method = RequestMethod.POST)
	public String loginFetch(@ModelAttribute("cmd") LoginCommand logincommand,
			RedirectAttributes redirectattibutes) {
		String mail = logincommand.getMail();
		String password = logincommand.getPassword();
		Student student = loginservice.Autheticate(mail, password);
		if (student != null) {
			redirectattibutes.addFlashAttribute("msg",
					"Student Login Successfull");
			return "redirect:/login/form";
		} else {
			redirectattibutes.addFlashAttribute("msg",
					"Id and Password Incurrect");
			return "redirect:/login/form";
		}

	}

	@RequestMapping("/DeleteUser")
	public String deleteUser(HttpServletRequest request) {
		try {
			Integer studentId = null;
			String studentStringId = request.getParameter("studentId");
			System.out.println(studentStringId);
			if (studentStringId != null && !studentStringId.equals("")) {
				studentId = new Integer(studentStringId);
				System.out.println("inside deleteUser");
			}
			userDao.delete(studentId);

			return "redirect:/userList";
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;

		}
	}
	@RequestMapping("/DeleteUserJson")
	public String deleteUserJson(HttpServletRequest request) {
		String studentStringId = request.getParameter("studentId");
		System.out.println("delete user json controller"+studentStringId);
		try {
			Integer studentId = null;
			
			System.out.println(studentStringId);
			if (studentStringId != null && !studentStringId.equals("")) {
				studentId = new Integer(studentStringId);
				System.out.println("inside deleteUser");
			}
			userDao.delete(studentId);

			return "redirect:/userList";
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;

		}
	}

	@RequestMapping("/editUser")
	public String editUser(Model m, HttpServletRequest request) {
		String str = request.getParameter("studentId");
		Integer studentId = new Integer(str);
		Student student;
		student = userDao.findById(studentId);
		m.addAttribute("cmd", student);
		return "Update";
	}
}
