package by.grsu.smart.project.controller;

import by.grsu.smart.project.service.ProjectService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SmartProjectController {
    private final static Logger logger = Logger.getLogger(SmartProjectController.class);

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public String getCalculator() {
        logger.info("calculator");
        return "calculator";
    }

}
