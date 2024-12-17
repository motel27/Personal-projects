# Test Scenarios: Contact Form

## Test Case 1: Form Submission

**Description**:
Verify Contact Form Submission

### Steps:
1. Open the HP: 'https://kebormed.com/about/index.html'.
2. Enter the name: `Test User`.
3. Enter the email: `test@example.com`.
4. Enter the message: `This is a test message.`.
5. Click the **"Send"** button.

**Expected Results**:  
Message has been sent and "success" message id displayed

---

## Test Case 2: Form Submission using empty data

### Steps:
1. Open the HP: 'https://kebormed.com/about/index.html'.
2. Click the **"Send"** button: empty fields
3. Check Error messages for all fields

**Expected Results**:  
Message has not been sent and "error" messages are displayed for all fields
