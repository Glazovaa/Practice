package book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CutURL {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String defaultURL;
	private String shortURL;
	private String tag = "http://localhost:8080/";
	protected CutURL() {}

	public CutURL(String defaultURL, String shortURL) {
		this.defaultURL = defaultURL;
		this.shortURL = shortURL;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer[id=%d, defaultURL='%s', shortURL='%s']",
				id, defaultURL, shortURL);
	}

	public Long getId() {
		return id;
	}
	public String getDefaultURL(){
		return defaultURL;
	}
	public String getShortURL(){
		return shortURL;
	}

	public String getTag() {
		return tag;
	}
}
