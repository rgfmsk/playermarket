package com.betbull.teamservice.repository;

import com.betbull.teamservice.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    List<Transfer> findAllByPlayer_Id(Long id);
    List<Transfer> findAllByTeam_Id(Long id);
}
