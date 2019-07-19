package com.example.java.gettingstarted.entity;

import lombok.Data;

import java.util.List;

@Data
public class Assignee {
	String name;
	List<Task> tasks;
}
