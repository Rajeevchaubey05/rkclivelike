package io.codewithrkc.trackercovid19v1.controllers;

import io.codewithrkc.trackercovid19v1.models.CovidDataLocationWise;
import io.codewithrkc.trackercovid19v1.services.dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CovidHomeController {
    @Autowired
    dataService dService;
    @GetMapping("/")
    public String home(Model model){
        List<CovidDataLocationWise> allData = dService.getAllCovidData();
        int totalCaseReported = allData.stream().mapToInt(data -> data.getCurrentTotalCase()).sum();
        int totalNewCases = allData.stream().mapToInt(data -> data.getDiffFromPrevDay()).sum();
        model.addAttribute("locationData",allData);
        model.addAttribute("totalCasesReported",totalCaseReported);
        model.addAttribute("totalNewCases",totalNewCases);

        return "home";
    }
}
