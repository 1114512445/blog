package blog.chl.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="image")
public class Image {

	private String id;
	private String path;
	private String title;
	private String content;
	private String spare;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
	public String getSpare() {
		return spare;
	}
	public void setSpare(String spare) {
		this.spare = spare;
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", path=" + path + ", title=" + title + ", content=" + content + ", spare=" + spare
				+ "]";
	}
	
	
}
