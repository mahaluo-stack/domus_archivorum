rootProject.name = "domus_archivorum"

include(":curia_actarii")
project(":curia_actarii").projectDir = file("collegium/officina/curia/curia_actarii")

include(":curia_disciplinae")
project(":curia_disciplinae").projectDir = file("collegium/officina/curia/curia_disciplinae")

include(":scriptorium_depositum")
project(":scriptorium_depositum").projectDir = file("collegium/officina/scriptorium/scriptorium_depositum")

include(":scriptorium_exemplaria")
project(":scriptorium_exemplaria").projectDir = file("collegium/officina/scriptorium/scriptorium_exemplaria")

include(":scriptorium_infrastructura")
project(":scriptorium_infrastructura").projectDir = file("collegium/officina/scriptorium/scriptorium_infrastructura")

include(":scriptorium_ministerium")
project(":scriptorium_ministerium").projectDir = file("collegium/officina/scriptorium/scriptorium_ministerium")

include(":scriptorium_registrum")
project(":scriptorium_registrum").projectDir = file("collegium/officina/scriptorium/scriptorium_registrum")