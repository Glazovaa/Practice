package book;

import org.springframework.data.repository.CrudRepository;

public interface RepOfCountry extends CrudRepository<Country, Long> {
}
