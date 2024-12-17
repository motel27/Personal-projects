# Test Scenarios: Reset Password

## Test Case 1: Successful Reset Password

**Description**:  
Verify that a user can successfully Reset the password using existing Email.

**Data**: 
1. Valid Email: Kebormed@gmail.com
2. Invalid Email: ExampleInvalid@gmail.com

### Steps:
1. Open the SigIN form: 'https://kebormed.com/platform/index.html'.
2. Click on [Forgot Password] button.
3. Enter already Existing Email in the requested field: `Kebormedtest@gmail.com`.
4. Click on [Submit] button.

**Expected Result**:  
The messages of the page is `example`.

---

## Test Case 1: Reset Password using unregistered Email

**Description**:  
Verify that a user can't Reset the password using unregistered Email.

### Steps:
1. Open the SigIN form: 'https://kebormed.com/platform/index.html'.
2. Click on [Forgot Password] button.
3. Enter unregistered Email in the requested field: `ExampleInvalid@gmail.com`.
4. Click on [Submit] button.

**Expected Results**:  
The messages of the page is `example`.