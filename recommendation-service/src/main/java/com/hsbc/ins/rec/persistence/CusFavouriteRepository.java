package com.hsbc.ins.rec.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsbc.ins.rec.domain.CusFavourite;

@Repository
public interface CusFavouriteRepository extends JpaRepository<CusFavourite, Long> {

}
