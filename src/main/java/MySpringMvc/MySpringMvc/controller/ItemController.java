package MySpringMvc.MySpringMvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;



import MySpringMvc.MySpringMvc.entity.Category;
import MySpringMvc.MySpringMvc.entity.Item;
import MySpringMvc.MySpringMvc.model.Cart;
import MySpringMvc.MySpringMvc.model.CartCollection;
import MySpringMvc.MySpringMvc.service.CategoryService;
import MySpringMvc.MySpringMvc.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	CategoryService categoryservice;
	@Autowired
	ItemService productservice;
	@Autowired
    ServletContext servletContext;//this object will return me the current server path
@RequestMapping("additem")
public ModelAndView addItem(Model model1)
{
	List<Category>	categories=categoryservice.getAll();
	Map<String, Object> model = new HashMap<String, Object>();
	//for(Category category : categories)
	//{
	   // categoriesMap.put(category, category.getCategoryName());
	//}
	model.put("categories",  categories);
	model.put("product", new Item());
	//model.addAttribute("categories1",categoriesMap);
	//ModelAndView modelAndView = new ModelAndView("item-form","product",new Item());
	//modelAndView.addObject("categoryList",categories);
	return new ModelAndView("item-form", model);
	
}

@RequestMapping(value="save",method=RequestMethod.POST)
public ModelAndView SaveItem(@ModelAttribute("product") Item item  ,Model model,
		HttpServletRequest request,BindingResult result) throws Exception
{
	
	System.out.println("Product file name is "+request.getParameter("filename"));
	item.setFilename(request.getParameter("filename"));
	System.out.println("The category name sent is "+request.getParameter("category"));
	
	try {
        if (item.getFilename().trim() != "" || item.getFilename() != null) {
            File directory;
            String check = File.separator; // Checking if system is linux
                                            // based or windows based by
                                            // checking seprator used.
            String path = null;
            if (check.equalsIgnoreCase("\\")) {
                path = servletContext.getRealPath("").replace("build\\", ""); // gives real path as /build/web/
                                                                              // so we need to replace build in the path
                                                                                    }
            //in case of MAC
            if (check.equalsIgnoreCase("/")) {
                path = servletContext.getRealPath("").replace("build/", "");
                path += "/"; // Adding trailing slash for Mac systems.
            }
            //creating the director path
            directory = new File(path + "\\" + item.getFilename());
            //checking the directory exits
            boolean temp = directory.exists();
            if (!temp) {
            	//create the new director if the director not exits
                temp = directory.mkdir();
            }
            if (temp) {
                // We need to transfer to a file
                CommonsMultipartFile photoInMemory = item.getPhoto();

                String fileName = photoInMemory.getOriginalFilename();
                // could generate file names as well
                //creating the file with the path to create and store the file
                File localFile = new File(directory.getPath(), fileName);

                // move the file from memory to the file

                photoInMemory.transferTo(localFile);
               item.setFilename(localFile.getPath());
                System.out.println("File is stored at" + localFile.getPath());
                System.out.print("registerNewUser");
                //User u = e.register(user);
                //Category category=categoryservice.getById(item.getCategory().getCategoryId());
                //Product p=employeeDao.createProduct(product.getFilename(), product.getProductName(), product.getProductPrice(), category);
                if(item.getItemId()==null)
                	item.setItemId(0);
                if(item.getItemId()==0)
                productservice.add(item);
                else
                productservice.update(item);
                return new ModelAndView("redirect:/item/list");
            
            } else {
                System.out.println("Failed to create directory!");
                return new ModelAndView("error", "errorMessage", "error while creating directory");
            }

        
        }

    } catch (IllegalStateException e) {
        System.out.println("*** IllegalStateException: " + e.getMessage());
        return new ModelAndView("error", "errorMessage", "error while creating directory");
    } catch (IOException e) {
        // TODO Auto-generated catch block
        System.out.println("*** IOException: " + e.getMessage());
        return new ModelAndView("error", "errorMessage", "error while creating directory");
    }


	return new ModelAndView("error", "errorMessage", "error while creating directory");
	
}
//create a requestmapping for itemlist
@RequestMapping(value="list")
public ModelAndView allItem()
{
	ModelAndView model=new ModelAndView();
List<Item> items=productservice.getAll();
	model.addObject("items",items);
	model.setViewName("itemlist");
	return model;
}
@RequestMapping(value="edititem/{id}")
public ModelAndView editItem(@PathVariable("id") int id)
{
	//get the item by id
	List<Category>	categories=categoryservice.getAll();
	Map<String, Object> model1 = new HashMap<String, Object>();
	model1.put("categories",  categories);
	Item item=productservice.getById(id);
	//Item item=new Item();
	

	model1.put("product",item);
	
	return new ModelAndView("item-form",model1);
}
//mapping for delete item
@RequestMapping(value="deletetem/{id}")
public String deleteItem(@PathVariable("id") int id)
{
	//get the item by id
	productservice.delete(id);
	
	return "redirect://item/list";
}
@RequestMapping(value="addtocart/{id}")

public String addToCart(@PathVariable("id") int id,HttpSession session,Model model)
{
	//get the item by id
	Item item= productservice.getById(id);
	//create the object of the cart
	Cart cart=new Cart();
	cart.setItemid(item.getItemId());
	cart.setItemname(item.getItemName());
	cart.setPrice(item.getItemPrice());
	cart.setQty(1);
	//check the session object of the cart colelction is created or not
	CartCollection cartcollection=null;
	if(session.getAttribute("cartcollection")==null)
	{
		cartcollection=new CartCollection();
	}
	else
	{
		cartcollection=(CartCollection) session.getAttribute("cartcollection");
	}
	cartcollection.addToCart(cart);
	//add the cartcollection to the session
	session.setAttribute("cartcollection", cartcollection);
	//add the collection to the model attribute
	model.addAttribute("carts", cartcollection);
	return "redirect://item/cart";
}
}
