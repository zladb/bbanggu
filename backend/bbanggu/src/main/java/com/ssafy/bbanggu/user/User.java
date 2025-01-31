package com.ssafy.bbanggu.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import com.ssafy.bbanggu.bakery.Bakery;
import com.ssafy.bbanggu.bakery.Settlement;
import com.ssafy.bbanggu.favorite.Favorite;
import com.ssafy.bbanggu.reservation.Reservation;
import com.ssafy.bbanggu.review.Review;
import com.ssafy.bbanggu.saving.EchoSaving;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId; // 사용자 ID

    @Column(nullable = false, unique = true, length = 255)
    private String email; // 이메일

    @Column(nullable = false, length = 255)
    private String password; // 비밀번호

    @Column(nullable = false, length = 100)
    private String name; // 이름

    @Column(length = 20)
    private String phone; // 전화번호

    @Column(name = "profile_image_url", length = 255)
    private String profileImageUrl; // 프로필 이미지 URL

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    private UserType userType; // 사용자 타입 (USER, OWNER, ADMIN)

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt; // 생성일

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt; // 삭제일

    // 연관 관계 설정
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bakery> bakeries; // 가게 목록

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorite> favorites; // 즐겨찾기 목록

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews; // 리뷰 목록

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations; // 예약 목록

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private EchoSaving echoSaving; // 에코 세이빙

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Settlement settlement; // 정산 정보
}

enum UserType {
    USER, OWNER, ADMIN
}
