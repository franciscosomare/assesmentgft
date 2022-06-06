package com.assestment.gft.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nace_entity")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NaceEntity {

    @Column(name = "nace_order")
    @Id
    private String order;

    @Column(name = "level")
    private String level;

    @Column(name = "code")
    private String code;

    @Column(name = "parent")
    private String parent;

    @Column(name = "description")
    private String description;

    @Column(name = "itemIncludes", columnDefinition = "TEXT")
    private String itemIncludes;

    @Column(name = "itemAlsoIncludes", columnDefinition = "TEXT")
    private String itemAlsoIncludes;

    @Column(name = "itemExcludes", columnDefinition = "TEXT")
    private String itemExcludes;

    @Column(name = "rulings", columnDefinition = "TEXT")
    private String rulings;

    @Column(name = "ISICReference")
    private String isicReference;

}
