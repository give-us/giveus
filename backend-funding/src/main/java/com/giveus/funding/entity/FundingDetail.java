package com.giveus.funding.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "funding_detail")
@Getter
@Setter
@NoArgsConstructor
public class FundingDetail {

    @Id
    @Column(name = "funding_detail_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fundingDetailNo;

    @OneToOne
    @JoinColumn(name = "funding_no")
    private Funding funding;

    @Column(name = "content")
    private String content;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

}
