package mahder.daves.demo.controller;

import mahder.daves.demo.models.Person;
import mahder.daves.demo.models.Rooms;
import mahder.daves.demo.repository.PersonRepository;
import mahder.daves.demo.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomeController {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    RoomsRepository roomsRepository;

    @GetMapping("/")
    public String Welcomepage()
    {

        return "home";
    }
    @GetMapping("/enterowner")

    public String PersonalInfo(Model model)
    {
        model.addAttribute("newperson", new Person());
        return"enterowner";
    }

    @PostMapping("/enterowner")
    public String PostInfo(@Valid @ModelAttribute("newperson") Person otherperson, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "enterowner";
        }
        personRepository.save(otherperson);
        return "ownerresult";
    }

    @GetMapping("/enterroom")
    public String AddRoom(Model model)
    {
        model.addAttribute("newroom", new Rooms());

        return"enterroom";
    }
    @PostMapping("/enterroom")
    public String PostRoom(@Valid @ModelAttribute("newroom") Rooms otherroom, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return"enterroom";
        }
        if(otherroom.getAvailablity()=="yes")
        {
            otherroom.setStatus("Available");
        }
        else if(otherroom.getAvailablity()=="no")
        {
            otherroom.setStatus("Not Available");
        }
        roomsRepository.save(otherroom);
        return "roomresult";
    }

    @GetMapping("/showrooms")
    public String Allrooms(Model model, Rooms room)
    {

//        Person persdata=personRepository.findOne(new Long(1));
//        ArrayList<Rooms> roomsArrayList=((ArrayList<Rooms>)roomsRepository.findAll());
//        persdata.setRoomsinstance(roomsArrayList);
//        model.addAttribute("newroom" ,persdata);
//        roomsRepository.save(room);
        model.addAttribute("room", roomsRepository.findAll());
        System.out.println();
        return "showrooms";

    }
}
