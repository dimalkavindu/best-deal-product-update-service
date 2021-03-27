package com.application.transport.request.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OfferItem{

	private String offer;
	private Integer bankCode;
	private String cardName;
	private String bankName;

}