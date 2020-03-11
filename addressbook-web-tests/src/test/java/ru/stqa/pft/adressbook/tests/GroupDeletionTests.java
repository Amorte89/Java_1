package ru.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;


public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().groupPage();
    if (app.getGroupHelper().all().size() == 0) {
      app.getGroupHelper().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletionTests() {
    Groups before = app.getGroupHelper().all();
    GroupData deletedGroup = before.iterator().next();
    app.getGroupHelper().delete(deletedGroup);
    Groups after = app.getGroupHelper().all();
    Assert.assertEquals(after.size(), before.size() - 1);
    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(deletedGroup)));
    }
}
