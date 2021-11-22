package com.rillsoft.springbookadmin.Token.data;

import com.rillsoft.springbookadmin.model.AuthUsers;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

// added by crane zhou on 2021.11.16
// Refer to:
//      https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/
//          jpa/repository/JpaRepository.html
//

/*
@Entity
@Table(name = "tbl_auth_user_tokens")
public class AuthUserTokens implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String token_name;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp token_timeStamp;

    @Column(updatable = false)
    @Basic(optional = false)
    private LocalDateTime token_expire_at;

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName ="id")
    private AuthUsers objAuthUser;

    @Transient
    private boolean is_Token_Expired;

    public String getTokenName() {
        return token_name;
    }

    public void setTokenName(String strTokenName) {
        this.token_name = strTokenName;
    }

    public Long getTokenId() {
        return id;
    }

    public LocalDateTime getTokenExpireAt() {
        return token_expire_at;
    }

    public void setTokenExpireAt(LocalDateTime dtExpireAt) {
        this.token_expire_at = dtExpireAt;
    }

    public Timestamp getTokenTimeStamp() {
        return token_timeStamp;
    }

    public boolean isTokenExpired() {

        // this is generic implementation, you can always make it timezone specific
        return getTokenExpireAt().isBefore(LocalDateTime.now());
    }

    public AuthUsers getAuthUser() {
        return objAuthUser;
    }

    public void setAuthUser(AuthUsers objAuthUser) {
        this.objAuthUser = objAuthUser;
    }
}
*/