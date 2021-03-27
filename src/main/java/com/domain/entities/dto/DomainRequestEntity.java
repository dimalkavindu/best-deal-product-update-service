package com.domain.entities.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DomainRequestEntity {

	private List<Product> data;

}