import { MuscleGroup } from "../muscle/muscle-group.interface"
import { MusclePart } from "../muscle/muscle-part.interface"

export type MuscleEntity = {
    muscleId: number,
    muscleName: string,
    muscleDescription: string,
    muscleGroup: MuscleGroup,
    muscleParts: MusclePart[]
}