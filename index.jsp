<%@ page import="java.util.*, com.example.chat.Message" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>iOS Messages Clone</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="chat-container">
    <div class="chat-box">
        <%
            List<Message> messages = (List<Message>) request.getAttribute("messages");
            if (messages != null) {
                for (Message msg : messages) {
        %>
            <div class="message <%= "You".equals(msg.getSender()) ? "right" : "left" %>">
                <div class="bubble"><%= msg.getContent() %></div>
            </div>
        <%
                }
            }
        %>
    </div>
    <form method="post" action="chat" class="chat-form">
        <input type="hidden" name="sender" value="You"/>
        <input type="text" name="content" placeholder="iMessage..." required />
        <button type="submit">Send</button>
    </form>
</div>
</body>
</html>
