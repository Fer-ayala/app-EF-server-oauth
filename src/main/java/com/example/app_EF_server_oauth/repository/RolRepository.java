package com.example.app_EF_server_oauth.repository;

import com.example.app_EF_server_oauth.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

}
