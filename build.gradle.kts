plugins {
    java
    `java-library`
    `maven-publish`
}

val minestomVersion = "0b0dc83ffe"
val cloudVersion = "1.5.0"

group = "me.konicai"
//Use the same version as cloud
version = cloudVersion

tasks.withType<JavaCompile> {
    options.release.set(17)
}

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
    //maven("https://libraries.minecraft.net")
    //maven("https://repo.spongepowered.org/maven")
}

dependencies {
    api("cloud.commandframework:cloud-core:$cloudVersion")
    compileOnly("com.github.Minestom:Minestom:$minestomVersion")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
