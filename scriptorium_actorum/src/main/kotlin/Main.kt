package org.example

import officina.actorum.exemplaria.archivum.Disciplina
import officina.actorum.exemplaria.archivum.Instrumenti
import officina.actorum.exemplaria.archivum.Musculi
import officina.actorum.lector.LectorSessionum

fun main() {
    val sessioBruta = LectorSessionum.lege("/sessions.csv")

    println(sessioBruta)

    sessioBruta.forEach {
        val lines = it.corpus.toString()
        val musculi: Musculi
        val instrumenti: Instrumenti
        val disciplina: Disciplina


    }

//    val allExerciseCandidates = mutableListOf<String>()
//
//    df["body"].toList().filterNotNull().forEach { body ->
//        val lines = body.toString()
//            .lines()
//            .map { it.trim().lowercase() }
//            .filter { it.isNotBlank() }
//
//        // iterate with next-line context
//        for (i in 0 until lines.lastIndex) {
//            val current = lines[i]
//            val next = lines[i + 1]
//
//            val nextLooksLikeSet = next.matches(Regex(""".*\b(\d+\s*kg|kv)\b.*x\d+.*"""))
//            val currentLooksLikeText = current.matches(Regex("""^[a-zåäö\s]+$"""))
//
//            if (nextLooksLikeSet && currentLooksLikeText) {
//                allExerciseCandidates += current
//            }
//        }
//    }
//
//    val unique = allExerciseCandidates.distinct().sorted()
//
//    println("Detected ${unique.size} exercise names:")
//    unique.forEach { println(it) }

}