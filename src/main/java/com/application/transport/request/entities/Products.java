package com.application.transport.request.entities;

import java.util.List;

import com.application.validator.RequestEntityInterface;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Products implements RequestEntityInterface {
	private List<Product> data;
}