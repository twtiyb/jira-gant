package gettingstarted;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import org.junit.Test;

import java.util.List;

public class JiraTest {
	@Test
	public void testSprint() throws Exception {
		BasicCredentials creds = new BasicCredentials("chunchun.xu", "123123123aa");
		JiraClient jira = new JiraClient("http://jira.wwwarehouse.com", creds);
		Issue.SearchResult searchResult = jira.searchIssues("project = XDW AND issuetype = 子任务 AND Sprint = 702 ORDER BY key ASC");
		List<Issue> list = searchResult.issues;

		list.forEach(n -> System.out.printf("需求id:%s,%s 任务id:%s,%s 指定人:%s 开始时间:%s 结束时间:%s %n", n.getParent().getKey(), n.getParent().getSummary(), n.getKey(), n.getSummary(), n.getAssignee().getDisplayName(), n.getField("customfield_10112"), n.getField("customfield_10113")));

	}
}

