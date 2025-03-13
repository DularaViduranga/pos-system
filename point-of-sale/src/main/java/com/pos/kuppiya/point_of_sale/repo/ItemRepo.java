package com.pos.kuppiya.point_of_sale.repo;

import com.pos.kuppiya.point_of_sale.entity.Item;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ItemRepo extends CrudRepository<Item, Integer> {

    List<Item> findAllByActiveStateEquals(boolean status);
}
