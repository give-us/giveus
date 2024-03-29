package com.giveus.admin.dto.response;

import com.giveus.admin.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class AdminInfoRes {

    private int adminNo;

    private String email;

    private String name;

    private LocalDateTime createdAt;

    private String provider;

    private String snsKey;

    public static AdminInfoRes from(Admin admin) {
        return AdminInfoRes.builder()
                .adminNo(admin.getAdminNo())
                .email(admin.getEmail())
                .name(admin.getName())
                .createdAt(admin.getCreatedAt())
                .provider(admin.getProvider())
                .snsKey(admin.getKey())
                .build();
    }

}
