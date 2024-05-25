package com.gfg.JBDL70DB.db;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
@Cacheable
public class Author {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
//    @GenericGenerator( name = "sequence-generator",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence1"),
//                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "5"),
//                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
//            }
//    )
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator= "table-generator")
    @TableGenerator(
            name = "table-generator",
            initialValue = 1,
            allocationSize = 1
    )

    private Integer  id;

    private String name;

}
