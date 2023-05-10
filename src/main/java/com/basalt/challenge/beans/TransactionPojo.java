/**
 * 
 */
package com.basalt.challenge.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ShaliniRanga
 *
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TransactionPojo {
	private int id;
	private String trans_type;
	private double amount;
	private String description;  

}
