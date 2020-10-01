package ua.kpi.iasa.ServletWebMarket.dao;

import ua.kpi.iasa.ServletWebMarket.model.Bucket;
import ua.kpi.iasa.ServletWebMarket.model.Product;

import java.util.List;
import java.util.UUID;

public interface BucketDao extends GenericDao<Bucket, UUID> {
    List<Product> getAllProducts();

    boolean isEmpty();
}
