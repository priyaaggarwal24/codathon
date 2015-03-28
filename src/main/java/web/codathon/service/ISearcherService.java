package web.codathon.service;

import org.springframework.stereotype.Service;
import web.codathon.domain.Offer;

import java.util.List;

public interface ISearcherService {
    List<Offer> search(String productName);
}
