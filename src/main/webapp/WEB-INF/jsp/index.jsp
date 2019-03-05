<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Kafka - Produce and Consume Messages</title>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script type="text/javascript">

        var stompClient = null;

        function setConnected(connected) {
            document.getElementById('disconnect').disabled = !connected;
            document.getElementById('conversationDiv').style.visibility
                = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }

        function connect() {
            var socket = new SockJS('/chat');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                setConnected(true);
                stompClient.subscribe('/topic/messages', function(messageOutput) {
                    showMessageOutput(JSON.parse(messageOutput.body));
                });
            });
        }

        function disconnect() {
            if(stompClient != null) {
                stompClient.disconnect();
            }
            setConnected(false);
        }

        function showMessageOutput(messageOutput) {
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(messageOutput.sender + ": "
                + messageOutput.text));
            response.appendChild(p);
        }

        function sendMessageToKafka(text) {
            document.getElementById('msg').value = '';
            var name = document.getElementById('name').value;

            var xhr = new XMLHttpRequest();
            xhr.open('POST', "/message", true);
            xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            var params = "message=" + text + "&name=" + name;

            xhr.onload = function () {
                var result = JSON.parse(xhr.responseText);
                if (xhr.readyState == 4 && xhr.status == "200" && result) {
                } else {
                    console.error(result);
                }
            };
            xhr.send(params);
        }
    </script>
</head>
<body onload="connect();">

<h1>Kafka - Produce and Consume Messages</h1>

<div>
    <input type="text" id="name" name="name" style="max-width: 250px" placeholder="Your name"><br />
    <input type="text" id="msg" name="text" style="max-width: 250px" placeholder="Message..."><br /><br />
    <input type="button" value="Send" onclick="sendMessageToKafka(document.getElementById('msg').value);">

</div>

<h2>Messages</h2>

<div>
    <div>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
        <br />
        <br />
        Refresh to reconnect
    </div>
    <br />
    <div id="conversationDiv">
        <p id="response"></p>
    </div>
</div>


<script>
    document.getElementById("msg").addEventListener("keypress", function(e){
        var key = e.which || e.keyCode;
        if (key === 13) {
            sendMessageToKafka(e.target.value)
        }
    });
</script>
</body>
</html>
