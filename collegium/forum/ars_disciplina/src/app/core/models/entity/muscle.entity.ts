import { MuscleGroup } from "../muscle/muscle-group.interface"
import { Muscle } from "../muscle/muscle.interface"
import { MusclePart } from "../muscle/muscle-part.interface"

export type MuscleEntity = {
    muscleGroup: MuscleGroup,
    muscle: Muscle,
    muscleParts: MusclePart[]
}