Feature: Posting 

  Scenario: Alice can publish messages to a personal timeline
    When Alice publishes a Message
    Then the Message is added to Alice timeline



    