package com.vivek.controller;

import com.vivek.model.BaseModel;
import com.vivek.service.BaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public abstract class BaseRestController<T extends BaseModel> {
	@Autowired protected BaseService<T> service;

	@GetMapping("/{id}")
	public T getById(@PathVariable Long id) {
		return service.validateAndGet(id);
	}

	@PostMapping
	public T add(@Valid @RequestBody T model) {
		return service.add(model);
	}

	@PutMapping("/{id}")
	public T update(@PathVariable Long id, @Valid @RequestBody T model) {
		return service.update(id, model);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
