package ma.enset.springbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompleteNotificationListener implements JobExecutionListener {
    private static final Logger logger= LoggerFactory.getLogger(OrderItemProcessor.class);
    private final JdbcTemplate jdbcTemplate;

    public JobCompleteNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution){
        if (jobExecution.getStatus()== BatchStatus.COMPLETED){
            logger.info("le job a été bien éxecuté");
        }
        jdbcTemplate.query("select * from orders",new DataClassRowMapper<>(Order.class))
                .forEach(System.out::println);
    }
}
