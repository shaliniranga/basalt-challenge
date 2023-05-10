/**
 * 
 */
package com.basalt.challenge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ShaliniRanga
 *
 */
@Entity
@Table(name="transactions_catalog")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TransactionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
    private Long id;
    
    @Column(name="description")
    private String description;
    
    @Column(name="trans_type")
    private String trans_type;
    
    @Column(name="amount")
    private Integer amount;

}
