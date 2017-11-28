package com.readlearncode.model;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class TransactionTest {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    @Test
    public void givenTransactionPOJO_whenDataNull_shouldNotValidate() throws ParseException {
        Transaction transaction = new Transaction();
        transaction.setQuantity(null);
        transaction.setPriceLimit(null);
        transaction.setType(null);
        transaction.setStock(null);
        transaction.setExerciseDate(null);

        Set<ConstraintViolation<Transaction>> violations = validator.validate(transaction);
        assertThat(violations.size()).isEqualTo(5);
    }

    @Test
    public void givenTransactionPOJO_whenDataValid_shouldValidate() throws ParseException {
        Transaction transaction = new Transaction();
        transaction.setQuantity(10);
        transaction.setPriceLimit(123.00);
        transaction.setType(Transaction.TYPE.BUY);
        transaction.setStock(new Stock());
        transaction.setExerciseDate(dateFormat.parse("2020/01/01"));

        Set<ConstraintViolation<Transaction>> violations = validator.validate(transaction);
        assertThat(violations.size()).isEqualTo(0);
    }

}