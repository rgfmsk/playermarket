package com.betbull.teamservice.service;

import com.betbull.teamservice.entity.Player;
import com.betbull.teamservice.entity.Team;
import com.betbull.teamservice.entity.Transfer;
import com.betbull.teamservice.exception.TransferNotFoundException;
import com.betbull.teamservice.repository.TransferRepository;
import com.betbull.teamservice.util.FeeCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final TransferRepository transferRepository;
    private final TeamService teamService;
    private final PlayerService playerService;

    public Transfer insert(Transfer model) {
        return insert(
                teamService.find(model.getTeam().getId()),
                playerService.find(model.getPlayer().getId()),
                model.getTransferDate());
    }

    public Transfer insert(Team team, Player player, LocalDate date) {
        Transfer transfer = new Transfer();
        transfer.setTransferDate(date);
        transfer.setTeam(team);
        transfer.setPlayer(player);
        return save(transfer);
    }

    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }

    public Transfer find(Long id) {
        return transferRepository.findById(id).orElseThrow(() -> new TransferNotFoundException(id));
    }

    public BigDecimal calculateFee(Long id) {
        Transfer transfer = transferRepository.findById(id).orElseThrow(() -> new TransferNotFoundException(id));

        return FeeCalculator.calculateTransferFeeWCommission(transfer.getTeam(), transfer.getPlayer());
    }

    public Transfer save(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    public void delete(Long id) {
        Optional<Transfer> byId = transferRepository.findById(id);
        if (!byId.isPresent()) {
            throw new TransferNotFoundException(id);
        } else {
            transferRepository.deleteById(id);
        }
    }

    public List<Transfer> findPlayerTransfers(Long id) {
        return transferRepository.findAllByPlayer_Id(id);
    }

    public List<Transfer> findTeamTransfers(Long id) {
        return transferRepository.findAllByTeam_Id(id);
    }

}
