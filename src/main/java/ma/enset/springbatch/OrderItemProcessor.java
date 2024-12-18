package ma.enset.springbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;


public class OrderItemProcessor implements ItemProcessor<Order,Order> {
    private static final Logger logger= LoggerFactory.getLogger(OrderItemProcessor.class);
    @Override
    public Order process(Order item) throws Exception {
            int id=item.id();
            String name=item.customerName().toUpperCase();
            double price=item.amount()-item.amount()*0.1;
            Order transformedOrder=new Order(id,name,price);
        return transformedOrder;
    }
}
