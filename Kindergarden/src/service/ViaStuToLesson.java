package service;

import java.util.List;

import entity.lesson;

/**
 * @author 严强强
 */
public interface ViaStuToLesson {
/*
 * 实现根据儿童查找所学课程
 */
	public List<lesson> viastulesson(int id);
}
