package gettingstarted;

import com.example.java.gettingstarted.entity.Assignee;
import com.example.java.gettingstarted.entity.Task;
import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JiraTest {
	@Test
	public void testSprint() throws Exception {
		BasicCredentials creds = new BasicCredentials("chunchun.xu", "123123123aa");
		JiraClient jira = new JiraClient("http://jira.wwwarehouse.com", creds);
		Issue.SearchResult searchResult = jira.searchIssues("project = XDW AND issuetype = 子任务 AND Sprint = 702 ORDER BY key ASC");
		List<Issue> list = searchResult.issues;
		Map<String, Assignee> map = new HashMap<>();
		for (Issue issue : list) {
			Task task = new Task();
			task.setDemand(issue.getParent().getKey() + issue.getParent().getSummary());
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
		System.out.println(com.alibaba.fastjson.JSON.toJSON(map.values()));
	}

	@Test
	public void testReopen() throws Exception {
		BasicCredentials creds = new BasicCredentials("chunchun.xu", "123123123aa");
		JiraClient jira = new JiraClient("http://jira.wwwarehouse.com", creds);
		Issue.SearchResult searchResult = jira.searchIssues("project = XDW AND issuetype = 生产缺陷 AND text ~ \"【发布商品优化】\" AND reporter in (xiuxiu.chen)","changelog");
		List<Issue> list = searchResult.issues;
		Map<String, Assignee> map = new HashMap<>();
		for (Issue issue : list) {
			Task task = new Task();
		}
		System.out.println(com.alibaba.fastjson.JSON.toJSON(map.values()));
	}
}

