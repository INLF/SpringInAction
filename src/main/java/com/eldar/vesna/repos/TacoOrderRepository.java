package com.eldar.vesna.repos;

import com.eldar.vesna.data.TacoOrder;

public interface TacoOrderRepository {
    Iterable<TacoOrder> findAll();
    TacoOrder save(TacoOrder order);

}
