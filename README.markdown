# Testing just on localhost


```	
Try forcing IPv4 (-Djava.net.preferIPv4Stack=true) and setting a bind
address, e.g. via -Djgroups.bind_addr=1.2.3.4 (valid IP address) or
-Djgroups.bind_addr=site_local
```


## Bootstrap, basic sanity check

### Start the listener

```
[~%]java -Djava.net.preferIPv4Stack=true -cp `find ~/.m2 | egrep -v sources | egrep '.*jgroup.*\.jar$'` org.jgroups.tests.McastReceiverTest -bind_addr 127.0.0.1
Socket=0.0.0.0/0.0.0.0:5555, bind interface=/192.168.50.208
Socket=0.0.0.0/0.0.0.0:5555, bind interface=/127.0.0.1

d [sender=127.0.0.1:5555]
d [sender=192.168.50.208:5555]

```
### Then send some messages in

```
[~%]java -Djava.net.preferIPv4Stack=true -cp `find ~/.m2 | egrep -v sources | egrep '.*jgroup.*\.jar$'` org.jgroups.tests.McastSenderTest -help

McastSenderTest [-bind_addr <bind address>] [-help] [-mcast_addr <multicast address>] [-port <multicast port that receivers are listening on>] [-ttl <time to live for mcast packets>] [-use_all_interfaces]
[~%]java -Djava.net.preferIPv4Stack=true -cp `find ~/.m2 | egrep -v sources | egrep '.*jgroup.*\.jar$'` org.jgroups.tests.McastSenderTest -bin_addr 127.0.0.1
McastSenderTest [-bind_addr <bind address>] [-help] [-mcast_addr <multicast address>] [-port <multicast port that receivers are listening on>] [-ttl <time to live for mcast packets>] [-use_all_interfaces]
[~%]java -Djava.net.preferIPv4Stack=true -cp `find ~/.m2 | egrep -v sources | egrep '.*jgroup.*\.jar$'` org.jgroups.tests.McastSenderTest -bind_addr 127.0.0.1
Socket #1=0.0.0.0/0.0.0.0:5555, ttl=32, bind interface=/192.168.50.208
Socket #2=0.0.0.0/0.0.0.0:5555, ttl=32, bind interface=/127.0.0.1
> d
>
```

