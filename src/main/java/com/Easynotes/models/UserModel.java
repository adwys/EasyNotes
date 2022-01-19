package com.Easynotes.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String email;

}
