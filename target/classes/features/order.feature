Feature: ordering product

  Scenario: User orders products and pay by check
    Given browser with my store site open up
    And logged user yfxdvazirunwydcuwm@tcwlx.com with password zaq1@WSX
    When user enter product page
    And chooses size M, pick amount of 5 and add them to cart
    And proceed thought checkout process
    Then make screenshot of order
    And confirms order have correct values on acc order history

