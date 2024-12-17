# Test Scenarios: Authorization

## Test Case 1: Valid Login Credentials

**Description**:  
Verify that a user can successfully log in with valid credentials.

### Steps:
1. Open the HP and click on SignIn button: 'https://kebormed.com/platform/index.html'.
2. Switch to the Login form tab.
3. Enter the username: `Test`.
4. Enter the password: `123456789`.
5. Click the **"SignIn"** button.
6. Verify that the Admin panel is opened.

**Expected Result**:  
Successful Authorization.
The URL of the page is `example`.

---

## Test Case 2: Incorrect Password and valid Username

**Description**:  
Verify the system behavior when an incorrect password is entered.

### Steps:
1. Open the HP and click on SignIn button: 'https://kebormed.com/platform/index.html'.
2. Switch to the Login form tab.
3. Enter the username: `Test`.
4. Enter the password: `000000000`.
5. Click the **"SignIn"** button.
6. Verify the error message:
   > "Incorrect username or password."

**Expected Result**:  
The error message is displayed, and the user remains on the login page.

## Test Case 3: Case Sensitivity in Username

**Description**:  
Verify the system behavior when username is entered with different letter casing, but valid password

### Steps:
1. Open the HP and click on SignIn button: 'https://kebormed.com/platform/index.html'.
2. Switch to the Login form tab.
3. Enter the username: `TeST`.
4. Enter the correct password with proper case: `123456789`.
5. Click the **"SignIn"** button.
6. Verify the error message:
> "Incorrect username or password."

**Expected Result**:  
Login should fail, and an error message should display indicating incorrect credentials.

## Test Case 4: SQL Injection Test
**Description**:
Verify the system behavior when using SQL Injection

1. Open the HP and click on SignIn button: 'https://kebormed.com/platform/index.html'.
2. Switch to the Login form tab.
3. Enter the username: `" OR ""="`.
4. Enter the correct password with proper case: `" OR ""="`.
5. Click the **"SignIn"** button.
6. Verify the error message:
> "Incorrect username or password."