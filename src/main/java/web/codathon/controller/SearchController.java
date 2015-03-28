package web.codathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.codathon.domain.Offer;
import web.codathon.repository.IProductRepository;
import web.codathon.service.IParserService;
import web.codathon.service.ISearcherService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    private static final String[] offerStrings = new String[]{
            "25% off on mobile",
            "INR 100 discount on mobile",
            "5% off on tv",
            "INR 3500 off on mobile",
            "100% off on fridge"
    };

    private ISearcherService searcherService;
    private IParserService parserService;
    private IProductRepository productRepository;

    @Autowired
    public SearchController(ISearcherService searcherService, IParserService parserService, IProductRepository productRepository) {
        this.searcherService = searcherService;
        this.parserService = parserService;
        this.productRepository = productRepository;

        for(String offerString: offerStrings){
            parserService.parse(offerString);
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchOfferForProduct(@RequestParam(required = false) String productName ,Model model){
        List<Offer> offers = new ArrayList<>();
        if(productName != null) {
            offers = searcherService.search(productName);
        }
        model.addAttribute("offers", offers);
        model.addAttribute("products", productRepository.getProducts());
        model.addAttribute("offerStrings", offerStrings);

        return "search";
    }
}
