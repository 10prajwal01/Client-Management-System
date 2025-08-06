package com.example.users.repository;

import com.example.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

// In JpaRepository<Users, Long> We Can Create Custom Queries

// <Users, Long> Is are the Generics i.e. Nothing But Referring To Users Class and ID.
public interface UsersRepository extends JpaRepository<Users,Long> {

}
