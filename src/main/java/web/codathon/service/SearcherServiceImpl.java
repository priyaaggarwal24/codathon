package web.codathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.codathon.domain.Offer;
import web.codathon.repository.IOfferRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class SearcherServiceImpl implements ISearcherService {

    private IOfferRepository offerRepository;

    @Autowired
    public SearcherServiceImpl(IOfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public List<Offer> search(String productName) {
        List<Offer> searchResultList = new ArrayList<Offer>();

        // see the product name and try to find an offer for that product name
        for(Offer offer: offerRepository.getOffers()){
            if(offer.getProduct().getName().toLowerCase().equals(productName)){
                searchResultList.add(offer);
            }
        }
        searchResultList.sort(new Comparator<Offer>() {
            @Override
            public int compare(Offer o1, Offer o2) {
                return Float.compare(o1.getOfferPrice(),o2.getOfferPrice());
            }
        });

        return searchResultList;
    }
}
