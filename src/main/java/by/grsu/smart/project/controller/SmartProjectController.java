package by.grsu.smart.project.controller;

import by.grsu.smart.project.entity.Currency;
import by.grsu.smart.project.entity.Metal;
import by.grsu.smart.project.entity.Project;
import by.grsu.smart.project.entity.json.CalculationResponse;
import by.grsu.smart.project.entity.json.CalculatorRequest;
import by.grsu.smart.project.service.currency.CurrencyService;
import by.grsu.smart.project.service.metal.MetalService;
import by.grsu.smart.project.service.project.ProjectService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

@Controller
public class SmartProjectController {
    private final static Logger logger = Logger.getLogger(SmartProjectController.class);

    @Autowired
    private ProjectService projectService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private MetalService metalService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView mainPage() {
        logger.info("Direct to main page");

        Map<String, Object> params = new HashMap<>();
        List<Currency> currencies = new ArrayList<>();
        currencies.add(currencyService.getUSDCurrencyExchange());
        currencies.add(currencyService.getEURCurrencyExchange());
        currencies.add(currencyService.getRUBCurrencyExchange());
        params.put("currencyExchange", currencies);
//        params.put("currencyExchange", currencyService.getCurrencyExchange());
        List<Metal> metals = metalService.getMetalCost();

        Iterator<Metal> metalIterator = metals.iterator();

        while(metalIterator.hasNext()) {
            if (metalIterator.next().getNominal() != 10) {
                metalIterator.remove();
            }
        }

        params.put("ingotsPrices", metals);
//        params.put("USD", currencyService.getUSDCurrencyExchange());
//        params.put("EUR", currencyService.getEURCurrencyExchange());
//        params.put("RUB", currencyService.getRUBCurrencyExchange());

        return new ModelAndView("main", params);
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public String calculatorPage() {
        logger.info("Direct to calculator page");
        return "calculator";
    }

    @RequestMapping(value = "/repository", method = RequestMethod.GET)
    public ModelAndView repositoryPage() {
        logger.info("Direct to repository page");
        return new ModelAndView("projectRepository", "projects", projectService.getLatestProjects());
    }

    @RequestMapping(value = "/theory", method = RequestMethod.GET)
    public String theoryPage() {
        logger.info("Direct to theory page");
        return "theory";
    }

    @RequestMapping(value = "/law", method = RequestMethod.GET)
    public String documentPage() {
        logger.info("Direct to law page");
        return "law";
    }

    @RequestMapping(value = "/calculateProject", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getProjectParams(@RequestParam("params") String params,
                                   @RequestParam("calculationHorizon") Integer calculationHorizon,
                                   @RequestParam("bettingShopDiscount") Double bettingShopDiscount,
                                   @RequestParam("investedCapital") Double investedCapital) {
        List<CalculationResponse> responses = projectService.calculateProjectParams(calculationHorizon, bettingShopDiscount, investedCapital, parseRequestJSON(params));
        Project project = projectService.calculateProject(calculationHorizon, bettingShopDiscount, investedCapital, responses);

        Map<String, Object> map = new HashMap<>(2);
        map.put("attribute", responses);
        map.put("project", project);

        return getJSONString(map);
    }

    private String getJSONString(Object value) {
        String json = "{}";
        ObjectMapper mapper = new ObjectMapper();

        try {
            json = mapper.writeValueAsString(value);
        } catch (IOException e) {
            logger.error("Exception when parsing value " + value);
            e.printStackTrace();
        }

        return json;
    }

    private List<CalculatorRequest> parseRequestJSON(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<CalculatorRequest> requests = null;

        try {
            requests = Arrays.asList(objectMapper.readValue(json, CalculatorRequest[].class));
        } catch (IOException e) {
            logger.error("Exception deserialization json - " + json, e);
            e.printStackTrace();
        }

        return requests;
    }

}
