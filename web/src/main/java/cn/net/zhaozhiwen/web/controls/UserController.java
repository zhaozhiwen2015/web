package cn.net.zhaozhiwen.web.controls;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.net.zhaozhiwen.db.daos.UserDao;
import cn.net.zhaozhiwen.db.entities.User;
import cn.net.zhaozhiwen.web.utils.CoreUtils;


@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	UserDao userDao;
	/**
	 * 登录
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String index(String username,String password,String code,HttpServletRequest request, HttpServletResponse response,Model model){     
		HttpSession session =  request.getSession();
	    String token =  session.getAttribute("captchaToken").toString();
	    System.out.println("valid-----当前的SessionID=" + session.getId() + "，验证码=" + token +"--"+code);
	    if(CoreUtils.isNotEmpty(code)&& code.trim().equalsIgnoreCase(token)){
	    	return "/index";
	    }
	        
		return "redirect:/";
	}
	/**
	 * 退出登录
	 * @param model
	 * @param name
	 * @return
	 */

	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String mainpad(HttpServletRequest request, Model model){    
		request.getSession().invalidate();
		return "redirect:/";
	}
	static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 


	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(HttpServletRequest request, Model model){    
		return "user/list";
	}
	
	@RequestMapping(value="/listUsers",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> listUsers(Integer page,Integer rows,HttpServletRequest request, Model model){  
		Map<String,Object> map = new HashMap<String,Object>();
		if(CoreUtils.isNull(page))page = 1;
		if(CoreUtils.isNull(rows))rows = 2;
		Pageable pageable = new PageRequest(page-1,rows);
		Page<User> usrList = userDao.findAll(pageable);
	
		map.put("total", usrList.getTotalElements());
		
		
		
		map.put("rows",usrList.getContent());
		return map;
	}
	
}