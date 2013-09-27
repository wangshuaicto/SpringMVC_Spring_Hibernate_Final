package com.shuai.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shuai.web.entity.User;
import com.shuai.web.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/toaddUser")
	public String toAddUser()
	{
		return "addUser";
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user)
	{
		userService.addUser(user);
		//SpringMVC重定向
		return "redirect:/user/getalluser";
	}
	
	@RequestMapping("/getalluser")
	public String getAllUser(User user,HttpServletRequest request)
	{
		List<User> userlist = userService.getAllUser();
		request.setAttribute("userlist", userlist);
		return "usermanager";
	}
	
	@RequestMapping("/deleteUser")
	public void deleteUser(String id,HttpServletRequest request ,HttpServletResponse response)
	{
		String result = "{\"msg\":\"success\"}";
		String error  = "{\"msg\":\"error\"}";
		try {
			PrintWriter pw = response.getWriter();
			if(userService.deleteUser(id))
			{
				pw.print(result);
			}else
			{
				pw.print(error);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/toedit")
	public String toeditUser(String id,HttpServletRequest request)
	{
		User user = userService.getSingleUser(id);
		request.setAttribute("user", user);
		return "edit";
	}
	@RequestMapping("/updateUser")
	public String updateUser(User user,HttpServletRequest request)
	{
		if(userService.updateUser(user))
		{
			return "redirect:/user/getalluser";
		}
		else
		{
			return "error";
		}
	}
	
}
