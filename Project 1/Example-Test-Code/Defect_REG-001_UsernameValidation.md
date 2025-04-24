Field | Description
Defect ID | REG-001 (or system-generated)
Title | Incorrect error message when registering with an existing username
Reported By | Jyoti Chiliveri (Tester)
Module | User Registration
Severity | Medium
Priority | High
Environment | QA / Test Environment
Status | New / Open
Assigned To | Developer Team
Description | When a new user attempts to register using a username that already exists in the system but enters a different password, the application displays an error message: "Invalid username". This is misleading and does not accurately represent the issue, as the username format is valid, but the username is already taken.
Steps to Reproduce | 1. Navigate to the login page2. Click the "Register" link3. Enter an existing username (e.g., Batman)4. Enter a new password (e.g., Test@1234)5. Click the "Register" button
Expected Result | User should receive the message: "Username already exists. Please choose a different username."
Actual Result | User sees: "Invalid username"
Impact | Misleads users into thinking their username format is invalid. Prevents clarity in the registration process and user experience is negatively affected.
Suggested Fix | Update backend (or frontend) validation to differentiate between format validation and duplicate username check. Return appropriate message.