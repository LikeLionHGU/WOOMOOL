package com.project.woomool.entity;

import com.project.woomool.controller.request.UserDetailRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetail extends Base{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float weight;
    private float height;
    private float bmi;
    private float recommendation;
    private float todayTotal;
    private byte hasDrank;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="User_Id" )
    private User user;

    public void updateTotal(float amount) {
        this.todayTotal += amount;
    }

    public static UserDetail of(UserDetailRequest request, float bmi, User user) {
        return UserDetail.builder()
            .weight(request.getWeight())
            .height(request.getHeight())
            .bmi(bmi)
            .recommendation(((request.getHeight()+ request.getWeight())/100)*1000)
            .hasDrank((byte) 0)
            .todayTotal(0)
            .user(user)
            .build();
    }
}