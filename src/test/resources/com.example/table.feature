Feature: Table inside scenario

  @positive
  Scenario: Listing book details
    Given the following books
      | title                  | author              | yearOfPublishing |
      | To kill a mockingbird  | Harper Lee          | 1960             |
      | The catcher in the rye | J.D. Salinger       | 1951             |
      | The great Gatsby       | F. Scott Fitzgerald | 1925             |