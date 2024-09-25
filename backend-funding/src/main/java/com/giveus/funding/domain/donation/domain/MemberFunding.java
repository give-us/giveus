package com.giveus.funding.domain.donation.domain;

import com.giveus.funding.domain.funding.domain.Funding;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Entity
@Table(name = "member_funding")
@Getter
@Setter
@DynamicInsert
@NoArgsConstructor
public class MemberFunding {

    @Id
    @Column(name = "member_funding_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberFundingNo;

    @ManyToOne
    @JoinColumn(name = "member_no")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "funding_no")
    private Funding funding;

    @Column(name = "payment_no")
    private int paymentNo;

    @Column(name = "point_no")
    private int pointNo;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "amount")
    private int amount;

    @Column(name = "is_public")
    private Boolean isPublic;
}
