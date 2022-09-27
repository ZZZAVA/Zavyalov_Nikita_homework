Feature: User can edit main form on Different Elements Page

  @first
  Scenario: User can edit checkboxes, radio and dropdown
    Given I open JDI GitHub site
    And I login as User "Roman Iovlev"
    Then Browser title equals "Home Page"
    And Name is displayed and equals to "ROMAN IOVLEV"
    When I click on "SERVICE" button in Header
    And I click on "DIFFERENT ELEMENTS" button in Service dropdown
    And I select checkboxes in main form on Different Elements page
      | Water |
      | Wind  |
    And I select radio buttons in main form on Different Elements page
      | Selen |
    And I select in dropdown in main form on Different Elements page
      | Yellow |
    Then I see that part of logs in right section on Different Elements page
      | Colors: value changed to Yellow  |
      | metal: value changed to Selen    |
      | Wind: condition changed to true  |
      | Water: condition changed to true |