package Controller;

import currency.CurrencyTransaction;
import data.OldCalcs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by maxim on 07.05.2021.
 */
@Controller
@RequestMapping("/calculator")
public class CurrencyController {


    private final OldCalcs calcs;

    public CurrencyController(OldCalcs calcs) {
        this.calcs = calcs;
    }

    @GetMapping
    public String getNotes(Model model){
        model.addAttribute("calcList", calcs.getAll());
        return "calcs";
    }
    // TODO: implement controller methods according to the javadoc and verify your impl using NoteControllerTest

    @PostMapping
    public String addNote(CurrencyTransaction transaction){
        calcs.add(transaction);
        return "redirect:/calculator";
    }
}
