package com.mediac.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "percent_map")
@NoArgsConstructor
@AllArgsConstructor
public class PercentMap {

    @Id
    @Column(name = "percentmap_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long percentMapId;

    @Column(name = "map_order")
    private int mapOrder;

    @OneToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Column(name = "map_str")
    private String mapStr;


}
