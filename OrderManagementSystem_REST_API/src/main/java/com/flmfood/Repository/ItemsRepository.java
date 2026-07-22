package com.flmfood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flmfood.entity.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
