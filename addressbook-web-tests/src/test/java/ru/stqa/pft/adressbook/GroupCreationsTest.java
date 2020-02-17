package ru.stqa.pft.adressbook;

import org.testng.annotations.Test;

public class GroupCreationsTest extends TestBase{

  @Test
  public void testGroupCreations() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
  }
}
