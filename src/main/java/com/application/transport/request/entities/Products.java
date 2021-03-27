package com.application.transport.request.entities;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Products{
	private List<Product> data;
}