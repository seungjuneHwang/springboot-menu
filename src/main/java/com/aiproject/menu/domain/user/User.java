package com.aiproject.menu.domain.user;

import com.aiproject.menu.domain.Timestamped;
import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User extends Timestamped {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false)
   private String name;

   @Column(nullable = false)
   private String email;

//    @Column(nullable = false)
//    private String password;

   @Column
   private String picture;

   @Enumerated(EnumType.STRING)
   @Column(nullable = false)
   private Role role;

   @Builder
   public User(String name, String email, String picture, Role role) {
       this.name = name;
       this.email = email;
       this.picture = picture;
       this.role = role;
   }

   public User update(String name, String picture) {
       this.name = name;
       this.picture = picture;

       return this;
   }

   public String getRoleKey() {
       return this.role.getKey();
   }
}