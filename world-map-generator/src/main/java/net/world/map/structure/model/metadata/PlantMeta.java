package net.world.map.structure.model.metadata;

import net.world.map.structure.registry.BlockTypes;

public class PlantMeta extends BlockMeta {
    public short plantHeight = 1;
    public BlockTypes plantType;

    public PlantMeta(BlockTypes plantType) {
        this.plantType = plantType;
    }

    public BlockTypes getPlantType() {
        return plantType;
    }

    public short getPlantHeight() {
        return plantHeight;
    }

    public void setPlantHeight(short plantHeight) {
        this.plantHeight = plantHeight;
    }

    public void increasePlantHeight() {
        plantHeight++;
    }

    public void decreasePlantHeight() {
        plantHeight--;
    }
}
