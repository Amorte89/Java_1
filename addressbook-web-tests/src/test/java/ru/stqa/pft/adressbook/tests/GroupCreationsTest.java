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
    assertThat(app.getGroupHelper().count(), equalTo(before.size() + 1));
    Groups after = app.getGroupHelper().all();
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadGroupCreations() {
    app.getNavigationHelper().groupPage();
    Groups before = app.getGroupHelper().all();
    GroupData group = new GroupData().withName("test2'").withHeader("test3").withFooter("test4");
    app.getGroupHelper().create(group);
    assertThat(app.getGroupHelper().count(), equalTo(before.size()));
    Groups after = app.getGroupHelper().all();
    assertThat(after, equalTo(before));
  }
}
