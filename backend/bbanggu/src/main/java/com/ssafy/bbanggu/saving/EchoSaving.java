package com.ssafy.bbanggu.saving;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.ssafy.bbanggu.user.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "echo_saving")
public class EchoSaving {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "echo_saving_id")
    private Long echoSavingId; // 에코 세이빙 ID

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 사용자 ID

    @Column(name = "saved_money", nullable = false)
    private Integer savedMoney; // 절약한 금액

    @Column(name = "reduced_co2e")
    private Integer reducedCo2e; // 절약한 CO2e

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt; // 생성일

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; // 수정일
}
