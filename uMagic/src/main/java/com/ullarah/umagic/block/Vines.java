package com.ullarah.umagic.block;

import com.ullarah.umagic.MagicFunctions;
import org.bukkit.block.Block;
import org.bukkit.metadata.FixedMetadataValue;

public class Vines extends MagicFunctions {

    public Vines(Block block) {

        super(false);

        byte data = block.getData();
        block.setData(data < 15 ? (byte) (data + 1) : (byte) 0);

        block.setMetadata(metaVine, new FixedMetadataValue(getPlugin(), true));
        saveMetadata(block.getLocation(), metaVine);

    }

}
