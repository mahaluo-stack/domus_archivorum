package ars_disciplina.disciplinarum.constantia

object ConstantiaDisciplinae {
    const val CONVENTIONAL_DEADLIFT = "conventional deadlift"
    const val ROMANIAN_DEADLIFT = "romanian deadlift"
    const val SUMO_DEADLIFT = "sumo deadlift"
    const val STIFF_LEG_DEADLIFT = "stiff-leg deadlift"
    const val RACK_PULL = "rack pull"
    val DEADLIFT_ARCHETYPUS = setOf(
        CONVENTIONAL_DEADLIFT,
        ROMANIAN_DEADLIFT,
        SUMO_DEADLIFT,
        STIFF_LEG_DEADLIFT,
        RACK_PULL
    )

    const val SQUAT = "squat"
    const val FRONT_SQUAT = "front squat"
    const val GOBLET_SQUAT = "goblet squat"
    val SQUAT_ARCHETYPUS = setOf(
        SQUAT,
        FRONT_SQUAT,
        GOBLET_SQUAT
    )

    const val BULGARIAN_SPLIT_SQUAT = "bulgarian split squat"
    const val REVERSE_LUNGE = "reverse lunge"
    const val LUNGE = "lunge"
    val LUNGE_ARCHETYPUS = setOf(
        BULGARIAN_SPLIT_SQUAT,
        REVERSE_LUNGE,
        LUNGE
    )

    const val CHIN_UP = "chin-up"
    const val PULL_UP = "pull-up"
    const val LAT_PULLDOWN = "lat pulldown"
    val PULLDOWN_ARCHETYPUS = setOf(
        CHIN_UP,
        PULL_UP,
        LAT_PULLDOWN
    )

    const val OVERHEAD_PRESS = "overhead press"
    const val BEHIND_THE_NECK_PRESS = "behind the neck press"
    const val PUSH_PRESS = "push press"
    val OVERHEAD_PRESS_ARCHETYPUS = setOf(
        OVERHEAD_PRESS,
        BEHIND_THE_NECK_PRESS,
        PUSH_PRESS
    )

    const val BICEP_CURL = "bicep curl"
    const val PREACHER_CURL = "preacher curl"
    const val DRAG_CURL = "drag curl"
    const val SPIDER_CURL = "spider curl"
    val CURL_ARCHETYPUS = setOf(
        BICEP_CURL,
        SPIDER_CURL,
        DRAG_CURL,
        PREACHER_CURL
    )

    const val BENCH_PRESS = "bench press"
    const val DIP = "dip"
    const val FLYE = "flye"
    val PRESS_ARCHETYPUS = setOf(
        BENCH_PRESS,
        DIP,
        FLYE
    )

    const val TRICEP_EXTENSION = "tricep extension"
    const val TRICEP_KICKBACK = "tricep kickback"
    const val SKULLCRUSHER = "skullcrusher"
    const val TRICEP_PUSHDOWN = "tricep pushdown"
    val TRICEP_EXTENSION_ARCHETYPUS = setOf(
        TRICEP_EXTENSION,
        TRICEP_KICKBACK,
        SKULLCRUSHER,
        TRICEP_PUSHDOWN
    )

    const val FRONT_DELT_RAISE = "front delt raise"
    const val REAR_DELT_RAISE = "rear delt raise"
    const val LATERAL_DELT_RAISE = "lateral delt raise"
    val DELT_RAISE_ARCHETYPUS = setOf(
        FRONT_DELT_RAISE,
        REAR_DELT_RAISE,
        LATERAL_DELT_RAISE
    )

    const val HANGING_LEG_RAISE = "hanging leg raise"
    const val CRUNCH = "crunch"
    const val OBLIQUE_CRUNCH = "oblique crunch"
    const val PULLOVER = "pullover"
    const val FACEPULL = "facepull"
    const val SHRUG = "shrug"
    const val ROW = "row"

    const val BACK_EXTENSION = "back extension"
    const val CALF_RAISE = "calfraise"
    const val CALF_PRESS = "calf press"
    const val LEG_CURL = "leg curl"
    const val LEG_EXTENSION = "leg extension"
    const val LEG_PRESS = "leg press"
}