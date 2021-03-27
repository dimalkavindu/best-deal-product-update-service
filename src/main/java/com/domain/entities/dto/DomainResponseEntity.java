
package com.domain.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class DomainResponseEntity {
    String resCode;
    String resDesc;
    String messageId;
}
