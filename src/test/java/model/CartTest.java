package test.java.model;


import org.junit.jupiter.api.Test;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Locale;

import sample.model.Cart;
import sample.model.CartItem;
import sample.entity.Item;

import static org.assertj.core.api.Assertions.assertThat;

class ShoppingCartTest {

	private Validator createValidator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.afterPropertiesSet();
		return localValidatorFactoryBean;
    }
    
    @Test
    public void addOneItem() {
        LocaleContextHolder.setLocale(Locale.ENGLISH);
        
        Cart c = new Cart();
        assertThat(c.getNumberOfItems()).isEqualTo(0);
        assertThat(c.isEmpty()).isTrue();

        Item i = new Item();
        i.setItemId("1");
        i.setProductId("1");
        i.setQuantity(3);
        i.setProductName("Producto 1");

        c.addItem(i, true);
        assertThat(c.getNumberOfItems()).isEqualTo(1);
        assertThat(c.isEmpty()).isFalse();

        CartItem ci = c.getCartItem("1");
        assertThat(ci).isNotNull();
        assertThat(ci.getQuantity()).isEqualTo(1);
        assertThat(ci.isInStock()).isTrue();

        Item i1 = ci.getItem();
        assertThat(i1.getQuantity()).isEqualTo(3);
        assertThat(i1.getProductId()).isEqualTo("1");

    }

}