package exercise9.CommandPatternExample;

public class TestCommand {
    public static void main(String[] args) {
        // Receiver
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        // Commands
        Command livingRoomOn = new LightOnCommand(livingRoomLight);
        Command livingRoomOff = new LightOffCommand(livingRoomLight);

        Command kitchenOn = new LightOnCommand(kitchenLight);
        Command kitchenOff = new LightOffCommand(kitchenLight);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // Turn on living room light
        remote.setCommand(livingRoomOn);
        remote.pressButton();

        // Turn off living room light
        remote.setCommand(livingRoomOff);
        remote.pressButton();

        // Turn on kitchen light
        remote.setCommand(kitchenOn);
        remote.pressButton();

        // Turn off kitchen light
        remote.setCommand(kitchenOff);
        remote.pressButton();
    }
}
