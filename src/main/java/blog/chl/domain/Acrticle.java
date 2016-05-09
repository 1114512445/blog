package blog.chl.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="acrticle")
public class Acrticle {

	private String id;
	private String title;
	private String content;
	private String user_id;
	private String spare;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSpare() {
		return spare;
	}
	public void setSpare(String spare) {
		this.spare = spare;
	}
	@Override
	public String toString() {
		return "Acrticle [id=" + id + ", title=" + title + ", content=" + content + ", user_id=" + user_id + ", spare="
				+ spare + "]";
	}
	
}
