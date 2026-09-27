buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("net.sourceforge.tess4j:tess4j:5.9.0")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
}

tasks.register("ocrUiJpgs") {
    doLast {
        val uiDir = file("C:/Users/DELL/Desktop/UI/UI")
        val files = uiDir.listFiles { f -> f.extension == "jpg" } ?: arrayOf()
        val tesseract = net.sourceforge.tess4j.Tesseract()
        val sb = StringBuilder()
        for (f in files.sortedBy { it.name }) {
            try {
                val text = tesseract.doOCR(f)
                sb.append("==================== ${f.name} ====================\n")
                sb.append(text)
                sb.append("\n\n")
            } catch (e: Exception) {
                sb.append("Error ${f.name}: ${e.message}\n")
            }
        }
        file("ui_jpg_ocr_results.txt").writeText(sb.toString())
        println("Done OCR")
    }
}