package web.codathon;

import web.codathon.repository.OfferRepositoryImpl;
import web.codathon.repository.ProductRepositoryImpl;
import web.codathon.service.ParserServiceImpl;

/**
 * For testing purpose only
 */
public class Main {

    private static final String[] offerStrings = new String[]{
            "25% off on mobile",
            "INR 100 discount on mobile",
            "5% off on tv",
            "INR 3500 off on mobile"
    };

    public static void main(String[] args){

        ParserServiceImpl parser = new ParserServiceImpl(new ProductRepositoryImpl(),new OfferRepositoryImpl());
        for(String offerString: offerStrings){
            parser.parse(offerString);
        }
    }
}
