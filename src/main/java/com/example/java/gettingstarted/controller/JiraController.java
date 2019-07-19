package com.example.java.gettingstarted.controller;


import com.example.java.gettingstarted.entity.Assignee;
import com.example.java.gettingstarted.entity.Task;
import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


@Controller
@RequestMapping("/jira")
public class JiraController {

	@RequestMapping("/assigneeTasks")
	@ResponseBody
	public Collection<Assignee> testJson(String jql) {
		if (StringUtils.isEmpty(jql)) {
			jql = "project = XDW AND issuetype = 子任务 AND Sprint = 702 ORDER BY key ASC";
		}

		BasicCredentials creds = new BasicCredentials("chunchun.xu", "123123123aa");
		JiraClient jira = new JiraClient("http://jira.wwwarehouse.com", creds);
		Issue.SearchResult searchResult = null;
		try {
			searchResult = jira.searchIssues(jql);
		} catch (JiraException e) {
		}
		List<Issue> list = searchResult.issues;
		Map<String, Assignee> map = new HashMap<>();
		for (Issue issue : list) {
			Task task = new Task();
			if (issue.getParent() == null) {
				task.setDemand(issue.getIssueType().getName());
			} else {
				task.setDemand(issue.getIssueType().getName() + issue.getParent().getKey() + issue.getParent().getSummary());
			}
			task.setTaskName(issue.getKey() + issue.getSummary());
			task.setStartDate((String) issue.getField("customfield_10112"));
			task.setEndDate((String) issue.getField("customfield_10113"));

			Assignee assignee = null;
			if (map.containsKey(issue.getAssignee().getDisplayName())) {
				assignee = map.get(issue.getAssignee().getDisplayName());
			} else {
				assignee = new Assignee();
				assignee.setName(issue.getAssignee().getDisplayName());
				assignee.setTasks(new ArrayList<>());
				map.put(assignee.getName(), assignee);
			}

			assignee.getTasks().add(task);
		}
		return map.values();
	}
}
