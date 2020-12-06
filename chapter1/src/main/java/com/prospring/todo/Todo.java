package com.prospring.todo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Todo {

	private String id;
	private String description;
	private LocalDateTime created;
	private LocalDateTime modified;
	private boolean completed;

	public Todo ()
	{
		LocalDateTime dateTime = LocalDateTime.now();
		this.id = UUID.randomUUID().toString();
		this.created = dateTime;
		this.modified = dateTime;
	}

	public Todo (String description)
	{
		this ();
		this.description = description;
	}

}
