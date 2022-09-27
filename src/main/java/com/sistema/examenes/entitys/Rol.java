package com.sistema.examenes.entitys;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    private Long rolId;
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
    private Set<UserRol> userRoles = new HashSet<>();

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<UserRol> getUsuarioRoles() {
        return userRoles;
    }

    public void setUsuarioRoles(Set<UserRol> userRoles) {
        this.userRoles = userRoles;
    }

    public Rol(){

    }
}
