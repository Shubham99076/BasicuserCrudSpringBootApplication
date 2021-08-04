package com.shubham.controller;

import com.shubham.model.User;
import com.shubham.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Controller
public class UserController {


    private UserService userService;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    // SHOW User

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }


    @RequestMapping("user/{id}")
    public String showUser(@PathVariable Integer id, Model model){

        model.addAttribute("user",userService.getUserById(id));
        return "view-user";

    }

    @RequestMapping("user/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {

        model.addAttribute("edit1",userService.getUserById(id));
        return "edit-user";

    }

    @RequestMapping("user/delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        System.out.println(id);
        userService.deleteUserss(id);
        return "redirect:/users";

    }

    @RequestMapping(value = "/user/update-user")
    @Transactional
    public String updateUsers(@RequestParam("userid") Integer userid, @RequestParam("first_name") String first_name, @RequestParam("last_name") String last_name, @RequestParam("username") String username,@RequestParam("dob") String dob,@RequestParam("password") String password,@RequestParam("email_id") String email_id, Model model){

        Query query = entityManager.createQuery("UPDATE User u set u.first_name=:first_name,u.last_name=:last_name,u.username=:username,u.dob=:dob,u.password=:password,u.email_id=:email_id where u.userid=:userid");
        query.setParameter("first_name", first_name);
        query.setParameter("last_name", last_name);
        query.setParameter("username", username);
        query.setParameter("dob", dob);
        query.setParameter("password", password);
        query.setParameter("email_id", email_id);
        query.setParameter("userid", userid);

        int i = query.executeUpdate();
        System.out.println(i);
        if(i>0){
            return "redirect:/user/" + userid;
        } else {
            return "error-500";
        }


    }

    @RequestMapping("user/new")
    public String newUser(Model model){
        model.addAttribute("users", new User());
        return "userforms";
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveUser(User User){
        userService.saveUsers(User);
        return "redirect:/user/" + User.getUserid();
    }

}
