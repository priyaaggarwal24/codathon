package web.codathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.codathon.domain.Offer;
import web.codathon.domain.Product;
import web.codathon.repository.IOfferRepository;
import web.codathon.repository.IProductRepository;

@Service
public class ParserServiceImpl implements IParserService {

    private IProductRepository productRepository;
    private IOfferRepository offerRepository;

    private static final String[] offerKeyWords = new String[]{"off", "discount"};

    @Autowired
    public ParserServiceImpl(IProductRepository productRepository, IOfferRepository offerRepository) {
        this.productRepository = productRepository;
        this.offerRepository = offerRepository;
    }

    @Override
    public void parse(String offerString) {
        // from the string try to find the product by complete name

        // foreach product in the repository, try to search the offer string by product name
        for(Product productToBeSearched : productRepository.getProducts()){
            if(offerString.toLowerCase().indexOf(productToBeSearched.getName().toLowerCase()) != -1){
                // product found!!, see if there is an offer

                // if the string has offer or off keywords in it try to find the number associated with it
                // assumption is that the amount or percentage would be either on the rhs or lhs of the offer keywords
                int indexOfOff = offerString.toLowerCase().indexOf("off");
                int indexOfDiscount = offerString.toLowerCase().indexOf("discount");
                boolean isPercentage = false;
                float offerNumber = 0;
                if(indexOfOff != -1 || indexOfDiscount != -1){
                    // get the number on the right or left
                    // fastest codeable way I can think of is to search for characters 0-9
                    String numeral = "";
                    int numeralLastFoundAt = -1;
                    char[] offerStringAsCharArray = offerString.toCharArray();

                    int charIndex = -1;
                    for(charIndex=0; charIndex< offerString.length();charIndex++){
                        char c = offerStringAsCharArray[charIndex];
                        if(c >= '0' && c<= '9' && (numeralLastFoundAt == -1 || numeralLastFoundAt == charIndex-1)){
                            numeral += c;
                            numeralLastFoundAt = charIndex;
                        }
                        else if((c < '0' || c > '9') && numeral != ""){
                            break;
                        }
                    }
                    try{
                        offerNumber = Float.parseFloat(numeral);
                        isPercentage = offerStringAsCharArray[charIndex] == '%' ;
                    }catch(NumberFormatException ex){

                    }
                }

                // 2. find the offer by keyword either in % or in exact offer amount

                if(isPercentage && offerNumber < 100.0 && offerNumber > 0.0 ) {
                    // create an offer object and add it to the offer repository
                    Offer newOffer = new Offer();
                    newOffer.setProduct(productToBeSearched);
                    newOffer.setOfferPrice((float)(productToBeSearched.getPrice() * (100.00 - offerNumber)/100));
                    newOffer.setOfferString(offerString);

                    offerRepository.add(newOffer);
                }
                else if(isPercentage == false && offerNumber > 0.0 && productToBeSearched.getPrice() > offerNumber){
                    Offer newOffer = new Offer();
                    newOffer.setProduct(productToBeSearched);
                    newOffer.setOfferPrice(productToBeSearched.getPrice() - offerNumber);
                    newOffer.setOfferString(offerString);

                    offerRepository.add(newOffer);
                }
            }
        }
    }
}
