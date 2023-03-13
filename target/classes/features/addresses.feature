Feature: adding and removing addresses

  Scenario Outline: adding new address to registered user having min 1 address added
    Given browser with my store site open up
    And logged user yfxdvazirunwydcuwm@tcwlx.com with password zaq1@WSX
    When user adds new address <alias>, <address>, <city>, <postal code>, <country>, <phone>
    Then address <alias> is added
    Examples:
      | alias | address | city | postal code | country        | phone     |
      | dom   | asd     | zxc  | 12-345      | United Kingdom | 123456789 |
      | praca | fgh     | zxc  | 12-346      | United Kingdom | 123456789 |

  Scenario Outline:removing address
    Given browser with my store site open up
    And logged user with added addresses email yfxdvazirunwydcuwm@tcwlx.com  password zaq1@WSX
    When user remove address <alias>
    Then address <alias> is removed
    Examples:
      | alias |
      | dom   |
      | praca |
