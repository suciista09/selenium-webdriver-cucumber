@new-login
Feature:

    Scenario:
        Given the user navigate to "homepage_url" page
        And the user click "homepage_login_link" element
        When the user input "login_email" field with "suci.ij@gmail.com" text
        And the user input "login_password" field with "password" text
        And the user click "login_submit" element