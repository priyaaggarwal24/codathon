package web.codathon.repository;

import org.springframework.stereotype.Repository;
import web.codathon.domain.Offer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OfferRepositoryImpl implements IOfferRepository {

    private List<Offer> offers = new ArrayList<Offer>();

    @Override
    public List<Offer> getOffers() {
        return offers;
    }

    @Override
    public void add(Offer offer) {
        offers.add(offer);
    }

    @Override
    public void remove(Offer offer) {
        offers.remove(offer);
    }
}
