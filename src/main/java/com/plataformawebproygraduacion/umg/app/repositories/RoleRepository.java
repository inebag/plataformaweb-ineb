package com.plataformawebproygraduacion.umg.app.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.plataformawebproygraduacion.umg.app.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{


}
