package book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface URLRepository extends CrudRepository<CutURL, Long> {
	CutURL findByShortURL(String shortURL);
}
