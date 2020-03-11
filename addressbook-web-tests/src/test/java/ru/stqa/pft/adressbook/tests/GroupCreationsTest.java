package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationsTest extends TestBase{

  @Test
  public void testGroupCreations() {
    app.getNavigationHelper().groupPage();
    Groups before = app.getGroupHelper().all();
    GroupData group = new GroupData().withName("test2").withHeader("test3").withFooter("test4");
    app.getGroupHelper().create(group);
    Groups after = app.getGroupHelper().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
