package web.codathon.repository;

import web.codathon.domain.Offer;

import java.util.List;

public interface IOfferRepository {

    List<Offer> getOffers();

    void add(Offer offer);

    void remove(Offer offer);
}
