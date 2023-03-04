package baemin.baeminjpa.domain;

import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User extends BaseTimeEntity{

    @Id @GeneratedValue
    @Column(name = "userId")
    private Long id;

    private String userName;
    private String profileImage;
    private String grade;
    private double point;

    @Enumerated(EnumType.STRING)
    private UserStatus status;
    private String phoneNumber;
    private String email;
    private String loginId;
    private String password;
    private int cntReview;
    private double avgReview;
    private int cnt5Point;
    private int cnt4Point;
    private int cnt3Point;
    private int cnt2Point;
    private int cnt1Point;

    @Enumerated(EnumType.STRING)
    private ReceiveStatus mailReceive;

    @Enumerated(EnumType.STRING)
    private ReceiveStatus SMSReceive;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addressList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notice> noticeList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<User_Coupon> user_couponList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Heart> heartList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Order> orderList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deliveryId")
    private Delivery delivery;

}
