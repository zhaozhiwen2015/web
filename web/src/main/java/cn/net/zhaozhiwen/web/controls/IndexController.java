package cn.net.zhaozhiwen.web.controls;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping()
public class IndexController {

	
	/**
	 * 类型1：返回视图string
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index( Model model){     
		return "login";
	}
	/**
	 * 类型2：返回jsonObject
	 * @param model
	 * @param name
	 * @return
	 */

	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String mainpad( Model model){     
		return "index";
	}
	static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 


	
}