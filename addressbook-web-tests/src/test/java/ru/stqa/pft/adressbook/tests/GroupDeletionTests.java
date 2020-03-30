package ru.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;


public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.getNavigationHelper().groupPage();
      app.getGroupHelper().create(new GroupData().withName("test 1"));
    }
  }

  @Test
  public void testGroupDeletionTests() {
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
    app.getNavigationHelper().groupPage();
    app.getGroupHelper().delete(deletedGroup);
    assertEquals(app.getGroupHelper().count(), before.size() - 1);
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(deletedGroup)));

    verifyGroupListInUI();
  }
}
