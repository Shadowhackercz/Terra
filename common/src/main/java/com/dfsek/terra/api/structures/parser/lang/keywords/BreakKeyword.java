package com.dfsek.terra.api.structures.parser.lang.keywords;

import com.dfsek.terra.api.math.vector.Location;
import com.dfsek.terra.api.platform.world.Chunk;
import com.dfsek.terra.api.structures.parser.lang.Block;
import com.dfsek.terra.api.structures.parser.lang.Keyword;
import com.dfsek.terra.api.structures.structure.Rotation;
import com.dfsek.terra.api.structures.tokenizer.Position;

public class BreakKeyword implements Keyword<Block.ReturnLevel> {
    private final Position position;

    public BreakKeyword(Position position) {
        this.position = position;
    }

    @Override
    public Block.ReturnLevel apply(Location location, Rotation rotation) {
        return Block.ReturnLevel.BREAK;
    }

    @Override
    public Block.ReturnLevel apply(Location location, Chunk chunk, Rotation rotation) {
        return Block.ReturnLevel.BREAK;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public ReturnType returnType() {
        return ReturnType.VOID;
    }
}
