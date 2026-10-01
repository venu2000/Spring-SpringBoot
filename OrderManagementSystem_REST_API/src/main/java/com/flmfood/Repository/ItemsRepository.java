package com.flmfood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flmfood.entity.Items;

import jakarta.transaction.Transactional;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer> {
	

	@Query("update Items set rating = ?2 where itemId = ?1")
	@Modifying
	@Transactional
	public int updateRating(int Itemid, double rating);

}
