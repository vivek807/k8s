package com.vivek.service;

import com.vivek.exception.ApiException;
import com.vivek.model.BaseModel;
import com.vivek.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService<T extends BaseModel> {
	@Autowired protected BaseRepository<T, Long> repository;

	protected T save(T save) {
		return this.repository.save(save);
	}

	public T validateAndGet(Long id) {
		return this.repository.findById(id).orElseThrow(() -> ApiException.resourceNotFound(id));
	}

	public T add(T model) {
		return this.save(model);
	}

	public T update(Long id, T model) {
		validateAndGet(id);
		model.setId(id);
		return this.save(model);
	}

	public void delete(Long id) {
		this.repository.delete(validateAndGet(id));
	}
}
