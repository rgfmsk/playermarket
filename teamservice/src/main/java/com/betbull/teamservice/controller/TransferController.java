package com.betbull.teamservice.controller;

import com.betbull.teamservice.entity.Transfer;
import com.betbull.teamservice.service.TransferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@Api(tags = "Transfer API")
@RequestMapping("api/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @GetMapping
    @ApiOperation(value = "Get All Transfers")
    public List<Transfer> getTransfers() {
        return transferService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Transfer")
    public Transfer getTransfer(@PathVariable Long id) {
        return transferService.find(id);
    }

    @GetMapping("/{id}/charge")
    @ApiOperation(value = "Get Transfer Charge")
    public BigDecimal getCharge(@PathVariable Long id) {
        return transferService.calculateFee(id);
    }

    @GetMapping("/player/{id}")
    @ApiOperation(value = "Get Player Transfers")
    public List<Transfer> getPlayerTransfers(@PathVariable Long id) {
        return transferService.findPlayerTransfers(id);
    }

    @GetMapping("/team/{id}")
    @ApiOperation(value = "Get Team Transfers")
    public List<Transfer> getTeamTransfers(@PathVariable Long id) {
        return transferService.findTeamTransfers(id);
    }

    @PutMapping
    @ApiOperation(value = "Insert Transfer")
    public Transfer create(@RequestBody Transfer transfer) {
        return transferService.insert(transfer);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete Transfer")
    public void delete(@PathVariable Long id) {
        transferService.delete(id);
    }
}
