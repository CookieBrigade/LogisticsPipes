package logisticspipes.network.packets.pipe;

import java.io.IOException;
import java.util.List;
import logisticspipes.network.LPDataInputStream;
import logisticspipes.network.LPDataOutputStream;
import logisticspipes.network.abstractpackets.CoordinatesPacket;
import logisticspipes.network.abstractpackets.ModernPacket;
import logisticspipes.pipes.basic.CoreRoutedPipe;
import logisticspipes.pipes.basic.LogisticsTileGenericPipe;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.minecraft.entity.player.EntityPlayer;

@Accessors(chain = true)
public class PipeSignTypes extends CoordinatesPacket {

    public PipeSignTypes(int id) {
        super(id);
    }

    @Getter
    @Setter
    private List<Integer> types;

    @Override
    public void processPacket(EntityPlayer player) {
        LogisticsTileGenericPipe pipe = this.getPipe(player.getEntityWorld(), LTGPCompletionCheck.PIPE);
        if (pipe == null || !pipe.isInitialized()) {
            return;
        }
        ((CoreRoutedPipe) pipe.pipe).handleSignPacket(types);
    }

    @Override
    public void writeData(LPDataOutputStream data) throws IOException {
        super.writeData(data);
        data.writeList(types, (data1, object) -> data1.writeInt(object));
    }

    @Override
    public void readData(LPDataInputStream data) throws IOException {
        super.readData(data);
        types = data.readList(data1 -> data1.readInt());
    }

    @Override
    public ModernPacket template() {
        return new PipeSignTypes(getId());
    }
}
