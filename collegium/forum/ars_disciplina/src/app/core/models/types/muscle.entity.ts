import { MuscleGroup } from "../interfaces/muscle/muscle.group.interface"
import { Muscle } from "../interfaces/muscle/muscle.interface"
import { MusclePart } from "../interfaces/muscle/muscle.part.interface"

export type MuscleEntity = {
    muscleGroup: MuscleGroup,
    muscle: Muscle,
    muscleParts: MusclePart[]
}