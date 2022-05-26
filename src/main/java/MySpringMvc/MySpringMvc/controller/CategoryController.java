package MySpringMvc.MySpringMvc.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import MySpringMvc.MySpringMvc.entity.Category;
import MySpringMvc.MySpringMvc.service.CategoryService;

@Controller
//requestmapping for controller
@RequestMapping("/category")
public class CategoryController {
//inject CategoryService
	@Autowired
	CategoryService categoryservice;
	@Autowired
    ServletContext context;
	//RequestMaping for List category
@RequestMapping("list")
public String getAllCategories(Model model)
{
	List<Category> categories=categoryservice.getAll();
	model.addAttribute("categories",categories);
	return "categorylist";
}
//RequestMaping for Add category
@RequestMapping("add")
public ModelAndView addCategories(HttpSession session,Model model)
{
	//create the object of the category
	//Category category=new Category();
	//ModelAndView model=new ModelAndView();
	//get the value from the session to check the user is loggedin or not
	
	if(session.getAttribute("user")==null)
	{
		model.addAttribute("error", "Authentication Required.Please Login");
		return new ModelAndView("authorize");
	}
	String role=(String)session.getAttribute("userrole");
	if(role.contentEquals("admin") || role.equals("employee"))
	{
	return new ModelAndView("category-form", "category", new Category());
	}
	else
	{
		model.addAttribute("error", "Sorry your are not authorized for this work");
		return new ModelAndView("authorize");	}
	//return "category-form";
	}
//request mapping to save the record
@RequestMapping(value="save",method=RequestMethod.POST)
public String SaveCategories(HttpServletRequest request, @ModelAttribute("category") Category category  ,Model model)
{
	try {
		//ServletContext ctx= request.getServletContext();
	      // Get the absolute path of the file
	     // String filename = ctx.getRealPath("resources/");
		/*
		 String saveDirectory = "D:/javaImages/Upload/";
		
            System.out.println("Filename"+category.getFilename());
            
            
            	
                // We need to transfer to a file
                CommonsMultipartFile photoInMemory = category.getPhoto();
                BufferedImage src = ImageIO.read(new ByteArrayInputStream(photoInMemory.getBytes()));
				 
                 String fileName = photoInMemory.getOriginalFilename();//getting file name
          	  System.out.println("directory with file name: " + saveDirectory+fileName);
          	  photoInMemory.transferTo(new File(saveDirectory + fileName));
                System.out.println("");
                category.setFilename(fileName);
                //String fileName = photoInMemory.getOriginalFilename();
                // could generate file names as well

               // File localFile = new File(directory.getPath(), fileName);

                // move the file from memory to the file

                //photoInMemory.transferTo(localFile);
                //category.setFilename(localFile.getPath());
               // System.out.println("File is stored at" + localFile.getPath());
                System.out.print("registerNewUser");
                //User u = e.register(user);
                 * */
                 
                if(category.getCategoryId()>0)
                categoryservice.update(category);
                else
                	 categoryservice.add(category);
    			
    			//request.getSession().setAttribute("category", category);
    			
    			return "redirect://category/list";
                 
             

        
        }

     
    catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println("*** IOException: " + e.getMessage());
        return "error errorMessage error while creating directory";
    }


	

}
//RequestMaping for Add category
@RequestMapping("update/{id}")
public String updateCategories(@PathVariable int id, Model model,HttpSession session)
{
	if(session.getAttribute("user")==null)
	{
		model.addAttribute("error", "Authentication Required.Please Login");
		return "authorize";
	}
	String role=(String)session.getAttribute("userrole");
	if(role.contentEquals("admin") || role.equals("employee"))
	{
		Category category=categoryservice.getById(id);
		model.addAttribute("category",category);
		return "category-form";
	}
	else
	{
		model.addAttribute("error", "Sorry your are not authorized for this work");
		return "authorize";
	//return "category-form";
	}
	//create the object of the category
	
}
//RequestMaping for Add category
@RequestMapping("delete/{id}")
public String deleteCategories(@PathVariable int id, Model model,HttpSession session)
{
	if(session.getAttribute("user")==null)
	{
		model.addAttribute("error", "Authentication Required.Please Login");
		return "authorize";
	}
	String role=(String)session.getAttribute("userrole");
	if(role.contentEquals("admin"))
	{
		categoryservice.delete(id);
		
		return "redirect:/category/list";
	}
	else
	{
		model.addAttribute("error", "Sorry your are not authorized for this work");
		return "authorize";
	//return "category-form";
	}
	//create the object of the category
	
}
//RequestMaping for search category
@RequestMapping("search")
public String searchCategories(@RequestParam String catname, Model model)
{
	//create the object of the category
	//categoryservice.delete(id);
	System.out.println("catname"+catname);
 //List<Category>	categories=categoryservice.searchCategory(catname);
	List<Category>	categories=categoryservice.search(catname);
 System.out.println("not of category"+categories.size());
 model.addAttribute("categories",categories);
	return "categorylist";
}
//RequestMaping for search category
@RequestMapping("searchbyanycharacter")
public String searchbyanycharacter(@RequestParam String catname, Model model)
{
	//create the object of the category
	//categoryservice.delete(id);
	System.out.println("catname"+catname);
List<Category>	categories=categoryservice.search(catname);
System.out.println("not of category"+categories.size());
model.addAttribute("categories",categories);
	return "categorylist";
}
}
