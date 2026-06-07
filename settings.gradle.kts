rootProject.name = "domus_archivorum"

include(":actarii")
project(":actarii").projectDir = file("collegium/officina/curia/actarii")

include(":disciplinae")
project(":disciplinae").projectDir = file("collegium/officina/curia/disciplinae")

include(":depositum")
project(":depositum").projectDir = file("collegium/officina/scriptorium/depositum")

include(":exemplaria")
project(":exemplaria").projectDir = file("collegium/officina/scriptorium/exemplaria")

include(":infrastructura")
project(":infrastructura").projectDir = file("collegium/officina/scriptorium/infrastructura")

include(":ministerium")
project(":ministerium").projectDir = file("collegium/officina/scriptorium/ministerium")

include(":registrum")
project(":registrum").projectDir = file("collegium/officina/scriptorium/registrum")