import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.conf.ProtocolStackConfigurator;
import org.jgroups.stack.Protocol;

public class JGroupsPocMain {

    public static void main(String[] args) throws Exception {




        JChannel channel=new JChannel(

                Protocol
        );
        channel.setReceiver(new ReceiverAdapter() {
            public void receive(Message msg) {
                System.out.println("received msg from " + msg.getSrc() + ": " + msg.getObject());
            }
        });
        channel.connect("MyCluster");
        channel.send(new Message(null, "hello world"));
        channel.close();


    }
}
