package com.eldar.vesna.data;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TacoOrder implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private Date createdAt;

    @Digits(integer = 3 , fraction = 0 , message = "Invalid CVV")
    private String ccCVV;

    @Pattern(regexp = "^(0[1-9]|1[0-2])(/)([2-9][0-9])",
             message = "Must be formatted MM/YY")
    private String ccExpirationDate;

    @CreditCardNumber(message = "Credit card number is not valid!")
    private String ccNumber;


    @NotBlank(message = "State is required!")
    private String deliveryState;

    @NotBlank(message = "City is required!")
    private String deliveryCity;

    @NotBlank(message = "Street is required!")
    private String deliveryStreet;

    @NotBlank(message = "Zip is required!")
    private String deliveryZip;

    @Size(min = 1 , message = "You need at least 1 taco to make order!")
    private final List<Taco> tacos = new ArrayList<>();
    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
