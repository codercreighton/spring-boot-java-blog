package com.tts.theBlog.post;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;

import com.tts.theBlog.author.Author;
import com.tts.theBlog.comment.Comment;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	

	@Column(columnDefinition="TEXT")
	private String body;
	
	//will automatically set the date to the current date 
	@CreatedDate @Column(columnDefinition ="TIMESTAMP")
	private Date posted;
	@ManyToOne
	private Author author;
	

	@OneToMany (mappedBy ="post")
	private Set<Comment> comment = new HashSet<Comment>();
	
	private Post() {
		//JPA needs at least 1 non-argument constructor
	}
	
	// our public constructor makes sure title, body, and date are set when creating a new Post
	public Post(String title, String body, Date posted ) {
		this.setTitle(title);
		this.setBody(body);
		this.setPosted(posted);
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getPosted() {
		return posted;
	}
	public void setPosted(Date posted) {
		this.posted = posted;
	}
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + ", posted=" + posted + ", author=" + author
				+ ", comment=" + comment + "]";
	}

	
	

}
