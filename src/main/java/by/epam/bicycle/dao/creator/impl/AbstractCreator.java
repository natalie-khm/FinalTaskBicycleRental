package by.epam.bicycle.dao.creator.impl;

import by.epam.bicycle.dao.creator.EntityCreator;
import by.epam.bicycle.entity.Entity;

public abstract class AbstractCreator<T extends Entity> implements EntityCreator<T> {
	private String language;
	
	public AbstractCreator() {
	}
	
	public AbstractCreator(String language) {
		this.language = language;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
}
