package logisticspipes.commands;

import logisticspipes.commands.abstracts.SubCommandHandler;
import logisticspipes.commands.commands.*;
import net.minecraft.command.ICommandSender;

public class MainCommandHandler extends SubCommandHandler {

    @Override
    public String[] getNames() {
        return new String[] {"logisticspipes", "lp", "logipipes"};
    }

    @Override
    public boolean isCommandUsableBy(ICommandSender sender) {
        return true;
    }

    @Override
    public String[] getDescription() {
        return new String[] {"The main LP command"};
    }

    @Override
    public void registerSubCommands() {
        registerSubCommand(new DummyCommand());
        registerSubCommand(new VersionCommand());
        registerSubCommand(new ChangelogCommand());
        registerSubCommand(new NBTDebugCommand());
        registerSubCommand(new RoutingThreadCommand());
        registerSubCommand(new TransferNamesCommand());
        registerSubCommand(new NameLookupCommand());
        registerSubCommand(new DumpCommand());
        registerSubCommand(new BypassCommand());
        registerSubCommand(new DebugCommand());
        registerSubCommand(new WrapperCommand());
        registerSubCommand(new ClearCommand());
    }
}
