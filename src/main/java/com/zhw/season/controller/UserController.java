package com.zhw.season.controller;

import com.zhw.season.pojo.User;
import com.zhw.season.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @RequestMapping("/allUser")
    public String list(Model model) {
        List<User> list = userService.getAllUser();

        model.addAttribute("list", list);
        return "allUser";
    }

    @RequestMapping("/toAdduser")
    public String toAdduser() {
        return "addUser";
    }

    @RequestMapping("/adduser")
    public String adduser(User user) {
        System.out.println(user);
        userService.addUser(user);
        return "redirect:/user/allUser";
    }

    @RequestMapping("/toUpdateUser")
    public String toUpdateUser(Model model, int id) {
        User user = userService.getUserById(id);
        System.out.println(user);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @RequestMapping("updateUser")
    public String updateUser(Model model, User user) {
        System.out.println(user);
        userService.updateUser(user);
        User users = userService.getUserById(user.getId());
        model.addAttribute("users",users);
        return "redirect:/user/allUser";
    }

    @RequestMapping("/del/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/user/allUser";
    }

    @RequestMapping("/userQuery")
    public String userQuery(String userQueryName,Model model){

        User user = userService.queryUserByName(userQueryName);

        List<User> list = new ArrayList<User>();
        list.add(user);

        if(user == null){
            list = userService.getAllUser();
            model.addAttribute("error","未查到用户");
        }
        model.addAttribute("list", list);
        return "allUser";
    }

    //@RequestMapping("/uploadHead")
    //public String uploadMusic(MultipartFile musicFile) {
    //    System.out.println("========upload");
    //    String msg = "fail";
    //    try {
    //        //原始文件名称   music.mp3/musicpic.jig
    //        String fileName =  musicFile.getOriginalFilename();
    //        //文件格式后缀
    //        String str = fileName.substring(fileName.lastIndexOf("."));
    //        //music.mp3
    //        String fileNewName = UUID.randomUUID().toString() + str;
    //
    //        File newfile = new File("D://findmapfile//" + fileNewName);
    //        if(!newfile.exists()) {
    //            newfile.createNewFile();
    //        }
    //        //拷贝文件
    //        musicFile.transferTo(newfile);
    //        msg = fileNewName;
    //    } catch (Exception e) {
    //        // TODO: handle exception
    //        e.printStackTrace();
    //        msg = "Error";
    //    }
    //    return msg;
    //}

}