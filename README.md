# Build-a-book-add-page-using-JSF-tags
1. Use the JSF tag to build a book add page. The page includes: book name, book book number, author, publication time, price text input box (h: inputText), category, sub-category selection box (h: selectOneRadio or h: selectOnelistbox) and add button, cancel button (h:commandButton ), as well as the required text labels (h:outputLabel) and form labels (h:form).
Classification includes the following: computer, literature, management, and others.
Sub-categories are determined by classification, and when different classifications are selected, sub-categories will vary depending on the classification selected. The relationship between classification and sub-categorization: computer->software engineering, computer network, programming language, others; literature->fiction, prose, poetry, others; management->administration, business administration, financial management, others; others->none .
2. Use the managed bean to get the book information input by the user. Build a book class, set the class as a managed bean, and associate its properties with the tags on the page. In the attributes of the book class, the book name, the book book number is a string type, and the author is an ordered collection of string types (the author can have multiple, requiring the user to input with a comma), the publication time is the date type, and the price is floating. Point types, categories, and subcategories are integer or enumerated types.
3. Convert and verify the book information input by the user using the converter and the verifier. All fields except the sub-category cannot be empty; the book code must be the beginning of the ISBN followed by 13 digits; the price must be an integer or a floating-point number. If the number entered by the user after the decimal point exceeds 1 digit, one decimal place is valid. ; Convert the author to an ordered collection for storage; verify the correctness of the book number based on the book number verification bit.
4. Use the navigation function. After the user clicks the Add button, navigate to the Add Confirmation page.
The action function corresponding to the add button returns "success", and in the navigation configuration, it corresponds to the add confirmation page.
The Add Confirmation page includes: information about the book to be added, a confirmation button, and a Continue Add button. The information of the book is displayed by EL expression, and the publication date is required to be displayed in the form of March 2015. The price is displayed in the form of RMB currency, and the book number is displayed in the manner of ISBN 978-7-5343-4134-2. Click the confirmation button to complete the database insertion operation of the book (the specific operation can be completed in the next experiment). Click the Continue Add button to navigate to the Book Add page and re-add other book information.
5. Use the value change event to implement the linkage relationship between the category and the subcategory. When the user selects a category to change, the subcategory is also required to change.
6, (optional) use action events to achieve log writes. Set the action event response for the add button, when the user clicks the add button, writes a row of records in the log file.
