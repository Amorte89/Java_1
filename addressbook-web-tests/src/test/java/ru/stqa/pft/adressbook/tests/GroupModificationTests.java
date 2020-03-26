package ru.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.MatcherAssert.*;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.getNavigationHelper().groupPage();
            app.getGroupHelper().create(new GroupData().withName("test 1"));
        }
    }

    @Test
    public void testGroupModification() {

        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("test 1").withHeader("test 2").withFooter("test 3");
        app.getNavigationHelper().groupPage();
        app.getGroupHelper().modify(group);
        Assert.assertEquals(app.getGroupHelper().count(), before.size());
        Groups after = app.db().groups();
        assertThat(after, CoreMatchers.equalTo(before.without(modifiedGroup).withAdded(group)));
    }
}
