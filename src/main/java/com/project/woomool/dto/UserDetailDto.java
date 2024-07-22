package com.project.woomool.dto;

import com.project.woomool.entity.User;
import com.project.woomool.entity.UserDetail;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailDto {

    private float weight;
    private float height;
    private float bmi;
    private float recommendation;
    private float todayTotal;
    private int hasDrankLevel;
    private boolean hasDrankToday;
    private boolean warnDrankToday;

    public static UserDetailDto of(UserDetail userDetail) {
        UserDetailDto dto = new UserDetailDto();
        dto.setWeight(userDetail.getWeight());
        dto.setHeight(userDetail.getHeight());
        dto.setHasDrankLevel(userDetail.getHasDrankLevel());
        dto.setHasDrankToday(userDetail.isHasDrankToday());
        dto.setBmi(userDetail.getBmi());
        dto.setTodayTotal(userDetail.getTodayTotal());
        dto.setWarnDrankToday(userDetail.isWarnDrankToday());
        dto.setRecommendation(userDetail.getRecommendation());
        return dto;
    }
}
