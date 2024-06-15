package org.singhav.graphql.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuditorAwareImpl implements AuditorAware<String> {
    private final DataSource dataSource;

    @Override
    public Optional<String> getCurrentAuditor() {
        try (Connection connection = dataSource.getConnection()) {
            return Optional.ofNullable(connection.getMetaData().getUserName());
        } catch (SQLException se) {
            log.error("Error in getting datasource user name", se);
        }
        return Optional.empty();
    }
}
