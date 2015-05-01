package net.codejava.springmvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.springmvc.dao.*;
import net.codejava.springmvc.model.Class;
import net.codejava.springmvc.model.File;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private ClassDAO classDAO;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public ModelAndView listClass(ModelAndView model) throws IOException {
		
		List<Class> listClass = classDAO.list();
		model.addObject("listClass", listClass);
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/importData", method = RequestMethod.GET)
	public String importData(Model model) {
		
		File fileModel = new File();
		model.addAttribute("file", fileModel);
		return "UploadForm";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView upload(ModelAndView model, File file) {
		MultipartFile multi;
		multi = file.getFile();
		classDAO.upload(multi);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/saveClass", method = RequestMethod.POST)
	public ModelAndView saveClass(@ModelAttribute Class clss) {
		
		classDAO.saveOrUpdate(clss);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteClass", method = RequestMethod.GET)
	public ModelAndView deleteClass(HttpServletRequest request) {
		
		String className = request.getParameter("name");
		classDAO.delete(className);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editClass", method = RequestMethod.GET)
	public ModelAndView editClass(HttpServletRequest request){
		
		String className = request.getParameter("name");
		Class clss = classDAO.get(className);
		List<String> tagList = new ArrayList<String>();
		tagList.add("LEC");
		tagList.add("LAB");
		ModelAndView model = new ModelAndView("ClassForm");
		model.addObject("class", clss);
		model.addObject("tagList", tagList);
		return model;
	}
}