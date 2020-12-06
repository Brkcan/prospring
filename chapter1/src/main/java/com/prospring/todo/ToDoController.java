package com.prospring.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class ToDoController {

	private CommonRepository<Todo> repository;

	@Autowired
	public ToDoController (CommonRepository<Todo> repository)
	{
		this.repository = repository;
	}

	@GetMapping("/todo")
	public ResponseEntity<Iterable<Todo>> getToDos ()
	{
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/todo/{id}")
	public ResponseEntity<Todo> getToDoById(@PathVariable String id)
	{
		return ResponseEntity.ok(repository.findById(id));
	}

	@PatchMapping("/todo/{id}")
	public ResponseEntity<Todo> setCompleted(@PathVariable String id){
		Todo result = repository.findById(id);
		result.setCompleted(true);
		repository.save(result);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.buildAndExpand(result.getId()).toUri();
        return ResponseEntity.ok().header("Location",location.toString()).
				build();
	}
	 @RequestMapping(value="/todo", method = {RequestMethod.POST,
			RequestMethod.PUT})
    public ResponseEntity<?> createToDo(@RequestBody Todo toDo){
		 Todo result = repository.save(toDo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}")
				.buildAndExpand(result.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
		@DeleteMapping("/todo/{id}")
		public ResponseEntity<Todo> deleteToDo(@PathVariable String id){
			repository.delete(TodoBuilder.create().withId(id).build());
			return ResponseEntity.noContent().build();
		}
}
