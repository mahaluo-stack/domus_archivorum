package commune.constantia

enum class ConstantiaResponsumPonere {
    CREATED,
    UNCHANGED,
    UPDATED
}

enum class ConstantiaResponsumDelereNexus {
    SUCCESS,
    NOT_FOUND
}

enum class ConstantiaResponsumDelereRegistra {
    SUCCESS,
    NOT_FOUND,
    REFERENCED
}

enum class ConstantiaResponsumCreata {
    SUCCESS,
    EXISTING
}