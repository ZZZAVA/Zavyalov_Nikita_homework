Feature: User can select "vip" checkbox on User Table Page

  @third
  Scenario: User Table Page Vip checkbox test
    Given I open JDI GitHub site
      And I login as User "Roman Iovlev"
      And I click on "SERVICE" button in Header
      And I click on "USER TABLE" button in Service dropdown
      When I select 'vip' checkbox for "Sergey Ivan"
      Then 1 log row has "Vip: condition changed to true" text in log section